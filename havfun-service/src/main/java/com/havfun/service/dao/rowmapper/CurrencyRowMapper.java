package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.Currency;

public class CurrencyRowMapper implements RowMapper<Currency> {

	@Override
	public Currency mapRow(ResultSet rs, int rowNum) throws SQLException {

		Currency currency = new Currency();

		currency.setCurrencyId(rs.getInt("currency_id"));
		currency.setCode(rs.getString("code"));
		currency.setSymbolLeft(rs.getString("symbol_left"));
		currency.setSymbolRight(rs.getString("symbol_right"));
		currency.setDecimalPlace(rs.getInt("decimal_place"));
		currency.setLastModifiedTimestamp(rs.getLong("last_modified_timestamp"));
		return currency;
	}

 }

