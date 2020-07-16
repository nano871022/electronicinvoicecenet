package co.com.japl.facturacionelectronica.pojo;

import com.google.gson.annotations.SerializedName;

import co.com.japl.facturacionelectronica.response.AttachResponse;

public class DocumentsPOJO {
	private String name;
	@SerializedName("ID")
	private String id;

	public DocumentsPOJO(){}

	public DocumentsPOJO(String id,String name){
		this.id = id;
		this.name = name;
	}
	
	public DocumentsPOJO(AttachPOJO attach) {
		this.id = attach.getId();
		this.name = attach.getName();
	}

	public DocumentsPOJO(AttachResponse response){
		this.id = response.getId();
		this.name = response.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}