package co.com.japl.facturacionelectronica.request;

public class BaseRequest extends ARequest{
	
	private String documentID;
	private Integer documentType;
	public String getDocumentID() {
		return documentID;
	}
	public void setDocumentID(String documentID) {
		this.documentID = documentID;
	}
	public Integer getDocumentType() {
		return documentType;
	}
	public void setDocumentType(Integer documentType) {
		this.documentType = documentType;
	}
}