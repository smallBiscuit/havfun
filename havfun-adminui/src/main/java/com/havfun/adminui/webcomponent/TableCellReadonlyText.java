package com.havfun.adminui.webcomponent;

public class TableCellReadonlyText {

public static String renderHtml( String key, String value, String origValue, int webComponentMode ){
		
		return renderHtml( -1, key, value, origValue, webComponentMode );
		
	}
	
	public static String renderHtml( int rowIndex, String key, String value, String origValue, int webComponentMode ){
		
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
			case WebComponent.MODE_READONLY:
			case WebComponent.MODE_DISABLED:

				contentHtml = "<input type=\"text\" data-key=\""+ key + "\" class=\"web_component_input\" id=\"" + name + "\" value=\"" + valueString + "\" name=\"" + name + "\" style=\"width:100px\"  readonly>";
				
				break;
				 
			case WebComponent.MODE_HIDDEN:
				
				contentHtml = "<input type=\"text\" data-key=\""+ key + "\" class=\"web_component_input\" id=\"" + name + "\" value=\"" + valueString + "\" name=\"" + name + "\" style=\"width:100px\"  readonly>";
				
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
				
				contentHtml += "<input type=\"hidden\" data-key=\""+ key + "\" class=\"web_component_input\" id=\"" + name + "\" value=\" " + valueString + "\" name=\"" + name + "\" style=\"width:100px\"  readonly>";
				
				break;
		
			default:
				break;
		}
		
		
		return "<td>" + contentHtml + "</td>";
		
		
	}
		
}
