package com.havfun.service.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum DevicePlatform {

	IOS("IOS"),
	
	ANDROID("AND"),	
	
	;
	
	private String value;
	
	private DevicePlatform( String value){
		
		this.value = value;
		
	}
	
	private static Map<String, DevicePlatform> DEVICE_PLATFORM_MAP = new HashMap<String, DevicePlatform>();
	
	static {
		
		for ( DevicePlatform devicePlatform : DevicePlatform.values() ){
			
			DEVICE_PLATFORM_MAP.put( devicePlatform.getValue(), devicePlatform );
			
		}
		
	}
	
	public static DevicePlatform fromValue( String value ){
		
		if ( value == null ){
			return null;
		}
		return DEVICE_PLATFORM_MAP.get( value );
	}
	
	public static List<String> keys(){
		
		List<String> keys = new ArrayList<String>();
		for ( DevicePlatform devicePlatform : DevicePlatform.values() ){
			
			keys.add( devicePlatform.getValue() );
			
		}
		return keys;
		
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}
