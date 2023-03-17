package com.havfun.adminui.order;

import com.havfun.adminui.common.AbstractDataHelper;
import com.havfun.adminui.webcomponent.DatePicker;
import com.havfun.adminui.webcomponent.OrderProductList;
import com.havfun.adminui.webcomponent.Select;
import com.havfun.adminui.webcomponent.TextInput;
import com.havfun.adminui.webcomponent.TimePicker;
import com.havfun.adminui.webcomponent.WebComponent;

public interface OrderHelper extends AbstractDataHelper {

	public static final String DATA_IMAGE = "dataImage";
	public static final String ORIG_DATA_IMAGE = "origDataImage";
	public static final String ORDER_JSP = "/WEB-INF/order.jsp";
	public static final String SEARCH_ORDER_JSP = "/WEB-INF/searchOrder.jsp";

	public static final String CREATE_ORDER = "CreateOrder";
	public static final String CREATE_ORDER_REQUEST = "CreateOrderRequest";
	public static final String ENQUIRE_ORDER = "EnquireOrder";
	public static final String UPDATE_ORDER_REQUEST = "UpdateOrderRequest";

	public WebComponent ORDER_ID = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_ID), 8);
	public WebComponent ORDER_INVOICE_NO = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_INVOICE_NO), 20);
	public WebComponent ORDER_STORE_ID = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_STORE_ID), 20);
	public WebComponent ORDER_STORE_NAME = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_STORE_NAME), 20);
	public WebComponent ORDER_STORE_URL = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_STORE_URL), 20);
	public WebComponent ORDER_CLIENT_ID = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_CLIENT_ID), 20);
	public WebComponent ORDER_CLIENT_GROUP = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_CLIENT_GROUP), 20);
	public WebComponent ORDER_FIRST_NAME = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_FIRST_NAME), 20);
	public WebComponent ORDER_LAST_NAME = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_LAST_NAME), 20);
	public WebComponent ORDER_EMAIL = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_EMAIL), 20);
	public WebComponent ORDER_TELEPHONE = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_TELEPHONE), 20);
	public WebComponent ORDER_FAX = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_FAX), 20);

	public WebComponent ORDER_PRODUCT_LIST = new OrderProductList( OrderComponentConfig.getValueMapByKey( OrderComponentConfig.ORDER_PRODUCT_LIST ) );
	
	public WebComponent ORDER_BILLING_FIRST_NAME = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_BILLING_FIRST_NAME), 20);
	public WebComponent ORDER_BILLING_LAST_NAME = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_BILLING_LAST_NAME), 20);
	public WebComponent ORDER_BILLING_ADDRESS1 = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_BILLING_ADDRESS1), 20);
	public WebComponent ORDER_BILLING_ADDRESS2 = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_BILLING_ADDRESS2), 20);
	public WebComponent ORDER_BILLING_CITY = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_BILLING_CITY), 20);
	public WebComponent ORDER_BILLING_POSTCODE = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_BILLING_POSTCODE), 20);
	public WebComponent ORDER_BILLING_COUNTRY_ID = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_BILLING_COUNTRY_ID), 20);
	public WebComponent ORDER_BILLING_TELEPHONE = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_BILLING_TELEPHONE), 20);
	public WebComponent ORDER_SHIPPING_FIRST_NAME = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_SHIPPING_FIRST_NAME), 20);
	public WebComponent ORDER_SHIPPING_LAST_NAME = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_SHIPPING_LAST_NAME), 20);
	public WebComponent ORDER_SHIPPING_ADDRESS1 = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_SHIPPING_ADDRESS1), 20);
	public WebComponent ORDER_SHIPPING_ADDRESS2 = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_SHIPPING_ADDRESS2), 20);
	public WebComponent ORDER_SHIPPING_CITY = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_SHIPPING_CITY), 20);
	public WebComponent ORDER_SHIPPING_POSTCODE = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_SHIPPING_POSTCODE), 20);
	public WebComponent ORDER_SHIPPING_COUNTRY_ID = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_SHIPPING_COUNTRY_ID), 20);
	public WebComponent ORDER_SHIPPING_METHOD_ID = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_SHIPPING_METHOD_ID), 20);
	public WebComponent ORDER_PAYMENT_METHOD_ID = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_PAYMENT_METHOD_ID), 20);
	public WebComponent ORDER_SHIPPING_TELEPHONE = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_SHIPPING_TELEPHONE), 20);
	public WebComponent ORDER_CURRENCY_ID = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_CURRENCY_ID), 20);
	public WebComponent ORDER_CURRENCY_CODE = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_CURRENCY_CODE), 20);
	public WebComponent ORDER_CURRENCY_VALUE = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_CURRENCY_VALUE), 20);
	public WebComponent ORDER_REMARK = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_REMARK), 20);
	public WebComponent ORDER_TOTAL = new TextInput(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_TOTAL), 20);
	public WebComponent ORDER_STATUS = new Select(
			OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_STATUS));
	public WebComponent ORDER_CREATE_TIMESTAMP = new TimePicker( OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_CREATE_TIMESTAMP) );
	public WebComponent ORDER_LAST_MODIFIED_TIMESTAMP = new TimePicker( OrderComponentConfig.getValueMapByKey(OrderComponentConfig.ORDER_LAST_MODIFIED_TIMESTAMP) );


}
