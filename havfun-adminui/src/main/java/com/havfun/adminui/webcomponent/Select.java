package com.havfun.adminui.webcomponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.adminui.helper.DisplayFormatHelper;

public class Select extends WebComponent {
	private static final Logger LOGGER = LogManager.getLogger(Select.class.getName());

	private static final String IGNORE_PREFIX = "cashVoucher|instrumentVoucher|instrumentPending|cashPending";

	private String style;
	private int width = 205;

	public Select(Map<String, Object> valueMap) {
		super(valueMap);
	}


	@Override
	public String getWebComponentHtml(ResourceBundle resourceBundle, int pageMode, List<String> choiceList,
			Object value, Object origValue) {
		
		return getWebComponentHtmlSelection( resourceBundle, pageMode, choiceList, null,
			value, origValue );
		
	}
		
	@Override
	public String getWebComponentHtmlSelection(ResourceBundle resourceBundle, int pageMode, List<String> choiceList, List<String> labelList,
			Object value, Object origValue) {

		int webComponentMode = getComponentMode(pageMode);
		
		String finalHtml = "";

		String valueString = objectToString(value);
		String origValueString = objectToString(origValue);
		boolean isValueChange = isValueChange(valueString, origValueString);
		
		if ( labelList == null) {
						
			labelList = new ArrayList<String>();
			
			//set labelList
			insertLabelListWithResourceBundle( choiceList, labelList, resourceBundle );			

		}
		
		switch(webComponentMode){
			
			case MODE_EDITABLE: 
				
				String selectionHtmlFormat = "<select id=\"%s\" name=\"%s\" class=\"web_component_input\" style=\"%s\">%s</select>";
				String optionListHtmFormat = "";
				
				style = "width:" + this.width + "px;";
				
				if (choiceList != null) {
					
					boolean selected = false;
					
					String optionHtmFormat = "<option value=\"%s\" %s>%s</option>";
					
					for ( int i = 0; i < choiceList.size(); i ++ ) {
						
						String option = choiceList.get( i );						
						String displayLabel = labelList.get( i );
						
						if (!selected && option.equals(String.valueOf(value))) {
							
							optionListHtmFormat += String.format(optionHtmFormat, option, "selected", displayLabel );
							
							selected = true;
						} else {
							
							optionListHtmFormat += String.format(optionHtmFormat, option, "", displayLabel );
							
						}
						
					}
					
					//No match value, add current value
					if ( !selected ){
						
						if ( valueString != null && !valueString.equals("") ){
							
							optionListHtmFormat += String.format(optionHtmFormat, valueString, "selected", valueString );
							
						}
						
					}
					
				}
		
				finalHtml = String.format(selectionHtmlFormat, key, key, style, optionListHtmFormat );
				
				break;
				
			case MODE_READONLY:
			case MODE_DISABLED:
			case MODE_HIDDEN:
			case MODE_PENDING_CONFIRM:

				String inputHtmlFormat = "<input type=\"%s\" id=\"%s\" name=\"%s\" value=\"%s\">";
				
				finalHtml = String.format(inputHtmlFormat, "hidden", key, key,  valueString );
					
				break;					
				
			default:
				break;
		}			

		
		//label part html code
		String labelEffectHtml = "<span class= \"%s\"> %s </span>";
	
		String origDisplayLabel = getSelectionLableWithValue( origValueString, choiceList, labelList );
		String displayLabel = getSelectionLableWithValue( valueString, choiceList, labelList );
		
		if ( origDisplayLabel == null ){
			origDisplayLabel = origValueString;
		}
		
		if ( displayLabel == null ){
			displayLabel = valueString;
		}
		
		switch(webComponentMode){
		
			case MODE_EDITABLE: 				
			case MODE_HIDDEN:
				break;
				
			case MODE_READONLY:				
			case MODE_DISABLED:				

				finalHtml+= displayLabel;
	
				break;
				
			case MODE_PENDING_CONFIRM:
				
				if ( !isValueChange ){
					
					finalHtml+= displayLabel;
					
				}else{
						if(origValueString.equals("")){
				
							finalHtml+= String.format(labelEffectHtml, "blueFont", displayLabel);
						}else{	
									
							finalHtml+= String.format(labelEffectHtml, "grayFont", origDisplayLabel) + " > " + String.format( labelEffectHtml, "redFont", displayLabel);
					}			
				}									
								
				break;					
				
				default:
				break;
		}		
		

		LOGGER.debug(finalHtml);
		return finalHtml;
		
	}

	private void insertLabelListWithResourceBundle( List<String> valueList, List<String> labelList, ResourceBundle resourceBundle){
		LOGGER.debug(valueList + " " + labelList );
		if ( valueList != null) {
			
			for ( int i = 0; i < valueList.size(); i ++ ) {
				
				String option = valueList.get( i );
				
				String labelKey = key.replaceAll( IGNORE_PREFIX , "") + "." + option;
				labelKey = labelKey.replaceFirst(labelKey.substring(0, 1), labelKey.substring(0, 1).toLowerCase());
				LOGGER.debug("LabelList " + labelKey);
				String displayLabel = DisplayFormatHelper.getDisplayValueFromResourceBundle(resourceBundle, labelKey);
				
				labelList.add( displayLabel );
				
			}
		}		
		
	}
	
	private String getSelectionLableWithValue( String value, List<String> valueList, List<String> labelList ){

		if ( valueList == null ) return null;
		
		if ( labelList == null ) return null;
		
		for ( int i = 0; i < valueList.size(); i ++ ){
		
			if ( value.equals( valueList.get(i) ) ){
				
				if ( labelList.get(i) != null ){
					return labelList.get(i);
				}else{
					
					return null;
				}
				
			}
		}
		
		return null;
	}
}