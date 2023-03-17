package com.havfun.service.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.havfun.service.filter.ProcessCreateClientCommand;
import com.havfun.service.filter.ProcessCreateClientProductCommand;
import com.havfun.service.filter.ProcessCreateOrderCommand;
import com.havfun.service.filter.ProcessEnquireClientAddressesCommand;
import com.havfun.service.filter.ProcessEnquireOrderCommand;
import com.havfun.service.filter.ProcessEnquireProductCommand;
import com.havfun.service.filter.ProcessEnquireSystemDataCommand;
import com.havfun.service.filter.ProcessLoginCommand;
import com.havfun.service.filter.ProcessSearchMaterialCommand;
import com.havfun.service.filter.ProcessSearchOrderCommand;
import com.havfun.service.filter.ProcessSearchProductCommand;
import com.havfun.service.filter.ProcessSearchProductGroupCommand;
import com.havfun.service.filter.ProcessUpdateClientAddressCommand;
import com.havfun.service.filter.ProcessUpdateClientCommand;
import com.havfun.service.filter.ProcessUpdateOrderCommand;
import com.havfun.service.filter.admin.ProcessAdminChangePasscodeCommand;
import com.havfun.service.filter.admin.ProcessAdminLoginFilter;
import com.havfun.service.filter.admin.ProcessAdminLogoutCommand;
import com.havfun.service.filter.admin.ProcessAdminResetPasscodeFilter;
import com.havfun.service.filter.admin.ProcessAdminCreateUserCommand;
import com.havfun.service.filter.admin.ProcessAdminEnquireUserCommand;
import com.havfun.service.filter.admin.ProcessAdminSearchUserCommand;
import com.havfun.service.filter.admin.ProcessAdminUpdateUserCommand;
import com.havfun.service.filter.admin.ProcessAdminCreateClientCommand;
import com.havfun.service.filter.admin.ProcessAdminEnquireClientCommand;
import com.havfun.service.filter.admin.ProcessAdminSearchClientCommand;
import com.havfun.service.filter.admin.ProcessAdminUpdateClientCommand;
import com.havfun.service.filter.admin.ProcessAdminCreateProductGroupCommand;
import com.havfun.service.filter.admin.ProcessAdminEnquireProductGroupCommand;
import com.havfun.service.filter.admin.ProcessAdminSearchProductGroupCommand;
import com.havfun.service.filter.admin.ProcessAdminUpdateProductGroupCommand;
import com.havfun.service.filter.admin.ProcessAdminCreateProductCommand;
import com.havfun.service.filter.admin.ProcessAdminEnquireProductCommand;
import com.havfun.service.filter.admin.ProcessAdminSearchProductCommand;
import com.havfun.service.filter.admin.ProcessAdminUpdateProductCommand;
import com.havfun.service.filter.admin.ProcessAdminCreateOrderCommand;
import com.havfun.service.filter.admin.ProcessAdminEnquireOrderCommand;
import com.havfun.service.filter.admin.ProcessAdminSearchOrderCommand;
import com.havfun.service.filter.admin.ProcessAdminUpdateOrderCommand;
import com.havfun.service.filter.admin.ProcessAdminCreateMaterialGroupCommand;
import com.havfun.service.filter.admin.ProcessAdminEnquireMaterialGroupCommand;
import com.havfun.service.filter.admin.ProcessAdminSearchMaterialGroupCommand;
import com.havfun.service.filter.admin.ProcessAdminUpdateMaterialGroupCommand;
import com.havfun.service.filter.admin.ProcessAdminCreateMaterialCommand;
import com.havfun.service.filter.admin.ProcessAdminEnquireMaterialCommand;
import com.havfun.service.filter.admin.ProcessAdminSearchMaterialCommand;
import com.havfun.service.filter.admin.ProcessAdminUpdateMaterialCommand;
import com.havfun.service.filter.admin.UserTokenAuthenticationFilter;
import com.havfun.service.handler.CreateClientHandler;
import com.havfun.service.handler.CreateClientProductHandler;
import com.havfun.service.handler.CreateOrderHandler;
import com.havfun.service.handler.EnquireClientAddressesHandler;
import com.havfun.service.handler.EnquireOrderHandler;
import com.havfun.service.handler.EnquireProductHandler;
import com.havfun.service.handler.EnquireSystemDataHandler;
import com.havfun.service.handler.LoginHandler;
import com.havfun.service.handler.RequestHandler;
import com.havfun.service.handler.SearchMaterialHandler;
import com.havfun.service.handler.SearchOrderHandler;
import com.havfun.service.handler.SearchProductGroupHandler;
import com.havfun.service.handler.SearchProductHandler;
import com.havfun.service.handler.UpdateClientAddressHandler;
import com.havfun.service.handler.UpdateClientHandler;
import com.havfun.service.handler.UpdateOrderHandler;
import com.havfun.service.handler.admin.AdminChangePasscodeHandler;
import com.havfun.service.handler.admin.AdminLoginHandler;
import com.havfun.service.handler.admin.AdminLogoutHandler;
import com.havfun.service.handler.admin.AdminResetPasscodeHandler;
import com.havfun.service.handler.admin.AdminCreateUserHandler;
import com.havfun.service.handler.admin.AdminEnquireUserHandler;
import com.havfun.service.handler.admin.AdminSearchUserHandler;
import com.havfun.service.handler.admin.AdminUpdateUserHandler;
import com.havfun.service.handler.admin.AdminCreateClientHandler;
import com.havfun.service.handler.admin.AdminEnquireClientHandler;
import com.havfun.service.handler.admin.AdminSearchClientHandler;
import com.havfun.service.handler.admin.AdminUpdateClientHandler;
import com.havfun.service.handler.admin.AdminCreateProductGroupHandler;
import com.havfun.service.handler.admin.AdminEnquireProductGroupHandler;
import com.havfun.service.handler.admin.AdminSearchProductGroupHandler;
import com.havfun.service.handler.admin.AdminUpdateProductGroupHandler;
import com.havfun.service.handler.admin.AdminCreateProductHandler;
import com.havfun.service.handler.admin.AdminEnquireProductHandler;
import com.havfun.service.handler.admin.AdminSearchProductHandler;
import com.havfun.service.handler.admin.AdminUpdateProductHandler;
import com.havfun.service.handler.admin.AdminCreateOrderHandler;
import com.havfun.service.handler.admin.AdminEnquireOrderHandler;
import com.havfun.service.handler.admin.AdminSearchOrderHandler;
import com.havfun.service.handler.admin.AdminUpdateOrderHandler;
import com.havfun.service.handler.admin.AdminCreateMaterialGroupHandler;
import com.havfun.service.handler.admin.AdminEnquireMaterialGroupHandler;
import com.havfun.service.handler.admin.AdminSearchMaterialGroupHandler;
import com.havfun.service.handler.admin.AdminUpdateMaterialGroupHandler;
import com.havfun.service.handler.admin.AdminCreateMaterialHandler;
import com.havfun.service.handler.admin.AdminEnquireMaterialHandler;
import com.havfun.service.handler.admin.AdminSearchMaterialHandler;
import com.havfun.service.handler.admin.AdminUpdateMaterialHandler;
import com.havfun.service.message.constant.MessageId;

