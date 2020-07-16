package co.com.japl.facturacionelectronica.pojo;

public class InvoiceAllowanceChargePOJO {
	private Integer id;
	private boolean chargeIndicator;
	private String allowanceChargeReason;
	private double multiplierFactorNumeric;
	private double amount;
	private double baseAmount;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public boolean isChargeIndicator() {
		return chargeIndicator;
	}
	public void setChargeIndicator(boolean chargeIndicator) {
		this.chargeIndicator = chargeIndicator;
	}
	public String getAllowanceChargeReason() {
		return allowanceChargeReason;
	}
	public void setAllowanceChargeReason(String allowanceChargeReason) {
		this.allowanceChargeReason = allowanceChargeReason;
	}
	public double getMultiplierFactorNumeric() {
		return multiplierFactorNumeric;
	}
	public void setMultiplierFactorNumeric(double multiplierFactorNumeric) {
		this.multiplierFactorNumeric = multiplierFactorNumeric;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getBaseAmount() {
		return baseAmount;
	}
	public void setBaseAmount(double baseAmount) {
		this.baseAmount = baseAmount;
	}
}