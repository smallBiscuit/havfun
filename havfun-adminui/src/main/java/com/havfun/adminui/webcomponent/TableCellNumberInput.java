package com.havfun.adminui.webcomponent;

import java.text.DecimalFormat;

import com.havfun.adminui.utils.DisplayFormatHelper;

public class TableCellNumberInput {

	public static String renderHtml( int rowIndex, String key, Object value, Object origValue, int webComponentMode, int decimalPlace ){
		
		return renderHtml( rowIndex, key, value, origValue, webComponentMode, decimalPlace, -1, 0 );
		
	}
	
	public static String renderHtml( int rowIndex, String key, Object value, Object origValue, int webComponentMode, int decimalPlace, int minimum ){
		
		return renderHtml( rowIndex, key, value, origValue, webComponentMode, decimalPlace, minimum, 0 );
		
	}
	
	public static String renderHtml( int rowIndex, String key, Object value, Object origValue, int webComponentMode, int decimalPlace, int minimum, int maximum ){
		
		String valueString = WebComponentHelper.objectToString(value);
		String origValueString = WebComponentHelper.objectToString(origValue);
		String displayString = getDisplayStringWithValue( value, decimalPlace );
		String origDisplayString = origValueString;
		int width = 0;
		
		String name = "";
		
		if ( rowIndex >= 0 ){
			
			name = key + "_" + rowIndex;
			
		}
		
		
		String contentHtml = "";
		

		
		switch(webComponentMode){
			
			case WebComponent.MODE_EDITABLE:

				String textInputWidth = "90%";
				String minimumHtml = "";
				String maximumHtml = "";
				
				if ( width > 0 ){
					
					textInputWidth = width + "px";
					
				}
				
				if ( minimum >= 0 ){
					
					minimumHtml = "data-v-min=\"" + minimum + "\"";
					
				}
				
				if ( maximum > 0 ){
					
					maximumHtml = "data-v-max=\"" + maximum + "\"";
					
				}
				
				contentHtml = "<input type=\"text\" data-key=\""+ key + "\" class=\"web_component_input numberInput\" id=\"" + name + "\" value=\"" + valueString + "\" name=\"" + name + "\" data-m-dec=\"" + decimalPlace + "\" " + minimumHtml + "  " + maximumHtml + " style=\"width:" +  textInputWidth +"; margin: 2px 2px; text-align:right;\" \">";
				
				break;

			case WebComponent.MODE_READONLY:
			case WebComponent.MODE_DISABLED:

				contentHtml = "<input type=\"hidden\" data-key=\""+ key + "\" class=\"web_component_input\" id=\"" + name + "\" value=\"" + valueString + "\" name=\"" + name + "\" style=\"width:100px\"  readonly>";
				contentHtml += "<span>" + displayString + "</span>";
				
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
		
		
		return "<td class=\"align-right\"><div>" + contentHtml + "</div></td>";
		
		
	}
	
	private static String getDisplayStringWithValue( Object number, int decimalPlace ){
		
		String result = "";
		
		if ( number instanceof String ){
			
			return (String)number;
			
		}else{
		
			if ( decimalPlace == 0 ){
				
				result = DisplayFormatHelper.getDisplayValue((Number)number, DisplayFormatHelper.DISPLAY_NUMBER_FORMAT_QUANTITY );
		
			}else{
				
				String pattern = "#,###,##0.";
				
				for ( int i = 0; i < decimalPlace; i ++ ){
					
					pattern += "0";
					
				}
				
				
				DecimalFormat formatter = new DecimalFormat( pattern );
				
				result = formatter.format( number );
				
			}
		}
		
		return result;
		
	}
	
}

