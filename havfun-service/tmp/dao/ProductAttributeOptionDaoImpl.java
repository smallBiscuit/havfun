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
import com.havfun.service.dao.ProductAttributeOptionDao;
import com.havfun.service.dao.ProductAttributeOptionDaoImpl;
import com.havfun.service.entity.ProductAttributeOption;

public class ProductAttributeOptionDaoImpl implements ProductAttributeOptionDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(ProductAttributeOptionDaoImpl.class);

	private final static String PRODUCT_ATTRIBUTE_OPTION_UPDATE_SQL_BY_KEY = "update productAttributeOption set  product_attribute_id = ?, product_attribute_key = ?, product_attribute_name_en = ?, product_attribute_name_hk = ?, product_attribute_name_cn = ?, value = ?, name = ? where option_id = ?";

	private final static String PRODUCT_ATTRIBUTE_OPTION_SELECT_SQL_BY_KEY = "select * from product_attribute_option where option_id = ?";

	private final static String PRODUCT_ATTRIBUTE_OPTION_DELETE_SQL_BY_KEY = "delete from product_attribute_option where option_id = ?";

	private final static String PRODUCT_ATTRIBUTE_OPTION_SELECT_ALL_SQL = "select * from product_attribute_option";

	private final static String PRODUCT_ATTRIBUTE_OPTION_SELECT_SQL_BY_OPTION_ID = "select * from product_attribute_option where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<ProductAttributeOption> rowMapper;

	@Override
	public Integer create(ProductAttributeOption newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("product_attribute_option").usingGeneratedKeyColumns("option_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("option_id", newInstance.getOptionId());
		parameters.put("product_attribute_id", newInstance.getProductAttributeId());
		parameters.put("product_attribute_key", newInstance.getProductAttributeKey());
		parameters.put("product_attribute_name_en", newInstance.getProductAttributeNameEn());
		parameters.put("product_attribute_name_hk", newInstance.getProductAttributeNameHk());
		parameters.put("product_attribute_name_cn", newInstance.getProductAttributeNameCn());
		parameters.put("value", newInstance.getValue());
		parameters.put("name", newInstance.getName());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public ProductAttributeOption read(Integer id) {
		ProductAttributeOption productAttributeOption = null;
		try {
			productAttributeOption = jdbcTemplate.queryForObject(
			PRODUCT_ATTRIBUTE_OPTION_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return productAttributeOption;
	}

	@Override
	public int update(ProductAttributeOption transientObject) {
		return jdbcTemplate.update(
				PRODUCT_ATTRIBUTE_OPTION_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getProductAttributeId(),
					transientObject.getProductAttributeKey(),
					transientObject.getProductAttributeNameEn(),
					transientObject.getProductAttributeNameHk(),
					transientObject.getProductAttributeNameCn(),
					transientObject.getValue(),
					transientObject.getName(),
					transientObject.getOptionId(),

				}
			);
	}

	@Override
	public int delete(ProductAttributeOption persistentObject) {
		return jdbcTemplate.update(
			PRODUCT_ATTRIBUTE_OPTION_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getOptionId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				PRODUCT_ATTRIBUTE_OPTION_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

