package com.havfun.service.dao;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.havfun.service.dao.ProductDao;
import com.havfun.service.dao.ProductDaoImpl;
import com.havfun.service.entity.Product;

public class ProductDaoImpl implements ProductDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(ProductDaoImpl.class);

	private final static String PRODUCT_UPDATE_SQL_BY_KEY = "update product set  product_group_id = ?, name_en = ?, name_hk = ?, name_cn = ?, thumbnail_url = ?, designer_client_id = ?, model = ?, stock = ?, manufacturer_id = ?, price = ?, available_date = ?, weight = ?, length = ?, width = ?, height = ?, sorting_order = ?, stock_status = ?, product_status = ?, create_timestamp = ?, last_modified_timestamp = ? where product_id = ?";

	private final static String PRODUCT_SELECT_SQL_BY_KEY = "select * from product where product_id = ?";

	private final static String PRODUCT_DELETE_SQL_BY_KEY = "delete from product where product_id = ?";

	private final static String PRODUCT_SELECT_ALL_SQL = "select * from product";

	private final static String PRODUCT_SELECT_SQL_BY_PRODUCT_ID = "select * from product where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<Product> rowMapper;

	@Override
	public Integer create(Product newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("product").usingGeneratedKeyColumns("product_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("product_id", newInstance.getProductId());
		parameters.put("product_group_id", newInstance.getProductGroupId());
		parameters.put("name_en", newInstance.getNameEn());
		parameters.put("name_hk", newInstance.getNameHk());
		parameters.put("name_cn", newInstance.getNameCn());
		parameters.put("thumbnail_url", newInstance.getThumbnailUrl());
		parameters.put("designer_client_id", newInstance.getDesignerClientId());
		parameters.put("model", newInstance.getModel());
		parameters.put("stock", newInstance.getStock());
		parameters.put("manufacturer_id", newInstance.getManufacturerId());
		parameters.put("price", newInstance.getPrice());
		parameters.put("available_date", newInstance.getAvailableDate());
		parameters.put("weight", newInstance.getWeight());
		parameters.put("length", newInstance.getLength());
		parameters.put("width", newInstance.getWidth());
		parameters.put("height", newInstance.getHeight());
		parameters.put("sorting_order", newInstance.getSortingOrder());
		parameters.put("stock_status", newInstance.getStockStatus()==null?null:newInstance.getStockStatus().getValue());
		parameters.put("product_status", newInstance.getProductStatus()==null?null:newInstance.getProductStatus().getValue());
		parameters.put("create_timestamp", newInstance.getCreateTimestamp());
		parameters.put("last_modified_timestamp", newInstance.getLastModifiedTimestamp());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public Product read(Integer id) {
		Product product = null;
		try {
			product = jdbcTemplate.queryForObject(
			PRODUCT_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return product;
	}

	@Override
	public int update(Product transientObject) {
		return jdbcTemplate.update(
				PRODUCT_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getProductGroupId(),
					transientObject.getNameEn(),
					transientObject.getNameHk(),
					transientObject.getNameCn(),
					transientObject.getThumbnailUrl(),
					transientObject.getDesignerClientId(),
					transientObject.getModel(),
					transientObject.getStock(),
					transientObject.getManufacturerId(),
					transientObject.getPrice(),
					transientObject.getAvailableDate(),
					transientObject.getWeight(),
					transientObject.getLength(),
					transientObject.getWidth(),
					transientObject.getHeight(),
					transientObject.getSortingOrder(),
					transientObject.getStockStatus().getValue(),
					transientObject.getProductStatus().getValue(),
					transientObject.getCreateTimestamp(),
					transientObject.getLastModifiedTimestamp(),
					transientObject.getProductId(),

				}
			);
	}

	@Override
	public int delete(Product persistentObject) {
		return jdbcTemplate.update(
			PRODUCT_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getProductId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				PRODUCT_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

