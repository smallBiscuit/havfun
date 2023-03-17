package com.havfun.service;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.havfun.service.config.HavfunServiceConfig;
import com.havfun.service.handler.RequestHandler;
import com.havfun.service.message.AbstractRequest;
import com.havfun.service.message.AbstractResponse;
import com.havfun.service.message.CreateClientProductRequest;
import com.havfun.service.message.CreateClientProductResponse;
import com.havfun.service.message.CreateClientRequest;
import com.havfun.service.message.CreateClientResponse;
import com.havfun.service.message.CreateOrderRequest;
import com.havfun.service.message.CreateOrderResponse;
import com.havfun.service.message.EnquireClientAddressesRequest;
import com.havfun.service.message.EnquireClientAddressesResponse;
import com.havfun.service.message.EnquireOrderRequest;
import com.havfun.service.message.EnquireOrderResponse;
import com.havfun.service.message.EnquireProductRequest;
import com.havfun.service.message.EnquireProductResponse;
import com.havfun.service.message.EnquireSystemDataRequest;
import com.havfun.service.message.EnquireSystemDataResponse;
import com.havfun.service.message.LoginRequest;
import com.havfun.service.message.LoginResponse;
import com.havfun.service.message.SearchMaterialRequest;
import com.havfun.service.message.SearchMaterialResponse;
import com.havfun.service.message.SearchOrderRequest;
import com.havfun.service.message.SearchOrderResponse;
import com.havfun.service.message.SearchProductGroupRequest;
import com.havfun.service.message.SearchProductGroupResponse;
import com.havfun.service.message.SearchProductRequest;
import com.havfun.service.message.SearchProductResponse;
import com.havfun.service.message.UpdateClientAddressRequest;
import com.havfun.service.message.UpdateClientAddressResponse;
import com.havfun.service.message.UpdateClientRequest;
import com.havfun.service.message.UpdateClientResponse;
import com.havfun.service.message.UpdateOrderRequest;
import com.havfun.service.message.UpdateOrderResponse;
import com.havfun.service.message.admin.AdminChangePasscodeRequest;
import com.havfun.service.message.admin.AdminChangePasscodeResponse;
import com.havfun.service.message.admin.AdminGeneratePasscodeRequest;
import com.havfun.service.message.admin.AdminGeneratePasscodeResponse;
import com.havfun.service.message.admin.AdminGetPasscodeRequest;
import com.havfun.service.message.admin.AdminGetPasscodeResponse;
import com.havfun.service.message.admin.AdminLoginRequest;
import com.havfun.service.message.admin.AdminLoginResponse;
import com.havfun.service.message.admin.AdminLogoutRequest;
import com.havfun.service.message.admin.AdminLogoutResponse;
import com.havfun.service.message.admin.AdminResetPasscodeRequest;
import com.havfun.service.message.admin.AdminResetPasscodeResponse;
import com.havfun.service.message.admin.client.AdminCreateClientRequest;
import com.havfun.service.message.admin.client.AdminCreateClientResponse;
import com.havfun.service.message.admin.client.AdminEnquireClientRequest;
import com.havfun.service.message.admin.client.AdminEnquireClientResponse;
import com.havfun.service.message.admin.client.AdminSearchClientRequest;
import com.havfun.service.message.admin.client.AdminSearchClientResponse;
import com.havfun.service.message.admin.client.AdminUpdateClientRequest;
import com.havfun.service.message.admin.client.AdminUpdateClientResponse;
import com.havfun.service.message.admin.order.AdminCreateOrderRequest;
import com.havfun.service.message.admin.order.AdminCreateOrderResponse;
import com.havfun.service.message.admin.order.AdminEnquireOrderRequest;
import com.havfun.service.message.admin.order.AdminEnquireOrderResponse;
import com.havfun.service.message.admin.order.AdminSearchOrderRequest;
import com.havfun.service.message.admin.order.AdminSearchOrderResponse;
import com.havfun.service.message.admin.order.AdminUpdateOrderRequest;
import com.havfun.service.message.admin.order.AdminUpdateOrderResponse;
import com.havfun.service.message.admin.productgroup.AdminCreateProductGroupRequest;
import com.havfun.service.message.admin.productgroup.AdminCreateProductGroupResponse;
import com.havfun.service.message.admin.productgroup.AdminEnquireProductGroupRequest;
import com.havfun.service.message.admin.productgroup.AdminEnquireProductGroupResponse;
import com.havfun.service.message.admin.productgroup.AdminSearchProductGroupRequest;
import com.havfun.service.message.admin.productgroup.AdminSearchProductGroupResponse;
import com.havfun.service.message.admin.productgroup.AdminUpdateProductGroupRequest;
import com.havfun.service.message.admin.productgroup.AdminUpdateProductGroupResponse;
import com.havfun.service.message.admin.product.AdminCreateProductRequest;
import com.havfun.service.message.admin.product.AdminCreateProductResponse;
import com.havfun.service.message.admin.product.AdminEnquireProductRequest;
import com.havfun.service.message.admin.product.AdminEnquireProductResponse;
import com.havfun.service.message.admin.product.AdminSearchProductRequest;
import com.havfun.service.message.admin.product.AdminSearchProductResponse;
import com.havfun.service.message.admin.product.AdminUpdateProductRequest;
import com.havfun.service.message.admin.product.AdminUpdateProductResponse;
import com.havfun.service.message.admin.materialgroup.AdminCreateMaterialGroupRequest;
import com.havfun.service.message.admin.materialgroup.AdminCreateMaterialGroupResponse;
import com.havfun.service.message.admin.materialgroup.AdminEnquireMaterialGroupRequest;
import com.havfun.service.message.admin.materialgroup.AdminEnquireMaterialGroupResponse;
import com.havfun.service.message.admin.materialgroup.AdminSearchMaterialGroupRequest;
import com.havfun.service.message.admin.materialgroup.AdminSearchMaterialGroupResponse;
import com.havfun.service.message.admin.materialgroup.AdminUpdateMaterialGroupRequest;
import com.havfun.service.message.admin.materialgroup.AdminUpdateMaterialGroupResponse;
import com.havfun.service.message.admin.material.AdminCreateMaterialRequest;
import com.havfun.service.message.admin.material.AdminCreateMaterialResponse;
import com.havfun.service.message.admin.material.AdminEnquireMaterialRequest;
import com.havfun.service.message.admin.material.AdminEnquireMaterialResponse;
import com.havfun.service.message.admin.material.AdminSearchMaterialRequest;
import com.havfun.service.message.admin.material.AdminSearchMaterialResponse;
import com.havfun.service.message.admin.material.AdminUpdateMaterialRequest;
import com.havfun.service.message.admin.material.AdminUpdateMaterialResponse;
import com.havfun.service.message.admin.user.AdminCreateUserRequest;
import com.havfun.service.message.admin.user.AdminCreateUserResponse;
import com.havfun.service.message.admin.user.AdminEnquireUserRequest;
import com.havfun.service.message.admin.user.AdminEnquireUserResponse;
import com.havfun.service.message.admin.user.AdminSearchUserRequest;
import com.havfun.service.message.admin.user.AdminSearchUserResponse;
import com.havfun.service.message.admin.user.AdminUpdateUserRequest;
import com.havfun.service.message.admin.user.AdminUpdateUserResponse;

