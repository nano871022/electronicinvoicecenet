package co.com.japl.facturacionelectronica.pojo;

import static co.com.japl.facturacionelectronica.constants.Constants.CONST_FORMAT_DATE_STANDARD;

import java.util.Date;

import co.com.japl.facturacionelectronica.dto.NoteGeneralInformationDTO;
import co.com.japl.facturacionelectronica.util.DateUtils;

public class NoteGeneralInformationPOJO {
	private String noteNumber;
	private String CUFE;
	private String referenceID;
	private Date issueDate;
	private Integer discrepancyCode;
	private String currency;
	
	public NoteGeneralInformationPOJO() {}
	public NoteGeneralInformationPOJO(NoteGeneralInformationDTO dto) {
		noteNumber = dto.getNoteNumber();
		CUFE = dto.getCufe();
		referenceID = dto.getReferenceId();
		issueDate = DateUtils.format(dto.getIssueDate(),CONST_FORMAT_DATE_STANDARD);
		discrepancyCode = Integer.valueOf(dto.getDiscrepancyDate());
		currency = dto.getCurrency();
	}
	
	public String getNoteNumber() {
		return noteNumber;
	}
	public void setNoteNumber(String noteNumber) {
		this.noteNumber = noteNumber;
	}
	public String getCUFE() {
		return CUFE;
	}
	public void setCUFE(String cUFE) {
		CUFE = cUFE;
	}
	public String getReferenceID() {
		return referenceID;
	}
	public void setReferenceID(String referenceID) {
		this.referenceID = referenceID;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Integer getDiscrepancyCode() {
		return discrepancyCode;
	}
	public void setDiscrepancyCode(Integer discrepancyCode) {
		this.discrepancyCode = discrepancyCode;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
