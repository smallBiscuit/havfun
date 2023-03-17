package com.havfun.adminui.material;

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
import com.havfun.service.entity.constant.MaterialStatus;
import com.havfun.service.entity.constant.StockStatus;
import com.havfun.service.message.data.MaterialMessage;
import com.havfun.service.utils.LabelUtil;

public class MaterialHelperImpl implements MaterialHelper {

	private static final Logger LOGGER = LogManager.getLogger(MaterialHelper.class.getName());

	public void prepareMaterial(HttpServletRequest request, int servletMode) {

		List<String> modelList = new ArrayList<String>();
		List<String> stockStatusList = new ArrayList<String>();
		List<String> materialStatusList = new ArrayList<String>();
		List<String> manufacturerList = new ArrayList<String>();
		
		for (StockStatus stockStatus : StockStatus.values()) {
			stockStatusList.add(stockStatus.getValue());
		}
		
		for (MaterialStatus materialStatus : MaterialStatus.values()) {
			materialStatusList.add(materialStatus.getValue());
		}

		request.setAttribute("modelList", modelList);
		request.setAttribute("modelLabelList", modelList);
		request.setAttribute("stockStatusList", stockStatusList);
		request.setAttribute("stockStatusLabelList", stockStatusList);
		request.setAttribute("materialStatusList", materialStatusList);
		request.setAttribute("materialStatusLabelList", materialStatusList);
		request.setAttribute("manufacturerList", manufacturerList);
		request.setAttribute("manufacturerLabelList", manufacturerList);

		request.setAttribute(MATERIAL_ID.getKey(), MATERIAL_ID);
		request.setAttribute(MATERIAL_GROUP_ID.getKey(), MATERIAL_GROUP_ID);
		request.setAttribute(MATERIAL_NAME_EN.getKey(), MATERIAL_NAME_EN);
		request.setAttribute(MATERIAL_NAME_HK.getKey(), MATERIAL_NAME_HK);
		request.setAttribute(MATERIAL_NAME_CN.getKey(), MATERIAL_NAME_CN);
		request.setAttribute(MATERIAL_THUMBNAIL_URL.getKey(), MATERIAL_THUMBNAIL_URL);
		request.setAttribute(MATERIAL_DESIGNER_CLIENT_ID.getKey(), MATERIAL_DESIGNER_CLIENT_ID);
		request.setAttribute(MATERIAL_MODEL.getKey(), MATERIAL_MODEL);
		request.setAttribute(MATERIAL_STOCK.getKey(), MATERIAL_STOCK);
		request.setAttribute(MATERIAL_MANUFACTURER_ID.getKey(), MATERIAL_MANUFACTURER_ID);
		request.setAttribute(MATERIAL_PRICE.getKey(), MATERIAL_PRICE);
		request.setAttribute(MATERIAL_AVAILABLED_DATE.getKey(), MATERIAL_AVAILABLED_DATE);
		request.setAttribute(MATERIAL_WEIGHT.getKey(), MATERIAL_WEIGHT);
		request.setAttribute(MATERIAL_LENGTH.getKey(), MATERIAL_LENGTH);
		request.setAttribute(MATERIAL_WIDTH.getKey(), MATERIAL_WIDTH);
		request.setAttribute(MATERIAL_HEIGHT.getKey(), MATERIAL_HEIGHT);
		request.setAttribute(MATERIAL_SORTING_ORDER.getKey(), MATERIAL_SORTING_ORDER);
		request.setAttribute(MATERIAL_STOCK_STATUS.getKey(), MATERIAL_STOCK_STATUS);
		request.setAttribute(MATERIAL_STATUS.getKey(), MATERIAL_STATUS);
		request.setAttribute(MATERIAL_CREATE_TIMESTAMP.getKey(), MATERIAL_CREATE_TIMESTAMP);
		request.setAttribute(MATERIAL_LAST_MODIFIED_TIMESTAMP.getKey(), MATERIAL_LAST_MODIFIED_TIMESTAMP);
		
		
		Map<String, Boolean> actionMap = (Map<String, Boolean>) request.getAttribute("ActionMap");

		switch (servletMode) {
		case SERVLET_TYPE_CREATE:
			request.setAttribute(NAVIGATOR, "content_material_create_material");
			request.setAttribute(ACTION, CREATE_MATERIAL_REQUEST);
			request.setAttribute(PAGE_MODE, WebComponent.PAGE_MODE_CREATE);
			break;
		case SERVLET_TYPE_ENQUIRE:
			request.setAttribute(NAVIGATOR, "content_material_enquire_material");
			if (actionMap.get(UPDATE_MATERIAL_REQUEST) != null) {
				request.setAttribute(ACTION, UPDATE_MATERIAL_REQUEST);
				request.setAttribute(PAGE_MODE, WebComponent.PAGE_MODE_UPDATE);
			} else {
				request.setAttribute(PAGE_MODE, WebComponent.PAGE_MODE_READONLY);
			}
			break;
		}
	}

