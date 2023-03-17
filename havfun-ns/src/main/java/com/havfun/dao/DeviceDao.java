package com.havfun.dao;

import java.util.List;

import com.havfun.entity.Device;

public interface DeviceDao extends GenericDao<Device, Integer>{

	public List<Device> readAll();
	
	public Device readDeviceByUserId( int userId );
	
}

