package com.havfun.adminui.product;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.adminui.webcomponent.WebComponent;
import com.havfun.service.entity.constant.ProductStatus;
import com.havfun.service.entity.constant.StockStatus;
import com.havfun.service.message.data.CustomizeProductBaseMessage;
import com.havfun.service.message.data.CustomizeProductBaseViewMessage;
import com.havfun.service.message.data.CustomizeProductBorderItemMessage;
import com.havfun.service.message.data.CustomizeProductColorItemMessage;
import com.havfun.service.message.data.ProductMessage;
import com.havfun.service.utils.LabelUtil;

public class ProductHelperImpl implements ProductHelper {

	private static final Logger LOGGER = LogManager.getLogger(ProductHelper.class.getName());

	public void prepareProduct(HttpServletRequest request, int servletMode) {

		List<String> modelList = new ArrayList<String>();
		List<String> stockStatusList = new ArrayList<String>();
		List<String> productStatusList = new ArrayList<String>();
		List<String> manufacturerList = new ArrayList<String>();
		
		for (StockStatus stockStatus : StockStatus.values()) {
			stockStatusList.add(stockStatus.getValue());
		}
		
		for (ProductStatus productStatus : ProductStatus.values()) {
			productStatusList.add(productStatus.getValue());
		}

		request.setAttribute("modelList", modelList);
		request.setAttribute("modelLabelList", modelList);
		request.setAttribute("stockStatusList", stockStatusList);
		request.setAttribute("stockStatusLabelList", stockStatusList);
		request.setAttribute("productStatusList", productStatusList);
		request.setAttribute("productStatusLabelList", productStatusList);
		request.setAttribute("manufacturerList", manufacturerList);
		request.setAttribute("manufacturerLabelList", manufacturerList);

		request.setAttribute(PRODUCT_ID.getKey(), PRODUCT_ID);
		request.setAttribute(PRODUCT_GROUP_ID.getKey(), PRODUCT_GROUP_ID);
		request.setAttribute(PRODUCT_NAME_EN.getKey(), PRODUCT_NAME_EN);
		request.setAttribute(PRODUCT_NAME_HK.getKey(), PRODUCT_NAME_HK);
		request.setAttribute(PRODUCT_NAME_CN.getKey(), PRODUCT_NAME_CN);
		request.setAttribute(PRODUCT_THUMBNAIL_URL.getKey(), PRODUCT_THUMBNAIL_URL);
		request.setAttribute(PRODUCT_DESIGNER_CLIENT_ID.getKey(), PRODUCT_DESIGNER_CLIENT_ID);
		request.setAttribute(PRODUCT_MODEL.getKey(), PRODUCT_MODEL);
		request.setAttribute(PRODUCT_STOCK.getKey(), PRODUCT_STOCK);
		request.setAttribute(PRODUCT_MANUFACTURER_ID.getKey(), PRODUCT_MANUFACTURER_ID);
		request.setAttribute(PRODUCT_PRICE.getKey(), PRODUCT_PRICE);
		request.setAttribute(PRODUCT_AVAILABLED_DATE.getKey(), PRODUCT_AVAILABLED_DATE);
		request.setAttribute(PRODUCT_WEIGHT.getKey(), PRODUCT_WEIGHT);
		request.setAttribute(PRODUCT_LENGTH.getKey(), PRODUCT_LENGTH);
		request.setAttribute(PRODUCT_WIDTH.getKey(), PRODUCT_WIDTH);
		request.setAttribute(PRODUCT_HEIGHT.getKey(), PRODUCT_HEIGHT);
		request.setAttribute(PRODUCT_SORTING_ORDER.getKey(), PRODUCT_SORTING_ORDER);
		request.setAttribute(PRODUCT_STOCK_STATUS.getKey(), PRODUCT_STOCK_STATUS);
		request.setAttribute(PRODUCT_STATUS.getKey(), PRODUCT_STATUS);
		request.setAttribute(PRODUCT_CREATE_TIMESTAMP.getKey(), PRODUCT_CREATE_TIMESTAMP);
		request.setAttribute(PRODUCT_LAST_MODIFIED_TIMESTAMP.getKey(), PRODUCT_LAST_MODIFIED_TIMESTAMP);
		request.setAttribute(PRODUCT_CUSTOMIZE_PRODUCT_BASE.getKey(), PRODUCT_CUSTOMIZE_PRODUCT_BASE);
		
		
		Map<String, Boolean> actionMap = (Map<String, Boolean>) request.getAttribute("ActionMap");

		switch (servletMode) {
		case SERVLET_TYPE_CREATE:
			request.setAttribute(NAVIGATOR, "content_product_create_product");
			request.setAttribute(ACTION, CREATE_PRODUCT_REQUEST);
			request.setAttribute(PAGE_MODE, WebComponent.PAGE_MODE_CREATE);
			break;
		case SERVLET_TYPE_ENQUIRE:
			request.setAttribute(NAVIGATOR, "content_product_enquire_product");
			if (actionMap.get(UPDATE_PRODUCT_REQUEST) != null) {
				request.setAttribute(ACTION, UPDATE_PRODUCT_REQUEST);
				request.setAttribute(PAGE_MODE, WebComponent.PAGE_MODE_UPDATE);
			} else {
				request.setAttribute(PAGE_MODE, WebComponent.PAGE_MODE_READONLY);
			}
			break;
		}
	}

