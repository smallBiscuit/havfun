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
import com.havfun.service.dao.CouponHistoryDao;
import com.havfun.service.dao.CouponHistoryDaoImpl;
import com.havfun.service.entity.CouponHistory;

public class CouponHistoryDaoImpl implements CouponHistoryDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(CouponHistoryDaoImpl.class);

	private final static String COUPON_HISTORY_UPDATE_SQL_BY_KEY = "update couponHistory set  coupon_id = ?, order_id = ?, client_id = ?, amount = ?, create_timestamp = ? where coupon_history_id = ?";

	private final static String COUPON_HISTORY_SELECT_SQL_BY_KEY = "select * from couponHistory where coupon_history_id = ?";

	private final static String COUPON_HISTORY_DELETE_SQL_BY_KEY = "delete from couponHistory where coupon_history_id = ?";

//	private final static String COUPON_HISTORY_SELECT_ALL_SQL = "select * from couponHistory";

//	private final static String COUPON_HISTORY_SELECT_SQL_BY_COUPON_HISTORY_ID = "select * from couponHistory where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<CouponHistory> rowMapper;

	@Override
	public Integer create(CouponHistory newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("couponHistory").usingGeneratedKeyColumns("coupon_history_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("coupon_history_id", newInstance.getCouponHistoryId());
		parameters.put("coupon_id", newInstance.getCouponId());
		parameters.put("order_id", newInstance.getOrderId());
		parameters.put("client_id", newInstance.getClientId());
		parameters.put("amount", newInstance.getAmount());
		parameters.put("create_timestamp", newInstance.getCreateTimestamp());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public CouponHistory read(Integer id) {
		CouponHistory couponHistory = null;
		try {
			couponHistory = jdbcTemplate.queryForObject(
			COUPON_HISTORY_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return couponHistory;
	}

	@Override
	public int update(CouponHistory transientObject) {
		return jdbcTemplate.update(
				COUPON_HISTORY_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getCouponId(),
					transientObject.getOrderId(),
					transientObject.getClientId(),
					transientObject.getAmount(),
					transientObject.getCreateTimestamp(),
					transientObject.getCouponHistoryId(),

				}
			);
	}

	@Override
	public int delete(CouponHistory persistentObject) {
		return jdbcTemplate.update(
			COUPON_HISTORY_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getCouponHistoryId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				COUPON_HISTORY_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

