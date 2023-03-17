package com.havfun.adminui.webcomponent;

public class TableCellTextInput {

	public static String renderHtml( int rowIndex, String key, String value, String origValue, int webComponentMode ){
		
		return renderHtml( rowIndex, key, value, origValue, webComponentMode, 0, 100, "" );
		
	}
	
	public static String renderHtml( int rowIndex, String key, String value, String origValue, int webComponentMode, int width, int maxlength ){
		
		return renderHtml( rowIndex, key, value, origValue, webComponentMode, width, maxlength, "" );
		
	}
	
	public static String renderHtml( int rowIndex, String key, String value, String origValue, int webComponentMode, int width, int maxlength, String placeholder ){
		
		String contentHtml = TableCellTextInput.renderCellContentHtml(rowIndex, key, value, origValue, webComponentMode, width, maxlength, placeholder);
				
		return "<td><div>" + contentHtml + "</div></td>";		
		
	}
	
	public static String renderCellContentHtml( int rowIndex, String key, String value, String origValue, int webComponentMode, int width, int maxlength, String placeholder ){
		
		String valueString = WebComponentHelper.objectToString(value);
		String origValueString = WebComponentHelper.objectToString(origValue);
		String displayString = valueString;
		String origDisplayString = origValueString;

		String name = "";
		
		if ( rowIndex >= 0 ){
			
			name = key + "_" + rowIndex;
			
		}
		
		
		String contentHtml = "";
		

		
		switch(webComponentMode){
			
			case WebComponent.MODE_EDITABLE:

				String textInputWidth = "90%";
				
				if ( width > 0 ){
					
					textInputWidth = width + "px";
					
				}
				
				contentHtml = "<input type=\"text\" data-key=\""+ key + "\" class=\"web_component_input\" id=\"" + name + "\" value=\"" + valueString + "\" name=\"" + name + "\" style=\"width:" +  textInputWidth +"; margin: 2px 2px\" placeholder=\"" + placeholder + "\" maxlength=\"" + maxlength + "\">";
				
				break;

			case WebComponent.MODE_READONLY:
			case WebComponent.MODE_DISABLED:

				contentHtml = "<input type=\"hidden\" data-key=\""+ key + "\" class=\"web_component_input\" id=\"" + name + "\" value=\"" + valueString + "\" name=\"" + name + "\" style=\"width:100px\"  readonly>";
				contentHtml += displayString;
				
				break;
				 
			case WebComponent.MODE_HIDDEN:
				
				contentHtml = "<input type=\"hidden\" data-key=\""+ key + "\" class=\"web_component_input\" id=\"" + name + "\" value=\"" + valueString + "\" name=\"" + name + "\" style=\"width:100px\"  readonly>";
				
				break;
				
			
			case WebComponent.MODE_PENDING_APPROVAL:				
				
				boolean isValueChange = WebComponentHelper.isValueChange(valueString , origValueString);	
				String labelEffectHtml = "<span class= \"%s\"> %s </span>";
				
				if ( !isValueChange ){
					
					contentHtml = displayString;
					
				}else{
						if(origValueString.equals("")){
				
							contentHtml = String.format(labelEffectHtml, "blueFont", displayString);
						}else{	
									
							contentHtml = String.format(labelEffectHtml, "grayFont", origDisplayString) + " > " + String.format( labelEffectHtml, "redFont", displayString);
					}			
				}	
				
				contentHtml += "<input type=\"hidden\" data-key=\""+ key + "\" class=\"web_component_input\" id=\"" + name + "\" value=\"" + valueString + "\" name=\"" + name + "\" style=\"width:100px\"  readonly>";
				
				break;
		
			default:
				break;
		}
		
		
		return contentHtml;
		
		
	}
	
}
