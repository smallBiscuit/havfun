package com.havfun.service.filter;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.Filter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class ProcessCreateEnquiryFilter implements Filter {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessCreateEnquiryFilter.class.getSimpleName());
	
//	@Autowired
//	private EnquiryDao enquiryDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		/*
		CreateEnquiryRequest request = (CreateEnquiryRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HklistcoException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		EnquiryMessage enquiryMessage = request.getEnquiryMessage();
		
		if (enquiryMessage == null) {
			throw new HklistcoException(ErrorCode.FAIL_TO_PROCESS, "enquiryMessage is null");
		}
		
		Integer enquiryId = enquiryDao.create(EnquiryConvertor.convertToEntity(enquiryMessage));
		
		if (enquiryId == null) {
			throw new HklistcoException(ErrorCode.FAIL_TO_PROCESS, "cannot create enquriy");
		}
		
		LOGGER.info("enquiryId: {}", enquiryId);
		
		CreateEnquiryResponse response = new CreateEnquiryResponse();
		response.setResult(ErrorCode.NO_ERROR);
		response.setEnquiryId(enquiryId);
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		LOGGER.info("response: {}", response);
		*/
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean postprocess(Context context, Exception exception) {
		LOGGER.debug("postprocess...");
		LOGGER.debug("exception = {}", exception);
		/*
		if (exception != null) {
			CreateEnquiryResponse response = new CreateEnquiryResponse();
			response.setResult(ErrorCode.FAIL_TO_PROCESS);
			context.put(AbstractHkListCoEventHandler.RESPONSE, response);
			
			return true;
		}
		*/
		return false;
	}

}
