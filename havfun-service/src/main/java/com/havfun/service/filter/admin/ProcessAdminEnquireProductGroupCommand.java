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
import com.havfun.service.message.admin.productgroup.AdminEnquireProductGroupRequest;
import com.havfun.service.message.admin.productgroup.AdminEnquireProductGroupResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.ProductGroupMessage;

public class ProcessAdminEnquireProductGroupCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessAdminEnquireProductGroupCommand.class.getSimpleName());
	
	@Autowired
	private ProductGroupDao productGroupDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		AdminEnquireProductGroupRequest request = (AdminEnquireProductGroupRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		int productGroupId = request.getProductGroupId();
		
		LOGGER.info("productGroupId: {}", productGroupId);
		
		ProductGroup productGroup = productGroupDao.read(productGroupId);
		
		if (productGroup == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "cannot read productGroup");
		}
		
		ProductGroupMessage productGroupMessage = ProductGroupConvertor.convertToMessage(productGroup);
		
		AdminEnquireProductGroupResponse response = new AdminEnquireProductGroupResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		response.setProductGroupMessage(productGroupMessage);
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
	

}
