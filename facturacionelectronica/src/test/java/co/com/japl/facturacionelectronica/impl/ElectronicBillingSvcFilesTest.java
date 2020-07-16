package co.com.japl.facturacionelectronica.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import co.com.japl.facturacionelectronica.constants.URLConstants;
import co.com.japl.facturacionelectronica.impl.ElectronicBillingAPI;
import co.com.japl.facturacionelectronica.response.AttachResponse;
import co.com.japl.facturacionelectronica.util.RestClient;
import co.com.japl.facturacionelectronica.util.URLUtil;

public class ElectronicBillingSvcFilesTest {
	@Spy
	private ElectronicBillingAPI api = new ElectronicBillingAPI();
	
	@Before
	public void before() {
		
	}
	
	@Test
	public void sendFile() {
		try {
			String documentType = "1"//"73"
					, documentID = "0009f835-4a72-4529-aab2-a1a7af7c01d7"
					, idNumber = "800233464"
					, token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6IjgwMDIzMzQ2NCIsIm5iZiI6MTU5NDg1ODg5MywiZXhwIjoxNTk0OTQ1MjkzLCJpYXQiOjE1OTQ4NTg4OTMsImlzcyI6Ik1pc0ZhY3R1cmFzIn0.VKer3TThrKiKFZEQM_JWk8To_F8BAWle7kYRICVIo0g";
			File file = new File("src/test/resources/funcionesSql.pdf");
			URLUtil urlUtil = Mockito.spy(new URLUtil());
			Field urlUtils =  ElectronicBillingAPI.class.getDeclaredField("urlUtil");
			Field restClientField =  ElectronicBillingAPI.class.getDeclaredField("restClient");
			urlUtils.setAccessible(true);
			urlUtils.set(this.api, urlUtil);
			restClientField.setAccessible(true);
			restClientField.set(this.api, new RestClient());
			Mockito.doReturn("https://misfacturas.cenet.ws/IntegrationAPI_2/api/AttachRG").when(urlUtil).get(URLConstants.CONST_URL_ATTACH_GR);
			
			api.attachGR(documentType, documentID, idNumber, file, token);
			System.out.print("Archivo Enviado");
		}catch(Exception e) {
			e.printStackTrace();
			System.err.print(e);
		}
		
	}

}
