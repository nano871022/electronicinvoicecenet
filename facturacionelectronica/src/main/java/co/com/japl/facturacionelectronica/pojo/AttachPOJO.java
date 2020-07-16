package co.com.japl.facturacionelectronica.pojo;

import com.google.gson.annotations.SerializedName;

public class AttachPOJO{
	@SerializedName(value="ID",alternate = {"FileMailBoxUUID"})
	private String id;
	@SerializedName(value="Name",alternate = {"FileName"})
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