@Configuration
public class HavfunServiceEventConfig {
	
	@SuppressWarnings("rawtypes")
	@Bean(name = "havfunRequestEventHandlerMap")
	public Map<Integer, RequestHandler> havfunRequestEventHandlerMap() {
		Map<Integer, RequestHandler> eventHandlerMap = new ConcurrentHashMap<Integer, RequestHandler>();
		
		eventHandlerMap.put(MessageId.ENQUIRE_SYSTEM_DATA_REQUEST, enquireSystemDataHandler());		
		
		eventHandlerMap.put(MessageId.ADMIN_LOGIN_REQUEST, adminLoginHandler());		
		
		eventHandlerMap.put(MessageId.ADMIN_CREATE_USER_REQUEST, adminCreateUserHandler());
		eventHandlerMap.put(MessageId.ADMIN_UPDATE_USER_REQUEST, adminUpdateUserHandler());
		eventHandlerMap.put(MessageId.ADMIN_ENQUIRE_USER_REQUEST, adminEnquireUserHandler());
		eventHandlerMap.put(MessageId.ADMIN_SEARCH_USER_REQUEST, adminSearchUserHandler());
		eventHandlerMap.put(MessageId.ADMIN_CREATE_CLIENT_REQUEST, adminCreateClientHandler());
		eventHandlerMap.put(MessageId.ADMIN_UPDATE_CLIENT_REQUEST, adminUpdateClientHandler());
		eventHandlerMap.put(MessageId.ADMIN_ENQUIRE_CLIENT_REQUEST, adminEnquireClientHandler());
		eventHandlerMap.put(MessageId.ADMIN_SEARCH_CLIENT_REQUEST, adminSearchClientHandler());
		
		eventHandlerMap.put(MessageId.ADMIN_CREATE_PRODUCT_GROUP_REQUEST, adminCreateProductGroupHandler());
		eventHandlerMap.put(MessageId.ADMIN_UPDATE_PRODUCT_GROUP_REQUEST, adminUpdateProductGroupHandler());
		eventHandlerMap.put(MessageId.ADMIN_ENQUIRE_PRODUCT_GROUP_REQUEST, adminEnquireProductGroupHandler());
		eventHandlerMap.put(MessageId.ADMIN_SEARCH_PRODUCT_GROUP_REQUEST, adminSearchProductGroupHandler());
		
		eventHandlerMap.put(MessageId.ADMIN_CREATE_PRODUCT_REQUEST, adminCreateProductHandler());
		eventHandlerMap.put(MessageId.ADMIN_UPDATE_PRODUCT_REQUEST, adminUpdateProductHandler());
		eventHandlerMap.put(MessageId.ADMIN_ENQUIRE_PRODUCT_REQUEST, adminEnquireProductHandler());
		eventHandlerMap.put(MessageId.ADMIN_SEARCH_PRODUCT_REQUEST, adminSearchProductHandler());
		
		eventHandlerMap.put(MessageId.ADMIN_CREATE_ORDER_REQUEST, adminCreateOrderHandler());
		eventHandlerMap.put(MessageId.ADMIN_UPDATE_ORDER_REQUEST, adminUpdateOrderHandler());
		eventHandlerMap.put(MessageId.ADMIN_ENQUIRE_ORDER_REQUEST, adminEnquireOrderHandler());
		eventHandlerMap.put(MessageId.ADMIN_SEARCH_ORDER_REQUEST, adminSearchOrderHandler());

		eventHandlerMap.put(MessageId.ADMIN_CREATE_MATERIAL_GROUP_REQUEST, adminCreateMaterialGroupHandler());
		eventHandlerMap.put(MessageId.ADMIN_UPDATE_MATERIAL_GROUP_REQUEST, adminUpdateMaterialGroupHandler());
		eventHandlerMap.put(MessageId.ADMIN_ENQUIRE_MATERIAL_GROUP_REQUEST, adminEnquireMaterialGroupHandler());
		eventHandlerMap.put(MessageId.ADMIN_SEARCH_MATERIAL_GROUP_REQUEST, adminSearchMaterialGroupHandler());
		
		eventHandlerMap.put(MessageId.ADMIN_CREATE_MATERIAL_REQUEST, adminCreateMaterialHandler());
		eventHandlerMap.put(MessageId.ADMIN_UPDATE_MATERIAL_REQUEST, adminUpdateMaterialHandler());
		eventHandlerMap.put(MessageId.ADMIN_ENQUIRE_MATERIAL_REQUEST, adminEnquireMaterialHandler());
		eventHandlerMap.put(MessageId.ADMIN_SEARCH_MATERIAL_REQUEST, adminSearchMaterialHandler());
		
		eventHandlerMap.put(MessageId.ADMIN_LOGOUT_REQUEST, adminLogoutHandler());
		eventHandlerMap.put(MessageId.ADMIN_CHANGE_PASSCODE_REQUEST, adminChangePasscodeHandler());
		eventHandlerMap.put(MessageId.ADMIN_RESET_PASSCODE_REQUEST, adminResetPasscodeHandler());
		
		eventHandlerMap.put(MessageId.LOGIN_REQUEST, loginHandler());
		eventHandlerMap.put(MessageId.CREATE_CLIENT_REQUEST, createClientHandler());
		eventHandlerMap.put(MessageId.UPDATE_CLIENT_REQUEST, updateClientHandler());
		eventHandlerMap.put(MessageId.ENQUIRE_CLIENT_ADDRESSES_REQUEST, enquireClientAddressesHandler());
		eventHandlerMap.put(MessageId.UPDATE_CLIENT_ADDRESS_REQUEST, updateClientAddressHandler());
		eventHandlerMap.put(MessageId.SEARCH_PRODUCT_GROUP_REQUEST, searchProductGroupHandler());
		eventHandlerMap.put(MessageId.SEARCH_PRODUCT_REQUEST, searchProductHandler());
		eventHandlerMap.put(MessageId.ENQUIRE_PRODUCT_REQUEST, enquireProductHandler());

		eventHandlerMap.put(MessageId.CREATE_ORDER_REQUEST, createOrderHandler());
		eventHandlerMap.put(MessageId.UPDATE_ORDER_REQUEST, updateOrderHandler());
		eventHandlerMap.put(MessageId.ENQUIRE_ORDER_REQUEST, enquireOrderHandler());
		eventHandlerMap.put(MessageId.SEARCH_ORDER_REQUEST, searchOrderHandler());
		
		eventHandlerMap.put(MessageId.SEARCH_MATERIAL_REQUEST, searchMaterialHandler());
		eventHandlerMap.put(MessageId.CREATE_CLIENT_PRODUCT_REQUEST, createClientProductHandler());
		
		return eventHandlerMap;
	}

