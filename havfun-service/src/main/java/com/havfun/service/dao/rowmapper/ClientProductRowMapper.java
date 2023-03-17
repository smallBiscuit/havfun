package com.havfun.service.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.havfun.service.entity.ClientProduct;
import com.havfun.service.entity.constant.StockStatus;
import com.havfun.service.entity.constant.ProductStatus;

public class ClientProductRowMapper implements RowMapper<ClientProduct> {

	@Override
	public ClientProduct mapRow(ResultSet rs, int rowNum) throws SQLException {

		ClientProduct product = new ClientProduct();

		product.setClientProductId(rs.getInt("client_product_id"));
		product.setDesignerClientId(rs.getInt("designer_client_id"));
		product.setProductStatus(ProductStatus.fromValue(rs.getString("product_status")));
		product.setCreateTimestamp(rs.getTimestamp("create_timestamp").getTime() );
		product.setLastModifiedTimestamp(rs.getTimestamp("last_modified_timestamp").getTime() );
		return product;
	}

 }

