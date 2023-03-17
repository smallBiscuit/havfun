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
import com.havfun.service.convertor.MaterialConvertor;
import com.havfun.service.dao.MaterialDao;
import com.havfun.service.entity.Material;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.material.AdminSearchMaterialRequest;
import com.havfun.service.message.admin.material.AdminSearchMaterialResponse;
import com.havfun.service.message.constant.ErrorCode;

public class ProcessAdminSearchMaterialCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessAdminSearchMaterialCommand.class.getSimpleName());
	
	@Autowired
	private MaterialDao materialDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		AdminSearchMaterialRequest request = (AdminSearchMaterialRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		int materialGroupId = request.getMaterialGroupId();
		
		List<Material> materialList = materialDao.readByGroupId( materialGroupId );
		
		if (materialList == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "materialList is null");
		}
		
		LOGGER.info("materialList : {}", materialList);
		
		AdminSearchMaterialResponse response = new AdminSearchMaterialResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		response.setMaterialMessageList(MaterialConvertor.convertToMessageList(materialList));
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
}
