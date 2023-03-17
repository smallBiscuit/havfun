package com.havfun.service;

import com.havfun.service.message.EnquireClientAddressesRequest;
import com.havfun.service.message.EnquireClientAddressesResponse;
import com.havfun.service.message.SearchProductGroupRequest;
import com.havfun.service.message.SearchProductGroupResponse;
import com.havfun.service.message.SearchProductRequest;
import com.havfun.service.message.SearchProductResponse;
import com.havfun.service.message.UpdateClientAddressRequest;
import com.havfun.service.message.UpdateClientAddressResponse;
import com.havfun.service.message.UpdateClientRequest;
import com.havfun.service.message.UpdateClientResponse;
import com.havfun.service.message.CreateClientProductRequest;
import com.havfun.service.message.CreateClientProductResponse;
import com.havfun.service.message.CreateClientRequest;
import com.havfun.service.message.CreateClientResponse;
import com.havfun.service.message.CreateOrderRequest;
import com.havfun.service.message.CreateOrderResponse;
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
import com.havfun.service.message.admin.user.AdminCreateUserRequest;
import com.havfun.service.message.admin.user.AdminCreateUserResponse;
import com.havfun.service.message.admin.user.AdminEnquireUserRequest;
import com.havfun.service.message.admin.user.AdminEnquireUserResponse;
import com.havfun.service.message.admin.user.AdminSearchUserRequest;
import com.havfun.service.message.admin.user.AdminSearchUserResponse;
import com.havfun.service.message.admin.user.AdminUpdateUserRequest;
import com.havfun.service.message.admin.user.AdminUpdateUserResponse;
import com.havfun.service.message.admin.client.AdminCreateClientRequest;
import com.havfun.service.message.admin.client.AdminCreateClientResponse;
import com.havfun.service.message.admin.client.AdminEnquireClientRequest;
import com.havfun.service.message.admin.client.AdminEnquireClientResponse;
import com.havfun.service.message.admin.client.AdminSearchClientRequest;
import com.havfun.service.message.admin.client.AdminSearchClientResponse;
import com.havfun.service.message.admin.client.AdminUpdateClientRequest;
import com.havfun.service.message.admin.client.AdminUpdateClientResponse;
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
import com.havfun.service.message.admin.order.AdminCreateOrderRequest;
import com.havfun.service.message.admin.order.AdminCreateOrderResponse;
import com.havfun.service.message.admin.order.AdminEnquireOrderRequest;
import com.havfun.service.message.admin.order.AdminEnquireOrderResponse;
import com.havfun.service.message.admin.order.AdminSearchOrderRequest;
import com.havfun.service.message.admin.order.AdminSearchOrderResponse;
import com.havfun.service.message.admin.order.AdminUpdateOrderRequest;
import com.havfun.service.message.admin.order.AdminUpdateOrderResponse;
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

public interface HavfunService {
	
	public EnquireSystemDataResponse invoke(EnquireSystemDataRequest request);
	
	public AdminCreateUserResponse invoke(AdminCreateUserRequest request);
	
	public AdminUpdateUserResponse invoke(AdminUpdateUserRequest request);
	
	public AdminEnquireUserResponse invoke(AdminEnquireUserRequest request);
	
	public AdminSearchUserResponse invoke(AdminSearchUserRequest request);
	
	public AdminCreateClientResponse invoke(AdminCreateClientRequest request);
	
	public AdminUpdateClientResponse invoke(AdminUpdateClientRequest request);
	
	public AdminEnquireClientResponse invoke(AdminEnquireClientRequest request);
	
	public AdminSearchClientResponse invoke(AdminSearchClientRequest request);
	
	public AdminCreateProductGroupResponse invoke(AdminCreateProductGroupRequest request);
	
	public AdminUpdateProductGroupResponse invoke(AdminUpdateProductGroupRequest request);
	
	public AdminEnquireProductGroupResponse invoke(AdminEnquireProductGroupRequest request);
	
	public AdminSearchProductGroupResponse invoke(AdminSearchProductGroupRequest request);
	
	public AdminCreateProductResponse invoke(AdminCreateProductRequest request);
	
	public AdminUpdateProductResponse invoke(AdminUpdateProductRequest request);
	
	public AdminEnquireProductResponse invoke(AdminEnquireProductRequest request);
	
	public AdminSearchProductResponse invoke(AdminSearchProductRequest request);
	
	public AdminCreateOrderResponse invoke(AdminCreateOrderRequest request);
	
	public AdminUpdateOrderResponse invoke(AdminUpdateOrderRequest request);
	
	public AdminEnquireOrderResponse invoke(AdminEnquireOrderRequest request);
	
	public AdminSearchOrderResponse invoke(AdminSearchOrderRequest request);
	
	public AdminCreateMaterialGroupResponse invoke(AdminCreateMaterialGroupRequest request);
	
	public AdminUpdateMaterialGroupResponse invoke(AdminUpdateMaterialGroupRequest request);
	
	public AdminEnquireMaterialGroupResponse invoke(AdminEnquireMaterialGroupRequest request);
	
	public AdminSearchMaterialGroupResponse invoke(AdminSearchMaterialGroupRequest request);
	
	public AdminCreateMaterialResponse invoke(AdminCreateMaterialRequest request);
	
	public AdminUpdateMaterialResponse invoke(AdminUpdateMaterialRequest request);
	
	public AdminEnquireMaterialResponse invoke(AdminEnquireMaterialRequest request);
	
	public AdminSearchMaterialResponse invoke(AdminSearchMaterialRequest request);
	
	public AdminLoginResponse invoke(AdminLoginRequest request);
	
	public AdminLogoutResponse invoke(AdminLogoutRequest request);
	
	public AdminChangePasscodeResponse invoke(AdminChangePasscodeRequest request);
	
	public AdminResetPasscodeResponse invoke(AdminResetPasscodeRequest request);
	
	public AdminGetPasscodeResponse invoke(AdminGetPasscodeRequest request);
	
	public AdminGeneratePasscodeResponse invoke(AdminGeneratePasscodeRequest request);
	
	
	public LoginResponse invoke(LoginRequest request);
	
	public CreateClientResponse invoke( CreateClientRequest request);
	
	public EnquireClientAddressesResponse invoke(EnquireClientAddressesRequest request);
	
	public UpdateClientAddressResponse invoke(UpdateClientAddressRequest request);
	
	public UpdateClientResponse invoke(UpdateClientRequest request);
	
	public SearchProductGroupResponse invoke(SearchProductGroupRequest request);
	
	public SearchProductResponse invoke(SearchProductRequest request);
	
	public EnquireProductResponse invoke(EnquireProductRequest request);
	
	public CreateOrderResponse invoke(CreateOrderRequest request);
	
	public UpdateOrderResponse invoke(UpdateOrderRequest request);
	
	public EnquireOrderResponse invoke(EnquireOrderRequest request);
	
	public SearchOrderResponse invoke(SearchOrderRequest request);
	
	public SearchMaterialResponse invoke(SearchMaterialRequest request);
	
	public CreateClientProductResponse invoke(CreateClientProductRequest request);
	
}
