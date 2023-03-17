package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.OrderOptionValue;

public class OrderOptionValueRowMapper implements RowMapper<OrderOptionValue> {

	@Override
	public OrderOptionValue mapRow(ResultSet rs, int rowNum) throws SQLException {

		OrderOptionValue orderOptionValue = new OrderOptionValue();

		orderOptionValue.setOrderOptionValueId(rs.getInt("order_option_value_id"));
		orderOptionValue.setOrderOptionId(rs.getInt("order_option_id"));
		orderOptionValue.setSortingOrder(rs.getInt("sorting_order"));
		return orderOptionValue;
	}

 }

