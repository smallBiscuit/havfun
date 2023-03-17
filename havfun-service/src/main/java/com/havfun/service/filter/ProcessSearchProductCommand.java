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
import com.havfun.service.convertor.ProductConvertor;
import com.havfun.service.dao.ProductDao;
import com.havfun.service.entity.Product;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.SearchProductRequest;
import com.havfun.service.message.SearchProductResponse;
import com.havfun.service.message.constant.ErrorCode;

public class ProcessSearchProductCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessSearchProductCommand.class.getSimpleName());
	
	@Autowired
	private ProductDao productDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		SearchProductRequest request = (SearchProductRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		if ( request.getProductGroupId() == 0 ){
			
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "productGroupId is invalid");
			
		}
		
		int groupId = request.getProductGroupId();
		
		List<Product> productList = productDao.readByGroupId( groupId );
		
		if (productList == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "productList is null");
		}
		
		LOGGER.info("productList : {}", productList);
		
		SearchProductResponse response = new SearchProductResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		response.setProductMessageList(ProductConvertor.convertToMessageList(productList));
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
}
