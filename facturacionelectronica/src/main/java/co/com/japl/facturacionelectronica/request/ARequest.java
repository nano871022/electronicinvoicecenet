package co.com.japl.facturacionelectronica.request;

public abstract class ARequest{
	private Integer schemaID;
	private String idNumber;
	public Integer getSchemaID() {
		return schemaID;
	}
	public void setSchemaID(Integer schemaID) {
		this.schemaID = schemaID;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
}