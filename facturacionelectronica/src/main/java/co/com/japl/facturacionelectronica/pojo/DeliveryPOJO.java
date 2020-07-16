package co.com.japl.facturacionelectronica.pojo;

import static co.com.japl.facturacionelectronica.constants.Constants.CONST_FORMAT_DATE_STANDARD;

import java.util.Date;

import co.com.japl.facturacionelectronica.dto.DeliveryDTO;
import co.com.japl.facturacionelectronica.util.DateUtils;

public class DeliveryPOJO {
	private String addressLine;
	private String countryCode;
	private String countryName;
	private Integer subdivisionCode;
	private String subdivisionName;
	private Integer cityCode;
	private String cityName;
	private Integer contactPerson;
	private Date   deliveryDate;
	private String deliveryCompany;
	
	public DeliveryPOJO() {}
	
	public DeliveryPOJO(DeliveryDTO delivery) {
		addressLine = delivery.getAddressLine();
		countryCode = delivery.getCountryCode();
		countryName = delivery.getCityName();
		subdivisionCode = Integer.valueOf(delivery.getSubdivisionCode());
		subdivisionName = delivery.getSubdivisionName();
		cityCode = Integer.valueOf(delivery.getCityCode());
		cityName = delivery.getCityName();
		contactPerson = Integer.valueOf(delivery.getContactPerson());
		deliveryDate = DateUtils.format(delivery.getDeliveryDate(),CONST_FORMAT_DATE_STANDARD);
		deliveryCompany = delivery.getDeliveryCompany();
	}
	
	
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public Integer getSubdivisionCode() {
		return subdivisionCode;
	}
	public void setSubdivisionCode(Integer subdivisionCode) {
		this.subdivisionCode = subdivisionCode;
	}
	public String getSubdivisionName() {
		return subdivisionName;
	}
	public void setSubdivisionName(String subdivisionName) {
		this.subdivisionName = subdivisionName;
	}
	public Integer getCityCode() {
		return cityCode;
	}
	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Integer getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(Integer contactPerson) {
		this.contactPerson = contactPerson;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getDeliveryCompany() {
		return deliveryCompany;
	}
	public void setDeliveryCompany(String deliveryCompany) {
		this.deliveryCompany = deliveryCompany;
	}
	
}