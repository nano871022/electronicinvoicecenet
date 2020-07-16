package co.com.japl.facturacionelectronica.pojo;

public enum DocumentType {
  FACTURA(1), NOTA(2);
	
  private Integer numero;
  private DocumentType(Integer numero){
	  this.numero = numero;
  }
  public Integer get() {return numero;}
}
