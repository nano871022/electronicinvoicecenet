package co.com.japl.facturacionelectronica.pojo;

import java.util.List;

import com.google.gson.annotations.JsonAdapter;

import co.com.japl.facturacionelectronica.util.EmptyStringAsNullTypeAdapter;

public class ItemInformationPOJO {
	private Integer itemReference;
	private String name;
	private double quatity;
	private double price;
	private double lineAllowanceTotal;
	private double lineChargeTotal;
	private double lineTotalTaxes;
	private double lineTotal;
	private double lineExtensionAmount;
	private String measureUnitCode;
	private boolean freeOFChargeIndicator;
	private List<AdditionalReferencePOJO> additionalReference;
	private List<AdditionalPropertyPOJO> additionalProperty;
	private List<TaxesInformationPOJO> taxesInformation;
	private List<AllowanceChargePOJO> allowanceCharge;
	public Integer getItemReference() {
		return itemReference;
	}
	public void setItemReference(Integer itemReference) {
		this.itemReference = itemReference;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getQuatity() {
		return quatity;
	}
	public void setQuatity(double quatity) {
		this.quatity = quatity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public double getLineAllowanceTotal() {
		return lineAllowanceTotal;
	}
	public void setLineAllowanceTotal(double lineAllowanceTotal) {
		this.lineAllowanceTotal = lineAllowanceTotal;
	}
	public double getLineChargeTotal() {
		return lineChargeTotal;
	}
	public void setLineChargeTotal(double lineChargeTotal) {
		this.lineChargeTotal = lineChargeTotal;
	}
	public double getLineTotalTaxes() {
		return lineTotalTaxes;
	}
	public void setLineTotalTaxes(double lineTotalTaxes) {
		this.lineTotalTaxes = lineTotalTaxes;
	}
	public double getLineTotal() {
		return lineTotal;
	}
	public void setLineTotal(double lineTotal) {
		this.lineTotal = lineTotal;
	}
	public double getLineExtensionAmount() {
		return lineExtensionAmount;
	}
	public void setLineExtensionAmount(Integer lineExtensionAmount) {
		this.lineExtensionAmount = lineExtensionAmount;
	}
	public String getMeasureUnitCode() {
		return measureUnitCode;
	}
	public void setMeasureUnitCode(String measureUnitCode) {
		this.measureUnitCode = measureUnitCode;
	}
	public boolean isFreeOFChargeIndicator() {
		return freeOFChargeIndicator;
	}
	public void setFreeOFChargeIndicator(boolean freeOFChargeIndicator) {
		this.freeOFChargeIndicator = freeOFChargeIndicator;
	}
	public List<AdditionalReferencePOJO> getAdditionalReference() {
		return additionalReference;
	}
	public void setAdditionalReference(List<AdditionalReferencePOJO> additionalReference) {
		this.additionalReference = additionalReference;
	}
	public List<AdditionalPropertyPOJO> getAdditionalProperty() {
		return additionalProperty;
	}
	public void setAdditionalProperty(List<AdditionalPropertyPOJO> additionalProperty) {
		this.additionalProperty = additionalProperty;
	}
	public List<TaxesInformationPOJO> getTaxesInformation() {
		return taxesInformation;
	}
	public void setTaxesInformation(List<TaxesInformationPOJO> taxesInformation) {
		this.taxesInformation = taxesInformation;
	}
	public List<AllowanceChargePOJO> getAllowanceCharge() {
		return allowanceCharge;
	}
	public void setAllowanceCharge(List<AllowanceChargePOJO> allowanceCharge) {
		this.allowanceCharge = allowanceCharge;
	}

}