package com.havfun.service.dao;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import com.havfun.service.dao.ProductDiscountDao;
import com.havfun.service.dao.ProductDiscountDaoImpl;
import com.havfun.service.entity.ProductDiscount;

public class ProductDiscountDaoImpl implements ProductDiscountDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(ProductDiscountDaoImpl.class);

	private final static String PRODUCT_DISCOUNT_UPDATE_SQL_BY_KEY = "update productDiscount set  product_id = ?, client_group = ?, quantity = ?, priority = ?, price = ?, start_date = ?, end_date = ? where product_discount_id = ?";

	private final static String PRODUCT_DISCOUNT_SELECT_SQL_BY_KEY = "select * from productDiscount where product_discount_id = ?";

	private final static String PRODUCT_DISCOUNT_DELETE_SQL_BY_KEY = "delete from productDiscount where product_discount_id = ?";

//	private final static String PRODUCT_DISCOUNT_SELECT_ALL_SQL = "select * from productDiscount";

//	private final static String PRODUCT_DISCOUNT_SELECT_SQL_BY_PRODUCT_DISCOUNT_ID = "select * from productDiscount where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<ProductDiscount> rowMapper;

	@Override
	public Integer create(ProductDiscount newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("productDiscount").usingGeneratedKeyColumns("product_discount_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("product_discount_id", newInstance.getProductDiscountId());
		parameters.put("product_id", newInstance.getProductId());
		parameters.put("client_group", newInstance.getClientGroup());
		parameters.put("quantity", newInstance.getQuantity());
		parameters.put("priority", newInstance.getPriority());
		parameters.put("price", newInstance.getPrice());
		parameters.put("start_date", newInstance.getStartDate());
		parameters.put("end_date", newInstance.getEndDate());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public ProductDiscount read(Integer id) {
		ProductDiscount productDiscount = null;
		try {
			productDiscount = jdbcTemplate.queryForObject(
			PRODUCT_DISCOUNT_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return productDiscount;
	}

	@Override
	public int update(ProductDiscount transientObject) {
		return jdbcTemplate.update(
				PRODUCT_DISCOUNT_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getProductId(),
					transientObject.getClientGroup(),
					transientObject.getQuantity(),
					transientObject.getPriority(),
					transientObject.getPrice(),
					transientObject.getStartDate(),
					transientObject.getEndDate(),
					transientObject.getProductDiscountId(),

				}
			);
	}

	@Override
	public int delete(ProductDiscount persistentObject) {
		return jdbcTemplate.update(
			PRODUCT_DISCOUNT_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getProductDiscountId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				PRODUCT_DISCOUNT_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

