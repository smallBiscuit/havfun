package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.Option;

public class OptionRowMapper implements RowMapper<Option> {

	@Override
	public Option mapRow(ResultSet rs, int rowNum) throws SQLException {

		Option option = new Option();

		option.setOrderOptionId(rs.getInt("order_option_id"));
		option.setType(rs.getString("type"));
		return option;
	}

 }

