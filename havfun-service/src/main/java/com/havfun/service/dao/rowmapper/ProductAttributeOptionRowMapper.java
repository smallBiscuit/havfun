package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.ProductAttributeOption;

public class ProductAttributeOptionRowMapper implements RowMapper<ProductAttributeOption> {

	@Override
	public ProductAttributeOption mapRow(ResultSet rs, int rowNum) throws SQLException {

		ProductAttributeOption productAttributeOption = new ProductAttributeOption();

		productAttributeOption.setOptionId(rs.getInt("option_id"));
		productAttributeOption.setProductAttributeId(rs.getInt("product_attribute_id"));
		productAttributeOption.setProductAttributeKey(rs.getString("attribute_key"));
		productAttributeOption.setProductAttributeNameEn(rs.getString("name_en"));
		productAttributeOption.setProductAttributeNameHk(rs.getString("name_hk"));
		productAttributeOption.setProductAttributeNameCn(rs.getString("name_cn"));
		productAttributeOption.setProductAttributeKey(rs.getString("attribute_key"));
		productAttributeOption.setProductAttributeKey(rs.getString("attribute_key"));
		productAttributeOption.setValue(rs.getString("value"));
		productAttributeOption.setName(rs.getString("name"));
		
		return productAttributeOption;
	}

 }

