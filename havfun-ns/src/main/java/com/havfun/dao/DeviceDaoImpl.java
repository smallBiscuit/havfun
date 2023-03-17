package com.havfun.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;


import com.havfun.entity.Device;
import com.havfun.servlet.LoggerManager;

public class DeviceDaoImpl implements DeviceDao{
	private static final Logger LOGGER = LoggerManager.getLogger( DeviceDaoImpl.class.getName() );
	
	private static String DEVICE_SELECT_SQL_BY_KEY = "select * from device where device_id = ?";

	private static String DEVICE_SELECT_SQL_READ_ALL = "select * from device";
	
	private static String DEVICE_SELECT_SQL_BY_USER_ID = "select * from device where user_id = ?";
	
	private static String DEVICE_UPDATE_SQL_BY_KEY = "update device set user_id = ?, name = ?, platform = ?, token = ? where device_id = ?";
	
	private static String DEVICE_DELETE_SQL_BY_KEY = "delete from user where user_id = ?";
	
	private DataSource dataSource;	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	protected DeviceRowMapper rowMapper;
	
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}

	@Override
	public Integer create(Device newInstance) {
		
		jdbcTemplate = new JdbcTemplate( dataSource );
		
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("device").usingGeneratedKeyColumns("device_id");
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("user_id", newInstance.getUserId() );
		parameters.put("name", newInstance.getName() );
		parameters.put("platform", newInstance.getPlatform().getValue() );
		parameters.put("token", newInstance.getToken() );
		
		LOGGER.info("rayTest parameters: " + parameters);
		
		Number key = simpleJdbcInsert.executeAndReturnKey(parameters);
		if ( key != null ){			
			return key.intValue();			
		}
		return 0;

	}

	@Override
	public Device read(Integer id) {
		
		Device device = null;
		
		jdbcTemplate = new JdbcTemplate( dataSource );
		
		try{			
			device = jdbcTemplate.queryForObject(
					DEVICE_SELECT_SQL_BY_KEY, 
					new DeviceRowMapper(), 
					new Object[]{
							id					
			});			
		}catch( IncorrectResultSizeDataAccessException e ){			
			return null;			
		}
		return device;		
	}
	
	@Override
	public int update(Device persistentObject) {
		
		jdbcTemplate = new JdbcTemplate( dataSource );
		
		return jdbcTemplate.update(
				DEVICE_UPDATE_SQL_BY_KEY,
				new Object[]{
						persistentObject.getUserId(),
						persistentObject.getName(),
						persistentObject.getPlatform(),
						persistentObject.getToken(),
						persistentObject.getDeviceId()
				});
	}

	@Override
	public int deleteByKey(Integer id) {
		
		jdbcTemplate = new JdbcTemplate( dataSource );
		
		return jdbcTemplate.update(
				DEVICE_DELETE_SQL_BY_KEY,
				new Object[]{
					id
				});
	}

	@Override
	public List<Device> readAll() {

		jdbcTemplate = new JdbcTemplate( dataSource );
		
		return jdbcTemplate.query(
					DEVICE_SELECT_SQL_READ_ALL, 
					new DeviceRowMapper(), 
					new Object[]{
						}
					);
	}
	
	
	@Override
	public Device readDeviceByUserId(int userId) {

		Device device = null;
		
		jdbcTemplate = new JdbcTemplate( dataSource );
		
		try{			
			device = jdbcTemplate.queryForObject(
					DEVICE_SELECT_SQL_BY_USER_ID, 
					new DeviceRowMapper(), 
					new Object[]{
						userId					
			});			
		}catch( IncorrectResultSizeDataAccessException e ){			
			return null;			
		}
		return device;	
	}
	

}
