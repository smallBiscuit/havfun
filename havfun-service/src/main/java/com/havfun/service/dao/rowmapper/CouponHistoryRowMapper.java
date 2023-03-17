package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.CouponHistory;

public class CouponHistoryRowMapper implements RowMapper<CouponHistory> {

	@Override
	public CouponHistory mapRow(ResultSet rs, int rowNum) throws SQLException {

		CouponHistory couponHistory = new CouponHistory();

		couponHistory.setCouponHistoryId(rs.getInt("coupon_history_id"));
		couponHistory.setCouponId(rs.getInt("coupon_id"));
		couponHistory.setOrderId(rs.getInt("order_id"));
		couponHistory.setClientId(rs.getInt("client_id"));
		couponHistory.setAmount(rs.getBigDecimal("amount"));
		couponHistory.setCreateTimestamp(rs.getLong("create_timestamp"));
		return couponHistory;
	}

 }

