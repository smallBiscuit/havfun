package com.havfun.adminui.webcomponent;

import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchTextInput extends WebComponent {

	private static final Logger LOGGER = LogManager.getLogger(SearchTextInput.class.getName());
	private static final String SEARCH_TEXT_INPUT_CLASS_CLIENT_ID = "autoCompleteClientId";
	private static final String SEARCH_TEXT_INPUT_CLASS_USER_ID = "autoCompleteUserId";
	private static final String SEARCH_TEXT_INPUT_CLASS_INSTRUMENT_CODE = "autoCompleteInstrumentCode";
	private static final String SEARCH_TEXT_INPUT_CLASS_AE_CLIENT_ID = "autoCompleteAeClientId";
	private static final String SEARCH_TEXT_INPUT_CLASS_DEFAULT = SEARCH_TEXT_INPUT_CLASS_CLIENT_ID;
	
	protected int maxLength;
	protected int type;
	protected String placeholder;
	protected String popUpRequest;

	public SearchTextInput(Map<String, Object> valueMap, int maxLength, int type) {
		super(valueMap);

		this.maxLength = maxLength;
		this.type = type;
		this.placeholder = "";
	}
	
	public SearchTextInput(Map<String, Object> valueMap, int maxLength, int type, String popUpRequest) {
		super(valueMap);

		this.maxLength = maxLength;
		this.type = type;
		this.popUpRequest = popUpRequest;
		this.placeholder = "";
	}
	
	public SearchTextInput(Map<String, Object> valueMap, int maxLength, int type, String popUpRequest, String placeholder) {
		super(valueMap);

		this.maxLength = maxLength;
		this.type = type;
		this.popUpRequest = popUpRequest;
		this.placeholder = placeholder;
	}	

	@Override
	public String getWebComponentHtml(ResourceBundle resourceBundle, int pageMode, List<String> choiceList,
			Object value, Object origValue) {

		return this.getWebComponentHtmlWithExtraHints(resourceBundle, pageMode, choiceList, value, origValue, null);
		
	}
	
	@Override
	public String getWebComponentHtmlWithExtraHints(ResourceBundle resourceBundle, int pageMode, List<String> choiceList,
			Object value, Object origValue, String extraHints){
		
		int webComponentMode = getComponentMode(pageMode);
		String valueString = objectToString(value);
		String origValueString = objectToString(origValue);
		String displayString = valueString;
		String origDisplayString = origValueString;

		String extraHintsString = objectToString( extraHints );
		
		boolean isValueChange = isValueChange(valueString, origValueString);
		
		String extraText = "";
		String classType = SEARCH_TEXT_INPUT_CLASS_DEFAULT;
		String readonlyTextFormat = "<input id=\"%s\" name=\"%s\" type=\"%s\" value=\"%s\"  readonly>";
		String extraTextFormat = "<a class=\"%s %s popUpContainer\" style=\"margin-left:5px; text-decoration: none; color:black;cursor:default;z-index:0;\" data-action=\"%s\" ></a>";
		String outputTextFormat = "<input id=\"%s\" name=\"%s\" type=\"%s\" class=\"%s web_component_input\" maxlength=\"%s\" %s\" value=\"%s\" placeholder=\"%s\" %s> %s";
		
		String extraHintsFormat = "<span style=\"margin-left:10px;\">( %s )</span>";
		
		//Used For Client redirect link only
		String displayStringFormatOpenTag = "";
		String displayStringFormatCloseTag = "";
		
		String labelEffectHtml = "<span class= \"%s\"> %s </span>";
		String finalHtml= "";

		switch (type) {
		case SEARCH_TEXT_INPUT_TYPE_CLIENT_ID:
			classType = SEARCH_TEXT_INPUT_CLASS_CLIENT_ID;
			extraText = String.format(extraTextFormat, key + "Info", "resultClientName", popUpRequest);
			if(this.popUpRequest!= null && !this.popUpRequest.equals("")){
				displayStringFormatOpenTag = "<span class=\"popUpContainer\" id=\"pos_" +  key + "\" " + "data-action=\"pop_up_client_long\">";
				displayStringFormatCloseTag = "</span>";
			}
	
			break;
		case SEARCH_TEXT_INPUT_TYPE_USER_ID:
			classType = SEARCH_TEXT_INPUT_CLASS_USER_ID;
			extraText = String.format(extraTextFormat, key + "Info", "resultUserName", popUpRequest);
			
			break;
		case SEARCH_TEXT_INPUT_TYPE_INSTRUMENT_CODE:
			classType = SEARCH_TEXT_INPUT_CLASS_INSTRUMENT_CODE;
			extraText = String.format(extraTextFormat, key + "Info", "resultInstrumentName", popUpRequest);

			break;
		case SEARCH_TEXT_INPUT_TYPE_AE_CLIENT_ID:
			classType = SEARCH_TEXT_INPUT_CLASS_AE_CLIENT_ID;
			extraText = String.format(extraTextFormat, key + "Info", "resultAeClientName", popUpRequest);
			if(this.popUpRequest!= null && !this.popUpRequest.equals("")){
				displayStringFormatOpenTag = "<span class=\"popUpContainer\" id=\"pos_" +  key + "\" " + "data-action=\"pop_up_client_long\">";
				displayStringFormatCloseTag = "</span>";
			}
			
			break;
		}
		
		switch(webComponentMode){
		
			case MODE_EDITABLE:
				
				finalHtml = String.format(outputTextFormat, key, key, "text", classType, maxLength, "", valueString, placeholder, "", extraText);
				break;
			
			case MODE_READONLY:
			case MODE_DISABLED:
			case MODE_HIDDEN:
			case MODE_PENDING_CONFIRM:
				
				finalHtml = String.format(readonlyTextFormat, key, key, "hidden", valueString);
				break;			
				
			default:

		}
		
		switch(webComponentMode){
		
			case MODE_EDITABLE: 				
			case MODE_HIDDEN:
				break;

			case MODE_READONLY:
			case MODE_DISABLED:				
				
				finalHtml+= displayStringFormatOpenTag + displayString;
				if(!extraHintsString.equals("")){
					finalHtml+= " " + "(" + extraHintsString + ")";
				}
				finalHtml += displayStringFormatCloseTag;
				
				break;
				
			case MODE_PENDING_CONFIRM:
				
				if(!isValueChange)
				{
					finalHtml+= displayStringFormatOpenTag + displayString;
					if(!extraHintsString.equals("")){
						finalHtml+= " " + "(" + extraHintsString + ")";
					}
					finalHtml += displayStringFormatCloseTag;
					
				}else{
					
					if(origValueString.equals("")){
						
						finalHtml += String.format(labelEffectHtml, "blueFont", displayString);
						
						if ( !extraHintsString.equals("") ){
							finalHtml += String.format( extraHintsFormat, extraHintsString);
						}
						
					}else{
						finalHtml += String.format(labelEffectHtml, "grayFont", origDisplayString) + " > " + String.format( labelEffectHtml, "redFont", displayString);
					}
				}
				
				break;
			
			default:
				break;
		}
		
		return finalHtml;

	}
	

}