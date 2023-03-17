package com.havfun.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import com.havfun.service.dao.AddressDao;
import com.havfun.service.dao.AddressDaoImpl;
import com.havfun.service.dao.ClientDao;
import com.havfun.service.dao.ClientDaoImpl;
import com.havfun.service.dao.ClientProductDao;
import com.havfun.service.dao.ClientProductDaoImpl;
import com.havfun.service.dao.CountryDao;
import com.havfun.service.dao.CountryDaoImpl;
import com.havfun.service.dao.CourierDao;
import com.havfun.service.dao.CourierDaoImpl;
import com.havfun.service.dao.CustomizeProductBaseDao;
import com.havfun.service.dao.CustomizeProductBaseDaoImpl;
import com.havfun.service.dao.CustomizeProductBaseViewDao;
import com.havfun.service.dao.CustomizeProductBaseViewDaoImpl;
import com.havfun.service.dao.CustomizeProductBorderItemDao;
import com.havfun.service.dao.CustomizeProductBorderItemDaoImpl;
import com.havfun.service.dao.CustomizeProductColorItemDao;
import com.havfun.service.dao.CustomizeProductColorItemDaoImpl;
import com.havfun.service.dao.MaterialDao;
import com.havfun.service.dao.MaterialDaoImpl;
import com.havfun.service.dao.MaterialGroupDao;
import com.havfun.service.dao.MaterialGroupDaoImpl;
import com.havfun.service.dao.OrderDao;
import com.havfun.service.dao.OrderDaoImpl;
import com.havfun.service.dao.OrderProductDao;
import com.havfun.service.dao.OrderProductDaoImpl;
import com.havfun.service.dao.ProductAttributeOptionDao;
import com.havfun.service.dao.ProductAttributeOptionDaoImpl;
import com.havfun.service.dao.ProductDao;
import com.havfun.service.dao.ProductDaoImpl;
import com.havfun.service.dao.ProductGroupDao;
import com.havfun.service.dao.ProductGroupDaoImpl;
import com.havfun.service.dao.SocialSignInDao;
import com.havfun.service.dao.SocialSignInDaoImpl;
import com.havfun.service.dao.UserDao;
import com.havfun.service.dao.UserDaoImpl;
import com.havfun.service.dao.UserGetPasscodeDao;
import com.havfun.service.dao.UserGetPasscodeDaoImpl;
import com.havfun.service.dao.UserLoginHistoryDao;
import com.havfun.service.dao.UserLoginHistoryDaoImpl;
import com.havfun.service.dao.rowmapper.AddressRowMapper;
import com.havfun.service.dao.rowmapper.ClientProductRowMapper;
import com.havfun.service.dao.rowmapper.ClientRowMapper;
import com.havfun.service.dao.rowmapper.CountryRowMapper;
import com.havfun.service.dao.rowmapper.CourierRowMapper;
import com.havfun.service.dao.rowmapper.CustomizeProductBaseRowMapper;
import com.havfun.service.dao.rowmapper.CustomizeProductBaseViewRowMapper;
import com.havfun.service.dao.rowmapper.CustomizeProductBorderItemRowMapper;
import com.havfun.service.dao.rowmapper.CustomizeProductColorItemRowMapper;
import com.havfun.service.dao.rowmapper.MaterialGroupRowMapper;
import com.havfun.service.dao.rowmapper.MaterialRowMapper;
import com.havfun.service.dao.rowmapper.OrderProductRowMapper;
import com.havfun.service.dao.rowmapper.OrderRowMapper;
import com.havfun.service.dao.rowmapper.ProductAttributeOptionRowMapper;
import com.havfun.service.dao.rowmapper.ProductGroupRowMapper;
import com.havfun.service.dao.rowmapper.ProductRowMapper;
import com.havfun.service.dao.rowmapper.SocialSignInRowMapper;
import com.havfun.service.dao.rowmapper.UserGetPasscodeRowMapper;
import com.havfun.service.dao.rowmapper.UserLoginHistoryRowMapper;
import com.havfun.service.dao.rowmapper.UserRowMapper;
import com.havfun.service.entity.Address;
import com.havfun.service.entity.Client;
import com.havfun.service.entity.ClientProduct;
import com.havfun.service.entity.Country;
import com.havfun.service.entity.Courier;
import com.havfun.service.entity.CustomizeProductBase;
import com.havfun.service.entity.CustomizeProductBaseView;
import com.havfun.service.entity.CustomizeProductBorderItem;
import com.havfun.service.entity.CustomizeProductColorItem;
import com.havfun.service.entity.Material;
import com.havfun.service.entity.MaterialGroup;
import com.havfun.service.entity.Order;
import com.havfun.service.entity.OrderProduct;
import com.havfun.service.entity.Product;
import com.havfun.service.entity.ProductAttributeOption;
import com.havfun.service.entity.ProductGroup;
import com.havfun.service.entity.SocialSignIn;
import com.havfun.service.entity.User;
import com.havfun.service.entity.UserGetPasscode;
import com.havfun.service.entity.UserLoginHistory;

@Configuration
public class HavfunDaoConfig {
	
	@Bean (name = "userDao")
	public UserDao userDao() {
		return new UserDaoImpl();
	}
	
	@Bean
	public RowMapper<User> userRowMapper() {
		return new UserRowMapper();
	}
	
	@Bean (name = "clientDao")
	public ClientDao clientDao() {
		return new ClientDaoImpl();
	}
	
