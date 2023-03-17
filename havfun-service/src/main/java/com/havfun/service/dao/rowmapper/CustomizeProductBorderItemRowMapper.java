package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.CustomizeProductBorderItem;

public class CustomizeProductBorderItemRowMapper implements RowMapper<CustomizeProductBorderItem> {

	@Override
	public CustomizeProductBorderItem mapRow(ResultSet rs, int rowNum) throws SQLException {

		CustomizeProductBorderItem customizeProductBorderItem = new CustomizeProductBorderItem();

		customizeProductBorderItem.setBorderId(rs.getInt("border_id"));
		customizeProductBorderItem.setViewId(rs.getInt("view_id"));
		customizeProductBorderItem.setItemKey(rs.getString("item_key"));
		customizeProductBorderItem.setItemType(rs.getString("item_type"));
		customizeProductBorderItem.setTitle(rs.getString("title"));
		customizeProductBorderItem.setDefaultOption(rs.getString("default_option")=="1");
		customizeProductBorderItem.setCost(rs.getBigDecimal("cost"));
		customizeProductBorderItem.setX(rs.getLong("x"));
		customizeProductBorderItem.setY(rs.getLong("y"));		
		customizeProductBorderItem.setWidth(rs.getLong("width"));
		customizeProductBorderItem.setHeight(rs.getLong("height"));
		return customizeProductBorderItem;
	}

 }

