package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.ProductAttribute;

public class ProductAttributeRowMapper implements RowMapper<ProductAttribute> {

	@Override
	public ProductAttribute mapRow(ResultSet rs, int rowNum) throws SQLException {

		ProductAttribute productAttribute = new ProductAttribute();

		productAttribute.setProductAttributeId(rs.getInt("product_attribute_id"));
		productAttribute.setProductId(rs.getInt("product_id"));
		productAttribute.setAttributeKey(rs.getString("attribute_key"));
		productAttribute.setSortOrder(rs.getInt("sort_order"));
		return productAttribute;
	}

 }