	@Bean
	public UserTokenAuthenticationFilter userTokenAuthenticationFilter() {
		return new UserTokenAuthenticationFilter();
	}
	
	//////////////////////////////////////////////////////////////////////////

	@Bean
	public EnquireSystemDataHandler enquireSystemDataHandler() {
		EnquireSystemDataHandler enquireSystemDataHandler = new EnquireSystemDataHandler();
		
		enquireSystemDataHandler.addCommand(processEnquireSystemDataCommand());
		
		return enquireSystemDataHandler;
	}
	
	@Bean
	public ProcessEnquireSystemDataCommand processEnquireSystemDataCommand() {
		return new ProcessEnquireSystemDataCommand();
	}
	
	@Bean
	public AdminCreateUserHandler adminCreateUserHandler() {
		AdminCreateUserHandler adminCreateUserHandler = new AdminCreateUserHandler();
		
		adminCreateUserHandler.addCommand(userTokenAuthenticationFilter());
		adminCreateUserHandler.addCommand(processAdminCreateUserCommand());
		
		return adminCreateUserHandler;
	}
	
	@Bean
	public ProcessAdminCreateUserCommand processAdminCreateUserCommand() {
		return new ProcessAdminCreateUserCommand();
	}
	
	@Bean
	public AdminUpdateUserHandler adminUpdateUserHandler() {
		AdminUpdateUserHandler adminUpdateUserHandler = new AdminUpdateUserHandler();
		
		adminUpdateUserHandler.addCommand(userTokenAuthenticationFilter());
		adminUpdateUserHandler.addCommand(processAdminUpdateUserCommand());
		
		return adminUpdateUserHandler;
	}
	
