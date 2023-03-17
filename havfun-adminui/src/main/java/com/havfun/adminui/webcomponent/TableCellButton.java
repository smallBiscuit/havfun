package com.havfun.adminui.webcomponent;

public class TableCellButton {

	public static String renderHtmlCustomizeButton( String key, String label, int webComponentMode ){
		
		if ( webComponentMode != WebComponent.MODE_EDITABLE ){
			
			return "<td></td>";
			
		}
		
		String contentHtml = "";
		
		contentHtml = "<td><div data-key=\"" + key  + "\" class=\"btn_common_small " + key  + "\" id=\"" + key  + "\" style=\"float:right;\">" + label + "</div></td>";
				
		return contentHtml;
		
	}
	
	public static String renderHtmlRemoveButton( String label, int webComponentMode ){
		
		if ( webComponentMode != WebComponent.MODE_EDITABLE ){
			
			return "<td></td>";
			
		}
		
		String contentHtml = "";
		
		contentHtml = "<td><div data-key=\"btn_remove\" class=\"btn_common_sell_small btn_remove\" id=\"btn_remove_\" style=\"float:right;\">" + label + "</div></td>";
				
		return contentHtml;
		
	}
	
}
