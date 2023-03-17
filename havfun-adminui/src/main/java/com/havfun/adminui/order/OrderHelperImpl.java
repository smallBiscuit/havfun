package com.havfun.adminui.order;

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
import com.havfun.service.entity.constant.OrderStatus;
import com.havfun.service.entity.constant.StockStatus;
import com.havfun.service.message.data.OrderMessage;
import com.havfun.service.message.data.OrderProductMessage;
import com.havfun.service.utils.LabelUtil;

public class OrderHelperImpl implements OrderHelper {

	private static final Logger LOGGER = LogManager.getLogger(OrderHelper.class.getName());

	public void prepareOrder(HttpServletRequest request, int servletMode) {

		List<String> modelList = new ArrayList<String>();
		List<String> stockStatusList = new ArrayList<String>();
		List<String> orderStatusList = new ArrayList<String>();
		List<String> manufacturerList = new ArrayList<String>();
		
		for (StockStatus stockStatus : StockStatus.values()) {
			stockStatusList.add(stockStatus.getValue());
		}
		
		for (OrderStatus orderStatus : OrderStatus.values()) {
			orderStatusList.add(orderStatus.getValue());
		}

		request.setAttribute("modelList", modelList);
		request.setAttribute("modelLabelList", modelList);
		request.setAttribute("stockStatusList", stockStatusList);
		request.setAttribute("stockStatusLabelList", stockStatusList);
		request.setAttribute("orderStatusList", orderStatusList);
		request.setAttribute("orderStatusLabelList", orderStatusList);
		request.setAttribute("manufacturerList", manufacturerList);
		request.setAttribute("manufacturerLabelList", manufacturerList);

		request.setAttribute(ORDER_ID.getKey(), ORDER_ID);
		request.setAttribute(ORDER_INVOICE_NO.getKey(), ORDER_INVOICE_NO);
		request.setAttribute(ORDER_STORE_ID.getKey(), ORDER_STORE_ID);
		request.setAttribute(ORDER_STORE_NAME.getKey(), ORDER_STORE_NAME);
		request.setAttribute(ORDER_STORE_URL.getKey(), ORDER_STORE_URL);
		request.setAttribute(ORDER_CLIENT_ID.getKey(), ORDER_CLIENT_ID);
		request.setAttribute(ORDER_CLIENT_GROUP.getKey(), ORDER_CLIENT_GROUP);
		request.setAttribute(ORDER_FIRST_NAME.getKey(), ORDER_FIRST_NAME);
		request.setAttribute(ORDER_LAST_NAME.getKey(), ORDER_LAST_NAME);
		request.setAttribute(ORDER_EMAIL.getKey(), ORDER_EMAIL);
		request.setAttribute(ORDER_TELEPHONE.getKey(), ORDER_TELEPHONE);
		request.setAttribute(ORDER_FAX.getKey(), ORDER_FAX);
		request.setAttribute(ORDER_PRODUCT_LIST.getKey(), ORDER_PRODUCT_LIST);
		request.setAttribute(ORDER_BILLING_FIRST_NAME.getKey(), ORDER_BILLING_FIRST_NAME);
		request.setAttribute(ORDER_BILLING_LAST_NAME.getKey(), ORDER_BILLING_LAST_NAME);
		request.setAttribute(ORDER_BILLING_ADDRESS1.getKey(), ORDER_BILLING_ADDRESS1);
		request.setAttribute(ORDER_BILLING_ADDRESS2.getKey(), ORDER_BILLING_ADDRESS2);
		request.setAttribute(ORDER_BILLING_CITY.getKey(), ORDER_BILLING_CITY);
		request.setAttribute(ORDER_BILLING_POSTCODE.getKey(), ORDER_BILLING_POSTCODE);
		request.setAttribute(ORDER_BILLING_COUNTRY_ID.getKey(), ORDER_BILLING_COUNTRY_ID);
		request.setAttribute(ORDER_BILLING_TELEPHONE.getKey(), ORDER_BILLING_TELEPHONE);
		request.setAttribute(ORDER_SHIPPING_FIRST_NAME.getKey(), ORDER_SHIPPING_FIRST_NAME);
		request.setAttribute(ORDER_SHIPPING_LAST_NAME.getKey(), ORDER_SHIPPING_LAST_NAME);
		request.setAttribute(ORDER_SHIPPING_ADDRESS1.getKey(), ORDER_SHIPPING_ADDRESS1);
		request.setAttribute(ORDER_SHIPPING_ADDRESS2.getKey(), ORDER_SHIPPING_ADDRESS2);
		request.setAttribute(ORDER_SHIPPING_CITY.getKey(), ORDER_SHIPPING_CITY);
		request.setAttribute(ORDER_SHIPPING_POSTCODE.getKey(), ORDER_SHIPPING_POSTCODE);
		request.setAttribute(ORDER_SHIPPING_COUNTRY_ID.getKey(), ORDER_SHIPPING_COUNTRY_ID);
		request.setAttribute(ORDER_SHIPPING_TELEPHONE.getKey(), ORDER_SHIPPING_TELEPHONE);
		request.setAttribute(ORDER_SHIPPING_METHOD_ID.getKey(), ORDER_SHIPPING_METHOD_ID);
		request.setAttribute(ORDER_PAYMENT_METHOD_ID.getKey(), ORDER_PAYMENT_METHOD_ID);		
		request.setAttribute(ORDER_CURRENCY_ID.getKey(), ORDER_CURRENCY_ID);
		request.setAttribute(ORDER_CURRENCY_CODE.getKey(), ORDER_CURRENCY_CODE);
		request.setAttribute(ORDER_CURRENCY_VALUE.getKey(), ORDER_CURRENCY_VALUE);
		request.setAttribute(ORDER_REMARK.getKey(), ORDER_REMARK);
		request.setAttribute(ORDER_TOTAL.getKey(), ORDER_TOTAL);
		request.setAttribute(ORDER_STATUS.getKey(), ORDER_STATUS);
		request.setAttribute(ORDER_CREATE_TIMESTAMP.getKey(), ORDER_CREATE_TIMESTAMP);
		request.setAttribute(ORDER_LAST_MODIFIED_TIMESTAMP.getKey(), ORDER_LAST_MODIFIED_TIMESTAMP);
		
		
		Map<String, Boolean> actionMap = (Map<String, Boolean>) request.getAttribute("ActionMap");

		switch (servletMode) {
		case SERVLET_TYPE_CREATE:
			request.setAttribute(NAVIGATOR, "content_order_create_order");
			request.setAttribute(ACTION, CREATE_ORDER_REQUEST);
			request.setAttribute(PAGE_MODE, WebComponent.PAGE_MODE_CREATE);
			break;
		case SERVLET_TYPE_ENQUIRE:
			request.setAttribute(NAVIGATOR, "content_order_enquire_order");
			if (actionMap.get(UPDATE_ORDER_REQUEST) != null) {
				request.setAttribute(ACTION, UPDATE_ORDER_REQUEST);
				request.setAttribute(PAGE_MODE, WebComponent.PAGE_MODE_UPDATE);
			} else {
				request.setAttribute(PAGE_MODE, WebComponent.PAGE_MODE_READONLY);
			}
			break;
		}
	}

