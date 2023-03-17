package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.CustomizeProductBase;

public class CustomizeProductBaseRowMapper implements RowMapper<CustomizeProductBase> {

	@Override
	public CustomizeProductBase mapRow(ResultSet rs, int rowNum) throws SQLException {

		CustomizeProductBase customizeProductBase = new CustomizeProductBase();

		customizeProductBase.setBaseId(rs.getInt("base_id"));
		customizeProductBase.setProductId(rs.getInt("product_id"));
		return customizeProductBase;
	}

 }

