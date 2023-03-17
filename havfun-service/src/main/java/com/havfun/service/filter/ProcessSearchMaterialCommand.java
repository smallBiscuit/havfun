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
import com.havfun.service.convertor.MaterialConvertor;
import com.havfun.service.dao.MaterialDao;
import com.havfun.service.entity.Material;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.SearchMaterialRequest;
import com.havfun.service.message.SearchMaterialResponse;
import com.havfun.service.message.constant.ErrorCode;

public class ProcessSearchMaterialCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessSearchMaterialCommand.class.getSimpleName());
	
	@Autowired
	private MaterialDao materialDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		SearchMaterialRequest request = (SearchMaterialRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		if ( request.getMaterialGroupId() == 0 ){
			
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "materialGroupId is invalid");
			
		}
		
		int groupId = request.getMaterialGroupId();
		
		List<Material> materialList = materialDao.readByGroupId( groupId );
		
		if (materialList == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "materialList is null");
		}
		
		LOGGER.info("materialList : {}", materialList);
		
		SearchMaterialResponse response = new SearchMaterialResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		response.setMaterialMessageList(MaterialConvertor.convertToMessageList(materialList));
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
}