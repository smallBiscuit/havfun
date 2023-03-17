package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.ProductGroup;
import com.havfun.service.entity.constant.ProductGroupStatus;

public class ProductGroupRowMapper implements RowMapper<ProductGroup> {

	@Override
	public ProductGroup mapRow(ResultSet rs, int rowNum) throws SQLException {

		ProductGroup productGroup = new ProductGroup();

		productGroup.setProductGroupId(rs.getInt("product_group_id"));
		productGroup.setNameEn(rs.getString("name_en"));
		productGroup.setImage(rs.getBytes("image"));
		
		productGroup.setParentId(rs.getInt("parent_id"));
		productGroup.setStatus(ProductGroupStatus.fromValue(rs.getString("status")));
		productGroup.setCreateTimestamp(rs.getTimestamp("create_timestamp").getTime() );
		productGroup.setLastModifiedTimestamp(rs.getTimestamp("last_modified_timestamp").getTime() );
		return productGroup;
	}

 }

