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
import com.havfun.service.convertor.CustomizeProductBaseConvertor;
import com.havfun.service.convertor.CustomizeProductBaseViewConvertor;
import com.havfun.service.convertor.CustomizeProductBorderItemConvertor;
import com.havfun.service.convertor.CustomizeProductColorItemConvertor;
import com.havfun.service.convertor.ProductConvertor;
import com.havfun.service.dao.CustomizeProductBaseDao;
import com.havfun.service.dao.CustomizeProductBaseViewDao;
import com.havfun.service.dao.CustomizeProductBorderItemDao;
import com.havfun.service.dao.CustomizeProductColorItemDao;
import com.havfun.service.dao.ProductDao;
import com.havfun.service.entity.CustomizeProductBase;
import com.havfun.service.entity.CustomizeProductBaseView;
import com.havfun.service.entity.CustomizeProductBorderItem;
import com.havfun.service.entity.CustomizeProductColorItem;
import com.havfun.service.entity.Product;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.admin.product.AdminEnquireProductRequest;
import com.havfun.service.message.admin.product.AdminEnquireProductResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.CustomizeProductBaseMessage;
import com.havfun.service.message.data.CustomizeProductBaseViewMessage;
import com.havfun.service.message.data.CustomizeProductBorderItemMessage;
import com.havfun.service.message.data.CustomizeProductColorItemMessage;
import com.havfun.service.message.data.ProductMessage;

public class ProcessAdminEnquireProductCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessAdminEnquireProductCommand.class.getSimpleName());
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CustomizeProductBaseDao customizeProductBaseDao;
	
	@Autowired
	private CustomizeProductBaseViewDao customizeProductBaseViewDao;
	
	@Autowired
	private CustomizeProductBorderItemDao customizeProductBorderItemDao;
	
	@Autowired
	private CustomizeProductColorItemDao customizeProductColorItemDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		AdminEnquireProductRequest request = (AdminEnquireProductRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		int productId = request.getProductId();
		
		LOGGER.info("productId: {}", productId);
		
		Product product = productDao.read(productId);
		
		if (product == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "cannot read product");
		}
		
		ProductMessage productMessage = ProductConvertor.convertToMessage(product);
		
		List<CustomizeProductBase> baseList = customizeProductBaseDao.readByProductId( productMessage.getProductId() );
		
		if ( baseList != null && baseList.size() > 0 ){
			
			CustomizeProductBase base = baseList.get(0);
			
			List<CustomizeProductBaseView> viewList = customizeProductBaseViewDao.readByBaseId( base.getBaseId() );
			
			List<CustomizeProductColorItem> colorList = customizeProductColorItemDao.readByBaseId( base.getBaseId() );
			
			CustomizeProductBaseMessage baseMessage = CustomizeProductBaseConvertor.convertToMessage(base);
			
			List<CustomizeProductBaseViewMessage> viewMessageList = CustomizeProductBaseViewConvertor.convertToMessageList(viewList);
			
			if ( viewMessageList != null ){
				
				for ( int i = 0; i < viewMessageList.size(); i ++ ){
					
					CustomizeProductBaseViewMessage viewMessage = viewMessageList.get( i );
					
					List<CustomizeProductBorderItem> borderList = customizeProductBorderItemDao.readByViewId( viewMessage.getViewId() );
					
					List<CustomizeProductBorderItemMessage> borderMessageList = CustomizeProductBorderItemConvertor.convertToMessageList(borderList);
					
					viewMessage.setBorderList(borderMessageList);
					
					viewMessageList.set(i, viewMessage);
					
				}
			
			}
			
			List<CustomizeProductColorItemMessage> colorMessageList = CustomizeProductColorItemConvertor.convertToMessageList(colorList);
			
			baseMessage.setViews(viewMessageList);
			
			baseMessage.setColorItemList(colorMessageList);
			
			productMessage.setCustomizeProductBase(baseMessage);
			
		}
		
		AdminEnquireProductResponse response = new AdminEnquireProductResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		response.setProductMessage(productMessage);
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
	

}
