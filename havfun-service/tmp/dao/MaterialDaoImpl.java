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
import com.havfun.service.dao.MaterialDao;
import com.havfun.service.dao.MaterialDaoImpl;
import com.havfun.service.entity.Material;

public class MaterialDaoImpl implements MaterialDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(MaterialDaoImpl.class);

	private final static String MATERIAL_UPDATE_SQL_BY_KEY = "update material set  file_name = ?, file_path = ?, material_group_id = ? where material_id = ?";

	private final static String MATERIAL_SELECT_SQL_BY_KEY = "select * from material where material_id = ?";

	private final static String MATERIAL_DELETE_SQL_BY_KEY = "delete from material where material_id = ?";

	private final static String MATERIAL_SELECT_ALL_SQL = "select * from material";

	private final static String MATERIAL_SELECT_SQL_BY_MATERIAL_ID = "select * from material where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<Material> rowMapper;

	@Override
	public Integer create(Material newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("material").usingGeneratedKeyColumns("material_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("material_id", newInstance.getMaterialId());
		parameters.put("file_name", newInstance.getFileName());
		parameters.put("file_path", newInstance.getFilePath());
		parameters.put("material_group_id", newInstance.getMaterialGroupId());
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public Material read(Integer id) {
		Material material = null;
		try {
			material = jdbcTemplate.queryForObject(
			MATERIAL_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return material;
	}

	@Override
	public int update(Material transientObject) {
		return jdbcTemplate.update(
				MATERIAL_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getFileName(),
					transientObject.getFilePath(),
					transientObject.getMaterialGroupId(),
					transientObject.getMaterialId(),

				}
			);
	}

	@Override
	public int delete(Material persistentObject) {
		return jdbcTemplate.update(
			MATERIAL_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getMaterialId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				MATERIAL_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

}

