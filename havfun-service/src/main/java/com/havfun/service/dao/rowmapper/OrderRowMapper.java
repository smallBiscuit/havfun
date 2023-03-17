package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.Order;
import com.havfun.service.entity.constant.OrderStatus;

public class OrderRowMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {

		Order order = new Order();

		order.setOrderId(rs.getInt("order_id"));
		order.setInvoiceNo(rs.getString("invoice_no"));
		order.setStoreId(rs.getInt("store_id"));
		order.setStoreName(rs.getString("store_name"));
		order.setStoreUrl(rs.getString("store_url"));
		order.setClientId(rs.getInt("client_id"));
		order.setClientGroup(rs.getString("client_group"));
		order.setFirstName(rs.getString("first_name"));
		order.setLastName(rs.getString("last_name"));
		order.setEmail(rs.getString("email"));
		order.setTelephone(rs.getString("telephone"));
		order.setFax(rs.getString("fax"));
		order.setBillingFirstName(rs.getString("billing_first_name"));
		order.setBillingLastName(rs.getString("billing_last_name"));
		order.setBillingAddress1(rs.getString("billing_address_1"));
		order.setBillingAddress2(rs.getString("billing_address_2"));
		order.setBillingCity(rs.getString("billing_city"));
		order.setBillingPostcode(rs.getString("billing_postcode"));
		order.setBillingCountryId(rs.getInt("billing_country_id"));
		order.setBillingTelephone(rs.getString("billing_telephone"));
		order.setShippingFirstName(rs.getString("shipping_first_name"));
		order.setShippingLastName(rs.getString("shipping_last_name"));
		order.setShippingAddress1(rs.getString("shipping_address_1"));
		order.setShippingAddress2(rs.getString("shipping_address_2"));
		order.setShippingCity(rs.getString("shipping_city"));
		order.setShippingPostcode(rs.getString("shipping_postcode"));
		order.setShippingCountryId(rs.getInt("shipping_country_id"));
		order.setShippingTelephone(rs.getString("shipping_telephone"));
		order.setPaymentMethodId(rs.getInt("payment_method_id"));
		order.setShippingMethodId(rs.getInt("shipping_method_id"));
		order.setRemark(rs.getString("remark"));
		order.setTotal(rs.getBigDecimal("total"));
		order.setStatus(OrderStatus.fromValue(rs.getString("status")));
		order.setCurrencyId(rs.getInt("currency_id"));
		order.setCurrencyCode(rs.getString("currency_code"));
		order.setCurrencyValue(rs.getBigDecimal("currency_value"));
		order.setCreateTimestamp(rs.getTimestamp("create_timestamp").getTime());
		order.setLastModifiedTimestamp(rs.getTimestamp("last_modified_timestamp").getTime());
		return order;
	}

 }

