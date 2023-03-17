package com.havfun.appsservice.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.google.gson.Gson;
import com.havfun.appsservice.convertor.AddressConvertor;
import com.havfun.appsservice.data.Address;
import com.havfun.appsservice.data.BaseClient;
import com.havfun.appsservice.data.CartProduct;
import com.havfun.appsservice.data.Order;
import com.havfun.appsservice.data.OrderProductBase;
import com.havfun.appsservice.helper.ClientServiceHelper;
import com.havfun.appsservice.message.CreateOrderRequest;
import com.havfun.appsservice.message.CreateOrderResponse;
import com.havfun.service.message.SearchProductGroupRequest;
import com.havfun.service.message.SearchProductGroupResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.ClientMessage;
import com.havfun.service.message.data.OrderBaseMessage;
import com.havfun.service.message.data.OrderProductMessage;

/**
 * Servlet implementation class CreateOrder
 */
@WebServlet("/CreateOrder")
public class CreateOrder extends AbstractServlet{
	
	private static Logger LOGGER = LogManager.getLogger(CreateOrder.class.getSimpleName());		

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateOrder() {
    	
        super();
		
    }	
	
	protected void process( HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		Gson gson = new Gson();

		BufferedReader reader = request.getReader();
		CreateOrderRequest createOrderRequest = gson.fromJson(reader, CreateOrderRequest.class);
		CreateOrderResponse createOrderResponse = new CreateOrderResponse();
		
		LOGGER.info("CreateOrder createOrderRequest: "+ createOrderRequest );

		OrderBaseMessage orderMessage = new OrderBaseMessage();
		/*
		private List<OrderProductBase> orderProductList;
		
		private int paymentAddressIndex;
		
		private int billingAddressIndex;
		
		private int paymentMethodId;
		
		private int shippingMethodId;

		private BigDecimal weight;
		
		private BigDecimal total;
		*/
		
		BaseClient client = (BaseClient)request.getAttribute( LOGON_CLIENT );
		
		ClientMessage clientMessage = dataHelper.getClientMap().get( client.getClientId() );
		
		List<Address>  addressList = AddressConvertor.convertMessageToDataList( clientMessage.getAddressList() );
		
		Address billingAddress = addressList.get( createOrderRequest.getBillingAddressIndex() );
		Address shippingAddress = addressList.get( createOrderRequest.getPaymentAddressIndex() );
		
		orderMessage.setBillingFirstName( billingAddress.getFirstName() );
		orderMessage.setBillingLastName( billingAddress.getLastName() );
		orderMessage.setBillingAddress1( billingAddress.getAddress1() );
		orderMessage.setBillingAddress2( billingAddress.getAddress2() );
		orderMessage.setBillingCity( billingAddress.getCity() );
		orderMessage.setBillingTelephone( billingAddress.getPhoneNumber() );
		
		orderMessage.setShippingFirstName( shippingAddress.getFirstName() );
		orderMessage.setShippingLastName( shippingAddress.getLastName() );
		orderMessage.setShippingAddress1( shippingAddress.getAddress1() );
		orderMessage.setShippingAddress2( shippingAddress.getAddress2() );
		orderMessage.setShippingCity( shippingAddress.getCity() );
		orderMessage.setShippingTelephone( shippingAddress.getPhoneNumber() );
		
		orderMessage.setPaymentMethodId( createOrderRequest.getPaymentMethodId() );
		orderMessage.setShippingMethodId( createOrderRequest.getShippingMethodId() );
		orderMessage.setTotal( createOrderRequest.getTotal() );
		
		
		List<OrderProductMessage> orderProductList = new ArrayList<OrderProductMessage>();
		
		for ( OrderProductBase base : createOrderRequest.getOrderProductList() ){
			
			OrderProductMessage orderProductMessage = new OrderProductMessage();
			
			orderProductMessage.setProductId( base.getProductId() );
			orderProductMessage.setQuantity( base.getQuantity() );
			orderProductMessage.setPrice( base.getPrice() );
			
			orderProductList.add(orderProductMessage);
			
//			orderProductMessage.setTotal( base.get);
			/*
			private String name;
			
			private String model;
			
			private int quantity;
			
			private BigDecimal price;
			
			private BigDecimal total;
			*/
			
		}
		
		orderMessage.setOrderProductList(orderProductList);
		
		com.havfun.service.message.CreateOrderRequest createRequest = new com.havfun.service.message.CreateOrderRequest();

		createRequest.setClientId( client.getClientId() );
		createRequest.setToken( client.getToken() );
		createRequest.setOrderMessage(orderMessage);
		
		LOGGER.info("CreateOrder:: process:: createRequest: " +  createRequest );
		com.havfun.service.message.CreateOrderResponse createResponse = ClientServiceHelper.getInstance().getClientService().invoke( createRequest );
		LOGGER.info("CreateOrder:: process:: createResponse: "+ createResponse );

		
		if ( createResponse != null  ){
			createOrderResponse.setOrderId( createResponse.getOrderId() );
			createOrderResponse.setResult( createResponse.getResult() );
		}else{
			
			createOrderResponse.setResult( ErrorCode.INTERNAL_ERROR );
			
		}
		
		String json = gson.toJson( createOrderResponse );
		LOGGER.info("CreateOrder json: "+ json );
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}
	
	protected boolean isAuthenticationRequired(){
		return true;
	}
	
}