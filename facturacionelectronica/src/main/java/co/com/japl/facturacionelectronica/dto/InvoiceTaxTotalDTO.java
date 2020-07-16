package co.com.japl.facturacionelectronica.dto;

public class InvoiceTaxTotalDTO {
	private String id;
	private String taxEvidenceIndicator;
	private String taxableAmount;
	private String taxAmount;
	private String percent;
	private String baseUnitMeasure;
	private String perUnitAmount;
	private String llave;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTaxEvidenceIndicator() {
		return taxEvidenceIndicator;
	}
	public void setTaxEvidenceIndicator(String taxEvidenceIndicator) {
		this.taxEvidenceIndicator = taxEvidenceIndicator;
	}
	public String getTaxableAmount() {
		return taxableAmount;
	}
	public void setTaxableAmount(String taxableAmount) {
		this.taxableAmount = taxableAmount;
	}
	public String getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(String taxAmount) {
		this.taxAmount = taxAmount;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
	public String getBaseUnitMeasure() {
		return baseUnitMeasure;
	}
	public void setBaseUnitMeasure(String baseUnitMeasure) {
		this.baseUnitMeasure = baseUnitMeasure;
	}
	public String getPerUnitAmount() {
		return perUnitAmount;
	}
	public void setPerUnitAmount(String perUnitAmount) {
		this.perUnitAmount = perUnitAmount;
	}
	public String getLlave() {
		return llave;
	}
	public void setLlave(String llave) {
		this.llave = llave;
	}
}
