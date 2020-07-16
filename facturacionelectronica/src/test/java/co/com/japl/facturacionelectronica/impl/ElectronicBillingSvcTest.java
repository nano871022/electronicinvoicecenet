package co.com.japl.facturacionelectronica.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.com.japl.facturacionelectronica.constants.URLConstants;
import co.com.japl.facturacionelectronica.impl.ElectronicBillingAPI;
import co.com.japl.facturacionelectronica.impl.ElectronicBillingSvc;
import co.com.japl.facturacionelectronica.pojo.DocumentsPOJO;
import co.com.japl.facturacionelectronica.request.BillingRequest;
import co.com.japl.facturacionelectronica.request.NoteRequest;
import co.com.japl.facturacionelectronica.response.AttachResponse;
import co.com.japl.facturacionelectronica.response.InsertResponse;
import co.com.japl.facturacionelectronica.response.StatusResponse;
import co.com.japl.facturacionelectronica.util.Cache;
import co.com.japl.facturacionelectronica.util.RestClient;
import co.com.japl.facturacionelectronica.util.URLUtil;


public class ElectronicBillingSvcTest {
	private ElectronicBillingSvc impl;
	@InjectMocks @Spy
	private ElectronicBillingAPI api = new ElectronicBillingAPI();
	@Spy
	private RestClient restClient = new RestClient();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		MockitoAnnotations.initMocks(api);
		impl = Mockito.spy(new ElectronicBillingSvc());
	}
	
	private void injectAPIANDRestClient() throws Exception{
		HttpURLConnection urlConnect = Mockito.mock(HttpURLConnection.class);
		Field api = ElectronicBillingSvc.class.getDeclaredField("api");
		api.setAccessible(true);
		api.set(impl, this.api);
		Field connect = RestClient.class.getDeclaredField("connect");
		connect.setAccessible(true);
		connect.set(restClient, urlConnect);
		OutputStream os = Mockito.mock(OutputStream.class);
		Mockito.doReturn(os).when(urlConnect).getOutputStream();
	}
	
	private void injectModeAttachFalse()throws Exception {
		Field mode = ElectronicBillingSvc.class.getDeclaredField("modeAttach");
		mode.setAccessible(true);
		mode.set(impl, true);
	}
	
	private void injectAPIANDRestClientANDURLUtil() throws Exception{
		URLUtil urlUtil = Mockito.spy(new URLUtil());
		HttpURLConnection urlConnect = Mockito.mock(HttpURLConnection.class);
		Field api = ElectronicBillingSvc.class.getDeclaredField("api");
		api.setAccessible(true);
		api.set(impl, this.api);
		Field connect = RestClient.class.getDeclaredField("connect");
		connect.setAccessible(true);
		connect.set(restClient, urlConnect);
		OutputStream os = Mockito.mock(OutputStream.class);
		Mockito.doReturn(os).when(urlConnect).getOutputStream();
		Field urlUtils =  ElectronicBillingAPI.class.getDeclaredField("urlUtil");
		urlUtils.setAccessible(true);
		urlUtils.set(this.api, urlUtil);
		Mockito.doReturn("http://localhost:8080/IntegrationAPI_2/api/login").when(urlUtil).get(URLConstants.CONST_URL_LOGIN);
		Mockito.doReturn("http://localhost:8080/IntegrationAPI_2/api/InsertInvoice").when(urlUtil).get(URLConstants.CONST_URL_INSERT_INVOICE);
		Mockito.doReturn("http://localhost:8080/IntegrationAPI_2/api/Insertnote").when(urlUtil).get(URLConstants.CONST_URL_INSERT_NOTE);
		Mockito.doReturn("http://localhost:8080/IntegrationAPI_2/api/GetDocumentStatus").when(urlUtil).get(URLConstants.CONST_URL_STATUS);
		Mockito.doReturn("http://localhost:8080/IntegrationAPI_2/api/InsertAttachment").when(urlUtil).get(URLConstants.CONST_URL_ATTACH);
		Mockito.doReturn("http://localhost:8080/IntegrationAPI_2/api/AttachRG").when(urlUtil).get(URLConstants.CONST_URL_ATTACH_GR);
	}

	private void injectAPIANDRestClientANDURLUtilIntegration() throws Exception{
		URLUtil urlUtil = Mockito.spy(new URLUtil());
		HttpURLConnection urlConnect = Mockito.mock(HttpURLConnection.class);
		Field api = ElectronicBillingSvc.class.getDeclaredField("api");
		api.setAccessible(true);
		api.set(impl, this.api);
		Field connect = RestClient.class.getDeclaredField("connect");
		connect.setAccessible(true);
		connect.set(restClient, urlConnect);
		OutputStream os = Mockito.mock(OutputStream.class);
		Mockito.doReturn(os).when(urlConnect).getOutputStream();
		Field urlUtils =  ElectronicBillingAPI.class.getDeclaredField("urlUtil");
		urlUtils.setAccessible(true);
		urlUtils.set(this.api, urlUtil);
		Mockito.doReturn("https://misfacturas.cenet.ws/IntegrationAPI_2/api/login").when(urlUtil).get(URLConstants.CONST_URL_LOGIN);
		Mockito.doReturn("https://misfacturas.cenet.ws/IntegrationAPI_2/api/InsertInvoice").when(urlUtil).get(URLConstants.CONST_URL_INSERT_INVOICE);
		//Mockito.doReturn("http://localhost:8080/IntegrationAPI_2/api/InsertInvoice").when(urlUtil).get(URLConstants.CONST_URL_INSERT_INVOICE);
		Mockito.doReturn("https://misfacturas.cenet.ws/IntegrationAPI_2/api/Insertnote").when(urlUtil).get(URLConstants.CONST_URL_INSERT_NOTE);
		Mockito.doReturn("https://misfacturas.cenet.ws/IntegrationAPI_2/api/GetDocumentStatus").when(urlUtil).get(URLConstants.CONST_URL_STATUS);
		Mockito.doReturn("https://misfacturas.cenet.ws/IntegrationAPI_2/api/InsertAttachment").when(urlUtil).get(URLConstants.CONST_URL_ATTACH);
		Mockito.doReturn("https://misfacturas.cenet.ws/IntegrationAPI_2/api/AttachRG").when(urlUtil).get(URLConstants.CONST_URL_ATTACH_GR);
	}

	
	@Test
	public void testInvoice() {
		
		String numberInvoice = "";
		String responseID = "123";
		String token = "token";
		BillingRequest br = new BillingRequest();
		InsertResponse ir = new InsertResponse();
		ir.setDocumentID(responseID);
		String response = instaceGson() .toJson(ir);
		String request = instaceGson() .toJson(br);
		try {
			injectAPIANDRestClient();
			Mockito.doReturn(token).when(api).login(Mockito.anyString(), Mockito.anyString());
			Mockito.doReturn(restClient).when(restClient).builder();
			Mockito.doReturn(response).when(restClient).response();

			String result = impl.invoice(numberInvoice,1);
			assertEquals(responseID, result);
		}catch(Exception e) {
			fail(e.getMessage());
		}
		Mockito.verify(restClient,Mockito.times(1)).headerToken(token);
	}
	
	@Test
	public void testNote() {
		
		String numberInvoice = "";
		String responseID = "123";
		String token = "token";
		NoteRequest br = new NoteRequest();
		InsertResponse ir = new InsertResponse();
		ir.setDocumentID(responseID);
		String response = instaceGson() .toJson(ir);
		String request = instaceGson() .toJson(br);
		try {
			injectAPIANDRestClient();
			Mockito.doReturn(token).when(api).login(Mockito.anyString(), Mockito.anyString());
			Mockito.doReturn(restClient).when(restClient).builder();
			Mockito.doReturn(response).when(restClient).response();

			String result = impl.note(numberInvoice,1);
			assertEquals(responseID, result);
		}catch(Exception e) {
			fail(e.getMessage());
		}
		Mockito.verify(restClient,Mockito.times(1)).headerToken(token);
	}
	
	@Test
	public void testGetDocumentType() {
		
		String numberNote = "";
		String responseID = "123";
		String token = "token";
		StatusResponse sr = new StatusResponse();
		sr.setCufe("KAJSDKAJSHJKD");
		sr.setCustomParty("japl");
		sr.setCustomPartyID("8008008080");
		sr.setStatusDate(new Date());
		sr.setDocumentStatus("expedida");
		sr.setDocumentNumber("808408048");
		String response = instaceGson() .toJson(sr);
		try {
			injectAPIANDRestClient();
			Mockito.doReturn(token).when(api).login(Mockito.anyString(), Mockito.anyString());
			Mockito.doReturn(restClient).when(restClient).builder();
			Mockito.doReturn(response).when(restClient).response();
			Mockito.doReturn("1").when(impl).getDocumentType(numberNote);

			StatusResponse result = impl.statusBilling(numberNote,1);
			assertEquals(sr.getCufe(), result.getCufe());
			assertEquals(sr.getCustomParty(), result.getCustomParty());
			assertEquals(sr.getCustomPartyID(), result.getCustomPartyID());
			assertEquals(sr.getDocumentNumber(), result.getDocumentNumber());
			assertEquals(sr.getDocumentStatus(), result.getDocumentStatus());
			assertEquals(sr.getNoteNumber(), result.getNoteNumber());
			assertEquals(sr.getPayableAmount(), result.getPayableAmount());
		}catch(Exception e) {
			fail(e.getMessage());
		}
		Mockito.verify(restClient,Mockito.times(1)).headerToken(token);
	}
	
	@Test
	public void attacInsertAttach() {
		String token = "token";
		AttachResponse ar = new AttachResponse();
		ar.setId("231asd32a1sd-a2sd5a-asdads");
		ar.setName("asdasdjlassdlklñ.zip");
		String response = instaceGson() .toJson(ar);
		try {
			File file = new File("src/test/resources/filetestattach.txt");
			
			injectAPIANDRestClient();
			Mockito.doReturn(token).when(api).login(Mockito.anyString(), Mockito.anyString());
			Mockito.doReturn(restClient).when(restClient).builder();
			Mockito.doReturn(response).when(restClient).response();
			
			List<DocumentsPOJO> result = impl.loadFields(null,1,file);
			assertEquals(1, result.size());
			assertEquals(ar.getId(), result.get(0).getId());
			assertEquals(ar.getName(), result.get(0).getName());
		}catch(Exception e) {
			fail(e.getMessage());
		}
		Mockito.verify(restClient,Mockito.times(1)).headerToken(token);
		
	}
	
	
	@Test
	public void attacAttachGR() {
		String token = "token";
		AttachResponse ar = new AttachResponse();
		ar.setId("231asd32a1sd-a2sd5a-asdads");
		ar.setName("asdasdjlassdlklñ.zip");
		String response = instaceGson() .toJson(ar);
		try {
			File file = new File("src/test/resources/filetestattach.txt");
			injectModeAttachFalse();
			injectAPIANDRestClient();
			Mockito.doReturn(token).when(api).login(Mockito.anyString(), Mockito.anyString());
			Mockito.doReturn(restClient).when(restClient).builder();
			Mockito.doReturn(response).when(restClient).response();
			
			List<DocumentsPOJO> result = impl.loadFields(null,1,file);
			assertEquals(1, result.size());
			assertEquals(ar.getId(), result.get(0).getId());
			assertEquals(ar.getName(), result.get(0).getName());
		}catch(Exception e) {
			fail(e.getMessage());
		}
		Mockito.verify(restClient,Mockito.times(1)).headerToken(token);
		
	}
	
	@Test
	public void testInvoiceMock() {
		String usuario = "unionsoluciones";
		String password = "unionsoluciones";
		String numberInvoice = "";
		String responseID = "123456789";
		try {
			injectAPIANDRestClientANDURLUtil();
			Mockito.doReturn(usuario).when(impl).getUser(1);
			Mockito.doReturn(password).when(impl).getPassword(1);
			String result = impl.invoice(numberInvoice,1);
			assertEquals(responseID, result);
		}catch(Exception e) {
			fail(e.getMessage());
		}
		Mockito.verify(restClient,Mockito.times(2)).requestPOSTJson(Mockito.anyString());
		Mockito.verify(restClient,Mockito.times(1)).headerToken(Mockito.anyString());
	}
	
	
	@Test
	public void testNoteMock() {
		String usuario = "japl";
		String password = "japl";
		String numberInvoice = "";
		String responseID = "123456789";
		try {
			injectAPIANDRestClientANDURLUtil();
			Mockito.doReturn(usuario).when(impl).getUser(1);
			Mockito.doReturn(password).when(impl).getPassword(1);
			String result = impl.note(numberInvoice,1);
			assertEquals(responseID, result);
		}catch(ConnectException e) {
			
		}catch(Exception e) {
			fail(e.getMessage());
		}
		Mockito.verify(restClient,Mockito.times(2)).requestPOSTJson(Mockito.anyString());
		Mockito.verify(restClient,Mockito.times(1)).headerToken(Mockito.anyString());
	}
	
	@Test
	public void testGetDocumentStatusMock() {
		String usuario = "japl";
		String password = "japl";
		String number = "YYYYYYYYYY";
		try {
			injectAPIANDRestClientANDURLUtil();
			Mockito.doReturn(usuario).when(impl).getUser(1);
			Mockito.doReturn(password).when(impl).getPassword(1);
			Mockito.doReturn("1").when(impl).getDocumentType(number);
			StatusResponse result = impl.statusBilling(number,1);
			assertNotNull(result);
			assertNotNull(result.getCufe());
			assertNotNull(result.getCustomParty());
			assertNotNull(result.getCustomPartyID());
			assertNotNull(result.getDocumentStatus());
			assertNotNull(result.getDocumentNumber());
			assertNotNull(result.getPayableAmount());
			assertNotNull(result.getStatusDate());
		}catch(Exception e) {
			fail(e.getMessage());
		}
		Mockito.verify(restClient,Mockito.times(1)).requestPOSTJson(Mockito.anyString());
		Mockito.verify(restClient,Mockito.times(1)).requestPOSTEmpty();
		Mockito.verify(restClient,Mockito.times(1)).headerToken(Mockito.anyString());
	}
	
	@Test
	public void testAttachMock() {
		String usuario = "japl";
		String password = "japl";
		String number = "YYYYYYYYYY";
		File file = new File("src/test/resources/filetestattach.txt");
		try {
			
			injectAPIANDRestClientANDURLUtil();
			Mockito.doReturn(usuario).when(impl).getUser(1);
			Mockito.doReturn(password).when(impl).getPassword(1);
			
			List<DocumentsPOJO> result = impl.loadFields(null,1,file);
			
			assertEquals(1, result.size());
			assertNotNull(result.get(0).getId());
			assertNotNull(result.get(0).getName());
		}catch(Exception e) {
			fail(e.getMessage());
		}
		Mockito.verify(restClient,Mockito.times(1)).requestPOSTJson(Mockito.anyString());
		Mockito.verify(restClient,Mockito.times(1)).requestPostFile(file);
		Mockito.verify(restClient,Mockito.times(1)).headerToken(Mockito.anyString());
	}
	
	@Test
	public void testAttachGRMock() {
		String usuario = "japl";
		String password = "japl";
		String number = "YYYYYYYYYY";
		File file = new File("src/test/resources/filetestattach.txt");
		try {
			injectModeAttachFalse();
			injectAPIANDRestClientANDURLUtil();
			Mockito.doReturn(usuario).when(impl).getUser(1);
			Mockito.doReturn(password).when(impl).getPassword(1);
			
			List<DocumentsPOJO> result = impl.loadFields(null,1,file);
			
			assertEquals(1, result.size());
			assertNotNull(result.get(0).getId());
			assertNotNull(result.get(0).getName());
		}catch(Exception e) {
			fail(e.getMessage());
		}
		Mockito.verify(restClient,Mockito.times(1)).requestPOSTJson(Mockito.anyString());
		Mockito.verify(restClient,Mockito.times(1)).requestPostFile(file);
		Mockito.verify(restClient,Mockito.times(1)).headerToken(Mockito.anyString());
	}
	
	@Test 
	public void testInsertInvoiceIntegration() {
		String usuario = "japl";
		String password = "japl";
		String numberInvoice = "";
		try {
			BillingRequest request = createInvoice();
			injectAPIANDRestClientANDURLUtilIntegration();
			Mockito.doReturn(usuario).when(impl).getUser(1);
			Mockito.doReturn(password).when(impl).getPassword(1);
			Mockito.doReturn(request).when(impl).mapperInvoice(numberInvoice);
			Mockito.doReturn("1").when(impl).getDocumentType(Mockito.anyString());
			File file = new File("src/test/resources/funcionesSql.pdf");
			
			String result = impl.invoice(numberInvoice,1,file);
			StatusResponse status = impl.statusBilling(result, 1);
			
			assertNotNull(status.getStatusDate());
			assertNotNull(status.getCufe());
			assertNotNull(status.getDocumentStatus());
			assertNotNull(result);
			//assertEquals(5,status.getDianErrors().size());
		}catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		Mockito.verify(restClient,Mockito.times(4)).requestPOSTJson(Mockito.anyString());
		//Mockito.verify(restClient,Mockito.times(2)).connect(Mockito.anyString(), Mockito.anyString());
		assertTrue(Cache.instance().exists(usuario));
	}
	
	@Test 
	public void testInsertInvoiceIntegrationGR() {
		String usuario = "japl";
		String password = "japl";
		String numberInvoice = "";
		try {
			injectAPIANDRestClientANDURLUtilIntegration();
			BillingRequest request = createInvoice();
			File file = new File("src/test/resources/funcionesSql.pdf");

			Mockito.doReturn(usuario).when(impl).getUser(1);
			Mockito.doReturn(password).when(impl).getPassword(1);
			Mockito.doReturn(request).when(impl).mapperInvoice(numberInvoice);
			Mockito.doReturn("1").when(impl).getDocumentType(Mockito.anyString());
			

			String result = impl.invoice(numberInvoice,1);
			StatusResponse status = impl.statusBilling(result, 1);
			List<DocumentsPOJO> docs = impl.loadFields(result, 1, file);
			
			assertNotNull(status.getStatusDate());
			assertNotNull(status.getCufe());
			assertNotNull(status.getDocumentStatus());
			assertNotNull(result);
			//assertEquals(5,status.getDianErrors().size());
		}catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		Mockito.verify(restClient,Mockito.times(4)).requestPOSTJson(Mockito.anyString());
		//Mockito.verify(restClient,Mockito.times(2)).connect(Mockito.anyString(), Mockito.anyString());
		assertTrue(Cache.instance().exists(usuario));
	}
	
	@Test 
	public void testInsertnoteIntegration() {
		String usuario = "japl";
		String password = "japl";
		String numberInvoice = "";
		try {
			NoteRequest request = createNote();
			injectAPIANDRestClientANDURLUtilIntegration();
			Mockito.doReturn(usuario).when(impl).getUser(1);
			Mockito.doReturn(password).when(impl).getPassword(1);
			Mockito.doReturn(request).when(impl).mapperNote(numberInvoice);
			
			String result = impl.note(numberInvoice,1);
			
			assertNotNull(result);
		}catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		Mockito.verify(restClient,Mockito.times(1)).requestPOSTJson(Mockito.anyString());
		Mockito.verify(restClient,Mockito.times(1)).connect(Mockito.anyString(), Mockito.anyString());
		assertTrue(Cache.instance().exists(usuario));
	}
	
	private BillingRequest createInvoice()throws Exception {
		String json = getJsonSaveIntoFile("invoice1.json");
		return instaceGson().fromJson(json, BillingRequest.class);
	}
	private NoteRequest createNote()throws Exception {
		String json = getJsonSaveIntoFile("note1.json");
		return instaceGson().fromJson(json, NoteRequest.class);
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
