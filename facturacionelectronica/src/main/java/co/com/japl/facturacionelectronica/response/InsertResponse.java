package co.com.japl.facturacionelectronica.response;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import co.com.japl.facturacionelectronica.pojo.ErrorPOJO;

public class InsertResponse{
	@SerializedName(value = "DocumentId",alternate = {"DocumentID"})
	private String documentID;
	
	private List<ErrorPOJO> errores;

	public String getDocumentID() {
		return documentID;
	}

	public void setDocumentID(String documentID) {
		this.documentID = documentID;
	}
	
	public void addError(ErrorPOJO error) {
		if(errores == null) {
			errores = new ArrayList<ErrorPOJO>();
		}
		errores.add(error);
	}
	
	public List<ErrorPOJO> getErrores(){return errores;}
}