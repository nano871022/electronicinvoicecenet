package co.com.japl.facturacionelectronica.response;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import co.com.japl.facturacionelectronica.pojo.AttachPOJO;

public class AttachResponse{
	@SerializedName("ID")
	private String id;
	private String name;
	@SerializedName("FileMailBoxList")
	private List<AttachPOJO> list;
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
	public List<AttachPOJO> getList() {
		return list;
	}
	public void setList(List<AttachPOJO> list) {
		this.list = list;
	}
}
