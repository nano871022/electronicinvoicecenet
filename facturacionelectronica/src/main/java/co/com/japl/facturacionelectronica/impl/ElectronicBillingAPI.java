package co.com.japl.facturacionelectronica.impl;

import static co.com.japl.facturacionelectronica.constants.ParameterURLConstants.CONST_EMISOR_NUMBER;
import static co.com.japl.facturacionelectronica.constants.ParameterURLConstants.CONST_EMISOR_TYPE;
import static co.com.japl.facturacionelectronica.constants.ParameterURLConstants.CONST_PARAM_DOCUMENT_ID;
import static co.com.japl.facturacionelectronica.constants.ParameterURLConstants.CONST_PARAM_DOCUMENT_TYPE;
import static co.com.japl.facturacionelectronica.constants.ParameterURLConstants.CONST_PARAM_ID_NUMBER;
import static co.com.japl.facturacionelectronica.constants.ParameterURLConstants.CONST_PARAM_PASSWORD;
import static co.com.japl.facturacionelectronica.constants.ParameterURLConstants.CONST_PARAM_SCHEMA_ID;
import static co.com.japl.facturacionelectronica.constants.ParameterURLConstants.CONST_PARAM_TEMPLATE_ID;
import static co.com.japl.facturacionelectronica.constants.ParameterURLConstants.CONST_PARAM_USER_NAME;
import static co.com.japl.facturacionelectronica.constants.ParameterURLConstants.CONST_VALUE_SCHEMA_ID;
import static co.com.japl.facturacionelectronica.constants.ParameterURLConstants.CONST_VALUE_TEMPLATE_ID_INVOICE;
import static co.com.japl.facturacionelectronica.constants.ParameterURLConstants.CONST_VALUE_TEMPLATE_ID_NOTE;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.com.japl.facturacionelectronica.constants.RestClientConstants;
import co.com.japl.facturacionelectronica.constants.URLConstants;
import co.com.japl.facturacionelectronica.exception.BillingException;
import co.com.japl.facturacionelectronica.pojo.ErrorPOJO;
import co.com.japl.facturacionelectronica.request.BillingRequest;
import co.com.japl.facturacionelectronica.request.LoginRequest;
import co.com.japl.facturacionelectronica.request.NoteRequest;
import co.com.japl.facturacionelectronica.response.AttachResponse;
import co.com.japl.facturacionelectronica.response.InsertResponse;
import co.com.japl.facturacionelectronica.response.StatusResponse;
import co.com.japl.facturacionelectronica.svc.IElectronicBillingAPI;
import co.com.japl.facturacionelectronica.util.Cache;
import co.com.japl.facturacionelectronica.util.Login;
import co.com.japl.facturacionelectronica.util.RestClient;
import co.com.japl.facturacionelectronica.util.URLUtil;

public class ElectronicBillingAPI implements IElectronicBillingAPI{
	private RestClient restClient;
	private URLUtil urlUtil = new URLUtil();

	public String login(String userName,String password)throws BillingException{
		if(Cache.instance().exists(userName)){
			Login login = Cache.instance().get(userName);
			if(login.getCreate().compareTo(new Date()) == 0 && StringUtils.isNotBlank(login.getToken())){
				return login.getToken();
			}else{
				Cache.instance().remove(userName);
			}
		}
		LoginRequest login = new LoginRequest();
		login.setPassword(password);
		String token = restClient.setUrl(urlUtil.get(URLConstants.CONST_URL_LOGIN))
								 .addParameter(CONST_PARAM_USER_NAME, userName)
								 .addParameter(CONST_PARAM_PASSWORD, password)
								 .builder()
								 .requestPOSTJson(RestClientConstants.SPACE)
								 .response();
		Login loginCache = new Login();
		loginCache.setLogin(login);
		loginCache.setCreate(new Date());
		loginCache.setToken(token);
		Cache.instance().add(userName,loginCache);
		return token;
	}

