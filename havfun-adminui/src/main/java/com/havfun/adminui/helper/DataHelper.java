package com.havfun.adminui.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.HavfunService;
import com.havfun.service.message.EnquireSystemDataRequest;
import com.havfun.service.message.EnquireSystemDataResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.ClientMessage;
import com.havfun.service.message.data.CountryMessage;
import com.havfun.service.message.data.CourierMessage;
import com.havfun.service.message.data.MaterialGroupMessage;
import com.havfun.service.message.data.ProductGroupMessage;

public class DataHelper {

	private static Logger LOGGER = LogManager.getLogger(DataHelper.class.getSimpleName());		
	
	private Map<Integer, ClientMessage> clientMap;
	
	private List<CountryMessage> countryList;

	private List<CourierMessage> courierList;
	
	private List<ProductGroupMessage> productGroupList;
	
	private List<MaterialGroupMessage> materialGroupList;
	
	public Map<Integer, ClientMessage> getClientMap() {
		return clientMap;
	}

	public void setClientMap(Map<Integer, ClientMessage> clientMap) {
		this.clientMap = clientMap;
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

	public void loadAllData( HavfunService havfunService ){
		

		EnquireSystemDataRequest request = new EnquireSystemDataRequest();
		
		EnquireSystemDataResponse response = ClientServiceHelper.getInstance().getClientService().invoke( request );

		LOGGER.info("DataHelper EnquireSystemDataResponse: " + response );
		
		if ( response != null && response.getResult() == ErrorCode.NO_ERROR ){
			
			this.countryList = response.getCountryList();
			
			this.courierList = response.getCourierList();
			
			this.productGroupList = response.getProductGroupList();
			
			this.materialGroupList = response.getMaterialGroupList();
			
			clientMap = new HashMap<Integer, ClientMessage>();
			
			for ( ClientMessage client : response.getClientList() ){
				
				clientMap.put( client.getClientId(), client);
				
			}
		}
		
		LOGGER.info("DataHelper clientMap: " + clientMap );
	}
	
	public String getCountryCodeById( int countryId ){
		
		if ( this.countryList == null ){
			
			return "";
			
		}
		
		for ( CountryMessage country : this.countryList ){
			
			if ( country.getCountryId() == countryId ){
				
				return country.getCountryCode();
				
			}
			
		}
		
		return "";
		
	}
	
	public String getCountryNameById( int countryId ){
		
		if ( this.countryList == null ){
			
			return "";
			
		}
		
		for ( CountryMessage country : this.countryList ){
			
			if ( country.getCountryId() == countryId ){
				
				return country.getNameEn();
				
			}
			
		}
		
		return "";
		
	}
	
	public String getCountryNameByCode( String countryCode ){
		
		if ( this.countryList == null ){
			
			return "";
			
		}
		
		for ( CountryMessage country : this.countryList ){
			
			if ( country.getCountryCode().equals( countryCode ) ){
				
				return country.getNameEn();
				
			}
			
		}
		
		return "";
		
	}
	
	public List<String> getMaterialGroupValueList() {
		
		List<String> valueList = new ArrayList<String>();
		
		if ( this.materialGroupList != null ){
		
			for ( MaterialGroupMessage message : this.materialGroupList ){
				
				valueList.add( "" + message.getMaterialGroupId() );
			
			}
			
		}
		
		return valueList;
	}
	
	public List<String> getMaterialGroupLabelList() {
		
		List<String> labelList = new ArrayList<String>();
		
		if (this.materialGroupList != null ){
		
			for ( MaterialGroupMessage message : this.materialGroupList ){
				
				labelList.add( message.getNameEn() );
			
			}
		
		}
		
		return labelList;
	}
	
}
