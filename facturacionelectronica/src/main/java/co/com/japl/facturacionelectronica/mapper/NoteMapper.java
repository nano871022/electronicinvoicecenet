package co.com.japl.facturacionelectronica.mapper;

import java.util.ArrayList;
import java.util.List;

import co.com.japl.facturacionelectronica.dto.NoteGeneralInformationDTO;
import co.com.japl.facturacionelectronica.dto.NoteTotalDTO;
import co.com.japl.facturacionelectronica.pojo.*;
import co.com.japl.facturacionelectronica.request.*; 

public class NoteMapper extends AMapper{

	private String llave;
	
	public NoteMapper(String llave) {
		this.llave = llave;
	}
	
	public NoteRequest note(){
		NoteRequest request = new NoteRequest();
		request.setCustomerInformation(customerInformation());
		request.setNoteGeneralInformation(noteGeneralInformation());
		request.setNoteTotal(noteTotal());
		request.setNoteAllowanceCharge(noteAllowanceCharge());
		request.setItemInformation(itemInformation());
		return request;
	}

	private NoteGeneralInformationPOJO noteGeneralInformation(){
		NoteGeneralInformationDTO dto = null;
		NoteGeneralInformationPOJO pojo = new NoteGeneralInformationPOJO(dto);
		return pojo;
	}

	private NoteTotalPOJO noteTotal(){
		NoteTotalDTO dto = null;
		NoteTotalPOJO pojo = new NoteTotalPOJO(dto);
		return pojo;
	}

	private List<NoteAllowanceChargePOJO> noteAllowanceCharge(){
		List<NoteAllowanceChargePOJO> pojos = new ArrayList<NoteAllowanceChargePOJO>();
		return pojos;
	}

}