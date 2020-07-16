package co.com.japl.facturacionelectronica.dto;

public class AdditionalDocumentsDTO {
	private String orderReference;
	private String despatchDocumentReference;
	private String receiptDocumentReference;
	private String additionalDocument;
	private String llave;
	public String getOrderReference() {
		return orderReference;
	}
	public void setOrderReference(String orderReference) {
		this.orderReference = orderReference;
	}
	public String getDespatchDocumentReference() {
		return despatchDocumentReference;
	}
	public void setDespatchDocumentReference(String despatchDocumentReference) {
		this.despatchDocumentReference = despatchDocumentReference;
	}
	public String getReceiptDocumentReference() {
		return receiptDocumentReference;
	}
	public void setReceiptDocumentReference(String receiptDocumentReference) {
		this.receiptDocumentReference = receiptDocumentReference;
	}
	public String getAdditionalDocument() {
		return additionalDocument;
	}
	public void setAdditionalDocument(String additionalDocument) {
		this.additionalDocument = additionalDocument;
	}
	public String getLlave() {
		return llave;
	}
	public void setLlave(String llave) {
		this.llave = llave;
	}
}
