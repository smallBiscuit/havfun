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
import com.havfun.service.dao.CouponProductDao;
import com.havfun.service.dao.CouponProductDaoImpl;
import com.havfun.service.entity.CouponProduct;

public class CouponProductDaoImpl implements CouponProductDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(CouponProductDaoImpl.class);

	private final static String COUPON_PRODUCT_UPDATE_SQL_BY_KEY = "update couponProduct set  coupon_id = ?, product_id = ? where coupon_product_id = ?";

	private final static String COUPON_PRODUCT_SELECT_SQL_BY_KEY = "select * from coupon_product where coupon_product_id = ?";

	private final static String COUPON_PRODUCT_DELETE_SQL_BY_KEY = "delete from coupon_product where coupon_product_id = ?";

	private final static String COUPON_PRODUCT_SELECT_ALL_SQL = "select * from coupon_product";

	private final static String COUPON_PRODUCT_SELECT_SQL_BY_COUPON_PRODUCT_ID = "select * from coupon_product where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<CouponProduct> rowMapper;

	@Override
	public Integer create(CouponProduct newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("coupon_product").usingGeneratedKeyColumns("coupon_product_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("coupon_product_id", newInstance.getCouponProductId());
		parameters.put("coupon_id", newInstance.getCouponId());
		parameters.put("product_id", newInstance.getProductId());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public CouponProduct read(Integer id) {
		CouponProduct couponProduct = null;
		try {
			couponProduct = jdbcTemplate.queryForObject(
			COUPON_PRODUCT_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return couponProduct;
	}

	@Override
	public int update(CouponProduct transientObject) {
		return jdbcTemplate.update(
				COUPON_PRODUCT_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getCouponId(),
					transientObject.getProductId(),
					transientObject.getCouponProductId(),

				}
			);
	}

	@Override
	public int delete(CouponProduct persistentObject) {
		return jdbcTemplate.update(
			COUPON_PRODUCT_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getCouponProductId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				COUPON_PRODUCT_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

