package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.CustomizeProductColorItem;

public class CustomizeProductColorItemRowMapper implements RowMapper<CustomizeProductColorItem> {

	@Override
	public CustomizeProductColorItem mapRow(ResultSet rs, int rowNum) throws SQLException {

		CustomizeProductColorItem customizeProductColorItem = new CustomizeProductColorItem();

		customizeProductColorItem.setColorId(rs.getInt("color_id"));
		customizeProductColorItem.setBaseId(rs.getInt("base_id"));
		customizeProductColorItem.setFileType(rs.getString("file_type"));
		customizeProductColorItem.setImageUrl(rs.getString("image_url"));
		customizeProductColorItem.setParentImage(rs.getString("parent_image"));
		return customizeProductColorItem;
	}

 }

