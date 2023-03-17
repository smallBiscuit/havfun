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
import com.havfun.service.message.admin.materialgroup.AdminUpdateMaterialGroupRequest;
import com.havfun.service.message.admin.materialgroup.AdminUpdateMaterialGroupResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.MaterialGroupMessage;

public class ProcessAdminUpdateMaterialGroupCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessAdminUpdateMaterialGroupCommand.class.getSimpleName());
	
	@Autowired
	private MaterialGroupDao materialGroupDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		AdminUpdateMaterialGroupRequest request = (AdminUpdateMaterialGroupRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		MaterialGroupMessage materialGroupMessage = request.getMaterialGroupMessage();
		
		if (materialGroupMessage == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "materialGroupMessage is null");
		}
		
		LOGGER.info("materialGroupMessage: {}", materialGroupMessage);
		
		MaterialGroup materialGroup = MaterialGroupConvertor.convertToEntity(materialGroupMessage);
		
		LOGGER.info("update materialGroup {}", materialGroup);
		
		int materialGroupId = materialGroupDao.update(materialGroup);
		
		if (materialGroupId == 0) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "cannot update materialGroup");
		}
		
		AdminUpdateMaterialGroupResponse response = new AdminUpdateMaterialGroupResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
	

}