	@Bean
	public ProcessAdminUpdateUserCommand processAdminUpdateUserCommand() {
		return new ProcessAdminUpdateUserCommand();
	}
	
	@Bean
	public AdminEnquireUserHandler adminEnquireUserHandler() {
		AdminEnquireUserHandler adminEnquireUserHandler = new AdminEnquireUserHandler();
		
		adminEnquireUserHandler.addCommand(userTokenAuthenticationFilter());
		adminEnquireUserHandler.addCommand(processAdminEnquireUserCommand());
		
		return adminEnquireUserHandler;
	}
	
	@Bean
	public ProcessAdminEnquireUserCommand processAdminEnquireUserCommand() {
		return new ProcessAdminEnquireUserCommand();
	}
	
	@Bean
	public AdminSearchUserHandler adminSearchUserHandler() {
		AdminSearchUserHandler adminSearchUserHandler = new AdminSearchUserHandler();
		
		adminSearchUserHandler.addCommand(userTokenAuthenticationFilter());
		adminSearchUserHandler.addCommand(processAdminSearchUserCommand());
		
		return adminSearchUserHandler;
	}
	
	@Bean
	public ProcessAdminSearchUserCommand processAdminSearchUserCommand() {
		return new ProcessAdminSearchUserCommand();
	}
	
	

	@Bean
	public AdminCreateClientHandler adminCreateClientHandler() {
		AdminCreateClientHandler adminCreateClientHandler = new AdminCreateClientHandler();
		
		adminCreateClientHandler.addCommand(userTokenAuthenticationFilter());
		adminCreateClientHandler.addCommand(processAdminCreateClientCommand());
		
		return adminCreateClientHandler;
	}
		
	@Bean
	public ProcessAdminCreateClientCommand processAdminCreateClientCommand() {
		return new ProcessAdminCreateClientCommand();
	}
	
	@Bean
	public AdminUpdateClientHandler adminUpdateClientHandler() {
		AdminUpdateClientHandler adminUpdateClientHandler = new AdminUpdateClientHandler();
		
		adminUpdateClientHandler.addCommand(userTokenAuthenticationFilter());
		adminUpdateClientHandler.addCommand(processAdminUpdateClientCommand());
		
		return adminUpdateClientHandler;
	}
	
	@Bean
	public ProcessAdminUpdateClientCommand processAdminUpdateClientCommand() {
		return new ProcessAdminUpdateClientCommand();
	}
	
	@Bean
	public AdminEnquireClientHandler adminEnquireClientHandler() {
		AdminEnquireClientHandler adminEnquireClientHandler = new AdminEnquireClientHandler();
		
		adminEnquireClientHandler.addCommand(userTokenAuthenticationFilter());
		adminEnquireClientHandler.addCommand(processAdminEnquireClientCommand());
		
		return adminEnquireClientHandler;
	}
	
	@Bean
	public ProcessAdminEnquireClientCommand processAdminEnquireClientCommand() {
		return new ProcessAdminEnquireClientCommand();
	}
	
	@Bean
	public AdminSearchClientHandler adminSearchClientHandler() {
		AdminSearchClientHandler adminSearchClientHandler = new AdminSearchClientHandler();
		
		adminSearchClientHandler.addCommand(userTokenAuthenticationFilter());
		adminSearchClientHandler.addCommand(processAdminSearchClientCommand());
		
		return adminSearchClientHandler;
	}
	
	@Bean
	public ProcessAdminSearchClientCommand processAdminSearchClientCommand() {
		return new ProcessAdminSearchClientCommand();
	}
	
	
	@Bean
	public AdminCreateProductGroupHandler adminCreateProductGroupHandler() {
		AdminCreateProductGroupHandler adminCreateProductGroupHandler = new AdminCreateProductGroupHandler();
		
		adminCreateProductGroupHandler.addCommand(userTokenAuthenticationFilter());
		adminCreateProductGroupHandler.addCommand(processAdminCreateProductGroupCommand());
		
		return adminCreateProductGroupHandler;
	}
		
	@Bean
	public ProcessAdminCreateProductGroupCommand processAdminCreateProductGroupCommand() {
		return new ProcessAdminCreateProductGroupCommand();
	}
	
