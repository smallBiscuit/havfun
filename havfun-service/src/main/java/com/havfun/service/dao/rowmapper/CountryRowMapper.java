package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.Country;

public class CountryRowMapper implements RowMapper<Country> {

	@Override
	public Country mapRow(ResultSet rs, int rowNum) throws SQLException {

		Country country = new Country();

		country.setCountryId(rs.getInt("country_id"));
		country.setCountryCode( rs.getString("country_code"));
		country.setNameEn(rs.getString("name_en"));
		country.setNameHk(rs.getString("name_hk"));
		country.setNameCn(rs.getString("name_cn"));
		country.setActive(rs.getString("active")=="1");
		
		return country;
	}

 }

