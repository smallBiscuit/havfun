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
import com.havfun.service.convertor.ProductGroupConvertor;
import com.havfun.service.dao.ProductGroupDao;
import com.havfun.service.entity.ProductGroup;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.SearchProductGroupRequest;
import com.havfun.service.message.SearchProductGroupResponse;
import com.havfun.service.message.constant.ErrorCode;

public class ProcessSearchProductGroupCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessSearchProductGroupCommand.class.getSimpleName());
	
	@Autowired
	private ProductGroupDao productGroupDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		SearchProductGroupRequest request = (SearchProductGroupRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		List<ProductGroup> productGroupList = productGroupDao.readAll();
		
		if (productGroupList == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "productGroupList is null");
		}
		
		LOGGER.info("productGroupList : {}", productGroupList);
		
		SearchProductGroupResponse response = new SearchProductGroupResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		response.setProductGroupMessageList(ProductGroupConvertor.convertToMessageList(productGroupList));
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
}