	@Bean
	public AdminUpdateProductGroupHandler adminUpdateProductGroupHandler() {
		AdminUpdateProductGroupHandler adminUpdateProductGroupHandler = new AdminUpdateProductGroupHandler();
		
		adminUpdateProductGroupHandler.addCommand(userTokenAuthenticationFilter());
		adminUpdateProductGroupHandler.addCommand(processAdminUpdateProductGroupCommand());
		
		return adminUpdateProductGroupHandler;
	}
	
	@Bean
	public ProcessAdminUpdateProductGroupCommand processAdminUpdateProductGroupCommand() {
		return new ProcessAdminUpdateProductGroupCommand();
	}
	
	@Bean
	public AdminEnquireProductGroupHandler adminEnquireProductGroupHandler() {
		AdminEnquireProductGroupHandler adminEnquireProductGroupHandler = new AdminEnquireProductGroupHandler();
		
		adminEnquireProductGroupHandler.addCommand(userTokenAuthenticationFilter());
		adminEnquireProductGroupHandler.addCommand(processAdminEnquireProductGroupCommand());
		
		return adminEnquireProductGroupHandler;
	}
	
	@Bean
	public ProcessAdminEnquireProductGroupCommand processAdminEnquireProductGroupCommand() {
		return new ProcessAdminEnquireProductGroupCommand();
	}
	
	@Bean
	public AdminSearchProductGroupHandler adminSearchProductGroupHandler() {
		AdminSearchProductGroupHandler adminSearchProductGroupHandler = new AdminSearchProductGroupHandler();
		
		adminSearchProductGroupHandler.addCommand(userTokenAuthenticationFilter());
		adminSearchProductGroupHandler.addCommand(processAdminSearchProductGroupCommand());
		
		return adminSearchProductGroupHandler;
	}
	
	@Bean
	public ProcessAdminSearchProductGroupCommand processAdminSearchProductGroupCommand() {
		return new ProcessAdminSearchProductGroupCommand();
	}
	
	
	
	@Bean
	public AdminCreateProductHandler adminCreateProductHandler() {
		AdminCreateProductHandler adminCreateProductHandler = new AdminCreateProductHandler();
		
		adminCreateProductHandler.addCommand(userTokenAuthenticationFilter());
		adminCreateProductHandler.addCommand(processAdminCreateProductCommand());
		
		return adminCreateProductHandler;
	}
		
	@Bean
	public ProcessAdminCreateProductCommand processAdminCreateProductCommand() {
		return new ProcessAdminCreateProductCommand();
	}
	
	@Bean
	public AdminUpdateProductHandler adminUpdateProductHandler() {
		AdminUpdateProductHandler adminUpdateProductHandler = new AdminUpdateProductHandler();
		
		adminUpdateProductHandler.addCommand(userTokenAuthenticationFilter());
		adminUpdateProductHandler.addCommand(processAdminUpdateProductCommand());
		
		return adminUpdateProductHandler;
	}
	
	@Bean
	public ProcessAdminUpdateProductCommand processAdminUpdateProductCommand() {
		return new ProcessAdminUpdateProductCommand();
	}
	
	@Bean
	public AdminEnquireProductHandler adminEnquireProductHandler() {
		AdminEnquireProductHandler adminEnquireProductHandler = new AdminEnquireProductHandler();
		
		adminEnquireProductHandler.addCommand(userTokenAuthenticationFilter());
		adminEnquireProductHandler.addCommand(processAdminEnquireProductCommand());
		
		return adminEnquireProductHandler;
	}
	
	@Bean
	public ProcessAdminEnquireProductCommand processAdminEnquireProductCommand() {
		return new ProcessAdminEnquireProductCommand();
	}
	
	@Bean
	public AdminSearchProductHandler adminSearchProductHandler() {
		AdminSearchProductHandler adminSearchProductHandler = new AdminSearchProductHandler();
		
		adminSearchProductHandler.addCommand(userTokenAuthenticationFilter());
		adminSearchProductHandler.addCommand(processAdminSearchProductCommand());
		
		return adminSearchProductHandler;
	}
	
	@Bean
	public ProcessAdminSearchProductCommand processAdminSearchProductCommand() {
		return new ProcessAdminSearchProductCommand();
	}
	
	@Bean
	public AdminCreateOrderHandler adminCreateOrderHandler() {
		AdminCreateOrderHandler adminCreateOrderHandler = new AdminCreateOrderHandler();
		
		adminCreateOrderHandler.addCommand(userTokenAuthenticationFilter());
		adminCreateOrderHandler.addCommand(processAdminCreateOrderCommand());
		
		return adminCreateOrderHandler;
	}
		
	@Bean
	public ProcessAdminCreateOrderCommand processAdminCreateOrderCommand() {
		return new ProcessAdminCreateOrderCommand();
	}
	
	@Bean
	public AdminUpdateOrderHandler adminUpdateOrderHandler() {
		AdminUpdateOrderHandler adminUpdateOrderHandler = new AdminUpdateOrderHandler();
		
		adminUpdateOrderHandler.addCommand(userTokenAuthenticationFilter());
		adminUpdateOrderHandler.addCommand(processAdminUpdateOrderCommand());
		
		return adminUpdateOrderHandler;
	}
	
