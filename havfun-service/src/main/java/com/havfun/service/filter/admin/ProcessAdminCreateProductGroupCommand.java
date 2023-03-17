package com.havfun.service.filter.admin;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.havfun.service.base.HavfunException;
import com.havfun.service.convertor.ProductGroupConvertor;
import com.havfun.service.dao.ProductGroupDao;
import com.havfun.service.entity.ProductGroup;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.productgroup.AdminCreateProductGroupRequest;
import com.havfun.service.message.admin.productgroup.AdminCreateProductGroupResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.ProductGroupMessage;

public class ProcessAdminCreateProductGroupCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessAdminCreateProductGroupCommand.class.getSimpleName());
	
	@Autowired
	private ProductGroupDao productGroupDao;
		
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		AdminCreateProductGroupRequest request = (AdminCreateProductGroupRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		ProductGroupMessage productGroupMessage = request.getProductGroupMessage();
		
		if (productGroupMessage == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "productGroupMessage is null");
		}
		
		LOGGER.info("productGroupMessage: {}", productGroupMessage);
		
		ProductGroup productGroup = ProductGroupConvertor.convertToEntity(productGroupMessage);
		
		LOGGER.info("create productGroup {}", productGroup);
		Integer productGroupId = productGroupDao.create(productGroup);
		
		if (productGroupId == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "cannot create productGroup");
		}
		
		AdminCreateProductGroupResponse response = new AdminCreateProductGroupResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		response.setProductGroupId(productGroupId);
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}

}
