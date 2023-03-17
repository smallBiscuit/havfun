package com.havfun.service.filter.admin;

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
import com.havfun.service.message.admin.material.AdminCreateMaterialRequest;
import com.havfun.service.message.admin.material.AdminCreateMaterialResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.MaterialMessage;

public class ProcessAdminCreateMaterialCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessAdminCreateMaterialCommand.class.getSimpleName());
	
	@Autowired
	private MaterialDao materialDao;
		
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		AdminCreateMaterialRequest request = (AdminCreateMaterialRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		MaterialMessage materialMessage = request.getMaterialMessage();
		
		if (materialMessage == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "materialMessage is null");
		}
		
		LOGGER.info("materialMessage: {}", materialMessage);
		
		Material material = MaterialConvertor.convertToEntity(materialMessage);
		
		LOGGER.info("create material {}", material);
		Integer materialId = materialDao.create(material);
		
		if (materialId == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "cannot create material");
		}
		
		AdminCreateMaterialResponse response = new AdminCreateMaterialResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		response.setMaterialId(materialId);
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}

}