	@Bean
	public ProcessAdminUpdateOrderCommand processAdminUpdateOrderCommand() {
		return new ProcessAdminUpdateOrderCommand();
	}
	
	@Bean
	public AdminEnquireOrderHandler adminEnquireOrderHandler() {
		AdminEnquireOrderHandler adminEnquireOrderHandler = new AdminEnquireOrderHandler();
		
		adminEnquireOrderHandler.addCommand(userTokenAuthenticationFilter());
		adminEnquireOrderHandler.addCommand(processAdminEnquireOrderCommand());
		
		return adminEnquireOrderHandler;
	}
	
	@Bean
	public ProcessAdminEnquireOrderCommand processAdminEnquireOrderCommand() {
		return new ProcessAdminEnquireOrderCommand();
	}
	
	@Bean
	public AdminSearchOrderHandler adminSearchOrderHandler() {
		AdminSearchOrderHandler adminSearchOrderHandler = new AdminSearchOrderHandler();
		
		adminSearchOrderHandler.addCommand(userTokenAuthenticationFilter());
		adminSearchOrderHandler.addCommand(processAdminSearchOrderCommand());
		
		return adminSearchOrderHandler;
	}
	
	@Bean
	public ProcessAdminSearchOrderCommand processAdminSearchOrderCommand() {
		return new ProcessAdminSearchOrderCommand();
	}
	
	@Bean
	public AdminCreateMaterialGroupHandler adminCreateMaterialGroupHandler() {
		AdminCreateMaterialGroupHandler adminCreateMaterialGroupHandler = new AdminCreateMaterialGroupHandler();
		
		adminCreateMaterialGroupHandler.addCommand(userTokenAuthenticationFilter());
		adminCreateMaterialGroupHandler.addCommand(processAdminCreateMaterialGroupCommand());
		
		return adminCreateMaterialGroupHandler;
	}
		
	@Bean
	public ProcessAdminCreateMaterialGroupCommand processAdminCreateMaterialGroupCommand() {
		return new ProcessAdminCreateMaterialGroupCommand();
	}
	
	@Bean
	public AdminUpdateMaterialGroupHandler adminUpdateMaterialGroupHandler() {
		AdminUpdateMaterialGroupHandler adminUpdateMaterialGroupHandler = new AdminUpdateMaterialGroupHandler();
		
		adminUpdateMaterialGroupHandler.addCommand(userTokenAuthenticationFilter());
		adminUpdateMaterialGroupHandler.addCommand(processAdminUpdateMaterialGroupCommand());
		
		return adminUpdateMaterialGroupHandler;
	}
	
	@Bean
	public ProcessAdminUpdateMaterialGroupCommand processAdminUpdateMaterialGroupCommand() {
		return new ProcessAdminUpdateMaterialGroupCommand();
	}
	
	@Bean
	public AdminEnquireMaterialGroupHandler adminEnquireMaterialGroupHandler() {
		AdminEnquireMaterialGroupHandler adminEnquireMaterialGroupHandler = new AdminEnquireMaterialGroupHandler();
		
		adminEnquireMaterialGroupHandler.addCommand(userTokenAuthenticationFilter());
		adminEnquireMaterialGroupHandler.addCommand(processAdminEnquireMaterialGroupCommand());
		
		return adminEnquireMaterialGroupHandler;
	}
	
	@Bean
	public ProcessAdminEnquireMaterialGroupCommand processAdminEnquireMaterialGroupCommand() {
		return new ProcessAdminEnquireMaterialGroupCommand();
	}
	
	@Bean
	public AdminSearchMaterialGroupHandler adminSearchMaterialGroupHandler() {
		AdminSearchMaterialGroupHandler adminSearchMaterialGroupHandler = new AdminSearchMaterialGroupHandler();
		
		adminSearchMaterialGroupHandler.addCommand(userTokenAuthenticationFilter());
		adminSearchMaterialGroupHandler.addCommand(processAdminSearchMaterialGroupCommand());
		
		return adminSearchMaterialGroupHandler;
	}
	
	@Bean
	public ProcessAdminSearchMaterialGroupCommand processAdminSearchMaterialGroupCommand() {
		return new ProcessAdminSearchMaterialGroupCommand();
	}
	
	
	
	@Bean
	public AdminCreateMaterialHandler adminCreateMaterialHandler() {
		AdminCreateMaterialHandler adminCreateMaterialHandler = new AdminCreateMaterialHandler();
		
		adminCreateMaterialHandler.addCommand(userTokenAuthenticationFilter());
		adminCreateMaterialHandler.addCommand(processAdminCreateMaterialCommand());
		
		return adminCreateMaterialHandler;
	}
		
	@Bean
	public ProcessAdminCreateMaterialCommand processAdminCreateMaterialCommand() {
		return new ProcessAdminCreateMaterialCommand();
	}
	
