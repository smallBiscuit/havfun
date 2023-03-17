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
import com.havfun.service.dao.OrderProductDao;
import com.havfun.service.dao.OrderProductDaoImpl;
import com.havfun.service.entity.OrderProduct;

public class OrderProductDaoImpl implements OrderProductDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(OrderProductDaoImpl.class);

	private final static String ORDER_PRODUCT_UPDATE_SQL_BY_KEY = "update orderProduct set  order_id = ?, product_id = ?, name = ?, model = ?, quantity = ?, price = ?, total = ?, tax = ?, reward = ? where order_product_id = ?";

	private final static String ORDER_PRODUCT_SELECT_SQL_BY_KEY = "select * from order_product where order_product_id = ?";

	private final static String ORDER_PRODUCT_DELETE_SQL_BY_KEY = "delete from order_product where order_product_id = ?";

	private final static String ORDER_PRODUCT_SELECT_ALL_SQL = "select * from order_product";

	private final static String ORDER_PRODUCT_SELECT_SQL_BY_ORDER_PRODUCT_ID = "select * from order_product where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<OrderProduct> rowMapper;

	@Override
	public Integer create(OrderProduct newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("order_product").usingGeneratedKeyColumns("order_product_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("order_product_id", newInstance.getOrderProductId());
		parameters.put("order_id", newInstance.getOrderId());
		parameters.put("product_id", newInstance.getProductId());
		parameters.put("name", newInstance.getName());
		parameters.put("model", newInstance.getModel());
		parameters.put("quantity", newInstance.getQuantity());
		parameters.put("price", newInstance.getPrice());
		parameters.put("total", newInstance.getTotal());
		parameters.put("tax", newInstance.getTax());
		parameters.put("reward", newInstance.getReward());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public OrderProduct read(Integer id) {
		OrderProduct orderProduct = null;
		try {
			orderProduct = jdbcTemplate.queryForObject(
			ORDER_PRODUCT_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return orderProduct;
	}

	@Override
	public int update(OrderProduct transientObject) {
		return jdbcTemplate.update(
				ORDER_PRODUCT_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getOrderId(),
					transientObject.getProductId(),
					transientObject.getName(),
					transientObject.getModel(),
					transientObject.getQuantity(),
					transientObject.getPrice(),
					transientObject.getTotal(),
					transientObject.getTax(),
					transientObject.getReward(),
					transientObject.getOrderProductId(),

				}
			);
	}

	@Override
	public int delete(OrderProduct persistentObject) {
		return jdbcTemplate.update(
			ORDER_PRODUCT_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getOrderProductId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				ORDER_PRODUCT_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

