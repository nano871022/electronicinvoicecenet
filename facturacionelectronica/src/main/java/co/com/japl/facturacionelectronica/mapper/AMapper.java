package co.com.japl.facturacionelectronica.mapper;

import java.util.ArrayList;
import java.util.List;

import co.com.japl.facturacionelectronica.pojo.CustomerInformationPOJO;
import co.com.japl.facturacionelectronica.pojo.ItemInformationPOJO;

public abstract class AMapper{

	protected CustomerInformationPOJO customerInformation(){
		CustomerInformationPOJO pojo = new CustomerInformationPOJO();

		return pojo;
	}

	protected List<ItemInformationPOJO> itemInformation(){
		List<ItemInformationPOJO> pojos = new ArrayList<ItemInformationPOJO>();

		return pojos;
	}

}