package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.MaterialGroup;

public class MaterialGroupRowMapper implements RowMapper<MaterialGroup> {

	@Override
	public MaterialGroup mapRow(ResultSet rs, int rowNum) throws SQLException {

		MaterialGroup materialGroup = new MaterialGroup();

		materialGroup.setMaterialGroupId(rs.getInt("material_group_id"));
		materialGroup.setNameEn(rs.getString("name_en"));
		materialGroup.setNameHk(rs.getString("name_hk"));
		materialGroup.setImage(rs.getBytes("image"));
		materialGroup.setParentId(rs.getInt("parent_id"));
		materialGroup.setActive(rs.getString("active")=="1");
		materialGroup.setCreateTimestamp(rs.getLong("create_timestamp"));
		return materialGroup;
	}

 }