	public ProductMessage getProductMessage(HttpServletRequest request) {
		
		Map<String, String> parameterMap = new HashMap<String, String>();
		
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        diskFileItemFactory.setRepository(new File("/tmp"));

		ServletFileUpload uploader = new ServletFileUpload(diskFileItemFactory);

		List<FileItem> fileItemsList = new ArrayList<FileItem>();
		List<FileItem> documentItemList = new ArrayList<FileItem>();

		try {

			fileItemsList =  uploader.parseRequest(request);

			for (FileItem fileItem : fileItemsList) {

				if (fileItem.getContentType() != null) {

					if (fileItem.getSize() > 0) {
						LOGGER.debug("FieldName=" + fileItem.getFieldName());
						LOGGER.debug("Name=" + fileItem.getName());
						LOGGER.debug("ContentType=" + fileItem.getContentType());
						LOGGER.debug("Size=" + fileItem.getSize());
						LOGGER.debug("Length=" + fileItem.get().length);
						
						documentItemList.add(fileItem);
					}
				} else {
					// prevent XSS
					parameterMap.put(fileItem.getFieldName(), fileItem.getString("utf-8"));
				}

			}
		}catch( Exception e){
			
			LOGGER.warn( "Exception ", e);
			
		}
		
//		LOGGER.debug("getProductMessage(): parameterMap: " + parameterMap);
//		LOGGER.debug("getProductMessage(): documentItemList: " + documentItemList);
		
		
		ProductMessage productMessage = new ProductMessage();

		String productIdStr = parameterMap.get(PRODUCT_ID.getKey());
		String productGroupIdStr = parameterMap.get(PRODUCT_GROUP_ID.getKey());
		String nameEn = parameterMap.get(PRODUCT_NAME_EN.getKey());
		String nameHk = parameterMap.get(PRODUCT_NAME_HK.getKey());
		String nameCn = parameterMap.get(PRODUCT_NAME_CN.getKey());
		String thumbnailUrl = parameterMap.get(PRODUCT_THUMBNAIL_URL.getKey());
		String designerClientId = parameterMap.get(PRODUCT_DESIGNER_CLIENT_ID.getKey());
		String model = parameterMap.get(PRODUCT_MODEL.getKey());
		String stock = parameterMap.get(PRODUCT_STOCK.getKey());
		String manufacturerId = parameterMap.get(PRODUCT_MANUFACTURER_ID.getKey());
		String price = parameterMap.get(PRODUCT_PRICE.getKey());
		String availableDate = parameterMap.get(PRODUCT_AVAILABLED_DATE.getKey());
		String weight = parameterMap.get(PRODUCT_WEIGHT.getKey());
		String length = parameterMap.get(PRODUCT_LENGTH.getKey());
		String width = parameterMap.get(PRODUCT_WIDTH.getKey());
		String height = parameterMap.get(PRODUCT_HEIGHT.getKey());
		String sortingOrder = parameterMap.get(PRODUCT_SORTING_ORDER.getKey());
		String stockStatus = parameterMap.get(PRODUCT_STOCK_STATUS.getKey());
		String productStatus = parameterMap.get(PRODUCT_STATUS.getKey());
		String createTimestamp = parameterMap.get(PRODUCT_CREATE_TIMESTAMP.getKey());
		String lastModifiedTimestamp = parameterMap.get(PRODUCT_LAST_MODIFIED_TIMESTAMP.getKey());
		
		if (LabelUtil.isValidFormValue(productIdStr)) {
			try {
				productMessage.setProductId(Integer.parseInt(productIdStr));
			} catch (Exception e) {
				LOGGER.warn("Exception ", e);
			}
		}
		
		if (LabelUtil.isValidFormValue(productGroupIdStr)) {
			try {
				productMessage.setProductGroupId(Integer.parseInt(productGroupIdStr));
			} catch (Exception e) {
				LOGGER.warn("Exception ", e);
			}
		}
		
		if (LabelUtil.isValidFormValue(nameEn)) {

			productMessage.setNameEn( LabelUtil.parseValidFormValue( nameEn ));

		}
		
		if (LabelUtil.isValidFormValue(nameHk)) {

			productMessage.setNameHk( LabelUtil.parseValidFormValue( nameHk ));

		}
		
		if (LabelUtil.isValidFormValue(nameCn)) {

			productMessage.setNameCn( LabelUtil.parseValidFormValue( nameCn ));

		}
		
		if (LabelUtil.isValidFormValue( thumbnailUrl)) {

			productMessage.setThumbnailUrl( LabelUtil.parseValidFormValue( thumbnailUrl ));

		}

		if (LabelUtil.isValidFormValue(designerClientId)) {
			try {
				productMessage.setDesignerClientId(Integer.parseInt(designerClientId));
			} catch (Exception e) {

			}
		}

		if (LabelUtil.isValidFormValue(model)) {

			productMessage.setModel( LabelUtil.parseValidFormValue( model ) );

		}else{
			
			productMessage.setModel( "" );
			
		}
		
		if (LabelUtil.isValidFormValue(stock)) {
			try {
				productMessage.setStock(Long.parseLong(LabelUtil.parseValidFormNumberValue(stock ) ) );
			} catch (Exception e) {
				
			}
		}

		if (LabelUtil.isValidFormValue(manufacturerId)) {
			try {
				productMessage.setManufacturerId(Integer.parseInt(manufacturerId));
			} catch (Exception e) {

			}
		}
		
		if (LabelUtil.isValidFormValue(price)) {
			try {
				productMessage.setPrice(new BigDecimal(LabelUtil.parseValidFormNumberValue(price)));
			} catch (Exception e) {

			}
		}

		if (LabelUtil.isValidFormValue(availableDate)) {
			try {
				productMessage.setAvailableDate(Integer.parseInt(availableDate));
			} catch (Exception e) {

			}
		}

		if (LabelUtil.isValidFormValue(weight)) {
			try {
				productMessage.setWeight(new BigDecimal(LabelUtil.parseValidFormNumberValue(weight)));
			} catch (Exception e) {

			}
		}

		if (LabelUtil.isValidFormValue(length)) {
			try {
				productMessage.setLength(new BigDecimal(LabelUtil.parseValidFormNumberValue(length)));
			} catch (Exception e) {

			}
		}

		if (LabelUtil.isValidFormValue(width)) {
			try {
				productMessage.setWidth(new BigDecimal( LabelUtil.parseValidFormNumberValue(width )) );
			} catch (Exception e) {

			}
		}

		if (LabelUtil.isValidFormValue(height)) {
			try {
				productMessage.setHeight(new BigDecimal(LabelUtil.parseValidFormNumberValue(height)));
			} catch (Exception e) {

			}
		}

		if (LabelUtil.isValidFormValue(sortingOrder)) {
			try {
				productMessage.setSortingOrder(Integer.parseInt(sortingOrder));
			} catch (Exception e) {

			}
		}

		if (LabelUtil.isValidFormValue(stockStatus)) {
			try {
				productMessage.setStockStatus(StockStatus.fromValue(stockStatus));
			} catch (Exception e) {

			}
		}

		if (LabelUtil.isValidFormValue(productStatus)) {
			try {
				productMessage.setProductStatus(ProductStatus.fromValue(productStatus));
			} catch (Exception e) {

			}
		}

		if (LabelUtil.isValidFormValue(createTimestamp)) {
			try {
				productMessage.setCreateTimestamp(Long.parseLong(createTimestamp));
			} catch (Exception e) {

			}
		}

		if (LabelUtil.isValidFormValue(lastModifiedTimestamp)) {
			try {
				productMessage.setLastModifiedTimestamp(Long.parseLong(lastModifiedTimestamp));
			} catch (Exception e) {

			}
		}
		
		CustomizeProductBaseMessage baseMessage = parseCustomizeProductBase( parameterMap );

		productMessage.setCustomizeProductBase( baseMessage );		
		
		return productMessage;
	}
	
