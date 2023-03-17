package com.havfun.service.filter;

import java.util.List;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.havfun.service.base.HavfunException;
import com.havfun.service.convertor.MaterialConvertor;
import com.havfun.service.dao.ClientProductDao;
import com.havfun.service.dao.MaterialDao;
import com.havfun.service.entity.ClientProduct;
import com.havfun.service.entity.Material;
import com.havfun.service.entity.constant.ProductStatus;
import com.havfun.service.entity.constant.StockStatus;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.CreateClientProductRequest;
import com.havfun.service.message.CreateClientProductResponse;
import com.havfun.service.message.constant.ErrorCode;

public class ProcessCreateClientProductCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessCreateClientProductCommand.class.getSimpleName());
	
	@Autowired
	private ClientProductDao clientProductDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		CreateClientProductRequest request = (CreateClientProductRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		/*
		if ( request.getProductBaseId() == 0 ){
			
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "materialGroupId is invalid");
			
		}
		
		int productBaseId = request.getProductBaseId();
		*/
		//List<Material> materialList = materialDao.readByGroupId( productBaseId );
		
		ClientProduct clientProduct = new ClientProduct();
		
		clientProduct.setDesignerClientId( request.getClientId() );
		clientProduct.setProductStatus(ProductStatus.ACTIVE);
		
		int newClientProductId = clientProductDao.create( clientProduct );
		
		if ( newClientProductId <= 0 ){
			
						
		}
		
		CreateClientProductResponse response = new CreateClientProductResponse();
		
		response.setClientProductId(newClientProductId);
		
		response.setResult(ErrorCode.NO_ERROR);
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
}