package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.CouponProduct;

public class CouponProductRowMapper implements RowMapper<CouponProduct> {

	@Override
	public CouponProduct mapRow(ResultSet rs, int rowNum) throws SQLException {

		CouponProduct couponProduct = new CouponProduct();

		couponProduct.setCouponProductId(rs.getInt("coupon_product_id"));
		couponProduct.setCouponId(rs.getInt("coupon_id"));
		couponProduct.setProductId(rs.getInt("product_id"));
		return couponProduct;
	}

 }

