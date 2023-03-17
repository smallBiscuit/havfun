package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.Courier;

public class CourierRowMapper implements RowMapper<Courier> {

	@Override
	public Courier mapRow(ResultSet rs, int rowNum) throws SQLException {

		Courier courier = new Courier();

		courier.setCourierId(rs.getInt("courier_id"));
		courier.setForwarderId(rs.getInt("forwarder_id"));
		courier.setForwarderNameEn(rs.getString("name_en"));
		courier.setForwarderNameHk(rs.getString("name_hk"));
		courier.setForwarderNameCn(rs.getString("name_cn"));
		courier.setCountryCode(rs.getString("country_code"));
		courier.setFromWeight(rs.getBigDecimal("from_weight"));
		courier.setToWeight(rs.getBigDecimal("to_weight"));
		courier.setBaseWeight(rs.getBigDecimal("base_weight"));
		courier.setBaseCost(rs.getBigDecimal("base_cost"));
		courier.setWeightPerTier(rs.getBigDecimal("weight_per_tier"));
		courier.setChargePerTier(rs.getBigDecimal("charge_per_tier"));
		courier.setServiceChargePercentage(rs.getBigDecimal("service_charge_percentage"));
		courier.setFuelChargePercentage(rs.getBigDecimal("fuel_charge_percentage"));
		return courier;
	}

 }

