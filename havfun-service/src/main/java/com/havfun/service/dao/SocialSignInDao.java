package com.havfun.service.dao;

import com.havfun.service.entity.SocialSignIn;

public interface SocialSignInDao extends GenericDao<SocialSignIn, Integer>{

	public SocialSignIn readWithIdentifier(String provider, String identifier );
	
}
