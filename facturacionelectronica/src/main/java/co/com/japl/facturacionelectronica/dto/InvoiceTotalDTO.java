package co.com.japl.facturacionelectronica.dto;

public class InvoiceTotalDTO {
	private String lineExtensionAmount;
	private String taxExclusiveAmount;
	private String taxInclusiveAmount;
	private String allowanceTotalAmount;
	private String chargeTotalAmount;
	private String prePaidAmount;
	private String payableAmount;
	private String llave;
	public String getLineExtensionAmount() {
		return lineExtensionAmount;
	}
	public void setLineExtensionAmount(String lineExtensionAmount) {
		this.lineExtensionAmount = lineExtensionAmount;
	}
	public String getTaxExclusiveAmount() {
		return taxExclusiveAmount;
	}
	public void setTaxExclusiveAmount(String taxExclusiveAmount) {
		this.taxExclusiveAmount = taxExclusiveAmount;
	}
	public String getTaxInclusiveAmount() {
		return taxInclusiveAmount;
	}
	public void setTaxInclusiveAmount(String taxInclusiveAmount) {
		this.taxInclusiveAmount = taxInclusiveAmount;
	}
	public String getAllowanceTotalAmount() {
		return allowanceTotalAmount;
	}
	public void setAllowanceTotalAmount(String allowanceTotalAmount) {
		this.allowanceTotalAmount = allowanceTotalAmount;
	}
	public String getChargeTotalAmount() {
		return chargeTotalAmount;
	}
	public void setChargeTotalAmount(String chargeTotalAmount) {
		this.chargeTotalAmount = chargeTotalAmount;
	}
	public String getPrePaidAmount() {
		return prePaidAmount;
	}
	public void setPrePaidAmount(String prePaidAmount) {
		this.prePaidAmount = prePaidAmount;
	}
	public String getPayableAmount() {
		return payableAmount;
	}
	public void setPayableAmount(String payableAmount) {
		this.payableAmount = payableAmount;
	}
	public String getLlave() {
		return llave;
	}
	public void setLlave(String llave) {
		this.llave = llave;
	}
}
