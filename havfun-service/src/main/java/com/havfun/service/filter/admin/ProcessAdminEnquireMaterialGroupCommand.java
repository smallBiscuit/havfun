package com.havfun.service.filter.admin;

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
import com.havfun.service.message.admin.materialgroup.AdminEnquireMaterialGroupRequest;
import com.havfun.service.message.admin.materialgroup.AdminEnquireMaterialGroupResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.MaterialGroupMessage;

public class ProcessAdminEnquireMaterialGroupCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessAdminEnquireMaterialGroupCommand.class.getSimpleName());
	
	@Autowired
	private MaterialGroupDao materialGroupDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		AdminEnquireMaterialGroupRequest request = (AdminEnquireMaterialGroupRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		int materialGroupId = request.getMaterialGroupId();
		
		LOGGER.info("materialGroupId: {}", materialGroupId);
		
		MaterialGroup materialGroup = materialGroupDao.read(materialGroupId);
		
		if (materialGroup == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "cannot read materialGroup");
		}
		
		MaterialGroupMessage materialGroupMessage = MaterialGroupConvertor.convertToMessage(materialGroup);
		
		AdminEnquireMaterialGroupResponse response = new AdminEnquireMaterialGroupResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		response.setMaterialGroupMessage(materialGroupMessage);
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
	

}
