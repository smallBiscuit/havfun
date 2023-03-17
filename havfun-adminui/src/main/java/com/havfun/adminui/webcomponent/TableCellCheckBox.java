package com.havfun.adminui.webcomponent;

import java.util.ResourceBundle;

public class TableCellCheckBox {

	
	
	public static String renderHtml( String key, Object value, Object origValue, int webComponentMode, ResourceBundle resourceBundle  ){
		
		return renderHtml( -1, key, value, origValue, webComponentMode, resourceBundle );
		
	}
	
	public static String renderHtml( int rowIndex, String key, Object value, Object origValue, int webComponentMode, ResourceBundle resourceBundle ){
		
		String valueString = WebComponentHelper.objectToString(value);
		String origValueString = WebComponentHelper.objectToString(origValue);


		String name = "";
		
		if ( rowIndex >= 0 ){
			
			name = key + "_" + rowIndex;
			
		}
		
		
		String contentHtml = "";
		
		String htmlCheckProperty = getHtmlCheckProperty( value, origValue );
		String cssColorFontClass = getCssColorFontClass( value, origValue );
		String htmlAmendedMessage = getHtmlAmendedMessage( value, origValue );


		
		//New
		String buttonYes = resourceBundle.getString("common_yes");
		String buttonNo = resourceBundle.getString("common_no");

		String htmlCheckboxFormat = "<input type=\"%s\" data-key=\"%s\" class=\"web_component_input\" id=\"%s\" name=\"%s\" %s %s %s />";
		htmlCheckboxFormat += "<label for=\"%s\" %s>";
		htmlCheckboxFormat += "<span class=\"checkboxLabelYes\">" + buttonYes + "</span>";
		htmlCheckboxFormat += "<span class=\"checkboxLabelNo\">" + buttonNo + "</span></label>";
		
		String htmlChangeValueFormat = "<div style=\"float:left;\" %s>%s</div>";
		
		switch(webComponentMode){
			
			case WebComponent.MODE_EDITABLE:

				contentHtml = String.format(htmlCheckboxFormat, "checkbox", key, name, name, htmlCheckProperty, "", "", name, "" );
				
				break;

			case WebComponent.MODE_READONLY:
			case WebComponent.MODE_DISABLED:
				if ( value != null ){
					
					contentHtml = String.format(htmlCheckboxFormat, "checkbox", key, name, name, htmlCheckProperty, "disabled", "style=\"cursor:default;\"", name, "style=\"cursor:default;\"" );
					
				}
				
				break;
				 
			case WebComponent.MODE_HIDDEN:

				contentHtml = String.format(htmlCheckboxFormat, "checkbox", key, name, name, htmlCheckProperty, "", "hidden", name, "style=\"display:none\"" );
				
				break;
				
			
			case WebComponent.MODE_PENDING_APPROVAL:	
				
				contentHtml = String.format(htmlCheckboxFormat, "checkbox", key, name, name, htmlCheckProperty, "disabled", "style=\"cursor:default;\"", name, "style=\"cursor:default;\"" );
				contentHtml += String.format(htmlChangeValueFormat, cssColorFontClass, htmlAmendedMessage);
				
				break;
		
			default:
				break;
		}
		
		
		return "<td>" + contentHtml + "</td>";
		
		
	}
	
	private static String getHtmlCheckProperty(Object value, Object origValue) {
		boolean isValueChecked = (value != null) ? ((Boolean) value).booleanValue() : false;
		boolean isOrigValueChecked = (origValue != null) ? ((Boolean) origValue).booleanValue() : false;

		if (value != null && isValueChecked) {

			return "checked=\"checked\"";
			
		}
		
		return "";
	}
	
	private static String getCssColorFontClass(Object value, Object origValue) {
		boolean isValueChecked = (value != null) ? ((Boolean) value).booleanValue() : false;
		boolean isOrigValueChecked = (origValue != null) ? ((Boolean) origValue).booleanValue() : false;

		if (value != null && isValueChecked) {

			if (origValue != null && !isOrigValueChecked) {
				return "class=\"blueFont\"";

			}
		} else if ((value != null && !isValueChecked) && (origValue != null && isOrigValueChecked)) {
			return "class=\"redFont\"";

		}
		
		return "";
	}
	
	private static String getHtmlAmendedMessage(Object value, Object origValue) {
		boolean isValueChecked = (value != null) ? ((Boolean) value).booleanValue() : false;
		boolean isOrigValueChecked = (origValue != null) ? ((Boolean) origValue).booleanValue() : false;

		if (value != null && isValueChecked) {

			if (origValue != null && !isOrigValueChecked) {

				return "(Checked)";
			}
		} else if ((value != null && !isValueChecked) && (origValue != null && isOrigValueChecked)) {

			return "(Unchecked)";
		}
		
		return "";
	}
	
}