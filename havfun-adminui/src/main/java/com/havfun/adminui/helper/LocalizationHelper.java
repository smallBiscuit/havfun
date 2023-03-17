package com.havfun.adminui.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class LocalizationHelper {

	private static final String FILE_LABEL = "Label";
	private static final String FILE_MENU = "Menu";
	private static final String FILE_RESULT = "Result";		
	
	private static final String LANG_EN = "en";
	private static final String LANG_ZH_CN = "zh_CN";
	private static final String LANG_ZH_HK = "zh_HK";	
	
	protected static String defaultFile = FILE_LABEL;
	protected static String defaultLang = LANG_ZH_HK;
	
	protected static Map<String, String> fileMap = new HashMap<String, String>();
	protected static Map<String, String> langMap = new HashMap<String, String>();

	static {
		fileMap.put(FILE_LABEL, FILE_LABEL);
		fileMap.put(FILE_MENU, FILE_MENU);
		fileMap.put(FILE_RESULT, FILE_RESULT);
		
		langMap.put(LANG_EN, LANG_EN);
		langMap.put(LANG_ZH_CN, LANG_ZH_CN);
		langMap.put(LANG_ZH_HK, LANG_ZH_HK);
	}	
		
	public static ResourceBundle getDefaultResourceBundle(){
		ResourceBundle labels = ResourceBundle.getBundle( defaultFile +"_"+ defaultLang);
		
		return labels;
	}
	
	public static ResourceBundle getResourceBundle( String lang ){
		ResourceBundle labels;
		
		if ( langMap.get(lang) != null ){
			labels = ResourceBundle.getBundle( defaultFile +"_"+ lang);
		}else{
			labels = getDefaultResourceBundle();
		}
		return labels;
	}
	
	public static ResourceBundle getResourceBundle( String file, String lang ){
		ResourceBundle labels;
		String finalFile = file;
		String finalLang = lang;
		
		if ( fileMap.get(file) == null ){
			finalFile = defaultFile;
		}
		if ( langMap.get(lang) == null ){
			finalLang = defaultLang;
		}
		
		labels = ResourceBundle.getBundle( finalFile +"_"+ finalLang);
		
		return labels;
	}
}