	public MaterialMessage getMaterialMessage(HttpServletRequest request) {
		
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
		
//		LOGGER.debug("getMaterialMessage(): parameterMap: " + parameterMap);
//		LOGGER.debug("getMaterialMessage(): documentItemList: " + documentItemList);
		
		
		MaterialMessage materialMessage = new MaterialMessage();

		String materialIdStr = parameterMap.get(MATERIAL_ID.getKey());
		String materialGroupIdStr = parameterMap.get(MATERIAL_GROUP_ID.getKey());
		String nameEn = parameterMap.get(MATERIAL_NAME_EN.getKey());
		String nameHk = parameterMap.get(MATERIAL_NAME_HK.getKey());
		String nameCn = parameterMap.get(MATERIAL_NAME_CN.getKey());
		String thumbnailUrl = parameterMap.get(MATERIAL_THUMBNAIL_URL.getKey());
		String designerClientId = parameterMap.get(MATERIAL_DESIGNER_CLIENT_ID.getKey());
		String model = parameterMap.get(MATERIAL_MODEL.getKey());
		String stock = parameterMap.get(MATERIAL_STOCK.getKey());
		String manufacturerId = parameterMap.get(MATERIAL_MANUFACTURER_ID.getKey());
		String price = parameterMap.get(MATERIAL_PRICE.getKey());
		String availableDate = parameterMap.get(MATERIAL_AVAILABLED_DATE.getKey());
		String weight = parameterMap.get(MATERIAL_WEIGHT.getKey());
		String length = parameterMap.get(MATERIAL_LENGTH.getKey());
		String width = parameterMap.get(MATERIAL_WIDTH.getKey());
		String height = parameterMap.get(MATERIAL_HEIGHT.getKey());
		String sortingOrder = parameterMap.get(MATERIAL_SORTING_ORDER.getKey());
		String stockStatus = parameterMap.get(MATERIAL_STOCK_STATUS.getKey());
		String materialStatus = parameterMap.get(MATERIAL_STATUS.getKey());
		String createTimestamp = parameterMap.get(MATERIAL_CREATE_TIMESTAMP.getKey());
		String lastModifiedTimestamp = parameterMap.get(MATERIAL_LAST_MODIFIED_TIMESTAMP.getKey());
		
		if (LabelUtil.isValidFormValue(materialIdStr)) {
			try {
				materialMessage.setMaterialId(Integer.parseInt(materialIdStr));
			} catch (Exception e) {
				LOGGER.warn("Exception ", e);
			}
		}
		/*
		if (LabelUtil.isValidFormValue(materialGroupIdStr)) {
			try {
				materialMessage.setMaterialGroupId(Integer.parseInt(materialGroupIdStr));
			} catch (Exception e) {
				LOGGER.warn("Exception ", e);
			}
		}
		
		*/	
		
		return materialMessage;
	}

}
