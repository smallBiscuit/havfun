package com.havfun.adminui.webcomponent;

import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextInput extends WebComponent {

	private static final Logger LOGGER = LogManager.getLogger(TextInput.class.getName());

	protected int width;
	protected int maxLength;
	protected int convertType;
	protected String placeholder;

	public TextInput(Map<String, Object> valueMap, int maxLength) {
		super( valueMap);
		this.maxLength = maxLength;
		this.placeholder = "";
	}
	
	public TextInput(Map<String, Object> valueMap, int maxLength, String placeholder) {
		super( valueMap);
		this.maxLength = maxLength;
		this.placeholder = placeholder;
	}

	public TextInput(Map<String, Object> valueMap, int maxLength, int convertType) {
		super( valueMap);
		this.maxLength = maxLength;
		this.convertType = convertType;
		this.placeholder = "";
	}
	
	@Override
	public String getWebComponentHtml(ResourceBundle resourceBundle, int pageMode, List<String> choiceList, Object value, Object origValue) {
	
		int webComponentMode = getComponentMode(pageMode);
		String valueString = objectToString(value).trim();
		String origValueString = objectToString(origValue).trim();
		String displayString = valueString;
		String origDisplayString = origValueString;
		boolean isValueChange = isValueChange(valueString, origValueString);		
		String classString = "";
		String finalHtml = "";

		if ( maxLength > 50){
			classString = "longTextInput";
		}
		
		if(convertType > 0)
		{
			
			displayString = getConvertedValue(valueString, convertType);
			origDisplayString = getConvertedValue(origValueString, convertType);
			
		}
		

		String inputHtmlFormat = "<input type=\"%s\" id=\"%s\" name=\"%s\" maxlength=\"%s\" autocomplete=\"off\" value=\"%s\" class=\"%s web_component_input\" style=\"%s\" placeholder=\"%s\" >";
		switch(webComponentMode){
			
			case MODE_EDITABLE: 
				
				finalHtml = String.format(inputHtmlFormat, "text", key, key, maxLength, valueString, classString, "", getDisplay(resourceBundle, placeholder));
				break;
				
			case MODE_READONLY:
			case MODE_DISABLED:
			case MODE_HIDDEN:
			case MODE_PENDING_APPROVAL:

				
				finalHtml = String.format(inputHtmlFormat, "hidden", key, key, maxLength, valueString, classString, "", getDisplay(resourceBundle, placeholder));
					
				break;					
				
			default:
				break;
		}			


		
		//label part html code
		String labelEffectHtml = "<span class= \"%s\"> %s </span>";
	
		switch(webComponentMode){
		
			case MODE_EDITABLE: 				
			case MODE_HIDDEN:
				break;
				
			case MODE_READONLY:				
			case MODE_DISABLED:				

				finalHtml+= displayString;
	
				break;
				
			case MODE_PENDING_APPROVAL:
				
				if ( !isValueChange ){
					
					finalHtml+= displayString;
					
				}else{
						if(origValueString.equals("")){
				
							finalHtml+= String.format(labelEffectHtml, "blueFont", displayString);
						}else{	
									
							finalHtml+= String.format(labelEffectHtml, "grayFont", origDisplayString) + " > " + String.format( labelEffectHtml, "redFont", displayString);
					}			
				}									
								
				break;					
				
				default:
				break;
		}			
		
//		LOGGER.debug(finalHtml);
		return finalHtml;
	}
	
}