	public InsertResponse invoice(BillingRequest billing,String idNumber,String token)throws BillingException{
		String json = instaceGson() .toJson(billing);
		
		String response = restClient.setUrl(urlUtil.get(URLConstants.CONST_URL_INSERT_INVOICE))
									.addParameter(CONST_PARAM_SCHEMA_ID,CONST_VALUE_SCHEMA_ID )
									.addParameter(CONST_PARAM_ID_NUMBER, idNumber)
									.addParameter(CONST_PARAM_TEMPLATE_ID,CONST_VALUE_TEMPLATE_ID_INVOICE)
									.builder()
									.headerToken(token)
									.requestPOSTJson(json)
									.response();
									//.connect(token, json);
		hasError(response);
		return instaceGson().fromJson(response,InsertResponse.class);
	}

	public InsertResponse note(NoteRequest note,String idNumber,String token)throws BillingException{
		String json = instaceGson() .toJson(note);
		
		String response = restClient.setUrl(urlUtil.get(URLConstants.CONST_URL_INSERT_NOTE))
									.addParameter(CONST_PARAM_SCHEMA_ID,CONST_VALUE_SCHEMA_ID )
									.addParameter(CONST_PARAM_ID_NUMBER, idNumber)
									.addParameter(CONST_PARAM_TEMPLATE_ID,CONST_VALUE_TEMPLATE_ID_NOTE)
									.builder()
									.headerToken(token)
									.requestPOSTJson(json)
									.response();
									//.connect(token, json);
		hasError(response);
		return instaceGson().fromJson(response,InsertResponse.class);									
	}
	
	private ErrorPOJO isError(String json) {
		try {
			ErrorPOJO error = instaceGson().fromJson(json,ErrorPOJO.class);
			if(StringUtils.isNoneBlank(error.getError())) {
				return error;
			}
		}catch(Exception e) {
			return null;
		}
		return null;
	}

	public StatusResponse statusBilling(String type,String id,String idNumber,String token)throws BillingException{

		String response = restClient.setUrl(urlUtil.get(URLConstants.CONST_URL_STATUS))
									.addParameter(CONST_PARAM_SCHEMA_ID,CONST_VALUE_SCHEMA_ID )
									.addParameter(CONST_PARAM_ID_NUMBER, idNumber)
									.addParameter(CONST_PARAM_DOCUMENT_TYPE,type)
									.addParameter(CONST_PARAM_DOCUMENT_ID,id)
									.builder()
									.headerToken(token)
									.requestPOSTEmpty()
									.response();
									//.connect(token, "");
		
		hasError(response);
		return instaceGson().fromJson(response,StatusResponse.class);	
	}
	
	private void hasError(String json)throws BillingException {
		ErrorPOJO error = null;
		if((error = isError(json)) != null) {
			throw new BillingException(error.getError());
		}
	}

	public AttachResponse attach(File file,String idNumber,String token)throws BillingException{
		
		String response = restClient.setUrl(urlUtil.get(URLConstants.CONST_URL_ATTACH))
									.addParameter(CONST_PARAM_SCHEMA_ID,CONST_VALUE_SCHEMA_ID )
									.addParameter(CONST_PARAM_ID_NUMBER, idNumber)
									.builder()
									.headerToken(token)
									.requestPostFile(file)
									.response();
		hasError(response);
		return instaceGson().fromJson(response,AttachResponse.class);	
	}

	public void attachGR(String documentType, String documentID ,String idNumber,File file,String token)throws BillingException{
		if(StringUtils.isBlank(documentID)) {
			documentID = "";
		}
		
		String response = restClient.setUrl(urlUtil.get(URLConstants.CONST_URL_ATTACH_GR))
									.addParameter(CONST_PARAM_SCHEMA_ID,CONST_VALUE_SCHEMA_ID )
									.addParameter(CONST_PARAM_ID_NUMBER, idNumber)
									.addParameter(CONST_PARAM_DOCUMENT_TYPE,documentType)
									.addParameter(CONST_PARAM_DOCUMENT_ID,documentID)
									.builder()
									.headerToken(token)
									.requestPostFile(file)
									.response();
		System.out.println("Respuesta: "+response);
		hasError(response);
	}
	
	private Gson instaceGson() {
		return new GsonBuilder()
				.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
				.setPrettyPrinting()
				.setDateFormat(URLConstants.CONST_FORMATE_DATE).create();
	}
	
	private Map<String,String> getInfoEmisor(){
		Map<String,String> emisor = new HashMap<String, String>();
		emisor.put(CONST_EMISOR_TYPE,"");
		emisor.put(CONST_EMISOR_NUMBER,"");
		return emisor;
	}
}