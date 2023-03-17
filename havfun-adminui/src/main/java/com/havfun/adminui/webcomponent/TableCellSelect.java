package com.havfun.adminui.webcomponent;

import java.util.List;

public class TableCellSelect {

	public static String renderHtml( String key, String value, String origValue, List<String> valueList, List<String> labelList, int webComponentMode ){
		
		return renderHtml( -1, key, value, origValue, valueList, labelList, webComponentMode );
		
	}
	
	public static String renderHtml( int rowIndex, String key, String value, String origValue, List<String> valueList, List<String> labelList, int webComponentMode ){
		
		String contentHtml = "";
		String valueString = WebComponentHelper.objectToString(value);
		String origValueString = WebComponentHelper.objectToString(origValue);
		String selectedLabel = valueString;
		String origSelectedLabel = origValueString;
		
		String name = "";
		
		if ( rowIndex >= 0 ){
			
			name = key + "_" + rowIndex;
			
		}
		
		if ( valueList == null || labelList == null ){
			
			return "";
			
		}
		
		switch(webComponentMode){
			
			case WebComponent.MODE_EDITABLE:

				contentHtml += "<select type=\"text\" data-key=\""+ key + "\" class=\"web_component_input\" id=\"" + name + "\" name=\"" + name + "\" style=\"width:auto;\">";
				
				boolean matched = false;
				
				for ( int i = 0; i < valueList.size(); i ++ ){
					
					String optionValue = valueList.get(i);
					String optionLabel = labelList.get(i);
					
					if ( valueString.equals( optionValue ) ){
						
						contentHtml += "<option value=\"" + optionValue + "\" selected>" + optionLabel+ "</option>";
						
						matched = true;
						
					}else{
						
						contentHtml += "<option value=\"" + optionValue + "\">" + optionLabel+ "</option>";
						
					}
				}
				
				if ( ! matched ){
					
					contentHtml += "<option value=\"\" selected></option>";
					
				}
				
				contentHtml += "</select>";
				
				break;

			case WebComponent.MODE_READONLY:
			case WebComponent.MODE_DISABLED:

				for ( int i = 0; i < valueList.size(); i ++ ){
					
					String optionValue = valueList.get(i);
					String optionLabel = labelList.get(i);
					
					if ( valueString.equals( optionValue ) ){
						
						selectedLabel = optionLabel;
						
					}
				}
				
				contentHtml = "<span>" + selectedLabel + "</span>";
				contentHtml += "<input type=\"hidden\" data-key=\""+ key + "\" class=\"web_component_input\" id=\"" + name + "\" value=\"" + valueString + "\" name=\"" + name + "\" style=\"width:100px\"  readonly>";
				
				break;
				 
			case WebComponent.MODE_HIDDEN:
				
				contentHtml = "<input type=\"hidden\" data-key=\""+ key + "\" class=\"web_component_input\" id=\"" + name + "\" value=\"" + valueString + "\" name=\"" + name + "\" style=\"width:100px\"  readonly>";
				
				break;
				
			
			case WebComponent.MODE_PENDING_APPROVAL:	
				
				boolean isValueChange = WebComponentHelper.isValueChange(valueString , origValueString);	
				String labelEffectHtml = "<span class= \"%s\"> %s </span>";
				
				for ( int i = 0; i < valueList.size(); i ++ ){
					
					String optionValue = valueList.get(i);
					String optionLabel = labelList.get(i);
					
					if ( valueString.equals( optionValue ) ){
						
						selectedLabel = optionLabel;
						
					}else if ( origValueString.equals( optionValue ) ){
						
						origSelectedLabel = optionLabel;
						
					}
				}
				
				
				if ( !isValueChange ){
					
					contentHtml = "<span>" + String.format(labelEffectHtml, "grayFont", selectedLabel) + "</span>";					
					
				}else{
					
						if(origValueString.equals("")){
				
							contentHtml = String.format(labelEffectHtml, "blueFont", selectedLabel);
						}else{	
									
							contentHtml = String.format(labelEffectHtml, "grayFont", origSelectedLabel) + " > " + String.format( labelEffectHtml, "redFont", selectedLabel);
					}			
				}		
				
				contentHtml += "<input type=\"hidden\" data-key=\""+ key + "\" class=\"web_component_input\" id=\"" + name + "\" value=\"" + valueString + "\" name=\"" + name + "\" style=\"width:100px\"  readonly>";
				
				break;
		
			default:
				break;
		}
		
		
		return "<td>" + contentHtml + "</td>";
		
		
	}
	
}
