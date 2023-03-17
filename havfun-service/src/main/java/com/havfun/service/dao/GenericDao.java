package com.havfun.service.dao;

import java.io.Serializable;

public interface GenericDao <T, PK extends Serializable> {

	/**
	 * Persist the newInstance object into database
	 * 
	 * @param newInstance
	 * @return
	 */
    public PK create(T newInstance);

    /**
     * Retrieve an object that was previously persisted to the database using the indicated id as primary key
     * 
     * @param id
     * @return
     */
    public T read(PK id);

    /**
     * Save changes made to a persistent object.
     * 
     * @param transientObject
     * @return
     */
    public int update(T transientObject);

    /**
     * Remove an object from persistent storage in the database
     * 
     * @param persistentObject
     * @return
     */
    public int delete(T persistentObject);
    
    /**
     * 
     * @param id
     * @return
     */
    public int deleteByKey(PK id);
}
