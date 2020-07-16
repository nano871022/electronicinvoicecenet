package co.com.japl.facturacionelectronica.util;

import static co.com.japl.facturacionelectronica.constants.RestClientConstants.CONST_HEADER_ACCEPT_CHARSET;
import static co.com.japl.facturacionelectronica.constants.RestClientConstants.CONST_HEADER_APPLICATION_JSON;
import static co.com.japl.facturacionelectronica.constants.RestClientConstants.CONST_HEADER_AUTHORIZATION;
import static co.com.japl.facturacionelectronica.constants.RestClientConstants.CONST_HEADER_CACHE_CONTROL;
import static co.com.japl.facturacionelectronica.constants.RestClientConstants.CONST_HEADER_CODING_UTF8;
import static co.com.japl.facturacionelectronica.constants.RestClientConstants.CONST_HEADER_CONNECTION;
import static co.com.japl.facturacionelectronica.constants.RestClientConstants.CONST_HEADER_CONTENT_DISPOSITION;
import static co.com.japl.facturacionelectronica.constants.RestClientConstants.CONST_HEADER_CONTENT_TYPE;
import static co.com.japl.facturacionelectronica.constants.RestClientConstants.CONST_HEADER_LOAD_FILE;
import static co.com.japl.facturacionelectronica.constants.RestClientConstants.CONST_HEADER_REQUEST_METHOD_POST;
import static co.com.japl.facturacionelectronica.constants.RestClientConstants.CONST_HEADER_VALUE_BOUNDARY;
import static co.com.japl.facturacionelectronica.constants.RestClientConstants.CONST_HEADER_VALUE_CTRF;
import static co.com.japl.facturacionelectronica.constants.RestClientConstants.CONST_HEADER_VALUE_KEEP_ALIVE;
import static co.com.japl.facturacionelectronica.constants.RestClientConstants.CONST_HEADER_VALUE_NO_CACHE;
import static co.com.japl.facturacionelectronica.constants.RestClientConstants.CONST_HEADER_VALUE_TWO_HYPENS;
import static co.com.japl.facturacionelectronica.constants.RestClientConstants.SPACE;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class RestClient{

	private String direction = "";
	private HttpURLConnection connect;
	private String params = "";

	public RestClient builder(){
		try {
			String dir = direction;
			if(StringUtils.isNoneBlank(params)) {
				dir = direction + params;
			}
			URL url = new URL(dir);
			connect = (HttpURLConnection) url.openConnection();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		return this;
	}
	
	public String connect(String token,String json) {
		try {
			token = token.replace("\"", "");
			CloseableHttpClient client = HttpClients.createDefault();
			HttpPost request = new HttpPost(direction+params);
			request.setHeader("Accept", CONST_HEADER_APPLICATION_JSON);
			request.setHeader(CONST_HEADER_ACCEPT_CHARSET,CONST_HEADER_CODING_UTF8);
			request.setHeader(CONST_HEADER_CONTENT_TYPE, CONST_HEADER_APPLICATION_JSON);
			request.setHeader(CONST_HEADER_AUTHORIZATION, "auth-user "+token);

			StringEntity entity = new StringEntity(json,ContentType.APPLICATION_JSON);
			request.setEntity(entity);

			CloseableHttpResponse response = client.execute(request);
			if(response.getStatusLine().getStatusCode() == 200) {
				String result = EntityUtils.toString(response.getEntity());
				return result;
			}
			String errores = EntityUtils.toString(response.getEntity());
			client.close();
			return errores;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public RestClient addParameter(String name,String value) {
		String param = "";
		if(StringUtils.isBlank(params)) {
			param = "?";
		}
		if(StringUtils.isNotBlank(params)) {
			param += "&";
		}
		param += String.format("%s=%s", name,value);
		params += param;
		return this;
	}
	
	public RestClient headerToken(String token){
		token = token.replace("\"", "");
		connect.setRequestProperty(CONST_HEADER_AUTHORIZATION,"misfacturas"+SPACE+token);
		return this;
	} 

	public RestClient requestPOSTJson(String request){
		try {
			byte[] output = request.getBytes(StandardCharsets.UTF_8);
			connect.setDoOutput(true);
			connect.setRequestMethod(CONST_HEADER_REQUEST_METHOD_POST);
			connect.setRequestProperty(CONST_HEADER_ACCEPT_CHARSET,CONST_HEADER_CODING_UTF8);
			connect.setRequestProperty(CONST_HEADER_CONTENT_TYPE,CONST_HEADER_APPLICATION_JSON);
			connect.setRequestProperty("Accept",CONST_HEADER_APPLICATION_JSON);
			connect.setFixedLengthStreamingMode(output.length);
			OutputStream outputStream = new DataOutputStream(connect.getOutputStream());
			outputStream.write(output);
			connect.connect();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		return this;
	}
	
	public RestClient requestPOSTEmpty() {
		try {
			connect.setDoOutput(true);
			connect.setRequestMethod(CONST_HEADER_REQUEST_METHOD_POST);
			//connect.setRequestPropertyCONST_HEADER_ACCEPT_CHARSET,CONST_HEADER_CODING_UTF8);
			connect.setRequestProperty(CONST_HEADER_CONTENT_TYPE,CONST_HEADER_APPLICATION_JSON);
			//connect.setRequestProperty("Accept",CONST_HEADER_APPLICATION_JSON);
			connect.setFixedLengthStreamingMode(0);
			connect.connect();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		return this;
	}


	public String response(){
		try {
			int statusResponseHttp = connect.getResponseCode();
			System.out.println(statusResponseHttp);
			if( statusResponseHttp ==  HttpURLConnection.HTTP_OK) {
				InputStream content = (InputStream) connect.getInputStream();	
				BufferedReader in = new BufferedReader(new InputStreamReader(content));
				String line;
				StringBuilder response = new StringBuilder();
				while((line = in.readLine()) != null){
					response.append(line);
				}
				return response.toString();
			}else {
				InputStream content = connect.getErrorStream();
				BufferedReader in = new BufferedReader(new InputStreamReader(content));
				String line;
				StringBuilder response = new StringBuilder();
				while((line = in.readLine()) != null){
					response.append(line);
				}
				return response.toString();
			}
		}catch(NullPointerException e){
			return "";
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			clean();
		}
		
	}

	public RestClient requestPostFile(File file) {
		try {
			connect.setDoOutput(true);
			connect.setUseCaches(false);
			connect.setRequestMethod(CONST_HEADER_REQUEST_METHOD_POST);
			connect.setRequestProperty(CONST_HEADER_CONTENT_TYPE,String.format(CONST_HEADER_LOAD_FILE,CONST_HEADER_VALUE_BOUNDARY));
			connect.setRequestProperty(CONST_HEADER_CONNECTION,CONST_HEADER_VALUE_KEEP_ALIVE);
			connect.setRequestProperty(CONST_HEADER_CACHE_CONTROL,CONST_HEADER_VALUE_NO_CACHE);
			
			DataOutputStream request = new DataOutputStream(connect.getOutputStream());
			request.writeBytes(CONST_HEADER_VALUE_TWO_HYPENS+CONST_HEADER_VALUE_BOUNDARY+CONST_HEADER_VALUE_CTRF);
			request.writeBytes(String.format(CONST_HEADER_CONTENT_DISPOSITION,"File",file.getName(),CONST_HEADER_VALUE_CTRF));
			request.writeBytes(CONST_HEADER_VALUE_CTRF);
			request.writeBytes(CONST_HEADER_VALUE_CTRF);
			
			InputStream fileToLoad = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
			fileToLoad.read(bytes);
			
			request.write(bytes);
			
			request.writeBytes(CONST_HEADER_VALUE_CTRF);
			request.writeBytes(CONST_HEADER_VALUE_TWO_HYPENS+CONST_HEADER_VALUE_BOUNDARY+CONST_HEADER_VALUE_CTRF);
			
			request.flush();
			request.close();
			connect.connect();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		return this;
	}
	
	protected void clean() {
		setUrl(null);
		connect = null;
		params = "";
	}

	public RestClient setUrl(String url){
		this.direction = url;
		return this;
	}
}