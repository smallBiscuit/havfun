package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.ProductImage;

public class ProductImageRowMapper implements RowMapper<ProductImage> {

	@Override
	public ProductImage mapRow(ResultSet rs, int rowNum) throws SQLException {

		ProductImage productImage = new ProductImage();

		productImage.setProductImageId(rs.getInt("product_image_id"));
		productImage.setProductId(rs.getInt("product_id"));
		productImage.setImage(rs.getBytes("image"));
		productImage.setSortingOrder(rs.getInt("sorting_order"));
		return productImage;
	}

 }

