package com.havfun.adminui.webcomponent;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.adminui.helper.DisplayFormatHelper;
import com.havfun.service.message.data.CustomizeProductColorItemMessage;


public class CustomizeProductColorDetailsList{

	/* static member */
	private static final Logger LOGGER = LogManager.getLogger(CustomizeProductColorDetailsList.class.getName());
	
	public static String renderHtml( ResourceBundle resourceBundle, Object value, Object origValue, int webComponentMode ){
		
		LOGGER.debug("CustomizeProductColorDetailsList.getWebComponentHtml");
		
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
		
		if ( webComponentMode == WebComponent.MODE_EDITABLE ){
			
			String enptyRowHtmlCode = "";
			
			enptyRowHtmlCode += TableCellTextInput.renderHtml( -1, "customize_product_color_id", "", "", WebComponent.MODE_READONLY  );
			enptyRowHtmlCode += TableCellTextInput.renderHtml( -1, "customize_product_color_file_type", "", "", webComponentMode );
			enptyRowHtmlCode += TableCellTextInput.renderHtml( -1, "customize_product_color_image_url", "", "", webComponentMode );
			enptyRowHtmlCode += TableCellTextInput.renderHtml( -1, "customize_product_color_parent_image", "", "", webComponentMode );

			enptyRowHtmlCode += TableCellButton.renderHtmlRemoveButton( resourceBundle.getString("common_delete_row"), webComponentMode );
			
			

			String addRowHtmlCode = "<div class=\"hide\" style=\"display:none\"><table id=\"customize_product_color_details_table_row_template\"><tr class=\"data_row\">" + enptyRowHtmlCode + "</tr></table></div>";
			
			html.append("<div class=\"btn_add_row left\" data-add-row-target=\"customize_product_color_details_table\" data-add-row-html-source=\"customize_product_color_details_table_row_template\"><a>");
			html.append(DisplayFormatHelper.getDisplayValueFromResourceBundle(resourceBundle, "product_add_color")).append("</a></div>");
			html.append(addRowHtmlCode);
			
		}
		
		html.append("<div style=\"width:100%;overflow-x:scroll;\">");
		html.append("<table class=\"display cell-border searchResultTable\" id=\"customize_product_color_details_table\" style=\"width:100%;\">");
		html.append("    <tr>");
		html.append("        <td style=\"width: 150px;\" class=\"form_label\">").append(DisplayFormatHelper.getDisplayValueFromResourceBundle(resourceBundle, "customize_product_color_id")).append("</td>");
		html.append("        <td style=\"width: 150px;\" class=\"form_label\">").append(DisplayFormatHelper.getDisplayValueFromResourceBundle(resourceBundle, "customize_product_color_file_type")).append("</td>");
		html.append("        <td style=\"width: 150px;\" class=\"form_label\">").append(DisplayFormatHelper.getDisplayValueFromResourceBundle(resourceBundle, "customize_product_color_image_url")).append("</td>");
		html.append("        <td style=\"width: 150px;\" class=\"form_label\">").append(DisplayFormatHelper.getDisplayValueFromResourceBundle(resourceBundle, "customize_product_color_parent_image")).append("</td>");
		html.append("    </tr>");
		
		if (items != null) {
			
			for (int i = 0; i < itemSize; i++) {
				
				CustomizeProductColorItemMessage colorItemMessage = (CustomizeProductColorItemMessage) items.get(i);
//				CustomizeProductColorItemMessage origColorItemMessage = null;
				
				int colorId = colorItemMessage.getColorId();
				String fileType = colorItemMessage.getFileType();
				String imageUrl = colorItemMessage.getImageUrl();
				String parentImage = colorItemMessage.getParentImage();
				
				if ( i%2 == 0 ){
				
					html.append("<tr id=\"row_" + i + "\" class=\"data_row searchResultTableRowEven\">");
					
				}else{
					
					html.append("<tr id=\"row_" + i + "\" class=\"data_row searchResultTableRowOdd\">");
					
				}
				
				
				html.append( TableCellTextInput.renderHtml( i, "customize_product_color_id", "" + colorId, "", WebComponent.MODE_READONLY ) );				
				html.append( TableCellTextInput.renderHtml( i, "customize_product_color_file_type", fileType, "", webComponentMode ) );
				html.append( TableCellTextInput.renderHtml( i, "customize_product_color_image_url", imageUrl, null, webComponentMode ) );
				html.append( TableCellTextInput.renderHtml( i, "customize_product_color_parent_image", parentImage, null, webComponentMode ) );

//				html.append( TableCellButton.renderHtmlRemoveButton( resourceBundle.getString("common_delete_row"), webComponentMode ) );
				
/*				
				//commissionDiscountType
				html.append( TableCellSelect.renderHtml( i, "address_country_id", 
						"" + countryId, 
						"", 
						countryList, 
						countryLabelList,
						webComponentMode ) );
*/					
				html.append("</tr>");				
				
			}
		}

		html.append("</table></div>\n");		
		

		return html.toString();
	}
	
	
}
