package co.com.japl.facturacionelectronica.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import co.com.japl.facturacionelectronica.exception.BillingException;
import co.com.japl.facturacionelectronica.mapper.InvoiceMapper;
import co.com.japl.facturacionelectronica.mapper.NoteMapper;
import co.com.japl.facturacionelectronica.pojo.DocumentsPOJO;
import co.com.japl.facturacionelectronica.request.BillingRequest;
import co.com.japl.facturacionelectronica.request.NoteRequest;
import co.com.japl.facturacionelectronica.response.AttachResponse;
import co.com.japl.facturacionelectronica.response.InsertResponse;
import co.com.japl.facturacionelectronica.response.StatusResponse;
import co.com.japl.facturacionelectronica.svc.IElectronicBillingAPI;
import co.com.japl.facturacionelectronica.svc.IElectronicBillingSvc;

@Stateless
public class ElectronicBillingSvc implements IElectronicBillingSvc{

	private IElectronicBillingAPI api = new ElectronicBillingAPI();

	protected BillingRequest mapperInvoice(String invoiceNumber) {
		InvoiceMapper mapper = new InvoiceMapper(invoiceNumber);
		return mapper.invoice(invoiceNumber);
	}
	
	protected NoteRequest mapperNote(String invoiceNumber) {
		NoteMapper mapper = new NoteMapper(invoiceNumber);
		return mapper.note();
	}
	
	public String invoice(String invoiceNumber,Integer empresa,File... fileAttach)throws BillingException{
		BillingRequest request = mapperInvoice(invoiceNumber);
		if(fileAttach.length > 0){
			List<DocumentsPOJO> list = loadFields(null,empresa,fileAttach);
			request.setDocuments(list);
		}
		String documentID = getUser(empresa);
		InsertResponse response = api.invoice(request,documentID,getToken(empresa));
		
		updateInvoice(invoiceNumber,response);
		return response.getDocumentID();
	}

	public String note(String noteNumber,Integer empresa)throws BillingException{
		NoteRequest request = mapperNote(noteNumber);
		String token = getToken(empresa);
		String documentId = getUser(empresa);
		
		InsertResponse response = api.note(request,documentId,token);
		updateNote(noteNumber,response);
		return response.getDocumentID();	
	}

	public StatusResponse statusBilling(String documentID,Integer empresa)throws BillingException{
		String documentType = getDocumentType(documentID);
		String token = getToken(empresa);
		String idNumber = getUser(empresa);
		
		StatusResponse response = api.statusBilling(documentType,documentID,idNumber,token);

		update(documentID,response);
		return response;
	}

	protected List<DocumentsPOJO> loadFields(String documentID,Integer empresa,File... files)throws BillingException{
		List<DocumentsPOJO> list = new ArrayList<DocumentsPOJO>();
		String token = getToken(empresa);
		String idNumber = getUser(empresa);
		AttachResponse response = null;
		for(File file : files){
			response = null;
			response = api.attach(file,idNumber,token);
			if(response != null && response.getList().size() > 0) {
				list.add(new DocumentsPOJO(response.getList().get(0)));
			}
		}
		return list;
	}
	
	public void attachInvoice(String idInvoice,String idNumber,File file,int empresa)throws BillingException {
		if(file != null && file.exists() && file.isFile()) {
			String type = getDocumentType(idInvoice);
			String token = getToken(empresa);
			api.attachGR(type,idInvoice,idNumber,file,token);
		}else {
			throw new BillingException("No se suministro un archivo valido.");
		}
	}

	private String getToken(Integer empresa)throws BillingException{
		String usuario = getUser(empresa);
		String password = getPassword(empresa);
		return api.login(usuario,password);
	}
	
	protected String getDocumentType(String documentID)throws BillingException {
		String isInvoice = "1";
		String isNote = "2";
		String typeDocument = typeDocument(documentID);
		if(isInvoice.contains(typeDocument)) {
			return "1";
		}else if(isNote.contains(typeDocument)) {
			return "2";
		}
		throw new BillingException("No se encontro el tipo de factura");
	}
	
	private String typeDocument(String documentID) {
		return "1";
	}

	private void update(String number,StatusResponse response){

	}

	private void updateNote(String number,InsertResponse response){

	}

	private void updateInvoice(String number,InsertResponse response){

	}

	protected String getUser(Integer empresa){
		return "";
	}
	protected String getPassword(Integer empresa){
		return "";
	}
}