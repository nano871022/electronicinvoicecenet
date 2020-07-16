package co.com.japl.facturacionelectronica.pojo;

import co.com.japl.facturacionelectronica.dto.PaymentSummaryDTO;

public class PaymentSummaryPOJO {
	private Integer paymentType;
	private Integer paymentMeans;
	private String paymentNote;
	
	public PaymentSummaryPOJO() {}
	public PaymentSummaryPOJO(PaymentSummaryDTO payment) {
		paymentType = Integer.valueOf(payment.getPaymentType());
		paymentMeans = Integer.valueOf(payment.getPaymentMeans());
		paymentNote = payment.getPaymentNote();
	}
	
	public Integer getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}
	public Integer getPaymentMeans() {
		return paymentMeans;
	}
	public void setPaymentMeans(Integer paymentMeans) {
		this.paymentMeans = paymentMeans;
	}
	public String getPaymentNote() {
		return paymentNote;
	}
	public void setPaymentNote(String paymentNote) {
		this.paymentNote = paymentNote;
	}
	
}