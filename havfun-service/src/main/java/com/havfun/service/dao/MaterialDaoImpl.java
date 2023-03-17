package com.havfun.service.dao;
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
import com.havfun.service.dao.MaterialDao;
import com.havfun.service.dao.MaterialDaoImpl;
import com.havfun.service.entity.Material;

public class MaterialDaoImpl implements MaterialDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(MaterialDaoImpl.class);

	private final static String MATERIAL_UPDATE_SQL_BY_KEY = "update material set image = ?, material_group_id = ?, material_index = ?,active = ? where material_id = ?";

	private final static String MATERIAL_SELECT_SQL_BY_KEY = "select * from material where material_id = ?";

	private final static String MATERIAL_DELETE_SQL_BY_KEY = "delete from material where material_id = ?";

	private final static String MATERIAL_SELECT_ALL_SQL = "select * from material";

	private final static String MATERIAL_SELECT_SQL_BY_MATERIAL_GROUP_ID = "select * from material where material_group_id = ?";

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
		parameters.put("image", newInstance.getImage());
		parameters.put("material_group_id", newInstance.getMaterialGroupId());
		parameters.put("material_index", newInstance.getMaterialIndex());
		parameters.put("active", newInstance.isActive()?1:0);
		parameters.put("create_timestamp", System.currentTimeMillis() );
		
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
					transientObject.getImage(),
					transientObject.getMaterialGroupId(),
					transientObject.getMaterialIndex(),
					transientObject.isActive()?1:0,
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

	@Override
	public List<Material> readAll() {
		return jdbcTemplate.query(
				MATERIAL_SELECT_ALL_SQL, 
				rowMapper, 
					new Object[]{
						}
					);
	}

	@Override
	public List<Material> readByGroupId(int groupId) {
		return jdbcTemplate.query(
				MATERIAL_SELECT_SQL_BY_MATERIAL_GROUP_ID, 
				rowMapper, 
					new Object[]{
							groupId
						}
					);
	}

}

