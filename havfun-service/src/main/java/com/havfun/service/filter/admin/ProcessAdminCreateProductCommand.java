package com.havfun.service.filter.admin;

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
import com.havfun.service.message.admin.product.AdminCreateProductRequest;
import com.havfun.service.message.admin.product.AdminCreateProductResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.ProductMessage;

public class ProcessAdminCreateProductCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessAdminCreateProductCommand.class.getSimpleName());
	
	@Autowired
	private ProductDao productDao;
		
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		AdminCreateProductRequest request = (AdminCreateProductRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		ProductMessage productMessage = request.getProductMessage();
		
		if (productMessage == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "productMessage is null");
		}
		
		LOGGER.info("productMessage: {}", productMessage);
		
		Product product = ProductConvertor.convertToEntity(productMessage);
		
		LOGGER.info("create product {}", product);
		Integer productId = productDao.create(product);
		
		if (productId == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "cannot create product");
		}
		
		AdminCreateProductResponse response = new AdminCreateProductResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		response.setProductId(productId);
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}

}
