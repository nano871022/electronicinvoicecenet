package co.com.japl.facturacionelectronica.svc;

import java.io.File;

import co.com.japl.facturacionelectronica.exception.BillingException;
import co.com.japl.facturacionelectronica.response.StatusResponse;

public interface IElectronicBillingSvc{
	/**
	* Envío de la factura a cenet
	* @param invoiceNumber {@link String} número de la factura a buscar en base de datos para construir la información que se envía al cenet
	* @param fileAttach {@link File} arrays de archivos que se deben adjuntar a la factura
	* @return {@link String} codigo de respuesta de l afacctura ingresada
	* @throws {@link BillingException}
	**/
	public String invoice(String invoiceNumber,Integer empresa,File... fileAttach)throws BillingException;
	/**
	* Envío de la nota crédito / débito a cenet
	* @param noteNumber {@link String} número de la factura a buscar en base de datos para construir la información que se envía al cenet
	* @param fileAttach {@link File} arrays de archivos que se deben adjuntar a la factura
	* @return {@link String} codigo de respuesta de la nota crédito / débito ingresada
	* @throws {@link BillingException}
	**/
	public String note(String noteNumber,Integer empresa)throws BillingException;
	/**
	* @param insertedNumber {@link String} numero de respuesta del ingreso de factura ó nota crédito/débito
	* @return {@link StatisResponse} resultado del a respuesta de la factura
	* @throws {@link BillingException}
	**/
	public StatusResponse statusBilling(String insertedNumber,Integer empresa)throws BillingException;
	/**
	 * Se usa para realizar la cargar de facturas personalizadas para que sean enviadas por la DIAN
	 * @param idInvoice {@link String} numero de la factura
	 * @param idNumber
	 * @param file
	 * @param empresa
	 * @throws BillingException
	 */
	public void attachInvoice(String idInvoice,String idNumber,File file,int empresa)throws BillingException ;
}