	@Bean
	public AdminUpdateMaterialHandler adminUpdateMaterialHandler() {
		AdminUpdateMaterialHandler adminUpdateMaterialHandler = new AdminUpdateMaterialHandler();
		
		adminUpdateMaterialHandler.addCommand(userTokenAuthenticationFilter());
		adminUpdateMaterialHandler.addCommand(processAdminUpdateMaterialCommand());
		
		return adminUpdateMaterialHandler;
	}
	
	@Bean
	public ProcessAdminUpdateMaterialCommand processAdminUpdateMaterialCommand() {
		return new ProcessAdminUpdateMaterialCommand();
	}
	
	@Bean
	public AdminEnquireMaterialHandler adminEnquireMaterialHandler() {
		AdminEnquireMaterialHandler adminEnquireMaterialHandler = new AdminEnquireMaterialHandler();
		
		adminEnquireMaterialHandler.addCommand(userTokenAuthenticationFilter());
		adminEnquireMaterialHandler.addCommand(processAdminEnquireMaterialCommand());
		
		return adminEnquireMaterialHandler;
	}
	
	@Bean
	public ProcessAdminEnquireMaterialCommand processAdminEnquireMaterialCommand() {
		return new ProcessAdminEnquireMaterialCommand();
	}
	
	@Bean
	public AdminSearchMaterialHandler adminSearchMaterialHandler() {
		AdminSearchMaterialHandler adminSearchMaterialHandler = new AdminSearchMaterialHandler();
		
		adminSearchMaterialHandler.addCommand(userTokenAuthenticationFilter());
		adminSearchMaterialHandler.addCommand(processAdminSearchMaterialCommand());
		
		return adminSearchMaterialHandler;
	}
	
	@Bean
	public ProcessAdminSearchMaterialCommand processAdminSearchMaterialCommand() {
		return new ProcessAdminSearchMaterialCommand();
	}
	
	
	@Bean
	public AdminLoginHandler adminLoginHandler() {
		AdminLoginHandler adminLoginHandler = new AdminLoginHandler();
		
		adminLoginHandler.addCommand(processAdminLoginFilter());
		
		return adminLoginHandler;
	}
	
	@Bean
	public ProcessAdminLoginFilter processAdminLoginFilter() {
		return new ProcessAdminLoginFilter();
	}
	
	@Bean
	public AdminLogoutHandler adminLogoutHandler() {
		AdminLogoutHandler adminLogoutHandler = new AdminLogoutHandler();
		
		adminLogoutHandler.addCommand(userTokenAuthenticationFilter());
		adminLogoutHandler.addCommand(processAdminLogoutCommand());
		
		return adminLogoutHandler;
	}
	
	@Bean
	public ProcessAdminLogoutCommand processAdminLogoutCommand() {
		return new ProcessAdminLogoutCommand();
	}
	
	@Bean
	public AdminChangePasscodeHandler adminChangePasscodeHandler() {
		AdminChangePasscodeHandler adminChangePasscodeHandler = new AdminChangePasscodeHandler();
		
		adminChangePasscodeHandler.addCommand(userTokenAuthenticationFilter());
		adminChangePasscodeHandler.addCommand(processAdminChangePasscodeCommand());
		
		return adminChangePasscodeHandler;
	}
	
	@Bean
	public ProcessAdminChangePasscodeCommand processAdminChangePasscodeCommand() {
		return new ProcessAdminChangePasscodeCommand();
	}
	
	@Bean
	public AdminResetPasscodeHandler adminResetPasscodeHandler() {
		AdminResetPasscodeHandler adminResetPasscodeHandler = new AdminResetPasscodeHandler();
		
		adminResetPasscodeHandler.addCommand(processAdminResetPasscodeFilter());
		
		return adminResetPasscodeHandler;
	}
	
	@Bean
	public ProcessAdminResetPasscodeFilter processAdminResetPasscodeFilter() {
		return new ProcessAdminResetPasscodeFilter();
	}
	
	////////////////////////////////////////////////////////////////
	@Bean
	public LoginHandler loginHandler() {
		
		LoginHandler loginHandler = new LoginHandler();
		
		loginHandler.addCommand(processLoginCommand());
		
		return loginHandler;
	}
	
	@Bean
	public ProcessLoginCommand processLoginCommand() {
		return new ProcessLoginCommand();
	}
	
	@Bean
	public CreateClientHandler createClientHandler() {
		
		CreateClientHandler createClientHandler = new CreateClientHandler();
		
		createClientHandler.addCommand(processCreateClientCommand());
		
		return createClientHandler;
	}
	
	@Bean
	public ProcessCreateClientCommand processCreateClientCommand() {
		return new ProcessCreateClientCommand();
	}
	
	
	@Bean
	public UpdateClientHandler updateClientHandler() {
		
		UpdateClientHandler updateClientHandler = new UpdateClientHandler();
		
		updateClientHandler.addCommand(processUpdateClientCommand());
		
		return updateClientHandler;
	}
	
