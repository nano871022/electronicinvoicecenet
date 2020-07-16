package co.com.japl.facturacionelectronica.request;

import java.util.List;

import co.com.japl.facturacionelectronica.pojo.*;

public class NoteRequest{
	private CustomerInformationPOJO customerInformation;
	private NoteGeneralInformationPOJO noteGeneralInformation;
	private List<ItemInformationPOJO> itemInformation;
	private NoteTotalPOJO noteTotal;
	private List<NoteTaxTotalPOJO> noteTaxTotal;
	private List<NoteAllowanceChargePOJO> noteAllowanceCharge;
	public CustomerInformationPOJO getCustomerInformation() {
		return customerInformation;
	}
	public void setCustomerInformation(CustomerInformationPOJO customerInformation) {
		this.customerInformation = customerInformation;
	}
	public NoteGeneralInformationPOJO getNoteGeneralInformation() {
		return noteGeneralInformation;
	}
	public void setNoteGeneralInformation(NoteGeneralInformationPOJO noteGeneralInformation) {
		this.noteGeneralInformation = noteGeneralInformation;
	}
	public List<ItemInformationPOJO> getItemInformation() {
		return itemInformation;
	}
	public void setItemInformation(List<ItemInformationPOJO> itemInformation) {
		this.itemInformation = itemInformation;
	}
	public NoteTotalPOJO getNoteTotal() {
		return noteTotal;
	}
	public void setNoteTotal(NoteTotalPOJO noteTotal) {
		this.noteTotal = noteTotal;
	}
	public List<NoteAllowanceChargePOJO> getNoteAllowanceCharge() {
		return noteAllowanceCharge;
	}
	public void setNoteAllowanceCharge(List<NoteAllowanceChargePOJO> noteAllowanceCharge) {
		this.noteAllowanceCharge = noteAllowanceCharge;
	}
	public List<NoteTaxTotalPOJO> getNoteTaxTotal() {
		return noteTaxTotal;
	}
	public void setNoteTaxTotal(List<NoteTaxTotalPOJO> noteTaxTotal) {
		this.noteTaxTotal = noteTaxTotal;
	}
	
}