	@Bean
	public RowMapper<Client> clientRowMapper() {
		return new ClientRowMapper();
	}
	
	@Bean (name = "addressDao")
	public AddressDao addressDao() {
		return new AddressDaoImpl();
	}
	
	@Bean
	public RowMapper<Address> addressRowMapper() {
		return new AddressRowMapper();
	}
	
	@Bean (name = "socialSignInDao")
	public SocialSignInDao socialSignInDao() {
		return new SocialSignInDaoImpl();
	}
	
	@Bean
	public RowMapper<SocialSignIn> socialSignInRowMapper() {
		return new SocialSignInRowMapper();
	}
	
	@Bean (name = "productGroupDao")
	public ProductGroupDao productGroupDao() {
		return new ProductGroupDaoImpl();
	}
	
	@Bean
	public RowMapper<ProductGroup> productGroupRowMapper() {
		return new ProductGroupRowMapper();
	}
	
	@Bean (name = "productDao")
	public ProductDao productDao() {
		return new ProductDaoImpl();
	}
	
	@Bean
	public RowMapper<Product> productRowMapper() {
		return new ProductRowMapper();
	}
	

	@Bean (name = "clientProductDao")
	public ClientProductDao clientProductDao() {
		return new ClientProductDaoImpl();
	}
	
	@Bean
	public RowMapper<ClientProduct> clientProductRowMapper() {
		return new ClientProductRowMapper();
	}
	
	@Bean (name = "materialGroupDao")
	public MaterialGroupDao materialGroupDao() {
		return new MaterialGroupDaoImpl();
	}
	
	@Bean
	public RowMapper<MaterialGroup> materialGroupRowMapper() {
		return new MaterialGroupRowMapper();
	}
	
	@Bean (name = "materialDao")
	public MaterialDao materialDao() {
		return new MaterialDaoImpl();
	}
	
	@Bean
	public RowMapper<Material> materialRowMapper() {
		return new MaterialRowMapper();
	}
	
	@Bean (name = "orderDao")
	public OrderDao orderDao() {
		return new OrderDaoImpl();
	}
	
	@Bean
	public RowMapper<Order> orderRowMapper() {
		return new OrderRowMapper();
	}
	
	@Bean (name = "orderProductDao")
	public OrderProductDao orderProductDao() {
		return new OrderProductDaoImpl();
	}
	
	@Bean
	public RowMapper<OrderProduct> orderProductRowMapper() {
		return new OrderProductRowMapper();
	}
	
	@Bean (name = "userLoginHistoryDao")
	public UserLoginHistoryDao userLoginHistoryDao() {
		return new UserLoginHistoryDaoImpl();
	}
	
	@Bean
	public RowMapper<UserLoginHistory> userLoginHistoryRowMapper() {
		return new UserLoginHistoryRowMapper();
	}
	
	@Bean (name = "userGetPasscodeDao")
	public UserGetPasscodeDao userGetPasscodeDao() {
		return new UserGetPasscodeDaoImpl();
	}
	
	@Bean
	public RowMapper<UserGetPasscode> userGetPasscodeRowMapper() {
		return new UserGetPasscodeRowMapper();
	}
	
	@Bean (name = "productAttributeOptionDao")
	public ProductAttributeOptionDao productAttributeOptionDao() {
		return new ProductAttributeOptionDaoImpl();
	}
	
	@Bean
	public RowMapper<ProductAttributeOption> productAttributeOptionRowMapper() {
		return new ProductAttributeOptionRowMapper();
	}
	
	@Bean (name = "customizeProductBaseDao")
	public CustomizeProductBaseDao customizeProductBaseDao() {
		return new CustomizeProductBaseDaoImpl();
	}
	
	@Bean
	public RowMapper<CustomizeProductBase> customizeProductBaseRowMapper() {
		return new CustomizeProductBaseRowMapper();
	}
	
	@Bean (name = "customizeProductBaseViewDao")
	public CustomizeProductBaseViewDao customizeProductBaseViewDao() {
		return new CustomizeProductBaseViewDaoImpl();
	}
	
	@Bean
	public RowMapper<CustomizeProductBaseView> customizeProductBaseViewRowMapper() {
		return new CustomizeProductBaseViewRowMapper();
	}

	@Bean (name = "customizeProductBorderItemDao")
	public CustomizeProductBorderItemDao customizeProductBorderItemDao() {
		return new CustomizeProductBorderItemDaoImpl();
	}
	
	@Bean
	public RowMapper<CustomizeProductBorderItem> customizeProductBorderItemRowMapper() {
		return new CustomizeProductBorderItemRowMapper();
	}

	@Bean (name = "customizeProductColorItemDao")
	public CustomizeProductColorItemDao customizeProductColorItemDao() {
		return new CustomizeProductColorItemDaoImpl();
	}
	
	@Bean
	public RowMapper<CustomizeProductColorItem> customizeProductColorItemRowMapper() {
		return new CustomizeProductColorItemRowMapper();
	}
	
	@Bean (name = "CountryDao")
	public CountryDao countryDao() {
		return new CountryDaoImpl();
	}
	
	@Bean
	public RowMapper<Country> countryRowMapper() {
		return new CountryRowMapper();
	}
	
	@Bean (name = "courierDao")
	public CourierDao courierDao() {
		return new CourierDaoImpl();
	}
	
	@Bean
	public RowMapper<Courier> courierRowMapper() {
		return new CourierRowMapper();
	}
}
