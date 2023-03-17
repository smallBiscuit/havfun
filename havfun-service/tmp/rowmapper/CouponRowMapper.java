package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.Coupon;
import com.havfun.service.entity.constant.CouponType;
import com.havfun.service.entity.constant.CouponStatus;

public class CouponRowMapper implements RowMapper<Coupon> {

	@Override
	public Coupon mapRow(ResultSet rs, int rowNum) throws SQLException {

		Coupon coupon = new Coupon();

		coupon.setCouponId(rs.getInt("coupon_id"));
		coupon.setName(rs.getString("name"));
		coupon.setCode(rs.getString("code"));
		coupon.setType(CouponType.fromValue(rs.getString("type")));
		coupon.setDiscount(rs.getBigDecimal("discount"));
		coupon.setLogged(rs.getString("logged")=="1");
		coupon.setShipping(rs.getString("shipping")=="1");
		coupon.setTotal(rs.getBigDecimal("total"));
		coupon.setStartDate(rs.getInt("start_date"));
		coupon.setEndDate(rs.getInt("end_date"));
		coupon.setUsesTotal(rs.getInt("uses_total"));
		coupon.setUsesClient(rs.getInt("uses_client"));
		coupon.setStatus(CouponStatus.fromValue(rs.getString("status")));
		coupon.setCreateTimestamp(rs.getLong("create_timestamp"));
		return coupon;
	}

 }

