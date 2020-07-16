package co.com.japl.facturacionelectronica.pojo;

import static co.com.japl.facturacionelectronica.constants.Constants.CONST_FORMAT_DATE_STANDARD;

import java.util.Date;

import co.com.japl.facturacionelectronica.dto.InvoiceGeneralInformationDTO;
import co.com.japl.facturacionelectronica.util.DateUtils;

public class InvoiceGeneralInformationPOJO  {
	private Long invoiceAuthorizationNumber;
	private Integer preinvoiceNumber;
	private Integer invoiceNumber;
	private Integer daysOff;
	private String currency;
	private String exchangeRate;
	private Date exchangeRateDate;
	private Integer salesPerson;
	private String note;
	private Boolean externalGR;
	private Date invoiceDueDate;
	public InvoiceGeneralInformationPOJO() {
	}
	
	public InvoiceGeneralInformationPOJO(InvoiceGeneralInformationDTO invoice) {
		invoiceAuthorizationNumber = Long.valueOf(invoice.getInvoiceAuthorizationNumber());
		preinvoiceNumber = Integer.valueOf(invoice.getPreinvoiceNumber());
		daysOff = Integer.valueOf(invoice.getDaysOff());
		currency = invoice.getCurrency();
		exchangeRate  = invoice.getExchangeRate();
		exchangeRateDate = DateUtils.format(invoice.getExchangeRateDate(),CONST_FORMAT_DATE_STANDARD);
		salesPerson = Integer.valueOf(invoice.getSalesPerson());
		note = invoice.getNote();
		externalGR = Boolean.valueOf(invoice.getExternalGr());
	}

	public Long getInvoiceAuthorizationNumber() {
		return invoiceAuthorizationNumber;
	}
	public void setInvoiceAuthorizationNumber(Long invoiceAuthorizationNumber) {
		this.invoiceAuthorizationNumber = invoiceAuthorizationNumber;
	}
	public Integer getPreinvoiceNumber() {
		return preinvoiceNumber;
	}
	public void setPreinvoiceNumber(Integer preinvoiceNumber) {
		this.preinvoiceNumber = preinvoiceNumber;
	}
	public Integer getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(Integer invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public Integer getDaysOff() {
		return daysOff;
	}
	public void setDaysOff(Integer daysOff) {
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
	public Date getExchangeRateDate() {
		return exchangeRateDate;
	}
	public void setExchangeRateDate(Date exchangeRateDate) {
		this.exchangeRateDate = exchangeRateDate;
	}
	public Integer getSalesPerson() {
		return salesPerson;
	}
	public void setSalesPerson(Integer salesPerson) {
		this.salesPerson = salesPerson;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Boolean getExternalGR() {
		return externalGR;
	}
	public void setExternalGR(Boolean externalGR) {
		this.externalGR = externalGR;
	}
	public Date getInvoiceDueDate() {
		return invoiceDueDate;
	}
	public void setInvoiceDueDate(Date invoiceDueDate) {
		this.invoiceDueDate = invoiceDueDate;
	}
}