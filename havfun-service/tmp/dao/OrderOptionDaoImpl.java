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
import com.havfun.service.dao.OrderOptionDao;
import com.havfun.service.dao.OrderOptionDaoImpl;
import com.havfun.service.entity.OrderOption;

public class OrderOptionDaoImpl implements OrderOptionDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(OrderOptionDaoImpl.class);

	private final static String ORDER_OPTION_UPDATE_SQL_BY_KEY = "update orderOption set  order_id = ?, order_product_id = ?, product_option_id = ?, product_option_value_id = ?, name = ?, value = ?, type = ? where order_option_id = ?";

	private final static String ORDER_OPTION_SELECT_SQL_BY_KEY = "select * from order_option where order_option_id = ?";

	private final static String ORDER_OPTION_DELETE_SQL_BY_KEY = "delete from order_option where order_option_id = ?";

	private final static String ORDER_OPTION_SELECT_ALL_SQL = "select * from order_option";

	private final static String ORDER_OPTION_SELECT_SQL_BY_ORDER_OPTION_ID = "select * from order_option where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<OrderOption> rowMapper;

	@Override
	public Integer create(OrderOption newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("order_option").usingGeneratedKeyColumns("order_option_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("order_option_id", newInstance.getOrderOptionId());
		parameters.put("order_id", newInstance.getOrderId());
		parameters.put("order_product_id", newInstance.getOrderProductId());
		parameters.put("product_option_id", newInstance.getProductOptionId());
		parameters.put("product_option_value_id", newInstance.getProductOptionValueId());
		parameters.put("name", newInstance.getName());
		parameters.put("value", newInstance.getValue());
		parameters.put("type", newInstance.getType());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public OrderOption read(Integer id) {
		OrderOption orderOption = null;
		try {
			orderOption = jdbcTemplate.queryForObject(
			ORDER_OPTION_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return orderOption;
	}

	@Override
	public int update(OrderOption transientObject) {
		return jdbcTemplate.update(
				ORDER_OPTION_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getOrderId(),
					transientObject.getOrderProductId(),
					transientObject.getProductOptionId(),
					transientObject.getProductOptionValueId(),
					transientObject.getName(),
					transientObject.getValue(),
					transientObject.getType(),
					transientObject.getOrderOptionId(),

				}
			);
	}

	@Override
	public int delete(OrderOption persistentObject) {
		return jdbcTemplate.update(
			ORDER_OPTION_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getOrderOptionId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				ORDER_OPTION_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

