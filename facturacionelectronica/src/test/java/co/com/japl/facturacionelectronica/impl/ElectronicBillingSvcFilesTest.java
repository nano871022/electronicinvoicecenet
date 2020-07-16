package co.com.japl.facturacionelectronica.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.Writer;
import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.com.japl.facturacionelectronica.constants.URLConstants;
import co.com.japl.facturacionelectronica.impl.ElectronicBillingAPI;
import co.com.japl.facturacionelectronica.request.BillingRequest;
import co.com.japl.facturacionelectronica.response.AttachResponse;
import co.com.japl.facturacionelectronica.response.InsertResponse;
import co.com.japl.facturacionelectronica.util.RestClient;
import co.com.japl.facturacionelectronica.util.URLUtil;

public class ElectronicBillingSvcFilesTest {
	@Spy
	private ElectronicBillingAPI api = new ElectronicBillingAPI();
	@Spy
	private URLUtil urlUtil = new URLUtil();
	
	private String userName = "usuariocent";
	private String password = "pasword";
	private String email = "correoelectronico";
	private int invoiceNumber = 2345; 
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		MockitoAnnotations.initMocks(api);
		try {
			File file = new File("src/test/resources/invoicenumber.txt");
			file.createNewFile();
			System.out.println(file.getAbsolutePath());
			FileReader fr = new FileReader(file);
			BufferedReader bf = new BufferedReader(fr);
			String value = bf.readLine();
			System.out.println("Numero factura anterior: "+value);
			if(value != null) {
				invoiceNumber = Integer.valueOf(value);
			}
			invoiceNumber+=1;
			System.out.println("Numero factura nuevo: "+invoiceNumber);
			FileWriter fw = new FileWriter(file);
			fw.write(String.valueOf(invoiceNumber));
			fw.flush();
			fw.close();
			fr.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void sendFile() {
		try {
			String documentType = "1"//"73"
					, documentID = "a32fe035-8c69-408d-86b1-36f26479c44a"
					, idNumber = "nitempresa" 
					, token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6IjgwMDIzMzQ2NCIsIm5iZiI6MTU5NDg1ODg5MywiZXhwIjoxNTk0OTQ1MjkzLCJpYXQiOjE1OTQ4NTg4OTMsImlzcyI6Ik1pc0ZhY3R1cmFzIn0.VKer3TThrKiKFZEQM_JWk8To_F8BAWle7kYRICVIo0g";
			
			Field urlUtils =  ElectronicBillingAPI.class.getDeclaredField("urlUtil");
			Field restClientField =  ElectronicBillingAPI.class.getDeclaredField("restClient");
			urlUtils.setAccessible(true);
			urlUtils.set(this.api, urlUtil);
			restClientField.setAccessible(true);
			restClientField.set(this.api, new RestClient());
			
			token = obtenerToken();
			
			documentID = enviarFactura(idNumber, token);
			adjuntarArchivo(documentID, idNumber, token);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.err.print(e);
		}
		
	}
	
	private String obtenerToken()throws Exception {
		
		Mockito.doReturn("http://misfacturas.cenet.ws/IntegrationAPI_2/api/login").when(urlUtil).get(URLConstants.CONST_URL_LOGIN);
		
		return api.login(userName, password);
	}
	
	private void adjuntarArchivo(String documentID,String idNumber,String token)throws Exception {
		String documentType = "1";
		File file = new File("src/test/resources/funcionesSql.pdf");
		
		Mockito.doReturn("https://misfacturas.cenet.ws/IntegrationAPI_2/api/AttachRG").when(urlUtil).get(URLConstants.CONST_URL_ATTACH_GR);
		
		api.attachGR(documentType,documentID, idNumber, file, token);
		
		System.out.print("Archivo Enviado");
	}
	
	private String enviarFactura(String idNumber,String token) throws Exception{
		BillingRequest br = createInvoice("invoicegood.json",email,String.valueOf(invoiceNumber));
		br.getCustomerInformation().setEmail(email);
		br.getInvoiceGeneralInformation().setInvoiceNumber(invoiceNumber);
		br.getInvoiceGeneralInformation().setExternalGR(true);

		Mockito.doReturn("https://misfacturas.cenet.ws/IntegrationAPI_2/api/InsertInvoice").when(urlUtil).get(URLConstants.CONST_URL_INSERT_INVOICE);

		return api.invoice(br, idNumber, token).getDocumentID();
	
	}
	
	private BillingRequest createInvoice(String fileName,String... valores)throws Exception {
		String json = getJsonSaveIntoFile("invoice1.json");
		if(valores != null && valores.length > 0) {
			json = String.format(json,valores);
		}
		return instaceGson().fromJson(json, BillingRequest.class);
	}
	
	private String getJsonSaveIntoFile(String nameFile) throws Exception{
		String path = "src/test/resources/";
		File file = new File(path+nameFile);
		if(file.exists()) {
			InputStream stream = new FileInputStream(file);
			return new String(stream.readAllBytes());
		}
		throw new Exception("No se encontro el archivo en la ruta");
	}

	private Gson instaceGson() {
		return new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().serializeNulls().setDateFormat("YYYY-MM-dd'T'HH:mm:ss").create();
	}
}
