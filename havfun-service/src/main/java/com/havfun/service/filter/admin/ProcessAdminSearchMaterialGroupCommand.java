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
import com.havfun.service.convertor.MaterialGroupConvertor;
import com.havfun.service.dao.MaterialGroupDao;
import com.havfun.service.entity.MaterialGroup;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.materialgroup.AdminSearchMaterialGroupRequest;
import com.havfun.service.message.admin.materialgroup.AdminSearchMaterialGroupResponse;
import com.havfun.service.message.constant.ErrorCode;

public class ProcessAdminSearchMaterialGroupCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessAdminSearchMaterialGroupCommand.class.getSimpleName());
	
	@Autowired
	private MaterialGroupDao materialGroupDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		AdminSearchMaterialGroupRequest request = (AdminSearchMaterialGroupRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		List<MaterialGroup> materialGroupList = materialGroupDao.readAll();
		
		if (materialGroupList == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "materialGroupList is null");
		}
		
		LOGGER.info("materialGroupList : {}", materialGroupList);
		
		AdminSearchMaterialGroupResponse response = new AdminSearchMaterialGroupResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		response.setMaterialGroupMessageList(MaterialGroupConvertor.convertToMessageList(materialGroupList));
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
}
