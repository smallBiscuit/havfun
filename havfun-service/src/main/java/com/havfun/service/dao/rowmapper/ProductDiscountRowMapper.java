package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.ProductDiscount;

public class ProductDiscountRowMapper implements RowMapper<ProductDiscount> {

	@Override
	public ProductDiscount mapRow(ResultSet rs, int rowNum) throws SQLException {

		ProductDiscount productDiscount = new ProductDiscount();

		productDiscount.setProductDiscountId(rs.getInt("product_discount_id"));
		productDiscount.setProductId(rs.getInt("product_id"));
		productDiscount.setClientGroup(rs.getString("client_group"));
		productDiscount.setQuantity(rs.getLong("quantity"));
		productDiscount.setPriority(rs.getInt("priority"));
		productDiscount.setPrice(rs.getBigDecimal("price"));
		productDiscount.setStartDate(rs.getInt("start_date"));
		productDiscount.setEndDate(rs.getInt("end_date"));
		return productDiscount;
	}

 }

