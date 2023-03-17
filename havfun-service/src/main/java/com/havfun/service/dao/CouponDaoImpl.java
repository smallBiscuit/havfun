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
import com.havfun.service.dao.CouponDao;
import com.havfun.service.dao.CouponDaoImpl;
import com.havfun.service.entity.Coupon;

public class CouponDaoImpl implements CouponDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(CouponDaoImpl.class);

	private final static String COUPON_UPDATE_SQL_BY_KEY = "update coupon set  name = ?, code = ?, type = ?, discount = ?, logged = ?, shipping = ?, total = ?, start_date = ?, end_date = ?, uses_total = ?, uses_client = ?, status = ?, create_timestamp = ? where coupon_id = ?";

	private final static String COUPON_SELECT_SQL_BY_KEY = "select * from coupon where coupon_id = ?";

	private final static String COUPON_DELETE_SQL_BY_KEY = "delete from coupon where coupon_id = ?";

//	private final static String COUPON_SELECT_ALL_SQL = "select * from coupon";

//	private final static String COUPON_SELECT_SQL_BY_COUPON_ID = "select * from coupon where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<Coupon> rowMapper;

	@Override
	public Integer create(Coupon newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("coupon").usingGeneratedKeyColumns("coupon_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("coupon_id", newInstance.getCouponId());
		parameters.put("name", newInstance.getName());
		parameters.put("code", newInstance.getCode());
		parameters.put("type", newInstance.getType()==null?null:newInstance.getType().getValue());
		parameters.put("discount", newInstance.getDiscount());
		parameters.put("logged", newInstance.isLogged()?"1":"0");
		parameters.put("shipping", newInstance.isShipping()?"1":"0");
		parameters.put("total", newInstance.getTotal());
		parameters.put("start_date", newInstance.getStartDate());
		parameters.put("end_date", newInstance.getEndDate());
		parameters.put("uses_total", newInstance.getUsesTotal());
		parameters.put("uses_client", newInstance.getUsesClient());
		parameters.put("status", newInstance.getStatus()==null?null:newInstance.getStatus().getValue());
		parameters.put("create_timestamp", newInstance.getCreateTimestamp());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public Coupon read(Integer id) {
		Coupon coupon = null;
		try {
			coupon = jdbcTemplate.queryForObject(
			COUPON_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return coupon;
	}

	@Override
	public int update(Coupon transientObject) {
		return jdbcTemplate.update(
				COUPON_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getName(),
					transientObject.getCode(),
					transientObject.getType().getValue(),
					transientObject.getDiscount(),
					transientObject.isLogged()?"1":"0",
					transientObject.isShipping()?"1":"0",
					transientObject.getTotal(),
					transientObject.getStartDate(),
					transientObject.getEndDate(),
					transientObject.getUsesTotal(),
					transientObject.getUsesClient(),
					transientObject.getStatus().getValue(),
					transientObject.getCreateTimestamp(),
					transientObject.getCouponId(),

				}
			);
	}

	@Override
	public int delete(Coupon persistentObject) {
		return jdbcTemplate.update(
			COUPON_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getCouponId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				COUPON_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

