package co.com.japl.facturacionelectronica.pojo;

import co.com.japl.facturacionelectronica.dto.InvoiceTaxTotalDTO;

public class InvoiceTaxTotalPOJO {
	private String id;
	private boolean taxEvidenceIndicator;
	private double taxableAmount;
	private double taxAmount;
	private double percent;
	private String baseUnitMeasure;
	private double perUnitAmount;
	
	public InvoiceTaxTotalPOJO() {}
	public InvoiceTaxTotalPOJO(InvoiceTaxTotalDTO dto) {
		id = dto.getId();
		taxEvidenceIndicator = Boolean.valueOf(dto.getTaxEvidenceIndicator());
		taxableAmount = Double.valueOf(dto.getTaxableAmount());
		taxAmount = Double.valueOf(dto.getTaxAmount());
		percent = Double.valueOf(dto.getPercent());
		baseUnitMeasure = dto.getBaseUnitMeasure();
		perUnitAmount = Double.valueOf(dto.getPerUnitAmount());
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Boolean getTaxEvidenceIndicator() {
		return taxEvidenceIndicator;
	}
	public void setTaxEvidenceIndicator(Boolean taxEvidenceIndicator) {
		this.taxEvidenceIndicator = taxEvidenceIndicator;
	}
	public Double getTaxableAmount() {
		return taxableAmount;
	}
	public void setTaxableAmount(Double taxableAmount) {
		this.taxableAmount = taxableAmount;
	}
	public Double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public Double getPercent() {
		return percent;
	}
	public void setPercent(Double percent) {
		this.percent = percent;
	}
	public String getBaseUnitMeasure() {
		return baseUnitMeasure;
	}
	public void setBaseUnitMeasure(String baseUnitMeasure) {
		this.baseUnitMeasure = baseUnitMeasure;
	}
	public Double getPerUnitAmount() {
		return perUnitAmount;
	}
	public void setPerUnitAmount(Double perUnitAmount) {
		this.perUnitAmount = perUnitAmount;
	}
}