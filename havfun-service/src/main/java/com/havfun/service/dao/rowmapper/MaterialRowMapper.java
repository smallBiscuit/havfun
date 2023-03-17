package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.Material;

public class MaterialRowMapper implements RowMapper<Material> {

	@Override
	public Material mapRow(ResultSet rs, int rowNum) throws SQLException {

		Material material = new Material();

		material.setMaterialId(rs.getInt("material_id"));
		material.setImage(rs.getBytes("image"));
		material.setMaterialGroupId(rs.getInt("material_group_id"));
		material.setMaterialIndex(rs.getInt("material_index"));
		material.setActive(rs.getString("active")=="1");
		material.setCreateTimestamp(rs.getLong("create_timestamp"));
		
		return material;
	}

 }

