package com.havfun.adminui.bos;

import com.havfun.service.HavfunService;
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
import com.havfun.service.message.admin.material.AdminCreateMaterialRequest;
import com.havfun.service.message.admin.material.AdminCreateMaterialResponse;
import com.havfun.service.message.admin.material.AdminEnquireMaterialRequest;
import com.havfun.service.message.admin.material.AdminEnquireMaterialResponse;
import com.havfun.service.message.admin.material.AdminSearchMaterialRequest;
import com.havfun.service.message.admin.material.AdminSearchMaterialResponse;
import com.havfun.service.message.admin.material.AdminUpdateMaterialRequest;
import com.havfun.service.message.admin.material.AdminUpdateMaterialResponse;
import com.havfun.service.message.admin.materialgroup.AdminCreateMaterialGroupRequest;
import com.havfun.service.message.admin.materialgroup.AdminCreateMaterialGroupResponse;
import com.havfun.service.message.admin.materialgroup.AdminEnquireMaterialGroupRequest;
import com.havfun.service.message.admin.materialgroup.AdminEnquireMaterialGroupResponse;
import com.havfun.service.message.admin.materialgroup.AdminSearchMaterialGroupRequest;
import com.havfun.service.message.admin.materialgroup.AdminSearchMaterialGroupResponse;
import com.havfun.service.message.admin.materialgroup.AdminUpdateMaterialGroupRequest;
import com.havfun.service.message.admin.materialgroup.AdminUpdateMaterialGroupResponse;
import com.havfun.service.message.admin.order.AdminCreateOrderRequest;
import com.havfun.service.message.admin.order.AdminCreateOrderResponse;
import com.havfun.service.message.admin.order.AdminEnquireOrderRequest;
import com.havfun.service.message.admin.order.AdminEnquireOrderResponse;
import com.havfun.service.message.admin.order.AdminSearchOrderRequest;
import com.havfun.service.message.admin.order.AdminSearchOrderResponse;
import com.havfun.service.message.admin.order.AdminUpdateOrderRequest;
import com.havfun.service.message.admin.order.AdminUpdateOrderResponse;
import com.havfun.service.message.admin.product.AdminCreateProductRequest;
import com.havfun.service.message.admin.product.AdminCreateProductResponse;
import com.havfun.service.message.admin.product.AdminEnquireProductRequest;
import com.havfun.service.message.admin.product.AdminEnquireProductResponse;
import com.havfun.service.message.admin.product.AdminSearchProductRequest;
import com.havfun.service.message.admin.product.AdminSearchProductResponse;
import com.havfun.service.message.admin.product.AdminUpdateProductRequest;
import com.havfun.service.message.admin.product.AdminUpdateProductResponse;
import com.havfun.service.message.admin.productgroup.AdminCreateProductGroupRequest;
import com.havfun.service.message.admin.productgroup.AdminCreateProductGroupResponse;
import com.havfun.service.message.admin.productgroup.AdminEnquireProductGroupRequest;
import com.havfun.service.message.admin.productgroup.AdminEnquireProductGroupResponse;
import com.havfun.service.message.admin.productgroup.AdminSearchProductGroupRequest;
import com.havfun.service.message.admin.productgroup.AdminSearchProductGroupResponse;
import com.havfun.service.message.admin.productgroup.AdminUpdateProductGroupRequest;
import com.havfun.service.message.admin.productgroup.AdminUpdateProductGroupResponse;
import com.havfun.service.message.admin.user.AdminCreateUserRequest;
import com.havfun.service.message.admin.user.AdminCreateUserResponse;
import com.havfun.service.message.admin.user.AdminEnquireUserRequest;
import com.havfun.service.message.admin.user.AdminEnquireUserResponse;
import com.havfun.service.message.admin.user.AdminSearchUserRequest;
import com.havfun.service.message.admin.user.AdminSearchUserResponse;
import com.havfun.service.message.admin.user.AdminUpdateUserRequest;
import com.havfun.service.message.admin.user.AdminUpdateUserResponse;

public class TestHavfunService implements HavfunService{

	@Override
	public AdminCreateUserResponse invoke(AdminCreateUserRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminUpdateUserResponse invoke(AdminUpdateUserRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminEnquireUserResponse invoke(AdminEnquireUserRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminSearchUserResponse invoke(AdminSearchUserRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminLoginResponse invoke(AdminLoginRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminLogoutResponse invoke(AdminLogoutRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminChangePasscodeResponse invoke(AdminChangePasscodeRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminResetPasscodeResponse invoke(AdminResetPasscodeRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminGetPasscodeResponse invoke(AdminGetPasscodeRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminGeneratePasscodeResponse invoke(AdminGeneratePasscodeRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminCreateClientResponse invoke(AdminCreateClientRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminUpdateClientResponse invoke(AdminUpdateClientRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminEnquireClientResponse invoke(AdminEnquireClientRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminSearchClientResponse invoke(AdminSearchClientRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminCreateProductGroupResponse invoke(AdminCreateProductGroupRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminUpdateProductGroupResponse invoke(AdminUpdateProductGroupRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminEnquireProductGroupResponse invoke(AdminEnquireProductGroupRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminSearchProductGroupResponse invoke(AdminSearchProductGroupRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminCreateProductResponse invoke(AdminCreateProductRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminUpdateProductResponse invoke(AdminUpdateProductRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminEnquireProductResponse invoke(AdminEnquireProductRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminSearchProductResponse invoke(AdminSearchProductRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnquireClientAddressesResponse invoke(EnquireClientAddressesRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateClientAddressResponse invoke(UpdateClientAddressRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SearchProductGroupResponse invoke(SearchProductGroupRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SearchProductResponse invoke(SearchProductRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminCreateOrderResponse invoke(AdminCreateOrderRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminUpdateOrderResponse invoke(AdminUpdateOrderRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminEnquireOrderResponse invoke(AdminEnquireOrderRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminSearchOrderResponse invoke(AdminSearchOrderRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateOrderResponse invoke(CreateOrderRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateOrderResponse invoke(UpdateOrderRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnquireOrderResponse invoke(EnquireOrderRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SearchOrderResponse invoke(SearchOrderRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnquireProductResponse invoke(EnquireProductRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnquireSystemDataResponse invoke(EnquireSystemDataRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminCreateMaterialGroupResponse invoke(AdminCreateMaterialGroupRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminUpdateMaterialGroupResponse invoke(AdminUpdateMaterialGroupRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminEnquireMaterialGroupResponse invoke(AdminEnquireMaterialGroupRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminSearchMaterialGroupResponse invoke(AdminSearchMaterialGroupRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminCreateMaterialResponse invoke(AdminCreateMaterialRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminUpdateMaterialResponse invoke(AdminUpdateMaterialRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminEnquireMaterialResponse invoke(AdminEnquireMaterialRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminSearchMaterialResponse invoke(AdminSearchMaterialRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoginResponse invoke(LoginRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateClientResponse invoke(UpdateClientRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SearchMaterialResponse invoke(SearchMaterialRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreateClientResponse invoke(CreateClientRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