	public OrderMessage getOrderMessage(HttpServletRequest request) {
		
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
		
		LOGGER.debug("getOrderMessage(): parameterMap: " + parameterMap);
		LOGGER.debug("getOrderMessage(): documentItemList: " + documentItemList);
		
		
		OrderMessage orderMessage = new OrderMessage();

		String orderIdStr = parameterMap.get(ORDER_ID.getKey());
		String invoiceNo = parameterMap.get(ORDER_INVOICE_NO.getKey());
		String storeId = parameterMap.get(ORDER_STORE_ID.getKey());
		String storeName = parameterMap.get(ORDER_STORE_NAME.getKey());
		String storeUrl = parameterMap.get(ORDER_STORE_URL.getKey());
		String clientId = parameterMap.get(ORDER_CLIENT_ID.getKey());
		String clientGroup = parameterMap.get(ORDER_CLIENT_GROUP.getKey());
		String firstName = parameterMap.get(ORDER_FIRST_NAME.getKey());
		String lastName = parameterMap.get(ORDER_LAST_NAME.getKey());
		String email = parameterMap.get(ORDER_EMAIL.getKey());
		String telephone = parameterMap.get(ORDER_TELEPHONE.getKey());
		String fax = parameterMap.get(ORDER_FAX.getKey());
		String billingFirstName = parameterMap.get(ORDER_BILLING_FIRST_NAME.getKey());
		String billingLastName = parameterMap.get(ORDER_BILLING_LAST_NAME.getKey());
		String billingAddress1 = parameterMap.get(ORDER_BILLING_ADDRESS1.getKey());
		String billingAddress2 = parameterMap.get(ORDER_BILLING_ADDRESS2.getKey());
		String billingCity = parameterMap.get(ORDER_BILLING_CITY.getKey());
		String billingPostcode = parameterMap.get(ORDER_BILLING_POSTCODE.getKey());
		String billingCountryId = parameterMap.get(ORDER_BILLING_COUNTRY_ID.getKey());
		String billingTelephone = parameterMap.get(ORDER_BILLING_TELEPHONE.getKey());
		String shippingFirstName = parameterMap.get(ORDER_SHIPPING_FIRST_NAME.getKey());
		String shippingLastName = parameterMap.get(ORDER_SHIPPING_LAST_NAME.getKey());
		String shippingAddress1 = parameterMap.get(ORDER_SHIPPING_ADDRESS1.getKey());
		String shippingAddress2 = parameterMap.get(ORDER_SHIPPING_ADDRESS2.getKey());
		String shippingCity = parameterMap.get(ORDER_SHIPPING_CITY.getKey());
		String shippingPostcode = parameterMap.get(ORDER_SHIPPING_POSTCODE.getKey());
		String shippingCountryId = parameterMap.get(ORDER_SHIPPING_COUNTRY_ID.getKey());
		String shippingTelephone = parameterMap.get(ORDER_SHIPPING_TELEPHONE.getKey());
		String shippingMethodId = parameterMap.get(ORDER_SHIPPING_METHOD_ID.getKey());
		String paymentMethodId = parameterMap.get(ORDER_PAYMENT_METHOD_ID.getKey());
		String remark = parameterMap.get(ORDER_REMARK.getKey());
		String total = parameterMap.get(ORDER_TOTAL.getKey());
		String status = parameterMap.get(ORDER_STATUS.getKey());
		String currencyId = parameterMap.get(ORDER_CURRENCY_ID.getKey());
		String currencyCode = parameterMap.get(ORDER_CURRENCY_CODE.getKey());
		String currencyValue = parameterMap.get(ORDER_CURRENCY_VALUE.getKey());
		String createTimestamp = parameterMap.get(ORDER_CREATE_TIMESTAMP.getKey());
		String lastModifiedTimestamp = parameterMap.get(ORDER_LAST_MODIFIED_TIMESTAMP.getKey());
		
		
		if (LabelUtil.isValidFormValue(orderIdStr)) {
			try {
				orderMessage.setOrderId(Integer.parseInt(orderIdStr));
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(invoiceNo)) {

			orderMessage.setInvoiceNo( LabelUtil.parseValidFormValue( invoiceNo ) );

		}


		if (LabelUtil.isValidFormValue(storeId)) {
			try {
				orderMessage.setStoreId(Integer.parseInt(storeId));
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(storeName)) {
			try {
				orderMessage.setStoreName(storeName);
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(storeUrl)) {
			try {
				orderMessage.setStoreUrl(storeUrl);
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(clientId)) {
			try {
				orderMessage.setClientId(Integer.parseInt(clientId));
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(clientGroup)) {
			try {
				orderMessage.setClientGroup(clientGroup);
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(firstName)) {
			try {
				orderMessage.setFirstName(firstName);
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(lastName)) {
			try {
				orderMessage.setLastName(lastName);
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(email)) {
			try {
				orderMessage.setEmail(email);
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(telephone)) {
			try {
				orderMessage.setTelephone(telephone);
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(fax)) {
			try {
				orderMessage.setFax(fax);
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(billingFirstName)) {
			try {
				orderMessage.setBillingFirstName(billingFirstName);
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(billingLastName)) {
			try {
				orderMessage.setBillingLastName(billingLastName);
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(billingAddress1)) {
			try {
				orderMessage.setBillingAddress1(billingAddress1);
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(billingAddress2)) {
			try {
				orderMessage.setBillingAddress2(billingAddress2);
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(billingCity)) {
			try {
				orderMessage.setBillingCity(billingCity);
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(billingPostcode)) {
			try {
				orderMessage.setBillingPostcode(billingPostcode);
			} catch (Exception e) {

			}
		}

		if (LabelUtil.isValidFormValue(billingCountryId)) {
			try {
				orderMessage.setBillingCountryId(Integer.parseInt(billingCountryId));
			} catch (Exception e) {

			}
		}

		if (LabelUtil.isValidFormValue(billingTelephone)) {
			try {
				orderMessage.setBillingTelephone(billingTelephone);
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(shippingFirstName)) {
			try {
				orderMessage.setShippingFirstName(shippingFirstName);
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(shippingLastName)) {
			try {
				orderMessage.setShippingLastName(shippingLastName);
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(shippingAddress1)) {
			try {
				orderMessage.setShippingAddress1(shippingAddress1);
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(shippingAddress2)) {
			try {
				orderMessage.setShippingAddress2(shippingAddress2);
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(shippingCity)) {
			try {
				orderMessage.setShippingCity(shippingCity);
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(shippingPostcode)) {
			try {
				orderMessage.setShippingPostcode(shippingPostcode);
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(shippingCountryId)) {
			try {
				orderMessage.setShippingCountryId(Integer.parseInt(shippingCountryId));
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(shippingTelephone)) {
			try {
				orderMessage.setShippingTelephone(shippingTelephone);
			} catch (Exception e) {

			}
		}

		if (LabelUtil.isValidFormValue(shippingMethodId)) {
			try {
				orderMessage.setShippingMethodId(Integer.parseInt(shippingMethodId));
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(paymentMethodId)) {
			try {
				orderMessage.setPaymentMethodId(Integer.parseInt(paymentMethodId));
			} catch (Exception e) {

			}
		}

		if (LabelUtil.isValidFormValue(currencyId)) {
			try {
				orderMessage.setCurrencyId(Integer.parseInt(currencyId));
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(currencyCode)) {
			try {
				orderMessage.setCurrencyCode(currencyCode);
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(currencyValue)) {
			try {
				orderMessage.setCurrencyValue(new BigDecimal(currencyValue));
			} catch (Exception e) {

			}
		}

		if (LabelUtil.isValidFormValue(remark)) {
			try {
				orderMessage.setRemark(remark);
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(total)) {
			try {
				orderMessage.setTotal(new BigDecimal(total));
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(status)) {
			try {
				orderMessage.setStatus(OrderStatus.fromValue(status));
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(createTimestamp)) {
			try {
				orderMessage.setCreateTimestamp(Long.parseLong(createTimestamp));
			} catch (Exception e) {

			}
		}


		if (LabelUtil.isValidFormValue(lastModifiedTimestamp)) {
			try {
				orderMessage.setLastModifiedTimestamp(Long.parseLong(lastModifiedTimestamp));
			} catch (Exception e) {

			}
		}
		
		boolean findNext = true;
		int index = 0;
		
		List<OrderProductMessage> orderProductList = new ArrayList<OrderProductMessage>();
		
		do{
			
			String orderProductIdStr = parameterMap.get("order_product_id_" + index);
			String orderProductOrderIdStr = parameterMap.get("order_product_order_id_" + index);
			String orderProductProductIdStr = parameterMap.get( "order_product_product_id_" + index);
			String orderProductName = parameterMap.get( "order_product_name_" + index);
			String orderProductModel = parameterMap.get( "order_product_model_" + index);
			String orderProductQuantity = parameterMap.get( "order_product_quantity_" + index);
			String orderProductPrice = parameterMap.get( "order_product_price_" + index);			
			
			LOGGER.debug("dennis_order_product_order_id_"+index+"="+orderProductOrderIdStr);
			
			OrderProductMessage orderProductMessage = new OrderProductMessage();
						
			if ( orderProductOrderIdStr == null || orderProductProductIdStr == null ){
				
				findNext = false;
				
			}else{
			
				if (LabelUtil.isValidFormValue(orderProductIdStr)) {
					try {
						orderProductMessage.setOrderProductId(Integer.parseInt(orderProductIdStr));
					} catch (Exception e) {
						LOGGER.warn("Exception ", e);
					}
				}
				
				if (LabelUtil.isValidFormValue(orderProductOrderIdStr)) {
					try {
						orderProductMessage.setOrderId(Integer.parseInt(orderProductOrderIdStr));
					} catch (Exception e) {
						LOGGER.warn("Exception ", e);
					}
				}
				
				if (LabelUtil.isValidFormValue(orderProductProductIdStr)) {
					try {
						orderProductMessage.setProductId(Integer.parseInt(orderProductProductIdStr));
					} catch (Exception e) {
						LOGGER.warn("Exception ", e);
					}
				}
				
				if ( LabelUtil.isValidFormValue( orderProductName ) ) {
					
					orderProductMessage.setName( LabelUtil.parseValidFormValue( orderProductName ) );

				}
				
				if ( LabelUtil.isValidFormValue( orderProductModel ) ) {
					
					orderProductMessage.setModel( LabelUtil.parseValidFormValue( orderProductModel ) );

				}
				
				if (LabelUtil.isValidFormValue(orderProductQuantity)) {
					try {
						orderProductMessage.setQuantity(Integer.parseInt(orderProductQuantity));
					} catch (Exception e) {
						LOGGER.warn("Exception ", e);
					}
				}
				
				if (LabelUtil.isValidFormValue(orderProductPrice)) {
					try {
						orderProductMessage.setPrice(new BigDecimal(orderProductPrice));
					} catch (Exception e) {

					}
				}

				orderProductMessage.setTotal( BigDecimal.ZERO );
				
				orderProductMessage.setTax( BigDecimal.ZERO );
				
				orderProductList.add( orderProductMessage );
				
				index ++;
			}
			
		}while( findNext );
		
		
		
		orderMessage.setOrderProductList(orderProductList);

		return orderMessage;
	}

}
