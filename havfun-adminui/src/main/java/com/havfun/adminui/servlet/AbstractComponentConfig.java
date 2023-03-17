package com.havfun.adminui.servlet;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.adminui.webcomponent.WebComponent;

public class AbstractComponentConfig {

	private static final Logger LOGGER = LogManager.getLogger(AbstractComponentConfig.class.getName());

	public static Map<String, Boolean> mandatoryMap = new HashMap<String, Boolean>();
	public static Map<String, Integer> indexMap = new HashMap<String, Integer>();	

	public static Map<String, Integer> createModeMap = new HashMap<String, Integer>();
	public static Map<String, Integer> updateModeMap = new HashMap<String, Integer>();
	public static Map<String, Integer> readOnlyModeMap = new HashMap<String, Integer>();
	public static Map<String, Integer> confirmModeMap = new HashMap<String, Integer>();

	public static Map<String, Object> getValueMapByKey(String key) {

		Map<String, Object> modeMap = new HashMap<String, Object>();

		if (key == null) {
			return modeMap;
		}

		modeMap.put(WebComponent.KEY_WEB_COMPONENT_KEY, key);

		if ( mandatoryMap.containsKey(key) ){
			modeMap.put( WebComponent.KEY_MANDATORY_FLAG,  true);
		}

		if ( indexMap.containsKey(key) ){
			modeMap.put( WebComponent.KEY_INDEX,  indexMap.get(key));
		}
		
		if (createModeMap.containsKey(key)) {
			modeMap.put(WebComponent.KEY_CREATE_MODE, createModeMap.get(key));
		}
		if (updateModeMap.containsKey(key)) {
			modeMap.put(WebComponent.KEY_UPDATE_MODE, updateModeMap.get(key));
		}
		if (readOnlyModeMap.containsKey(key)) {
			modeMap.put(WebComponent.KEY_READONLY_MODE, readOnlyModeMap.get(key));
		}
		if (confirmModeMap.containsKey(key)) {
			modeMap.put(WebComponent.KEY_CONFIRM_MODE, confirmModeMap.get(key));
		}
		
		LOGGER.debug("AbstractComponentConfig.getValueMapByKey(), {}", modeMap.toString());
		return modeMap;
	}
}
