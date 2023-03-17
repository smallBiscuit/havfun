package com.havfun.service.filter.admin;

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
import com.havfun.service.message.admin.product.AdminSearchProductRequest;
import com.havfun.service.message.admin.product.AdminSearchProductResponse;
import com.havfun.service.message.constant.ErrorCode;

public class ProcessAdminSearchProductCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessAdminSearchProductCommand.class.getSimpleName());
	
	@Autowired
	private ProductDao productDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		AdminSearchProductRequest request = (AdminSearchProductRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		List<Product> productList = productDao.readAll();
		
		if (productList == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "productList is null");
		}
		
		LOGGER.info("productList : {}", productList);
		
		AdminSearchProductResponse response = new AdminSearchProductResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		response.setProductMessageList(ProductConvertor.convertToMessageList(productList));
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
}
