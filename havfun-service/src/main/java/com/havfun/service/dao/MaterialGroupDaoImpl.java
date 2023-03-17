package com.havfun.service.dao;
import java.sql.Timestamp;
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
import com.havfun.service.dao.MaterialGroupDao;
import com.havfun.service.dao.MaterialGroupDaoImpl;
import com.havfun.service.entity.MaterialGroup;

public class MaterialGroupDaoImpl implements MaterialGroupDao {

	/** logger **/
	private final static Logger LOGGER = LogManager.getLogger(MaterialGroupDaoImpl.class);

	private final static String MATERIAL_GROUP_UPDATE_SQL_BY_KEY = "update materialGroup set  name_en = ?, name_hk = ?, name_cn = ?, image = ?, parent_id = ?, active = ?, last_modified_timestamp = ? where material_group_id = ?";

	private final static String MATERIAL_GROUP_SELECT_SQL_BY_KEY = "select * from material_group where material_group_id = ?";

	private final static String MATERIAL_GROUP_DELETE_SQL_BY_KEY = "delete from material_group where material_group_id = ?";

	private final static String MATERIAL_GROUP_SELECT_ALL_SQL = "select * from material_group";
	
	private final static String MATERIAL_GROUP_SELECT_ALL_BASIC_DATA_SQL = "select material_group_id, name_en, name_hk, name_cn, parent_id from material_group where active=1";
	
//	private final static String MATERIAL_GROUP_SELECT_SQL_BY_MATERIAL_GROUP_ID = "select * from material_group where user_name = ?";

	/** jdbc template **/
	@Resource(name = "havfunJdbcTemplate")
	protected JdbcTemplate jdbcTemplate;

	/** row mapper **/
	@Autowired
	protected RowMapper<MaterialGroup> rowMapper;

	@Override
	public Integer create(MaterialGroup newInstance) {

		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("material_group").usingGeneratedKeyColumns("material_group_id");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("material_group_id", newInstance.getMaterialGroupId());
		parameters.put("name_en", newInstance.getNameEn());
		parameters.put("name_hk", newInstance.getNameHk());
		parameters.put("name_cn", newInstance.getNameCn());
		parameters.put("image", newInstance.getImage());
		parameters.put("parent_id", newInstance.getParentId());
		parameters.put("active", newInstance.isActive()?"1":"0");
		parameters.put("create_timestamp", new Timestamp( System.currentTimeMillis() ) );
		parameters.put("last_modified_timestamp", new Timestamp( System.currentTimeMillis() ) );
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if (key != null) {
			return key.intValue();
		}

		return null;
	}

	@Override
	public MaterialGroup read(Integer id) {
		MaterialGroup materialGroup = null;
		try {
			materialGroup = jdbcTemplate.queryForObject(
			MATERIAL_GROUP_SELECT_SQL_BY_KEY,
			rowMapper,
			new Object [] {
			id
			}
				);
			} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

		return materialGroup;
	}

	@Override
	public int update(MaterialGroup transientObject) {
		return jdbcTemplate.update(
				MATERIAL_GROUP_UPDATE_SQL_BY_KEY,
				new Object [] {
					transientObject.getNameEn(),
					transientObject.getNameHk(),
					transientObject.getNameCn(),
					transientObject.getImage(),
					transientObject.getParentId(),
					transientObject.isActive()?"1":"0",
					new Timestamp( System.currentTimeMillis() ),
					transientObject.getMaterialGroupId(),

				}
			);
	}

	@Override
	public int delete(MaterialGroup persistentObject) {
		return jdbcTemplate.update(
			MATERIAL_GROUP_DELETE_SQL_BY_KEY,
			new Object [] {
					persistentObject.getMaterialGroupId()
			}
			);
	}

	@Override
	public int deleteByKey(Integer id) {
		return jdbcTemplate.update(
				MATERIAL_GROUP_DELETE_SQL_BY_KEY,
				new Object [] {
						id
				}
				);
	}

	@Override
	public List<MaterialGroup> readAll() {
		return jdbcTemplate.query(
				MATERIAL_GROUP_SELECT_ALL_SQL, 
				rowMapper, 
					new Object[]{
						}
					);
	}
	
	@Override
	public List<MaterialGroup> readAllBasicData() {
		return jdbcTemplate.query(
				MATERIAL_GROUP_SELECT_ALL_BASIC_DATA_SQL, 
				rowMapper, 
					new Object[]{
						}
					);
	}

}