public class HavfunServiceImpl implements HavfunService, InitializingBean, ApplicationContextAware {
	
	/** logger */
	private final static Logger LOGGER = LogManager.getLogger(HavfunServiceImpl.class.getSimpleName());
	
	@Resource(name = "havfunService")
	private HavfunService service;
	
	@SuppressWarnings("rawtypes")
	@Resource(name = "havfunRequestEventHandlerMap")
	private Map<Integer, RequestHandler> requestHandlerMap;
	
	/** application context */
	private ApplicationContext applicationContext;
	
	@SuppressWarnings("unchecked")
	public AbstractResponse doHandle(AbstractRequest request) {
		 try {
			 LOGGER.debug("request: {}", request);
			 AbstractResponse response =  requestHandlerMap.get(request.getMessageId()).handle(request);
			 LOGGER.debug("response: {}", response);
			 return response;
		} catch (Exception e) {
			LOGGER.warn("doHandle(): Exception", e);
			
			AbstractResponse response = new AbstractResponse();
			
			return null;
		}
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	@SuppressWarnings("resource")
	public static void main(String [] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(HavfunServiceConfig.class);
		
		HavfunService serivce = context.getBean(HavfunService.class);
		/*
		EnquireCompanyRequest request = new EnquireCompanyRequest();
		
		request.setStockCode(1);
	
		serivce.invoke(request);
		*/
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		LOGGER.debug("requestHandlerMap = {}", requestHandlerMap);

	}
	
	@Override
	public EnquireSystemDataResponse invoke(EnquireSystemDataRequest request) {
		return (EnquireSystemDataResponse) doHandle(request);
	}
	
	@Override
	public AdminCreateUserResponse invoke(AdminCreateUserRequest request) {
		return (AdminCreateUserResponse) doHandle(request);
	}

	@Override
	public AdminUpdateUserResponse invoke(AdminUpdateUserRequest request) {
		return (AdminUpdateUserResponse) doHandle(request);
	}

	@Override
	public AdminEnquireUserResponse invoke(AdminEnquireUserRequest request) {
		return (AdminEnquireUserResponse) doHandle(request);
	}

	@Override
	public AdminSearchUserResponse invoke(AdminSearchUserRequest request) {
		return (AdminSearchUserResponse) doHandle(request);
	}
	

	@Override
	public AdminCreateClientResponse invoke(AdminCreateClientRequest request) {
		return (AdminCreateClientResponse) doHandle(request);
	}

	@Override
	public AdminUpdateClientResponse invoke(AdminUpdateClientRequest request) {
		return (AdminUpdateClientResponse) doHandle(request);
	}

	@Override
	public AdminEnquireClientResponse invoke(AdminEnquireClientRequest request) {
		return (AdminEnquireClientResponse) doHandle(request);
	}

	@Override
	public AdminSearchClientResponse invoke(AdminSearchClientRequest request) {
		return (AdminSearchClientResponse) doHandle(request);
	}
	

	@Override
	public AdminCreateProductGroupResponse invoke(AdminCreateProductGroupRequest request) {
		return (AdminCreateProductGroupResponse) doHandle(request);
	}

	@Override
	public AdminUpdateProductGroupResponse invoke(AdminUpdateProductGroupRequest request) {
		return (AdminUpdateProductGroupResponse) doHandle(request);
	}

	@Override
	public AdminEnquireProductGroupResponse invoke(AdminEnquireProductGroupRequest request) {
		return (AdminEnquireProductGroupResponse) doHandle(request);
	}

	@Override
	public AdminSearchProductGroupResponse invoke(AdminSearchProductGroupRequest request) {
		return (AdminSearchProductGroupResponse) doHandle(request);
	}

	@Override
	public AdminCreateProductResponse invoke(AdminCreateProductRequest request) {
		return (AdminCreateProductResponse) doHandle(request);
	}

	@Override
	public AdminUpdateProductResponse invoke(AdminUpdateProductRequest request) {
		return (AdminUpdateProductResponse) doHandle(request);
	}

	@Override
	public AdminEnquireProductResponse invoke(AdminEnquireProductRequest request) {
		return (AdminEnquireProductResponse) doHandle(request);
	}

	@Override
	public AdminSearchProductResponse invoke(AdminSearchProductRequest request) {
		return (AdminSearchProductResponse) doHandle(request);
	}
	
	@Override
	public AdminCreateMaterialGroupResponse invoke(AdminCreateMaterialGroupRequest request) {
		return (AdminCreateMaterialGroupResponse) doHandle(request);
	}

	@Override
	public AdminUpdateMaterialGroupResponse invoke(AdminUpdateMaterialGroupRequest request) {
		return (AdminUpdateMaterialGroupResponse) doHandle(request);
	}

	@Override
	public AdminEnquireMaterialGroupResponse invoke(AdminEnquireMaterialGroupRequest request) {
		return (AdminEnquireMaterialGroupResponse) doHandle(request);
	}

	@Override
	public AdminSearchMaterialGroupResponse invoke(AdminSearchMaterialGroupRequest request) {
		return (AdminSearchMaterialGroupResponse) doHandle(request);
	}

	@Override
	public AdminCreateMaterialResponse invoke(AdminCreateMaterialRequest request) {
		return (AdminCreateMaterialResponse) doHandle(request);
	}

	@Override
	public AdminUpdateMaterialResponse invoke(AdminUpdateMaterialRequest request) {
		return (AdminUpdateMaterialResponse) doHandle(request);
	}

	@Override
	public AdminEnquireMaterialResponse invoke(AdminEnquireMaterialRequest request) {
		return (AdminEnquireMaterialResponse) doHandle(request);
	}

	@Override
	public AdminSearchMaterialResponse invoke(AdminSearchMaterialRequest request) {
		return (AdminSearchMaterialResponse) doHandle(request);
	}
	
	@Override
	public AdminLoginResponse invoke(AdminLoginRequest request) {
		return (AdminLoginResponse) doHandle(request);
	}

	@Override
	public AdminLogoutResponse invoke(AdminLogoutRequest request) {
		return (AdminLogoutResponse) doHandle(request);
	}

	@Override
	public AdminChangePasscodeResponse invoke(AdminChangePasscodeRequest request) {
		return (AdminChangePasscodeResponse) doHandle(request);
	}

	@Override
	public AdminResetPasscodeResponse invoke(AdminResetPasscodeRequest request) {
		return (AdminResetPasscodeResponse) doHandle(request);
	}

	@Override
	public AdminGetPasscodeResponse invoke(AdminGetPasscodeRequest request) {
		return (AdminGetPasscodeResponse) doHandle(request);
	}

	@Override
	public AdminGeneratePasscodeResponse invoke(
			AdminGeneratePasscodeRequest request) {
		return (AdminGeneratePasscodeResponse) doHandle(request);
	}

	@Override
	public EnquireClientAddressesResponse invoke(EnquireClientAddressesRequest request) {
		return (EnquireClientAddressesResponse) doHandle(request);
	}

	@Override
	public UpdateClientAddressResponse invoke(UpdateClientAddressRequest request) {
		return (UpdateClientAddressResponse) doHandle(request);
	}

	@Override
	public CreateClientResponse invoke(CreateClientRequest request) {
		return (CreateClientResponse) doHandle(request);
	}
	
	@Override
	public UpdateClientResponse invoke(UpdateClientRequest request) {
		return (UpdateClientResponse) doHandle(request);
	}
	
	@Override
	public SearchProductGroupResponse invoke(SearchProductGroupRequest request) {
		return (SearchProductGroupResponse) doHandle(request);
	}

	@Override
	public SearchProductResponse invoke(SearchProductRequest request) {
		return (SearchProductResponse) doHandle(request);
	}
	
	@Override
	public EnquireProductResponse invoke(EnquireProductRequest request) {
		return (EnquireProductResponse) doHandle(request);
	}

	@Override
	public AdminCreateOrderResponse invoke(AdminCreateOrderRequest request) {
		return (AdminCreateOrderResponse) doHandle(request);
	}

	@Override
	public AdminUpdateOrderResponse invoke(AdminUpdateOrderRequest request) {
		return (AdminUpdateOrderResponse) doHandle(request);
	}

	@Override
	public AdminEnquireOrderResponse invoke(AdminEnquireOrderRequest request) {
		return (AdminEnquireOrderResponse) doHandle(request);
	}

	@Override
	public AdminSearchOrderResponse invoke(AdminSearchOrderRequest request) {
		return (AdminSearchOrderResponse) doHandle(request);
	}

	@Override
	public CreateOrderResponse invoke(CreateOrderRequest request) {
		return (CreateOrderResponse) doHandle(request);
	}

	@Override
	public UpdateOrderResponse invoke(UpdateOrderRequest request) {
		return (UpdateOrderResponse) doHandle(request);
	}

	@Override
	public EnquireOrderResponse invoke(EnquireOrderRequest request) {
		return (EnquireOrderResponse) doHandle(request);
	}

	@Override
	public SearchOrderResponse invoke(SearchOrderRequest request) {
		return (SearchOrderResponse) doHandle(request);
	}


	@Override
	public LoginResponse invoke(LoginRequest request) {
		return (LoginResponse) doHandle(request);
	}

	@Override
	public SearchMaterialResponse invoke(SearchMaterialRequest request) {
		return (SearchMaterialResponse) doHandle(request);
	}

	@Override
	public CreateClientProductResponse invoke(CreateClientProductRequest request) {
		return (CreateClientProductResponse) doHandle(request);
	}


}
