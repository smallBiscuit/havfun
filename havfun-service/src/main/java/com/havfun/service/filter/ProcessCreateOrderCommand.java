package com.havfun.service.filter;

import java.math.BigDecimal;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.havfun.service.base.HavfunException;
import com.havfun.service.convertor.OrderConvertor;
import com.havfun.service.dao.ClientDao;
import com.havfun.service.dao.OrderDao;
import com.havfun.service.dao.OrderProductDao;
import com.havfun.service.dao.ProductDao;
import com.havfun.service.dao.UserDao;
import com.havfun.service.entity.Client;
import com.havfun.service.entity.Order;
import com.havfun.service.entity.OrderProduct;
import com.havfun.service.entity.Product;
import com.havfun.service.entity.User;
import com.havfun.service.entity.constant.OrderStatus;
import com.havfun.service.entity.constant.UserGroup;
import com.havfun.service.entity.constant.UserStatus;
import com.havfun.service.handler.AbstractHkListCoEventHandler;
import com.havfun.service.message.CreateOrderRequest;
import com.havfun.service.message.CreateOrderResponse;
import com.havfun.service.message.constant.ErrorCode;
import com.havfun.service.message.data.OrderBaseMessage;
import com.havfun.service.message.data.OrderMessage;
import com.havfun.service.message.data.OrderProductMessage;

public class ProcessCreateOrderCommand implements Command {
	
	/** logger */
	private static final Logger LOGGER = LogManager.getLogger(ProcessCreateOrderCommand.class.getSimpleName());
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	private OrderProductDao orderProductDao;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(value = "havfunTxnManager", propagation = Propagation.REQUIRED)
	public boolean execute(Context context) throws Exception {
		
		CreateOrderRequest request = (CreateOrderRequest) context.get(AbstractHkListCoEventHandler.REQUEST);
		
		if (request == null) {
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "request is null");
		}
		
		if ( request.getOrderMessage() == null ){
		
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "orderMessage is null");
			
		}
		
		OrderBaseMessage orderBaseMessage = request.getOrderMessage();
		
		OrderMessage orderMessage = new OrderMessage();

		User user = new User();
		
		user.setUserGroup( UserGroup.ADMIN );
		user.setUserName( "rayTest" );
		user.setPasscode( "abcd" );
		user.setFirstName( "Ray");
		user.setLastName( "Cheng");
		user.setEmail("abc@gmail.com");
		user.setStatus(UserStatus.ACTIVE );
		
		Integer userId = userDao.create(user);
		
		Client client = clientDao.read( request.getClientId() );
		
		LOGGER.info("orderBaseMessage: " + orderBaseMessage );

		orderMessage.setClientId( client.getClientId() );
		orderMessage.setClientGroup( client.getClientGroup() );
		orderMessage.setFirstName( client.getFirstName() );
		orderMessage.setLastName( client.getLastName() );
		orderMessage.setEmail( client.getEmail() );
		orderMessage.setTelephone( client.getTelephone() );
		orderMessage.setFax( client.getFax() );
		
		
		orderMessage.setBillingFirstName( orderBaseMessage.getBillingFirstName() );
		orderMessage.setBillingLastName( orderBaseMessage.getBillingLastName() );
		orderMessage.setBillingAddress1( orderBaseMessage.getBillingAddress1() );
		orderMessage.setBillingAddress2( orderBaseMessage.getBillingAddress2() );
		orderMessage.setBillingCity( orderBaseMessage.getBillingCity() );
		orderMessage.setBillingPostcode( orderBaseMessage.getBillingPostcode() );		
		orderMessage.setBillingCountryId( orderBaseMessage.getBillingCountryId() );
		orderMessage.setBillingTelephone( orderBaseMessage.getBillingTelephone() );
		
		orderMessage.setShippingFirstName( orderBaseMessage.getShippingFirstName() );
		orderMessage.setShippingLastName( orderBaseMessage.getShippingLastName() );
		orderMessage.setShippingAddress1( orderBaseMessage.getShippingAddress1() );
		orderMessage.setShippingAddress2( orderBaseMessage.getShippingAddress2() );
		orderMessage.setShippingCity( orderBaseMessage.getShippingCity() );
		orderMessage.setShippingPostcode( orderBaseMessage.getShippingPostcode() );		
		orderMessage.setShippingTelephone( orderBaseMessage.getShippingTelephone() );
		
		orderMessage.setPaymentMethodId( orderBaseMessage.getPaymentMethodId() );
		orderMessage.setShippingMethodId( orderBaseMessage.getShippingMethodId() );
		
		orderMessage.setTotal( orderBaseMessage.getTotal() );
		
		orderMessage.setCurrencyCode( "HKD" );
		orderMessage.setCurrencyId( 1 );
		orderMessage.setCurrencyValue( new BigDecimal(1) );
		
		orderMessage.setStatus( OrderStatus.PENDING );
		
		
		LOGGER.info("orderMessage: " + orderMessage );
		
		Order order = OrderConvertor.convertToEntity(orderMessage);
		
		LOGGER.info("order: " + order );
		
		int orderId = orderDao.create( order );
		
		if ( orderId <= 0 ){
			
			throw new HavfunException(ErrorCode.FAIL_TO_PROCESS, "create order fail");
			
		}
		
		for ( OrderProductMessage orderProductMessage : orderBaseMessage.getOrderProductList() ){
			
			Product product = productDao.read( orderProductMessage.getProductId() );
			
			OrderProduct orderProduct = new OrderProduct();
			
			orderProduct.setOrderId(orderId);
			orderProduct.setProductId( orderProductMessage.getProductId() );
			orderProduct.setQuantity( orderProductMessage.getQuantity() );
			orderProduct.setName( product.getNameEn() );
			orderProduct.setModel( product.getModel() );
			orderProduct.setPrice( orderProductMessage.getPrice() );
			orderProduct.setTotal( orderProductMessage.getPrice() );
			orderProduct.setTax( BigDecimal.ZERO );
			orderProduct.setReward( 0 );
			
			orderProductDao.create(orderProduct);
			
		}
		
		
		CreateOrderResponse response = new CreateOrderResponse();
		
		response.setOrderId( orderId );
		response.setResult(ErrorCode.NO_ERROR);
		
		context.put(AbstractHkListCoEventHandler.RESPONSE, response);
		
		return false;
	}
	
}