	@Bean
	public ProcessUpdateClientCommand processUpdateClientCommand() {
		return new ProcessUpdateClientCommand();
	}
	
	@Bean
	public EnquireClientAddressesHandler enquireClientAddressesHandler() {
		
		EnquireClientAddressesHandler enquireClientAddressesHandler = new EnquireClientAddressesHandler();
		
		enquireClientAddressesHandler.addCommand(processEnquireClientAddressesCommand());
		
		return enquireClientAddressesHandler;
	}
	
	@Bean
	public ProcessEnquireClientAddressesCommand processEnquireClientAddressesCommand() {
		return new ProcessEnquireClientAddressesCommand();
	}
	
	@Bean
	public UpdateClientAddressHandler updateClientAddressHandler() {
		
		UpdateClientAddressHandler updateClientAddressHandler = new UpdateClientAddressHandler();
		
		updateClientAddressHandler.addCommand(processUpdateClientAddressCommand());
		
		return updateClientAddressHandler;
	}
	
	@Bean
	public ProcessUpdateClientAddressCommand processUpdateClientAddressCommand() {
		return new ProcessUpdateClientAddressCommand();
	}
	
	@Bean
	public SearchProductGroupHandler searchProductGroupHandler() {
		
		SearchProductGroupHandler searchProductGroupHandler = new SearchProductGroupHandler();
		
		searchProductGroupHandler.addCommand(processSearchProductGroupCommand());
		
		return searchProductGroupHandler;
	}
	
	@Bean
	public ProcessSearchProductGroupCommand processSearchProductGroupCommand() {
		return new ProcessSearchProductGroupCommand();
	}
	
	@Bean
	public ProcessEnquireProductCommand processEnquireProductCommand() {
		return new ProcessEnquireProductCommand();
	}
	
	@Bean
	public EnquireProductHandler enquireProductHandler() {
		
		EnquireProductHandler enquireProductHandler = new EnquireProductHandler();
		
		enquireProductHandler.addCommand(processEnquireProductCommand());
		
		return enquireProductHandler;
	}
	
	@Bean
	public SearchProductHandler searchProductHandler() {
		
		SearchProductHandler searchProductHandler = new SearchProductHandler();
		
		searchProductHandler.addCommand(processSearchProductCommand());
		
		return searchProductHandler;
	}
	
	@Bean
	public ProcessSearchProductCommand processSearchProductCommand() {
		return new ProcessSearchProductCommand();
	}
	
	
	@Bean
	public CreateOrderHandler createOrderHandler() {
		
		CreateOrderHandler createProductHandler = new CreateOrderHandler();
		
		createProductHandler.addCommand(processCreateOrderCommand());
		
		return createProductHandler;
	}
	
	@Bean
	public ProcessCreateOrderCommand processCreateOrderCommand() {
		return new ProcessCreateOrderCommand();
	}
	
	@Bean
	public EnquireOrderHandler enquireOrderHandler() {
		
		EnquireOrderHandler enquireProductHandler = new EnquireOrderHandler();
		
		enquireProductHandler.addCommand(processEnquireOrderCommand());
		
		return enquireProductHandler;
	}
	
	@Bean
	public ProcessEnquireOrderCommand processEnquireOrderCommand() {
		return new ProcessEnquireOrderCommand();
	}

	@Bean
	public SearchOrderHandler searchOrderHandler() {
		
		SearchOrderHandler searchProductHandler = new SearchOrderHandler();
		
		searchProductHandler.addCommand(processSearchOrderCommand());
		
		return searchProductHandler;
	}
	
	@Bean
	public ProcessSearchOrderCommand processSearchOrderCommand() {
		return new ProcessSearchOrderCommand();
	}
	
	@Bean
	public UpdateOrderHandler updateOrderHandler() {
		
		UpdateOrderHandler updateProductHandler = new UpdateOrderHandler();
		
		updateProductHandler.addCommand(processUpdateOrderCommand());
		
		return updateProductHandler;
	}
	
	@Bean
	public ProcessUpdateOrderCommand processUpdateOrderCommand() {
		return new ProcessUpdateOrderCommand();
	}
	
	@Bean
	public SearchMaterialHandler searchMaterialHandler() {
		
		SearchMaterialHandler searchMaterialHandler = new SearchMaterialHandler();
		
		searchMaterialHandler.addCommand(processSearchMaterialCommand());
		
		return searchMaterialHandler;
	}
	
	@Bean
	public ProcessSearchMaterialCommand processSearchMaterialCommand() {
		return new ProcessSearchMaterialCommand();
	}
	
	@Bean
	public CreateClientProductHandler createClientProductHandler() {
		
		CreateClientProductHandler createClientProductHandler = new CreateClientProductHandler();
		
		createClientProductHandler.addCommand(processCreateClientProductCommand());
		
		return createClientProductHandler;
	}
	
	@Bean
	public ProcessCreateClientProductCommand processCreateClientProductCommand() {
		return new ProcessCreateClientProductCommand();
	}
	
}
