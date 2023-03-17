package com.havfun.service.filter;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.havfun.service.base.HavfunException;
import com.havfun.service.convertor.AddressConvertor;
import com.havfun.service.convertor.ClientConvertor;
import com.havfun.service.convertor.CountryConvertor;
import com.havfun.service.convertor.CourierConvertor;
import com.havfun.service.convertor.MaterialGroupConvertor;
import com.havfun.service.convertor.ProductGroupConvertor;
import com.havfun.service.dao.AddressDao;
import com.havfun.service.dao.ClientDao;
import com.havfun.service.dao.CountryDao;
import com.havfun.service.dao.CourierDao;
import com.havfun.service.dao.MaterialGroupDao;
import com.havfun.service.dao.ProductGroupDao;
import com.havfun.service.entity.Address;
import com.havfun.service.entity.Client;
import com.havfun.service.entity.Country;
import com.havfun.service.entity.Courier;
import com.havfun.service.entity.MaterialGroup;
import com.havfun.service.entity.ProductGroup;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.EnquireSystemDataRequest;
import com.havfun.service.message.EnquireSystemDataResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.AddressMessage;
import com.havfun.service.message.data.ClientMessage;
import com.havfun.service.message.data.MaterialGroupMessage;
import com.havfun.service.message.data.ProductGroupMessage;

public class ProcessEnquireSystemDataCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessEnquireSystemDataCommand.class.getSimpleName());
	
	@Autowired
	private CountryDao countryDao;
	
	@Autowired
	private CourierDao courierDao;
	
	@Autowired
	private ProductGroupDao productGroupDao;
	
	@Autowired
	private MaterialGroupDao materialGroupDao;
	
	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	private AddressDao addressDao;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		EnquireSystemDataRequest request = (EnquireSystemDataRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		List<Country> countryList = countryDao.readAll();
				
		List<Courier> courierList = courierDao.readAll();
		
		List<ProductGroup> productGroupList = productGroupDao.readAll();
		
		List<MaterialGroup> materialGroupList = materialGroupDao.readAll();
		
		List<Client> clientList = clientDao.readAll();
		
		List<Address> addressList = addressDao.readAll();
		
		List<ProductGroupMessage> productGroupMessageList = ProductGroupConvertor.convertToMessageList(productGroupList);
		
		List<MaterialGroupMessage> materialGroupMessageList = MaterialGroupConvertor.convertToMessageList(materialGroupList);
		
		List<ClientMessage> clientMessageList = ClientConvertor.convertToMessageList( clientList );
		
		List<AddressMessage> addressMessageList = AddressConvertor.convertToMessageList( addressList );
		
		for ( int i = 0; i < clientMessageList.size(); i ++ ){
			
			ClientMessage clientMessage = clientMessageList.get(i);
			
			List<AddressMessage> clientAddresses = new ArrayList<AddressMessage>();
			
			for ( AddressMessage addressMessage : addressMessageList ){
				
				if ( addressMessage.getClientId() == clientMessage.getClientId() ){
					
					clientAddresses.add( addressMessage );
					
				}
				
			}
			
			clientMessage.setAddressList(clientAddresses);
			
			clientMessageList.set( i, clientMessage );
			
		}
		
		EnquireSystemDataResponse response = new EnquireSystemDataResponse();
		
		if ( countryList != null ){
			
			response.setCountryList( CountryConvertor.convertToMessageList( countryList ) );
			
		}
		
		if ( courierList != null ){
			
			response.setCourierList( CourierConvertor.convertToMessageList( courierList ) );
			
		}
		
		response.setProductGroupList( productGroupMessageList );
		
		response.setMaterialGroupList( materialGroupMessageList );
		
		response.setClientList( clientMessageList );
		
		response.setResult(ErrorCode.NO_ERROR);
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
}

