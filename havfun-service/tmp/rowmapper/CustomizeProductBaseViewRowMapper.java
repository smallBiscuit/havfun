package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.CustomizeProductBaseView;

public class CustomizeProductBaseViewRowMapper implements RowMapper<CustomizeProductBaseView> {

	@Override
	public CustomizeProductBaseView mapRow(ResultSet rs, int rowNum) throws SQLException {

		CustomizeProductBaseView customizeProductBaseView = new CustomizeProductBaseView();

		customizeProductBaseView.setViewId(rs.getInt("view_id"));
		customizeProductBaseView.setBaseId(rs.getInt("base_id"));
		customizeProductBaseView.setTitle(rs.getString("title"));
		customizeProductBaseView.setBoundWidth(rs.getLong("bound_width"));
		customizeProductBaseView.setBoundHeight(rs.getLong("bound_height"));
		customizeProductBaseView.setX(rs.getInt("x"));
		customizeProductBaseView.setY(rs.getInt("y"));
		customizeProductBaseView.setZ(rs.getInt("z"));
		customizeProductBaseView.setScale(rs.getBigDecimal("scale"));
		return customizeProductBaseView;
	}

 }

