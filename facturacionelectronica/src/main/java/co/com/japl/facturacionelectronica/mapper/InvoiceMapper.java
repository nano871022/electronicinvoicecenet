package co.com.japl.facturacionelectronica.mapper;

import java.util.ArrayList;
import java.util.List;

import co.com.japl.facturacionelectronica.dto.AdditionalDocumentsDTO;
import co.com.japl.facturacionelectronica.dto.DeliveryDTO;
import co.com.japl.facturacionelectronica.dto.InvoiceGeneralInformationDTO;
import co.com.japl.facturacionelectronica.dto.InvoiceTaxTotalDTO;
import co.com.japl.facturacionelectronica.dto.InvoiceTotalDTO;
import co.com.japl.facturacionelectronica.dto.PaymentSummaryDTO;
import co.com.japl.facturacionelectronica.pojo.AdditionalDocumentsPOJO;
import co.com.japl.facturacionelectronica.pojo.AdditionalPropertyPOJO;
import co.com.japl.facturacionelectronica.pojo.DeliveryPOJO;
import co.com.japl.facturacionelectronica.pojo.DocumentsPOJO;
import co.com.japl.facturacionelectronica.pojo.InvoiceAllowanceChargePOJO;
import co.com.japl.facturacionelectronica.pojo.InvoiceGeneralInformationPOJO;
import co.com.japl.facturacionelectronica.pojo.InvoiceTaxTotalPOJO;
import co.com.japl.facturacionelectronica.pojo.InvoiceTotalPOJO;
import co.com.japl.facturacionelectronica.pojo.PaymentSummaryPOJO;
import co.com.japl.facturacionelectronica.request.BillingRequest;

public class InvoiceMapper extends AMapper{
	
	private String llave;
	
	public InvoiceMapper(String llave) {
		this.llave = llave;
	}

	public BillingRequest invoice(String llave){
		BillingRequest request = new BillingRequest();
		request.setCustomerInformation(customerInformation());
		request.setInvoiceGeneralInformation(invoiceGeneralInformation());
		request.setDelivery(delivery());
		request.setAdditionalDocuments(additionalDocuments());
		request.setAdditionalProperty(additionalProperty());
		request.setPaymentSummary(paymentSummary());
		request.setInvoiceTaxTotal(invoiceTaxTotal());
		request.setInvoiceAllowanceCharge(invoiceAllowanceCharge());
		request.setInvoiceTotal(invoiceTotal());
		request.setDocuments(documents());
		request.setItemInformation(itemInformation());
		return request;
	}

	private InvoiceGeneralInformationPOJO invoiceGeneralInformation(){
		InvoiceGeneralInformationDTO dto = null;
		InvoiceGeneralInformationPOJO pojo = new InvoiceGeneralInformationPOJO(dto);
		return pojo;
	}

	private DeliveryPOJO delivery(){
		DeliveryDTO dto = null;
		DeliveryPOJO pojo = new DeliveryPOJO(dto);
		return pojo;
	}

	private AdditionalDocumentsPOJO additionalDocuments(){
		AdditionalDocumentsDTO dto = null;
		AdditionalDocumentsPOJO pojo = new AdditionalDocumentsPOJO(dto);
		return pojo;
	}

	private List<AdditionalPropertyPOJO> additionalProperty(){
		List<AdditionalPropertyPOJO> pojos = new ArrayList<AdditionalPropertyPOJO>();

		return pojos;
	}

	private PaymentSummaryPOJO paymentSummary(){
		PaymentSummaryDTO payment = null;
		PaymentSummaryPOJO pojo = new PaymentSummaryPOJO(payment);
		return pojo;
	}

	private List<InvoiceTaxTotalPOJO> invoiceTaxTotal(){
		List<InvoiceTaxTotalDTO> lista = null;
		List<InvoiceTaxTotalPOJO> pojos = new ArrayList<InvoiceTaxTotalPOJO>();
		for(InvoiceTaxTotalDTO dto : lista) {
			pojos.add(new InvoiceTaxTotalPOJO(dto));
		}
		return pojos;
	}

	private List<InvoiceAllowanceChargePOJO> invoiceAllowanceCharge(){
		List<InvoiceAllowanceChargePOJO> pojos = new ArrayList<InvoiceAllowanceChargePOJO>();
		return pojos;
	}

	private InvoiceTotalPOJO invoiceTotal(){
		InvoiceTotalDTO dto = null;
		InvoiceTotalPOJO pojo = new InvoiceTotalPOJO(dto);
		return pojo;
	}

	private List<DocumentsPOJO> documents(){
		List<DocumentsPOJO> pojos = new ArrayList<DocumentsPOJO>();
		
		return pojos;
	}  
	
}