package co.com.japl.facturacionelectronica.request;

import java.util.List;

import co.com.japl.facturacionelectronica.pojo.*;

public class BillingRequest{
	private CustomerInformationPOJO customerInformation;
	private InvoiceGeneralInformationPOJO invoiceGeneralInformation; 
	private DeliveryPOJO delivery;
	private AdditionalDocumentsPOJO additionalDocuments;
	private List<AdditionalPropertyPOJO> AdditionalProperty;
	private PaymentSummaryPOJO paymentSummary;
	private List<ItemInformationPOJO> ItemInformation;
	private List<InvoiceTaxTotalPOJO> invoiceTaxTotal;
	private List<InvoiceAllowanceChargePOJO> invoiceAllowanceCharge;
	private InvoiceTotalPOJO invoiceTotal;
	private List<DocumentsPOJO> documents;
	public CustomerInformationPOJO getCustomerInformation() {
		return customerInformation;
	}
	public void setCustomerInformation(CustomerInformationPOJO customerInformation) {
		this.customerInformation = customerInformation;
	}
	public InvoiceGeneralInformationPOJO getInvoiceGeneralInformation() {
		return invoiceGeneralInformation;
	}
	public void setInvoiceGeneralInformation(InvoiceGeneralInformationPOJO invoiceGeneralInformation) {
		this.invoiceGeneralInformation = invoiceGeneralInformation;
	}
	public DeliveryPOJO getDelivery() {
		return delivery;
	}
	public void setDelivery(DeliveryPOJO delivery) {
		this.delivery = delivery;
	}
	public AdditionalDocumentsPOJO getAdditionalDocuments() {
		return additionalDocuments;
	}
	public void setAdditionalDocuments(AdditionalDocumentsPOJO additionalDouments) {
		this.additionalDocuments = additionalDouments;
	}
	public List<AdditionalPropertyPOJO> getAdditionalProperty() {
		return AdditionalProperty;
	}
	public void setAdditionalProperty(List<AdditionalPropertyPOJO> additionalProperty) {
		AdditionalProperty = additionalProperty;
	}
	public PaymentSummaryPOJO getPaymentSummary() {
		return paymentSummary;
	}
	public void setPaymentSummary(PaymentSummaryPOJO paymentSummary) {
		this.paymentSummary = paymentSummary;
	}
	public List<ItemInformationPOJO> getItemInformation() {
		return ItemInformation;
	}
	public void setItemInformation(List<ItemInformationPOJO> itemInformation) {
		ItemInformation = itemInformation;
	}
	public List<InvoiceTaxTotalPOJO> getInvoiceTaxTotal() {
		return invoiceTaxTotal;
	}
	public void setInvoiceTaxTotal(List<InvoiceTaxTotalPOJO> invoiceTaxTotal) {
		this.invoiceTaxTotal = invoiceTaxTotal;
	}
	public List<InvoiceAllowanceChargePOJO> getInvoiceAllowanceCharge() {
		return invoiceAllowanceCharge;
	}
	public void setInvoiceAllowanceCharge(List<InvoiceAllowanceChargePOJO> invoiceAllowanceCharge) {
		this.invoiceAllowanceCharge = invoiceAllowanceCharge;
	}
	public InvoiceTotalPOJO getInvoiceTotal() {
		return invoiceTotal;
	}
	public void setInvoiceTotal(InvoiceTotalPOJO invoiceTotal) {
		this.invoiceTotal = invoiceTotal;
	}
	public List<DocumentsPOJO> getDocuments() {
		return documents;
	}
	public void setDocuments(List<DocumentsPOJO> documents) {
		this.documents = documents;
	}
}