package com.havfun.adminui.webcomponent;

import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextArea extends WebComponent {
	
	
	private static Logger LOGGER = LogManager.getLogger(TextArea.class.getName());
	
	public final static String TEXT_AREA_DISPLAY_STYLE_HIDDEN = "display: none;";
	public final static String TEXT_AREA_DISPLAY_STYLE_DISPLAY = "display: initial;";
	public final static String TEXT_AREA_DISPLAY_STYLE_DEFAULT = TEXT_AREA_DISPLAY_STYLE_DISPLAY;		

	protected int width;
	protected int maxLength;
	protected int rows;

	public TextArea(Map<String, Object> valueMap, int maxLength, int rows) {
		super( valueMap);

		this.maxLength = maxLength;
		this.rows = rows;
	}

	public TextArea(Map<String, Object> valueMap, int width, int maxLength, int rows) {
		super( valueMap);

		this.width = width;
		this.maxLength = maxLength;
		this.rows = rows;
	}

	@Override
	public String getWebComponentHtml(ResourceBundle resourceBundle, int pageMode, List<String> choiceList,
			Object value, Object origValue) {
		
		if (value == null) {
			value = "";
		}
		
		if (origValue == null) {
			origValue = "";
		}
		
		LOGGER.debug(getInputPartHtml( resourceBundle, pageMode, choiceList, value, origValue) + 
				getDisplayPartHtml( resourceBundle, pageMode, choiceList, value, origValue));
		
		return getInputPartHtml( resourceBundle, pageMode, choiceList, value, origValue) + 
				getDisplayPartHtml( resourceBundle, pageMode, choiceList, value, origValue);	

	}

	private String getInputPartHtml(ResourceBundle resourceBundle, int pageMode, List<String> choiceList, Object value, Object origValue) {
	
		int webComponentMode = getComponentMode(pageMode);
		
		String valueString = objectToString(value);
		
		String strHtmlFormat = "<textarea id=\"%s\" name=\"%s\" class=\" web_component_input\" maxlength=\"%s\" rows=\"%s\" style=\"%s\">%s</textarea>";
		String strHtml = "";
		
		switch(webComponentMode){
		
			case MODE_EDITABLE:
				
				strHtml = String.format(strHtmlFormat, key, key, maxLength, rows, TEXT_AREA_DISPLAY_STYLE_DISPLAY, valueString);
				break;
				
			case MODE_DISABLED:
			case MODE_READONLY:
			case MODE_HIDDEN:
			case MODE_PENDING_CONFIRM:
				strHtml = String.format(strHtmlFormat, key, key, maxLength, rows, TEXT_AREA_DISPLAY_STYLE_HIDDEN, valueString);
				break;
				
			
				
			default:
			
		}
		
		return strHtml;
	}
	
	private String getDisplayPartHtml(ResourceBundle resourceBundle, int pageMode, List<String> choiceList, Object value, Object origValue) {
	
		int webComponentMode = getComponentMode(pageMode);
		String valueString = objectToString(value);
		String origValueString = objectToString(origValue);
		boolean isValueChange = isValueChange(valueString, origValueString);
		
		String strHtmlDisplay = "<div style=\"float:left; width:200px;margin-right:20px;\">%s</div>";
		String strHtmlShowEffect = "<div class=\"%s\" style=\"%s\">%s</div>";
		String strHtml = "";
		
		switch(webComponentMode){
			
			case MODE_EDITABLE:
			case MODE_HIDDEN:	
				strHtml = String.format(strHtmlDisplay, "");
				break;
			
			case MODE_READONLY:
			case MODE_DISABLED:
				strHtml = String.format(strHtmlDisplay, valueString);
				break;
				
			case MODE_PENDING_CONFIRM:
			
			if( !isValueChange){
				strHtml = String.format(strHtmlDisplay, valueString);
			}else{
				
				if( origValueString.equals("") ){
					strHtml = String.format(strHtmlShowEffect, "blueFont", "float:left; width:200px;", valueString);
				}else{
					strHtml = String.format(strHtmlShowEffect, "grayFont", "float:left; width:200px;margin-right:20px;", origValueString);
					strHtml+= "<div style=\"vertical-align:middle; float: left;margin-right:20px;\"> > </div>";
					strHtml+= String.format(strHtmlShowEffect, "redFont", "float:left; width:200px;", valueString);
				}
			}
			
			break;
		
		default:
			
		}
		return strHtml;
	}		
	
}