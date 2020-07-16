package co.com.japl.facturacionelectronica.pojo;

import co.com.japl.facturacionelectronica.dto.InvoiceTotalDTO;

public class InvoiceTotalPOJO  {
	private double lineExtensionAmount;
	private double taxExclusiveAmount;
	private double taxInclusiveAmount;
	private double allowanceTotalAmount;
	private double chargeTotalAmount;
	private double prePaidAmount;
	private double payableAmount;
	
	public InvoiceTotalPOJO() {}
	public InvoiceTotalPOJO(InvoiceTotalDTO dto) {
		lineExtensionAmount = Double.valueOf(dto.getLineExtensionAmount());
		taxExclusiveAmount = Double.valueOf(dto.getTaxExclusiveAmount());
		taxInclusiveAmount = Double.valueOf(dto.getTaxInclusiveAmount());
		allowanceTotalAmount = Double.valueOf(dto.getAllowanceTotalAmount());
		chargeTotalAmount = Double.valueOf(dto.getChargeTotalAmount());
		prePaidAmount = Double.valueOf(dto.getPrePaidAmount());
		payableAmount = Double.valueOf(dto.getPayableAmount());
	}
	
	public Double getLineExtensionAmount() {
		return lineExtensionAmount;
	}
	public void setLineExtensionAmount(Double lineExtensionAmount) {
		this.lineExtensionAmount = lineExtensionAmount;
	}
	public Double getTaxExclusiveAmount() {
		return taxExclusiveAmount;
	}
	public void setTaxExclusiveAmount(Double taxExclusiveAmount) {
		this.taxExclusiveAmount = taxExclusiveAmount;
	}
	public Double getTaxInclusiveAmount() {
		return taxInclusiveAmount;
	}
	public void setTaxInclusiveAmount(Double taxInclusiveAmount) {
		this.taxInclusiveAmount = taxInclusiveAmount;
	}
	public Double getAllowanceTotalAmount() {
		return allowanceTotalAmount;
	}
	public void setAllowanceTotalAmount(Double allowanceTotalAmount) {
		this.allowanceTotalAmount = allowanceTotalAmount;
	}
	public Double getChargeTotalAmount() {
		return chargeTotalAmount;
	}
	public void setChargeTotalAmount(Double chargeTotalAmount) {
		this.chargeTotalAmount = chargeTotalAmount;
	}
	public Double getPrePaidAmount() {
		return prePaidAmount;
	}
	public void setPrePaidAmount(Double prePaidAmount) {
		this.prePaidAmount = prePaidAmount;
	}
	public Double getPayableAmount() {
		return payableAmount;
	}
	public void setPayableAmount(Double payableAmount) {
		this.payableAmount = payableAmount;
	}
}