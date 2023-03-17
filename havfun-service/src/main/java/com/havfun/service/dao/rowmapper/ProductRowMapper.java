package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.havfun.service.entity.Product;
import com.havfun.service.entity.constant.StockStatus;
import com.havfun.service.entity.constant.ProductStatus;

public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

		Product product = new Product();

		product.setProductId(rs.getInt("product_id"));
		product.setProductGroupId(rs.getInt("product_group_id"));
		product.setNameEn(rs.getString("name_en"));
		product.setNameHk(rs.getString("name_hk"));
		product.setNameCn(rs.getString("name_cn"));
		product.setDesignerClientId(rs.getInt("designer_client_id"));		
		product.setModel(rs.getString("model"));
		product.setStock(rs.getLong("stock"));
		product.setManufacturerId(rs.getInt("manufacturer_id"));
		product.setPrice(rs.getBigDecimal("price"));
		product.setAvailableDate(rs.getInt("available_date"));
		product.setWeight(rs.getBigDecimal("weight"));
		product.setLength(rs.getBigDecimal("length"));
		product.setWidth(rs.getBigDecimal("width"));
		product.setHeight(rs.getBigDecimal("height"));
		product.setSortingOrder(rs.getInt("sorting_order"));
		product.setStockStatus(StockStatus.fromValue(rs.getString("stock_status")));
		product.setProductStatus(ProductStatus.fromValue(rs.getString("product_status")));
		product.setCreateTimestamp(rs.getTimestamp("create_timestamp").getTime() );
		product.setLastModifiedTimestamp(rs.getTimestamp("last_modified_timestamp").getTime() );
		return product;
	}

 }

