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
		material.setFileName(rs.getString("file_name"));
		material.setFilePath(rs.getString("file_path"));
		material.setMaterialGroupId(rs.getString("material_group_id"));
		return material;
	}

 }

