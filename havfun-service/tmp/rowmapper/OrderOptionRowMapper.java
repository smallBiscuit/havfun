package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.OrderOption;

public class OrderOptionRowMapper implements RowMapper<OrderOption> {

	@Override
	public OrderOption mapRow(ResultSet rs, int rowNum) throws SQLException {

		OrderOption orderOption = new OrderOption();

		orderOption.setOrderOptionId(rs.getInt("order_option_id"));
		orderOption.setOrderId(rs.getInt("order_id"));
		orderOption.setOrderProductId(rs.getInt("order_product_id"));
		orderOption.setProductOptionId(rs.getInt("product_option_id"));
		orderOption.setProductOptionValueId(rs.getInt("product_option_value_id"));
		orderOption.setName(rs.getString("name"));
		orderOption.setValue(rs.getString("value"));
		orderOption.setType(rs.getString("type"));
		return orderOption;
	}

 }