	private CustomizeProductBaseMessage parseCustomizeProductBase( Map<String, String> dataMap ){
		
		CustomizeProductBaseMessage baseMessage = new CustomizeProductBaseMessage();
		
		String baseIdStr = dataMap.get( "customize_product_base_id" );

		int baseId = -1;
		
		try{	
			if ( baseIdStr != null ){
				baseId = Integer.parseInt( baseIdStr );
			}
			
			baseMessage.setBaseId(baseId);

		}catch( Exception e){
			LOGGER.warn( "Exception ", e );			
		}

		List<CustomizeProductBaseViewMessage> viewList = parseCustomizeProductViewList( baseId, dataMap );
		
		List<CustomizeProductColorItemMessage> colorList = parseCustomizeProductColorList( baseId, dataMap  );

		baseMessage.setViews(viewList);

		baseMessage.setColorItemList(colorList);
		
		return baseMessage;
		
	}
	
	private List<CustomizeProductBaseViewMessage> parseCustomizeProductViewList( int baseId, Map<String, String> dataMap ) {
		
		boolean findNext = true;
		int index = 0;
		
		List<CustomizeProductBaseViewMessage> viewList = new ArrayList<CustomizeProductBaseViewMessage>();
				
		do{
									
			String viewIdStr = dataMap.get("customize_product_base_view_id_" + index);
			String title = dataMap.get("customize_product_base_view_title_" + index);
			String boundWidthStr = dataMap.get("customize_product_base_view_bound_width_" + index);
			String boundHeightStr = dataMap.get("customize_product_base_view_bound_height_" + index);
			String zStr = dataMap.get( "customize_product_base_view_z_" + index);
			String scaleStr = dataMap.get( "customize_product_base_view_scale_" + index);
			
			CustomizeProductBaseViewMessage viewMessage = new CustomizeProductBaseViewMessage();
						
			viewMessage.setBaseId(baseId);
			
			if ( title == null ){
				
				findNext = false;
				
			}else{
			
				if ( LabelUtil.isValidFormValue( viewIdStr ) ) {
					
					try{
						viewMessage.setViewId( Integer.parseInt( viewIdStr ) );
					}catch( Exception e){
						
						LOGGER.warn("Exception ", e );
						
					}
				}
				
				if ( LabelUtil.isValidFormValue( title ) ) {
					
					viewMessage.setTitle(title);
					
				}
				
				if ( LabelUtil.isValidFormValue( boundWidthStr ) ) {
					
					try{
						viewMessage.setBoundWidth( Integer.parseInt( LabelUtil.parseValidFormNumberValue( boundWidthStr ) ) );
					}catch( Exception e){
						
						LOGGER.warn("Exception ", e );
						
					}
				}
				
				if ( LabelUtil.isValidFormValue( boundHeightStr ) ) {
					
					try{
						viewMessage.setBoundHeight( Integer.parseInt( LabelUtil.parseValidFormNumberValue( boundHeightStr ) ) );
					}catch( Exception e){
						
						LOGGER.warn("Exception ", e );
						
					}
				}
				
				if ( LabelUtil.isValidFormValue( zStr ) ) {
					
					try{
						viewMessage.setZ( Integer.parseInt( LabelUtil.parseValidFormNumberValue( zStr ) ) );
					}catch( Exception e){
						
						LOGGER.warn("Exception ", e );
						
					}
				}
				
				if ( LabelUtil.isValidFormValue( scaleStr ) ) {
					
					try{
						viewMessage.setScale( new BigDecimal( LabelUtil.parseValidFormNumberValue( scaleStr ) ) );
					}catch( Exception e){
						
						LOGGER.warn("Exception ", e );
						
					}
				}
			
				List<CustomizeProductBorderItemMessage> borderList = parseCustomizeProductBorderList( index, viewMessage.getViewId(), dataMap );
				
				viewMessage.setBorderList(borderList);
				
				viewList.add( viewMessage );
				
				index ++;
			}
			
		}while( findNext );
		
		return viewList;
		
	}
	
