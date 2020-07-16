package co.com.japl.facturacionelectronica.pojo;

import co.com.japl.facturacionelectronica.dto.NoteTotalDTO;

public class NoteTotalPOJO extends InvoiceTotalPOJO{
	
	public NoteTotalPOJO() {}
	public NoteTotalPOJO(NoteTotalDTO dto) {
		setAllowanceTotalAmount(Double.valueOf(dto.getAllowanceTotalAmount()));
		setChargeTotalAmount(Double.valueOf(dto.getChargeTotalAmount()));
		setLineExtensionAmount(Double.valueOf(dto.getLineExtensionAmount()));
		setPayableAmount(Double.valueOf(dto.getPayableAmount()));
		setPrePaidAmount(Double.valueOf(dto.getPrePaidAmount()));
		setTaxExclusiveAmount(Double.valueOf(dto.getTaxExclusiveAmount()));
		setTaxInclusiveAmount(Double.valueOf(dto.getTaxInclusiveAmount()));
	}
	
}