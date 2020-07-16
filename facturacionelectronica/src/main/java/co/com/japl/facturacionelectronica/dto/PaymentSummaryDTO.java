package co.com.japl.facturacionelectronica.dto;

public class PaymentSummaryDTO {
	private String paymentType;
	private String paymentMeans;
	private String paymentNote;
	private String llave;
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getPaymentMeans() {
		return paymentMeans;
	}
	public void setPaymentMeans(String paymentMeans) {
		this.paymentMeans = paymentMeans;
	}
	public String getPaymentNote() {
		return paymentNote;
	}
	public void setPaymentNote(String paymentNote) {
		this.paymentNote = paymentNote;
	}
	public String getLlave() {
		return llave;
	}
	public void setLlave(String llave) {
		this.llave = llave;
	}
}
