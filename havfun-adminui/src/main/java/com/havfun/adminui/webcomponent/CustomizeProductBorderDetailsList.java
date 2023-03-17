package com.havfun.adminui.webcomponent;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.adminui.helper.DisplayFormatHelper;
import com.havfun.service.message.data.CustomizeProductBorderItemMessage;


public class CustomizeProductBorderDetailsList{

	/* static member */
	private static final Logger LOGGER = LogManager.getLogger(CustomizeProductBorderDetailsList.class.getName());
	
	public static String renderHtml( int index, ResourceBundle resourceBundle, Object value, Object origValue, int webComponentMode ){
		
		LOGGER.debug("CustomizeProductBorderDetailsList.getWebComponentHtml");
		
		String templateSelector = "customize_product_border_details_table_row_template_" + index;
		String tableSelector = "customize_product_border_details_table_" + index;
		String tableClassSelector = "customize_product_border_details_table";
		
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
			
			enptyRowHtmlCode += TableCellTextInput.renderHtml( -1, "customize_product_border_id_" + index , "", "", WebComponent.MODE_READONLY  );
			enptyRowHtmlCode += TableCellTextInput.renderHtml( -1, "customize_product_border_item_key_" + index , "", "", webComponentMode );
			enptyRowHtmlCode += TableCellTextInput.renderHtml( -1, "customize_product_border_item_type_" + index , "", "", webComponentMode );
			enptyRowHtmlCode += TableCellTextInput.renderHtml( -1, "customize_product_border_title_" + index , "", "", webComponentMode );
			enptyRowHtmlCode += TableCellTextInput.renderHtml( -1, "customize_product_border_default_option_" + index , "", "", webComponentMode );
			enptyRowHtmlCode += TableCellNumberInput.renderHtml( -1, "customize_product_border_cost_" + index , "", "", webComponentMode, 2, 0 );
			enptyRowHtmlCode += TableCellNumberInput.renderHtml( -1, "customize_product_border_x_" + index , "", "", webComponentMode, 0, 0 );
			enptyRowHtmlCode += TableCellNumberInput.renderHtml( -1, "customize_product_border_y_" + index , "", "", webComponentMode, 0, 0 );
			enptyRowHtmlCode += TableCellNumberInput.renderHtml( -1, "customize_product_border_width_" + index , "", "", webComponentMode, 0, 0 );
			enptyRowHtmlCode += TableCellNumberInput.renderHtml( -1, "customize_product_border_height_" + index , "", "", webComponentMode, 0, 0 );
			
			enptyRowHtmlCode += TableCellButton.renderHtmlRemoveButton( resourceBundle.getString("common_delete_row"), webComponentMode );
			
			

			String addRowHtmlCode = "<div class=\"hide\" style=\"display:none\"><table id=\"" + templateSelector + "\"><tr class=\"data_row\">" + enptyRowHtmlCode + "</tr></table></div>";
			
			html.append("<div class=\"btn_add_row left\" data-add-row-target=\"" + tableSelector + "\" data-add-row-html-source=\"" + templateSelector + "\"><a>");
			html.append( DisplayFormatHelper.getDisplayValueFromResourceBundle(resourceBundle, "product_add_border")).append("</a></div>");
			html.append(addRowHtmlCode);
			
		}
		
		html.append("<div style=\"width:100%;overflow-x:scroll;\">");
		html.append("<table class=\"display cell-border searchResultTable " + tableClassSelector + " \" id=\"" + tableSelector + "\" style=\"width:100%;\">");
		html.append("    <tr>");
		html.append("        <td style=\"width: 150px;\" class=\"form_label\">").append( "Border ID" ).append("</td>");
		html.append("        <td style=\"width: 150px;\" class=\"form_label\">").append( "Item Key" ).append("</td>");
		html.append("        <td style=\"width: 150px;\" class=\"form_label\">").append( "Item Type" ).append("</td>");
		html.append("        <td style=\"width: 150px;\" class=\"form_label\">").append( "Title" ).append("</td>");
		html.append("        <td style=\"width: 100px;\" class=\"form_label\">").append( "Default" ).append("</td>");
		html.append("        <td style=\"width: 100px;\" class=\"form_label\">").append( "Cost" ).append("</td>");
		html.append("        <td style=\"width: 100px;\" class=\"form_label\">").append( "X" ).append("</td>");
		html.append("        <td style=\"width: 100px;\" class=\"form_label\">").append( "Y" ).append("</td>");
		html.append("        <td style=\"width: 100px;\" class=\"form_label\">").append( "Width" ).append("</td>");
		html.append("        <td style=\"width: 100px;\" class=\"form_label\">").append( "Height" ).append("</td>");
		
		html.append("    </tr>");
		
		if (items != null) {
			
			for (int i = 0; i < itemSize; i++) {
				
				CustomizeProductBorderItemMessage borderItemMessage = (CustomizeProductBorderItemMessage) items.get(i);
//				CustomizeProductColorItemMessage origColorItemMessage = null;
				
				int borderId = borderItemMessage.getBorderId();
				String itemKey = borderItemMessage.getItemKey();
				String itemType = borderItemMessage.getItemType();
				String title = borderItemMessage.getTitle();
				boolean defaultOption = borderItemMessage.isDefaultOption();
				String cost = String.valueOf( borderItemMessage.getCost() );
				String x = String.valueOf( borderItemMessage.getX() );
				String y = String.valueOf( borderItemMessage.getY() );
				String width = String.valueOf( borderItemMessage.getWidth() );
				String height = String.valueOf( borderItemMessage.getHeight() );
				
				if ( i%2 == 0 ){
				
					html.append("<tr id=\"row_" + i + "\" class=\"data_row searchResultTableRowEven\">");
					
				}else{
					
					html.append("<tr id=\"row_" + i + "\" class=\"data_row searchResultTableRowOdd\">");
					
				}
				
				
				html.append( TableCellTextInput.renderHtml( i, "customize_product_border_id_" + index, "" + borderId, "", WebComponent.MODE_READONLY ) );
				
				html.append( TableCellTextInput.renderHtml( i, "customize_product_border_item_key_" + index, itemKey, "", webComponentMode ) );
				html.append( TableCellTextInput.renderHtml( i, "customize_product_border_item_type_" + index, itemType, null, webComponentMode ) );
				html.append( TableCellTextInput.renderHtml( i, "customize_product_border_title_" + index, title, null, webComponentMode ) );
				html.append( TableCellCheckBox.renderHtml( i, "customize_product_border_default_option_" + index, defaultOption, false, webComponentMode, resourceBundle ) );
				html.append( TableCellNumberInput.renderHtml( i, "customize_product_border_cost_" + index, cost, null, webComponentMode, 2, 0 ) );
				html.append( TableCellNumberInput.renderHtml( i, "customize_product_border_x_" + index, x, null, webComponentMode, 0, 0 ) );
				html.append( TableCellNumberInput.renderHtml( i, "customize_product_border_y_" + index, y, null, webComponentMode, 0, 0 ) );
				html.append( TableCellNumberInput.renderHtml( i, "customize_product_border_width_" + index, width, null, webComponentMode, 0, 0 ) );
				html.append( TableCellNumberInput.renderHtml( i, "customize_product_border_height_" + index, height, null, webComponentMode, 0, 0 ) );
				
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
