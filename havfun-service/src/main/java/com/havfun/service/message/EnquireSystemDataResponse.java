package com.havfun.service.message;

import java.util.List;
import com.havfun.service.message.constant.MessageId;
import com.havfun.service.message.data.ClientMessage;
import com.havfun.service.message.data.CountryMessage;
import com.havfun.service.message.data.CourierMessage;
import com.havfun.service.message.data.MaterialGroupMessage;
import com.havfun.service.message.data.ProductGroupMessage;

public class EnquireSystemDataResponse extends AbstractResponse{

	private List<ClientMessage> clientList;	
	
	private List<CountryMessage> countryList;
	
	private List<CourierMessage> courierList;
	
	private List<ProductGroupMessage> productGroupList;
	
	private List<MaterialGroupMessage> materialGroupList;
	
	public EnquireSystemDataResponse() {
		setMessageId(MessageId.ENQUIRE_SYSTEM_DATA_RESPONSE);
	}
	
	public List<ClientMessage> getClientList() {
		return clientList;
	}

	public void setClientList(List<ClientMessage> clientList) {
		this.clientList = clientList;
	}

	public List<CountryMessage> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<CountryMessage> countryList) {
		this.countryList = countryList;
	}
	
	public List<CourierMessage> getCourierList() {
		return courierList;
	}

	public void setCourierList(List<CourierMessage> courierList) {
		this.courierList = courierList;
	}

	public List<ProductGroupMessage> getProductGroupList() {
		return productGroupList;
	}

	public void setProductGroupList(List<ProductGroupMessage> productGroupList) {
		this.productGroupList = productGroupList;
	}

	public List<MaterialGroupMessage> getMaterialGroupList() {
		return materialGroupList;
	}

	public void setMaterialGroupList(List<MaterialGroupMessage> materialGroupList) {
		this.materialGroupList = materialGroupList;
	}

	@Override
	public String toString() {
		return "EnquireSystemDataResponse [clientList=" + clientList + ", countryList=" + countryList + ", courierList="
				+ courierList + ", productGroupList=" + productGroupList + ", materialGroupList=" + materialGroupList
				+ ", result=" + result + ", messageId=" + messageId + "]";
	}
	
}
