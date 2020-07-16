package co.com.japl.facturacionelectronica.dto;

public class InvoiceGeneralInformationDTO {
	private String invoiceAuthorizationNumber;
	private String preinvoiceNumber;
	private String daysOff;
	private String currency;
	private String exchangeRate;
	private String exchangeRateDate;
	private String salesPerson;
	private String note;
	private String externalGr;
	private String llave;
	public String getInvoiceAuthorizationNumber() {
		return invoiceAuthorizationNumber;
	}
	public void setInvoiceAuthorizationNumber(String invoiceAuthorizationNumber) {
		this.invoiceAuthorizationNumber = invoiceAuthorizationNumber;
	}
	public String getPreinvoiceNumber() {
		return preinvoiceNumber;
	}
	public void setPreinvoiceNumber(String preinvoiceNumber) {
		this.preinvoiceNumber = preinvoiceNumber;
	}
	public String getDaysOff() {
		return daysOff;
	}
	public void setDaysOff(String daysOff) {
		this.daysOff = daysOff;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public String getExchangeRateDate() {
		return exchangeRateDate;
	}
	public void setExchangeRateDate(String exchangeRateDate) {
		this.exchangeRateDate = exchangeRateDate;
	}
	public String getSalesPerson() {
		return salesPerson;
	}
	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getExternalGr() {
		return externalGr;
	}
	public void setExternalGr(String externalGr) {
		this.externalGr = externalGr;
	}
	public String getLlave() {
		return llave;
	}
	public void setLlave(String llave) {
		this.llave = llave;
	}
}
