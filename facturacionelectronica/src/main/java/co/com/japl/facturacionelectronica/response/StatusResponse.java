package co.com.japl.facturacionelectronica.response;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import co.com.japl.facturacionelectronica.pojo.DIANError;

public class StatusResponse{
	
	private String documentStatus;
	private Date statusDate;
	private String documentNumber;
	private String noteNumber;
	private String customPartyID;
	private BigDecimal payableAmount;
	private String customParty;
	@SerializedName(value = "CUFE")
	private String cufe;
	@SerializedName(value = "DIANErrors")
	private List<DIANError> dianErrors;
	public String getDocumentStatus() {
		return documentStatus;
	}
	public void setDocumentStatus(String documentStatus) {
		this.documentStatus = documentStatus;
	}
	public Date getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(String invoiceNumber) {
		this.documentNumber = invoiceNumber;
	}
	public String getNoteNumber() {
		return noteNumber;
	}
	public void setNoteNumber(String noteNumber) {
		this.noteNumber = noteNumber;
	}
	public String getCustomPartyID() {
		return customPartyID;
	}
	public void setCustomPartyID(String customPartyID) {
		this.customPartyID = customPartyID;
	}
	public BigDecimal getPayableAmount() {
		return payableAmount;
	}
	public void setPayableAmount(BigDecimal payableAmount) {
		this.payableAmount = payableAmount;
	}
	public String getCustomParty() {
		return customParty;
	}
	public void setCustomParty(String customParty) {
		this.customParty = customParty;
	}
	public String getCufe() {
		return cufe;
	}
	public void setCufe(String cufe) {
		this.cufe = cufe;
	}
	public List<DIANError> getDianErrors() {
		return dianErrors;
	}
	public void setDianErrors(List<DIANError> dianErrors) {
		this.dianErrors = dianErrors;
	}
}