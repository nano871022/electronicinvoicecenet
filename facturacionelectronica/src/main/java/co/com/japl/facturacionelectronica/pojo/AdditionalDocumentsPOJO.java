package co.com.japl.facturacionelectronica.pojo;

import java.util.List;

import co.com.japl.facturacionelectronica.dto.AdditionalDocumentsDTO;

public class AdditionalDocumentsPOJO {
	private Integer orderReference;
	private Integer despatchDocumentReference;
	private Integer receiptDocumentReference;
	private List<AdditionalDocumentPOJO> additionalDocument;
	
	public AdditionalDocumentsPOJO() {}
	public AdditionalDocumentsPOJO(AdditionalDocumentsDTO docs) {
		orderReference = Integer.valueOf(docs.getOrderReference());
		despatchDocumentReference = Integer.valueOf(docs.getDespatchDocumentReference());
		receiptDocumentReference = Integer.valueOf(docs.getReceiptDocumentReference());
	}
	
	public Integer getOrderReference() {
		return orderReference;
	}
	public void setOrderReference(Integer orderReference) {
		this.orderReference = orderReference;
	}
	public Integer getDespatchDocumentReference() {
		return despatchDocumentReference;
	}
	public void setDespatchDocumentReference(Integer despatchDocumentReference) {
		this.despatchDocumentReference = despatchDocumentReference;
	}
	public Integer getReceiptDocumentReference() {
		return receiptDocumentReference;
	}
	public void setReceiptDocumentReference(Integer receiptDocumentReference) {
		this.receiptDocumentReference = receiptDocumentReference;
	}
	public List<AdditionalDocumentPOJO> getAdditionalDocument() {
		return additionalDocument;
	}
	public void setAdditionalDocument(List<AdditionalDocumentPOJO> additionalDocument) {
		this.additionalDocument = additionalDocument;
	}
	
}	