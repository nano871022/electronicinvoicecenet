package co.com.japl.facturacionelectronica.svc;

import co.com.japl.facturacionelectronica.exception.BillingException;
import co.com.japl.facturacionelectronica.request.*;
import co.com.japl.facturacionelectronica.response.*;

import java.io.File;


public interface IElectronicBillingAPI{
	/**
	* Con este servicio se solicita el usuario para obtener las credenciales para llamar los otros servicios
	* @param user {@link String} nombre del usuario
    * @param password {@link String} contrasenia asociada al usuario
    * @return {@link String} token generado para la conexión el cual solo es válido por un día
    * @throws {@link BillingException}
	**/
	public String login(String userName,String password)throws BillingException;
	/**
	* envío de la factura a cenet
	* @param billing {@link BillingRequest} objeto de la factura a ser enviada
	* @return {@link String} número de la factura con la cual se identifica en el cenet
    * @throws {@link BillingException}	
	**/
	public InsertResponse invoice(BillingRequest billing,String idNumber,String token)throws BillingException;
	/**
	* envío de la nota crédito/débito al cenet
	* @param note {@link NoteRequest} objeto de la nota crédito/débito a ser enviada
	* @return {@link String} número de la nota crédito/débito con la cual se identifica en el cenet
    * @throws {@link BillingException}	
	**/
	public InsertResponse note(NoteRequest note,String idNumber,String token)throws BillingException;
    /**
	* Con este servicio se realiza la verificacíón del estado de la factura o nota crédito/débito que fue ingresada
	* @param documentType {@link String} tipo de documento
	*  @param documentID {@link String} numero de la factura a consultar
	* @return {@link StatusResponse} Respuesta del estado de la factura o nota crédito/débito 
    * @throws {@link BillingException}	
	**/
	public StatusResponse statusBilling(String documentType,String documentID,String idNumber,String token)throws BillingException;
    /**
	* Con este servicio se permite realiza la carga de un archivo para asociar a la factura
	* @param file {@link File} archivo a cargar
	* @param token {@link Token} token
	* @return {@link AttachResponse} respuesta de la carga del archivo
    * @throws {@link BillingException}	
	**/
	public AttachResponse attach(File file,String idNumber,String token)throws BillingException;
    /**
	* Con este servicio se permite realiza la carga de un archivo para asociar a la factura
	* @param documentType {@link String} typo factura/nota
	* @param documentID {@link String} document id a verificar
	* @param file {@link File} archivo a cargar
	* @param token {@link String} token generado del login
	* @return {@link AttachResponse} Respuesta de la carga del archivo
    * @throws {@link BillingException}	
	**/
	public void attachGR(String diocumentType,String documentID,String idNumber,File file,String token)throws BillingException; 
}