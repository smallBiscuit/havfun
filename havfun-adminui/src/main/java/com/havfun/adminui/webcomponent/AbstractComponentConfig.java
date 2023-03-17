package com.havfun.adminui.webcomponent;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AbstractComponentConfig {

	private static final Logger LOGGER = LogManager.getLogger(AbstractComponentConfig.class.getName());

	public static String MAKER_ID = "makerId";
	public static String MAKER_NAME = "makerName";
	public static String MAKER_NOTE = "makerNote";
	public static String CHECKER_ID = "checkerId";
	public static String CHECKER_NAME = "checkerName";
	public static String CHECKER_NOTE = "checkerNote";
	public static String APPROVAL_ID = "approvalId";
	public static String APPROVAL_STATUS = "approvalStatus";
	public static String APPROVAL_ACTION = "approvalAction";
	public static String REQUEST_ACTION = "requestAction";

	public static Map<String, Boolean> mandatoryMap = new HashMap<String, Boolean>();
	public static Map<String, Integer> indexMap = new HashMap<String, Integer>();	

	public static Map<String, Integer> createModeMap = new HashMap<String, Integer>();
	public static Map<String, Integer> updateModeMap = new HashMap<String, Integer>();
	public static Map<String, Integer> readOnlyModeMap = new HashMap<String, Integer>();
	public static Map<String, Integer> confirmModeMap = new HashMap<String, Integer>();

	public static Map<String, Integer> labelWidthMap = new HashMap<String, Integer>();

	static {
		createModeMap.put(MAKER_ID, WebComponent.MODE_HIDDEN);
		createModeMap.put(MAKER_NAME, WebComponent.MODE_HIDDEN);
		createModeMap.put(MAKER_NOTE, WebComponent.MODE_EDITABLE);
		createModeMap.put(CHECKER_ID, WebComponent.MODE_READONLY);
		createModeMap.put(CHECKER_NAME, WebComponent.MODE_HIDDEN);
		createModeMap.put(CHECKER_NOTE, WebComponent.MODE_READONLY);
		createModeMap.put(APPROVAL_ID, WebComponent.MODE_HIDDEN);
		createModeMap.put(APPROVAL_STATUS, WebComponent.MODE_HIDDEN);
		createModeMap.put(APPROVAL_ACTION, WebComponent.MODE_HIDDEN);
		createModeMap.put(REQUEST_ACTION, WebComponent.MODE_HIDDEN);

		updateModeMap.put(MAKER_ID, WebComponent.MODE_READONLY);
		updateModeMap.put(MAKER_NAME, WebComponent.MODE_HIDDEN);
		updateModeMap.put(MAKER_NOTE, WebComponent.MODE_EDITABLE);
		updateModeMap.put(CHECKER_ID, WebComponent.MODE_HIDDEN);
		updateModeMap.put(CHECKER_NAME, WebComponent.MODE_HIDDEN);
		updateModeMap.put(CHECKER_NOTE, WebComponent.MODE_HIDDEN);
		updateModeMap.put(APPROVAL_ID, WebComponent.MODE_HIDDEN);
		updateModeMap.put(APPROVAL_STATUS, WebComponent.MODE_HIDDEN);
		updateModeMap.put(APPROVAL_ACTION, WebComponent.MODE_HIDDEN);
		updateModeMap.put(REQUEST_ACTION, WebComponent.MODE_HIDDEN);

		readOnlyModeMap.put(MAKER_ID, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(MAKER_NAME, WebComponent.MODE_HIDDEN);
		readOnlyModeMap.put(MAKER_NOTE, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(CHECKER_ID, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(CHECKER_NAME, WebComponent.MODE_HIDDEN);
		readOnlyModeMap.put(CHECKER_NOTE, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(APPROVAL_ID, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(APPROVAL_STATUS, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(APPROVAL_ACTION, WebComponent.MODE_READONLY);
		readOnlyModeMap.put(REQUEST_ACTION, WebComponent.MODE_HIDDEN);

		confirmModeMap.put(MAKER_ID, WebComponent.MODE_READONLY);
		confirmModeMap.put(MAKER_NAME, WebComponent.MODE_HIDDEN);
		confirmModeMap.put(MAKER_NOTE, WebComponent.MODE_PENDING_CONFIRM);
		confirmModeMap.put(CHECKER_ID, WebComponent.MODE_HIDDEN);
		confirmModeMap.put(CHECKER_NAME, WebComponent.MODE_HIDDEN);
		confirmModeMap.put(CHECKER_NOTE, WebComponent.MODE_EDITABLE);
		confirmModeMap.put(APPROVAL_ID, WebComponent.MODE_READONLY);
		confirmModeMap.put(APPROVAL_STATUS, WebComponent.MODE_READONLY);
		confirmModeMap.put(APPROVAL_ACTION, WebComponent.MODE_EDITABLE);
		confirmModeMap.put(REQUEST_ACTION, WebComponent.MODE_HIDDEN);

		
	}

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
		
		if (labelWidthMap.containsKey(key)) {
			modeMap.put(WebComponent.KEY_LABEL_WIDTH, labelWidthMap.get(key));
		} else {
			modeMap.put(WebComponent.KEY_LABEL_WIDTH, 200);
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