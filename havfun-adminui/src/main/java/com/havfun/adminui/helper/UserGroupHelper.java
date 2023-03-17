package com.havfun.adminui.helper;

import java.util.HashMap;
import java.util.Map;

import com.havfun.adminui.client.CreateClient;
import com.havfun.adminui.client.CreateClientRequest;
import com.havfun.adminui.client.EnquireClient;
import com.havfun.adminui.client.SearchClient;
import com.havfun.adminui.client.UpdateClientRequest;
import com.havfun.adminui.order.CreateOrder;
import com.havfun.adminui.order.CreateOrderRequest;
import com.havfun.adminui.order.EnquireOrder;
import com.havfun.adminui.order.SearchOrder;
import com.havfun.adminui.order.UpdateOrderRequest;
import com.havfun.adminui.product.CreateProduct;
import com.havfun.adminui.product.CreateProductRequest;
import com.havfun.adminui.product.EnquireProduct;
import com.havfun.adminui.product.SearchProduct;
import com.havfun.adminui.product.UpdateProductRequest;
import com.havfun.adminui.productgroup.CreateProductGroup;
import com.havfun.adminui.productgroup.CreateProductGroupRequest;
import com.havfun.adminui.productgroup.EnquireProductGroup;
import com.havfun.adminui.productgroup.SearchProductGroup;
import com.havfun.adminui.productgroup.UpdateProductGroupRequest;
/*
import com.havfun.adminui.product.CreateProduct;
import com.havfun.adminui.product.CreateProductRequest;
import com.havfun.adminui.product.EnquireProduct;
import com.havfun.adminui.product.SearchProduct;
import com.havfun.adminui.product.UpdateProductRequest;
*/
import com.havfun.adminui.servlet.ChangePassword;
import com.havfun.adminui.servlet.ChangePasswordRequest;
import com.havfun.adminui.servlet.Home;
import com.havfun.adminui.servlet.Login;
import com.havfun.adminui.servlet.LoginRequest;
import com.havfun.adminui.servlet.Logout;
import com.havfun.adminui.user.CreateUser;
import com.havfun.adminui.user.CreateUserRequest;
import com.havfun.adminui.user.EnquireUser;
import com.havfun.adminui.user.SearchUser;
import com.havfun.adminui.user.UpdateUserRequest;
import com.havfun.service.entity.constant.UserGroup;
import com.havfun.service.message.admin.AdminChangePasscodeRequest;
import com.havfun.service.message.admin.AdminLogoutRequest;

public class UserGroupHelper {
	
	private static Map<UserGroup, Map<String, Boolean>> userGroupPermissionMap = new HashMap<UserGroup, Map<String, Boolean>>();
	
	private static Map<String, Boolean> allPermittedMap = new HashMap<String, Boolean>();
	
	static { 
		
		allPermittedMap.put(AdminLogoutRequest.class.getSimpleName(), Boolean.TRUE);
		allPermittedMap.put(AdminChangePasscodeRequest.class.getSimpleName(), Boolean.TRUE);
		
		Map<String, Boolean> operatorPermissionMap = new HashMap<String, Boolean>();
		
		operatorPermissionMap.put(Login.class.getSimpleName(), Boolean.TRUE);
		operatorPermissionMap.put(LoginRequest.class.getSimpleName(), Boolean.TRUE);
		operatorPermissionMap.put(Logout.class.getSimpleName(), Boolean.TRUE);
		operatorPermissionMap.put(Home.class.getSimpleName(), Boolean.TRUE);
		operatorPermissionMap.put(ChangePassword.class.getSimpleName(), Boolean.TRUE);
		operatorPermissionMap.put(ChangePasswordRequest.class.getSimpleName(), Boolean.TRUE);
		
		operatorPermissionMap.put(Error.class.getSimpleName(), Boolean.TRUE);
		
		userGroupPermissionMap.put(UserGroup.OPERATOR, operatorPermissionMap);
		
		Map<String, Boolean> adminPermissionMap = new HashMap<String, Boolean>();
		
		adminPermissionMap.put(Login.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(LoginRequest.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(Logout.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(Home.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(ChangePassword.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(ChangePasswordRequest.class.getSimpleName(), Boolean.TRUE);
		
		adminPermissionMap.put(CreateUserRequest.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(CreateUser.class.getSimpleName(), Boolean.TRUE);		
		adminPermissionMap.put(EnquireUser.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(UpdateUserRequest.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(SearchUser.class.getSimpleName(), Boolean.TRUE);
		
		adminPermissionMap.put(CreateClientRequest.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(CreateClient.class.getSimpleName(), Boolean.TRUE);		
		adminPermissionMap.put(EnquireClient.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(UpdateClientRequest.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(SearchClient.class.getSimpleName(), Boolean.TRUE);
		
		adminPermissionMap.put(CreateProductGroupRequest.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(CreateProductGroup.class.getSimpleName(), Boolean.TRUE);		
		adminPermissionMap.put(EnquireProductGroup.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(UpdateProductGroupRequest.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(SearchProductGroup.class.getSimpleName(), Boolean.TRUE);
		
		adminPermissionMap.put(CreateProductRequest.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(CreateProduct.class.getSimpleName(), Boolean.TRUE);		
		adminPermissionMap.put(EnquireProduct.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(UpdateProductRequest.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(SearchProduct.class.getSimpleName(), Boolean.TRUE);
		
		adminPermissionMap.put(CreateOrderRequest.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(CreateOrder.class.getSimpleName(), Boolean.TRUE);		
		adminPermissionMap.put(EnquireOrder.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(UpdateOrderRequest.class.getSimpleName(), Boolean.TRUE);
		adminPermissionMap.put(SearchOrder.class.getSimpleName(), Boolean.TRUE);
		
		adminPermissionMap.put(Error.class.getSimpleName(), Boolean.TRUE);
		

		userGroupPermissionMap.put(UserGroup.ADMIN, adminPermissionMap);
		
		
	}
	
	public UserGroupHelper(){
		
	}
	
	public static HashMap<String, Boolean> getPermissionMapByRole( UserGroup role ){		
		return (HashMap<String, Boolean>)userGroupPermissionMap.get(role);
	}

}
