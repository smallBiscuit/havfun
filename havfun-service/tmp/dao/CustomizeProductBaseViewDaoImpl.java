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
import com.havfun.service.dao.CustomizeProductBaseViewDao;
import com.havfun.service.dao.CustomizeProductBaseViewDaoImpl;
import com.havfun.service.entity.CustomizeProductBaseView;

public class CustomizeProductBaseViewDaoImpl implements CustomizeProductBaseViewDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(CustomizeProductBaseViewDaoImpl.class);

	private final static String CUSTOMIZE_PRODUCT_BASE_VIEW_UPDATE_SQL_BY_KEY = "update customizeProductBaseView set  base_id = ?, title = ?, bound_width = ?, bound_height = ?, x = ?, y = ?, z = ?, scale = ? where view_id = ?";

	private final static String CUSTOMIZE_PRODUCT_BASE_VIEW_SELECT_SQL_BY_KEY = "select * from customize_product_base_view where view_id = ?";

	private final static String CUSTOMIZE_PRODUCT_BASE_VIEW_DELETE_SQL_BY_KEY = "delete from customize_product_base_view where view_id = ?";

	private final static String CUSTOMIZE_PRODUCT_BASE_VIEW_SELECT_ALL_SQL = "select * from customize_product_base_view";

	private final static String CUSTOMIZE_PRODUCT_BASE_VIEW_SELECT_SQL_BY_VIEW_ID = "select * from customize_product_base_view where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<CustomizeProductBaseView> rowMapper;

	@Override
	public Integer create(CustomizeProductBaseView newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("customize_product_base_view").usingGeneratedKeyColumns("view_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("view_id", newInstance.getViewId());
		parameters.put("base_id", newInstance.getBaseId());
		parameters.put("title", newInstance.getTitle());
		parameters.put("bound_width", newInstance.getBoundWidth());
		parameters.put("bound_height", newInstance.getBoundHeight());
		parameters.put("x", newInstance.getX());
		parameters.put("y", newInstance.getY());
		parameters.put("z", newInstance.getZ());
		parameters.put("scale", newInstance.getScale());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public CustomizeProductBaseView read(Integer id) {
		CustomizeProductBaseView customizeProductBaseView = null;
		try {
			customizeProductBaseView = jdbcTemplate.queryForObject(
			CUSTOMIZE_PRODUCT_BASE_VIEW_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return customizeProductBaseView;
	}

	@Override
	public int update(CustomizeProductBaseView transientObject) {
		return jdbcTemplate.update(
				CUSTOMIZE_PRODUCT_BASE_VIEW_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getBaseId(),
					transientObject.getTitle(),
					transientObject.getBoundWidth(),
					transientObject.getBoundHeight(),
					transientObject.getX(),
					transientObject.getY(),
					transientObject.getZ(),
					transientObject.getScale(),
					transientObject.getViewId(),

				}
			);
	}

	@Override
	public int delete(CustomizeProductBaseView persistentObject) {
		return jdbcTemplate.update(
			CUSTOMIZE_PRODUCT_BASE_VIEW_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getViewId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				CUSTOMIZE_PRODUCT_BASE_VIEW_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

