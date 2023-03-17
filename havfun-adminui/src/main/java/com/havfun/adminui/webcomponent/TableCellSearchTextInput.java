package com.havfun.adminui.webcomponent;

public class TableCellSearchTextInput {

	private static final String SEARCH_TEXT_INPUT_CLASS_CLIENT_ID = "autoCompleteClientId";
	private static final String SEARCH_TEXT_INPUT_CLASS_USER_ID = "autoCompleteUserId";
	private static final String SEARCH_TEXT_INPUT_CLASS_INSTRUMENT_CODE = "autoCompleteInstrumentCode";
	private static final String SEARCH_TEXT_INPUT_CLASS_AE_CLIENT_ID = "autoCompleteAeClientId";
	private static final String SEARCH_TEXT_INPUT_CLASS_DEFAULT = SEARCH_TEXT_INPUT_CLASS_CLIENT_ID;
	
	public static String renderHtml( int rowIndex, String key, String value, String origValue, int webComponentMode, int type ){
	
		return renderHtml( rowIndex, key, value, origValue, webComponentMode, type, "", "" );
		
	}
	
	public static String renderHtml( int rowIndex, String key, String value, String origValue, int webComponentMode, int type, String extraHintsLabel, String origExtraHintsLabel ){
		
		String valueString = WebComponentHelper.objectToString(value);
		String origValueString = WebComponentHelper.objectToString(origValue);
		String displayString = valueString;
		String origDisplayString = origValueString;

		String name = "";
		String placeholder = "";
		String extraHintsClass= "";
		String finalExtraHintsLabel = "";
		String finalOrigExtraHintsLabel = "";
		
		if ( rowIndex >= 0 ){
			
			name = key + "_" + rowIndex;
			
		}
		
		if ( extraHintsLabel != null && !extraHintsLabel.equals( "" ) ){
			finalExtraHintsLabel += "(" + extraHintsLabel + ")";
		}
		
		if ( origExtraHintsLabel != null && !origExtraHintsLabel.equals( "" ) ){
			finalOrigExtraHintsLabel += "(" + origExtraHintsLabel + ")";
		}
		
		
		String classType = SEARCH_TEXT_INPUT_CLASS_DEFAULT;
		
		if ( type == WebComponent.SEARCH_TEXT_INPUT_TYPE_CLIENT_ID ){
			
			classType = SEARCH_TEXT_INPUT_CLASS_CLIENT_ID;
					
			extraHintsClass = "resultClientName";
			
		}else if ( type == WebComponent.SEARCH_TEXT_INPUT_TYPE_USER_ID ){
			
			classType = SEARCH_TEXT_INPUT_CLASS_USER_ID;
					
		}else if ( type == WebComponent.SEARCH_TEXT_INPUT_TYPE_INSTRUMENT_CODE ){
			
			classType = SEARCH_TEXT_INPUT_CLASS_INSTRUMENT_CODE;
			
			placeholder = "i.e. 388.XHKG";
						
			extraHintsClass = "resultInstrumentName";
			
		}
		
		String readonlyTextFormat = "<input id=\"%s\" name=\"%s\" type=\"%s\" value=\"%s\"  readonly>";
		String outputTextFormat = "<input id=\"%s\" name=\"%s\" type=\"%s\" class=\"%s web_component_input\" maxlength=\"%s\" %s\" value=\"%s\" placeholder=\"%s\" %s> %s";
		
		String extraHintsFormat = "<span style=\"margin-left:10px;\">( %s )</span>";
				
		String contentHtml = "";
		/*
		switch ( type ) {
		case SEARCH_TEXT_INPUT_TYPE_CLIENT_ID:
			classType = SEARCH_TEXT_INPUT_CLASS_CLIENT_ID;
			
			if ( valueString.equals("0") ){
				
				valueString = "";
				
			}
			
			break;
		}
		*/
		switch(webComponentMode){
			
			case WebComponent.MODE_EDITABLE:

				contentHtml = "<input type=\"text\" data-key=\""+ key + "\" class=\"web_component_input " + classType + "\" id=\"" + name + "\" value=\"" + valueString + "\" name=\"" + name + "\" style=\"width:100px; margin: 2px 2px\" placeholder=\""+ placeholder +"\"\">";
				
				contentHtml += "<span class=\"" + extraHintsClass + "\" style=\"margin-left:5px;\" >" + extraHintsLabel + "</span>";
						
				break;

			case WebComponent.MODE_READONLY:
			case WebComponent.MODE_DISABLED:

				contentHtml = "<input type=\"hidden\" data-key=\""+ key + "\" class=\"web_component_input\" id=\"" + name + "\" value=\"" + valueString + "\" name=\"" + name + "\" style=\"width:100px\"  readonly>";
				contentHtml += displayString + " " + finalExtraHintsLabel;
				
				break;
				 
			case WebComponent.MODE_HIDDEN:
				
				contentHtml = "<input type=\"hidden\" data-key=\""+ key + "\" class=\"web_component_input\" id=\"" + name + "\" value=\"" + valueString + "\" name=\"" + name + "\" style=\"width:100px\"  readonly>";
				
				break;
				
			
			case WebComponent.MODE_PENDING_APPROVAL:				
				
				boolean isValueChange = WebComponentHelper.isValueChange(valueString , origValueString);	
				String labelEffectHtml = "<span class= \"%s\"> %s </span>";
				
				if ( !isValueChange ){
					
					contentHtml = displayString + " " + finalExtraHintsLabel;
					
				}else{
						if(origValueString.equals("")){
				
							contentHtml = String.format(labelEffectHtml, "blueFont", displayString + " " + finalExtraHintsLabel );
							
						}else{	
									
							contentHtml = String.format(labelEffectHtml, "grayFont", origDisplayString + " " + finalOrigExtraHintsLabel ) + " > " + String.format( labelEffectHtml, "redFont", displayString + " " + finalExtraHintsLabel );
					}			
				}	
				
				contentHtml += "<input type=\"hidden\" data-key=\""+ key + "\" class=\"web_component_input\" id=\"" + name + "\" value=\" " + valueString + "\" name=\"" + name + "\" style=\"width:100px\"  readonly>";
				
				break;
		
			default:
				break;
		}
		
		
		return "<td>" + contentHtml + "</td>";
		
		
	}
	
}