	private List<CustomizeProductBorderItemMessage> parseCustomizeProductBorderList( int viewIndex, int viewId, Map<String, String> dataMap ) {
		
		boolean findNext = true;
		int index = 0;
		
		List<CustomizeProductBorderItemMessage> itemList = new ArrayList<CustomizeProductBorderItemMessage>();
				
		do{
			
			String borderIdStr = dataMap.get("customize_product_border_id_" + viewIndex + "_" + index);
			String itemKey = dataMap.get("customize_product_border_item_key_" + viewIndex + "_" + index);
			String itemType = dataMap.get( "customize_product_border_item_type_" + viewIndex + "_" + index);
			String title = dataMap.get( "customize_product_border_title_" + viewIndex + "_" + index);
			String defaultOption = dataMap.get( "customize_product_border_default_option_" + viewIndex + "_" + index);
			String costStr = dataMap.get( "customize_product_border_cost_" + viewIndex + "_" + index);
			String xStr = dataMap.get( "customize_product_border_x_" + viewIndex + "_" + index);
			String yStr = dataMap.get( "customize_product_border_y_" + viewIndex + "_" + index);
			String widthStr = dataMap.get( "customize_product_border_width_" + viewIndex + "_" + index);
			String heightStr = dataMap.get( "customize_product_border_height_" + viewIndex + "_" + index);

			
			CustomizeProductBorderItemMessage itemMessage = new CustomizeProductBorderItemMessage();
						
			itemMessage.setViewId( viewId );
			
			if ( itemKey == null || itemType == null ){
					
				findNext = false;
				
			}else{
			
				if ( LabelUtil.isValidFormValue( borderIdStr ) ) {
					
					try{
						itemMessage.setBorderId( Integer.parseInt( borderIdStr ) );
					}catch( Exception e){
						
						LOGGER.warn("Exception ", e );
						
					}
				}
				
				if ( LabelUtil.isValidFormValue( itemKey ) ) {

					itemMessage.setItemKey(itemKey);

				}
				
				if ( LabelUtil.isValidFormValue( itemType ) ) {

					itemMessage.setItemType(itemType);

				}
				
				if ( LabelUtil.isValidFormValue( title ) ) {

					itemMessage.setTitle(title);

				}
				
				//DefaultOption
			
				if ( LabelUtil.isValidFormValue( costStr ) ) {
					
					try{
						itemMessage.setCost( new BigDecimal( LabelUtil.parseValidFormNumberValue( costStr ) ) );
					}catch( Exception e){
						
						LOGGER.warn("Exception ", e );
						
					}
				}
				
				if ( LabelUtil.isValidFormValue( xStr ) ) {
					
					try{
						itemMessage.setX( Integer.parseInt( LabelUtil.parseValidFormNumberValue( xStr ) ) );
					}catch( Exception e){
						
						LOGGER.warn("Exception ", e );
						
					}
				}
					
				if ( LabelUtil.isValidFormValue( yStr ) ) {
					
					try{
						itemMessage.setY( Integer.parseInt( LabelUtil.parseValidFormNumberValue( yStr ) ) );
					}catch( Exception e){
						
						LOGGER.warn("Exception ", e );
						
					}
				}


				if ( LabelUtil.isValidFormValue( widthStr ) ) {
					
					try{
						itemMessage.setWidth( Integer.parseInt( LabelUtil.parseValidFormNumberValue( widthStr ) ) );
					}catch( Exception e){
						
						LOGGER.warn("Exception ", e );
						
					}
				}
				
				if ( LabelUtil.isValidFormValue( heightStr ) ) {
					
					try{
						itemMessage.setHeight( Integer.parseInt( LabelUtil.parseValidFormNumberValue( heightStr ) ) );
					}catch( Exception e){
						
						LOGGER.warn("Exception ", e );
						
					}
				}
				
				itemList.add( itemMessage );
				
				index ++;
				
			}
			
		}while( findNext );
		
		return itemList;
		
	}
	
