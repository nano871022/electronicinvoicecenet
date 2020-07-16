package co.com.japl.facturacionelectronica.pojo;

public class AllowanceChargePOJO {
	private Integer id;
	private Boolean chargeIndicator;
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
	public Boolean getChargeIndicator() {
		return chargeIndicator;
	}
	public void setChargeIndicator(Boolean chargeIndicator) {
		this.chargeIndicator = chargeIndicator;
	}
	public String getAllowanceChargeReason() {
		return allowanceChargeReason;
	}
	public void setAllowanceChargeReason(String allowanceChargeReason) {
		this.allowanceChargeReason = allowanceChargeReason;
	}
	public Double getMultiplierFactorNumeric() {
		return multiplierFactorNumeric;
	}
	public void setMultiplierFactorNumeric(Double multiplierFactorNumeric) {
		this.multiplierFactorNumeric = multiplierFactorNumeric;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getBaseAmount() {
		return baseAmount;
	}
	public void setBaseAmount(Double baseAmount) {
		this.baseAmount = baseAmount;
	}
}