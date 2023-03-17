package com.havfun.dao;

import java.io.Serializable;

public interface GenericDao <T, PK extends Serializable>{

	public PK create(T newInstance );
	
	public T read(PK id);
	
	public int update(T persistentObject);
	
	public int deleteByKey(PK id);
}

