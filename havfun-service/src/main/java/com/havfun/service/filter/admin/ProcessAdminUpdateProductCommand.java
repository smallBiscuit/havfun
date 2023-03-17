package com.havfun.service.filter.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.havfun.service.base.HavfunException;
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
import com.havfun.service.message.admin.product.AdminUpdateProductRequest;
import com.havfun.service.message.admin.product.AdminUpdateProductResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.CustomizeProductBaseMessage;
import com.havfun.service.message.data.CustomizeProductBaseViewMessage;
import com.havfun.service.message.data.CustomizeProductBorderItemMessage;
import com.havfun.service.message.data.CustomizeProductColorItemMessage;
import com.havfun.service.message.data.ProductMessage;

public class ProcessAdminUpdateProductCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessAdminUpdateProductCommand.class.getSimpleName());
	
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
		
		AdminUpdateProductRequest request = (AdminUpdateProductRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		ProductMessage productMessage = request.getProductMessage();
		
		if (productMessage == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "productMessage is null");
		}
		
		LOGGER.info("productMessage: {}", productMessage);
		
		Product product = ProductConvertor.convertToEntity(productMessage);
		
		LOGGER.info("update product {}", product);
		
		int result = productDao.update(product);
		
		if (result < 0 ) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "cannot update product");
		}
		
		List<CustomizeProductBase> baseList = customizeProductBaseDao.readByProductId( product.getProductId() );
		
		int baseId = -1;
		
		if (baseList != null && baseList.size() > 0 ) {
			
			baseId = baseList.get( 0 ).getBaseId();
			
		}else{

			CustomizeProductBase base = new CustomizeProductBase();
			
			base.setProductId( product.getProductId() );
			
			baseId = customizeProductBaseDao.create( base );
			
		}
		
		
		CustomizeProductBaseMessage baseMessage = productMessage.getCustomizeProductBase();
		
		///////////////////////////////////////////////////////
		
		List<CustomizeProductColorItemMessage> colorMessageList = baseMessage.getColorItemList();
		
		if ( colorMessageList.size() > 0 ){
		
			List<CustomizeProductColorItem> colorList = CustomizeProductColorItemConvertor.convertToEntityList(colorMessageList);		
			
	//		int removingColorResult = customizeProductColorItemDao.deleteByBaseIdWithNewItemList( baseList.get(0).getBaseId() , colorList );
					
			List<CustomizeProductColorItem> finalColorList = new ArrayList<CustomizeProductColorItem>();
			
			for ( CustomizeProductColorItem item : colorList ){
				
				if ( item.getBaseId() == -1 ){
					
					item.setBaseId( baseId );
				
				}
				
				finalColorList.add(item);
				
			}
			
			int[] insertColorResult = customizeProductColorItemDao.replaceByItems(finalColorList);
		
		}
		
		///////////////////////////////////////////////////////
		
		if ( baseMessage.getViews() != null ){
			
			for ( CustomizeProductBaseViewMessage viewMessage : baseMessage.getViews() ){
				
				LOGGER.info("rayTest: viewMessage: " +  viewMessage );
				
				CustomizeProductBaseView view = CustomizeProductBaseViewConvertor.convertToEntity( viewMessage );
				
				if ( view.getBaseId() == -1 ){
			
					view.setBaseId(baseId);
					
				}
				
				customizeProductBaseViewDao.replaceByCustomizeProductBaseView( view );
				
				List<CustomizeProductBorderItemMessage> borderMessageList = viewMessage.getBorderList();
				
				List<CustomizeProductBorderItem> borderList = CustomizeProductBorderItemConvertor.convertToEntityList( borderMessageList );
				
//				int removingBorderResult = customizeProductBorderItemDao.deleteByViewIdWithNewItemList( viewMessage.getViewId() , borderList );
						
				//ToDo: setViewId, avoid which is new view
				
				LOGGER.info("rayTest: borderList: " +  borderList );
				
				int[] insertBorderResult = customizeProductBorderItemDao.replaceByItems(borderList);
				
				
			}
		
		}
		
		AdminUpdateProductResponse response = new AdminUpdateProductResponse();
		
		response.setResult(ErrorCode.NO_ERROR);
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
	

}
