package co.com.japl.facturacionelectronica.pojo;

import com.google.gson.annotations.JsonAdapter;

import co.com.japl.facturacionelectronica.util.EmptyStringAsNullTypeAdapter;

public class TaxesInformationPOJO {
	private String id;
	private Boolean taxEvidenceIndicator;
	private double taxableAmount;
	private double taxAmount;
	private double percent;
	@JsonAdapter(value = EmptyStringAsNullTypeAdapter.class)
	private Integer baseUnitMeasure;
	private double perUnitAmount;
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
	public Integer getBaseUnitMeasure() {
		return baseUnitMeasure;
	}
	public void setBaseUnitMeasure(Integer baseUnitMeasure) {
		this.baseUnitMeasure = baseUnitMeasure;
	}
	public Double getPerUnitAmount() {
		return perUnitAmount;
	}
	public void setPerUnitAmount(Double perUnitAmount) {
		this.perUnitAmount = perUnitAmount;
	}
}
