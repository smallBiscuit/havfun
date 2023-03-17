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
import com.havfun.service.dao.ProductAttributeDao;
import com.havfun.service.dao.ProductAttributeDaoImpl;
import com.havfun.service.entity.ProductAttribute;

public class ProductAttributeDaoImpl implements ProductAttributeDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(ProductAttributeDaoImpl.class);

	private final static String PRODUCT_ATTRIBUTE_UPDATE_SQL_BY_KEY = "update productAttribute set  product_id = ?, attribute_key = ?, sort_order = ? where product_attribute_id = ?";

	private final static String PRODUCT_ATTRIBUTE_SELECT_SQL_BY_KEY = "select * from product_attribute where product_attribute_id = ?";

	private final static String PRODUCT_ATTRIBUTE_DELETE_SQL_BY_KEY = "delete from product_attribute where product_attribute_id = ?";

	private final static String PRODUCT_ATTRIBUTE_SELECT_ALL_SQL = "select * from product_attribute";

	private final static String PRODUCT_ATTRIBUTE_SELECT_SQL_BY_PRODUCT_ATTRIBUTE_ID = "select * from product_attribute where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<ProductAttribute> rowMapper;

	@Override
	public Integer create(ProductAttribute newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("product_attribute").usingGeneratedKeyColumns("product_attribute_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("product_attribute_id", newInstance.getProductAttributeId());
		parameters.put("product_id", newInstance.getProductId());
		parameters.put("attribute_key", newInstance.getAttributeKey());
		parameters.put("sort_order", newInstance.getSortOrder());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public ProductAttribute read(Integer id) {
		ProductAttribute productAttribute = null;
		try {
			productAttribute = jdbcTemplate.queryForObject(
			PRODUCT_ATTRIBUTE_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return productAttribute;
	}

	@Override
	public int update(ProductAttribute transientObject) {
		return jdbcTemplate.update(
				PRODUCT_ATTRIBUTE_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getProductId(),
					transientObject.getAttributeKey(),
					transientObject.getSortOrder(),
					transientObject.getProductAttributeId(),

				}
			);
	}

	@Override
	public int delete(ProductAttribute persistentObject) {
		return jdbcTemplate.update(
			PRODUCT_ATTRIBUTE_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getProductAttributeId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				PRODUCT_ATTRIBUTE_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