	private List<CustomizeProductColorItemMessage> parseCustomizeProductColorList( int baseId, Map<String, String> dataMap ) {
			
		boolean findNext = true;
		int index = 0;
		
		List<CustomizeProductColorItemMessage> itemList = new ArrayList<CustomizeProductColorItemMessage>();
				
		do{
			
			String colorIdStr = dataMap.get("customize_product_color_id_" + index);
			String fileType = dataMap.get("customize_product_color_file_type_" + index);
			String imageUrl = dataMap.get( "customize_product_color_image_url_" + index);
			String parentImage = dataMap.get( "customize_product_color_parent_image_" + index);

			
			CustomizeProductColorItemMessage itemMessage = new CustomizeProductColorItemMessage();
						
			itemMessage.setBaseId(baseId);
			
			if ( fileType == null ){
					
				findNext = false;
				
			}else{
			
				if ( LabelUtil.isValidFormValue( colorIdStr ) ) {
					
					try{
						itemMessage.setColorId( Integer.parseInt( colorIdStr ) );
					}catch( Exception e){
						
						LOGGER.warn("Exception ", e );
						
					}
				}
				
				if ( LabelUtil.isValidFormValue( fileType ) ) {
				
					itemMessage.setFileType(fileType);
					
				}
				
				if ( LabelUtil.isValidFormValue( imageUrl ) ) {
					
					itemMessage.setImageUrl(imageUrl);
					
				}
				
				if ( LabelUtil.isValidFormValue( parentImage ) ) {
					
					itemMessage.setParentImage(parentImage);
					
				}
					
				itemList.add( itemMessage );
				
				index ++;
				
			}
			
		}while( findNext );
		
		return itemList;
		
	}

}
