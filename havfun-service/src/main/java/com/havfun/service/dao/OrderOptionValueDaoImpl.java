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
import com.havfun.service.dao.OrderOptionValueDao;
import com.havfun.service.dao.OrderOptionValueDaoImpl;
import com.havfun.service.entity.OrderOptionValue;

public class OrderOptionValueDaoImpl implements OrderOptionValueDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(OrderOptionValueDaoImpl.class);

	private final static String ORDER_OPTION_VALUE_UPDATE_SQL_BY_KEY = "update orderOptionValue set  order_option_id = ?, sorting_order = ? where order_option_value_id = ?";

	private final static String ORDER_OPTION_VALUE_SELECT_SQL_BY_KEY = "select * from orderOptionValue where order_option_value_id = ?";

	private final static String ORDER_OPTION_VALUE_DELETE_SQL_BY_KEY = "delete from orderOptionValue where order_option_value_id = ?";

//	private final static String ORDER_OPTION_VALUE_SELECT_ALL_SQL = "select * from orderOptionValue";

//	private final static String ORDER_OPTION_VALUE_SELECT_SQL_BY_ORDER_OPTION_VALUE_ID = "select * from orderOptionValue where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<OrderOptionValue> rowMapper;

	@Override
	public Integer create(OrderOptionValue newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("orderOptionValue").usingGeneratedKeyColumns("order_option_value_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("order_option_value_id", newInstance.getOrderOptionValueId());
		parameters.put("order_option_id", newInstance.getOrderOptionId());
		parameters.put("sorting_order", newInstance.getSortingOrder());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public OrderOptionValue read(Integer id) {
		OrderOptionValue orderOptionValue = null;
		try {
			orderOptionValue = jdbcTemplate.queryForObject(
			ORDER_OPTION_VALUE_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return orderOptionValue;
	}

	@Override
	public int update(OrderOptionValue transientObject) {
		return jdbcTemplate.update(
				ORDER_OPTION_VALUE_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getOrderOptionId(),
					transientObject.getSortingOrder(),
					transientObject.getOrderOptionValueId(),

				}
			);
	}

	@Override
	public int delete(OrderOptionValue persistentObject) {
		return jdbcTemplate.update(
			ORDER_OPTION_VALUE_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getOrderOptionValueId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				ORDER_OPTION_VALUE_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

