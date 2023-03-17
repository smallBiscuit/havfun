package com.havfun.adminui.webcomponent;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.adminui.helper.DisplayFormatHelper;
import com.havfun.service.message.data.CustomizeProductBaseViewMessage;


public class CustomizeProductBaseViewList{

	/* static member */
	private static final Logger LOGGER = LogManager.getLogger(CustomizeProductBaseViewList.class.getName());
	
	public static String renderHtml( ResourceBundle resourceBundle, Object value, Object origValue, int webComponentMode ){
		
		LOGGER.debug("CustomizeProductBaseViewList.getWebComponentHtml");
		
		StringBuilder html = new StringBuilder();
		List<?> items = null;
		List<?> origItems  = null;
		int itemSize = 0;
		int origItemSize = 0;
		if(value != null && value instanceof List){
			items = (List<?>) value;
			itemSize = items.size();
		}
		if(origValue != null && origValue instanceof List){
			origItems = (List<?>) origValue;
			origItemSize = origItems.size();
		}

		List<String> countryList = new ArrayList<String>();
		List<String> countryLabelList = new ArrayList<String>();
		
		countryList.add( "HK" ); 
		countryList.add( "CN" ); 
		
		countryLabelList.add( "Hong Kong" ); 
		countryLabelList.add( "China" ); 
		
//		html.append( "</td></tr>" );
//		html.append( "<tr><td colspan=\"4\">" );
		
		html.append("<div class=\"add_customize_product_base_view left\"><a>");
		html.append(DisplayFormatHelper.getDisplayValueFromResourceBundle(resourceBundle, "product_add_view")).append("</a></div>");
		
		html.append("<div style=\"width:100%;overflow-x:scroll;\">");

		if (items != null) {
			
			for (int i = 0; i < itemSize; i++) {
				
				CustomizeProductBaseViewMessage viewMessage = (CustomizeProductBaseViewMessage) items.get(i);
				
//				html.append( "<tr><td colspan=\"4\">" );

				html.append( CustomizeProductBaseViewForm.renderHtml( i, viewMessage, resourceBundle, webComponentMode) );
				
//				html.append( "</td></tr>" );
			}
		}

		html.append("<div id=\"customize_product_view_list_last\"></div>");	
		
		html.append("</table></div>\n");		
		

		return html.toString();
	}
	
	
}
