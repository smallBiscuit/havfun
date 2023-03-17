package com.havfun.adminui.webcomponent;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.message.data.OrderProductMessage;


public class OrderProductList extends WebComponent{

	/* static member */
	private static final Logger LOGGER = LogManager.getLogger(OrderProductList.class.getName());
	private ResourceBundle resourceBundle;
	
	public OrderProductList(Map<String, Object> valueMap) {
		super(valueMap);
	}

	@Override
	public String getWebComponentHtml(ResourceBundle resourceBundle, int pageMode, List<String> choiceList, Object value, Object origValue) {
		
		LOGGER.debug("CorporateActionEventList.getWebComponentHtml");
		
		int webComponentMode = getComponentMode(pageMode);
		this.resourceBundle = resourceBundle;
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

//		List<String> countryList = new ArrayList<String>();
//		List<String> countryLabelList = new ArrayList<String>();
//		
//		countryList.add( "HK" ); 
//		countryList.add( "CN" ); 
//		
//		countryLabelList.add( "Hong Kong" ); 
//		countryLabelList.add( "China" );
		
		
		html.append( "</td></tr>" );
		html.append( "<tr><td colspan=\"4\">" );
		
		if ( webComponentMode == MODE_EDITABLE ){
			
			String enptyRowHtmlCode = "";
			
			enptyRowHtmlCode += TableCellTextInput.renderHtml( -1, "order_product_id", "", "", WebComponent.MODE_READONLY  );
			enptyRowHtmlCode += TableCellTextInput.renderHtml( -1, "order_product_order_id", "", "", webComponentMode );
			enptyRowHtmlCode += TableCellTextInput.renderHtml( -1, "order_product_id", "", "", webComponentMode );
			enptyRowHtmlCode += TableCellTextInput.renderHtml( -1, "order_product_name", "", "", webComponentMode );
			enptyRowHtmlCode += TableCellTextInput.renderHtml( -1, "order_product_model", "", "", webComponentMode );
			enptyRowHtmlCode += TableCellTextInput.renderHtml( -1, "order_product_quantity", "", "", webComponentMode );
			enptyRowHtmlCode += TableCellTextInput.renderHtml( -1, "order_product_price", "", "", webComponentMode );

			enptyRowHtmlCode += TableCellButton.renderHtmlRemoveButton( this.resourceBundle.getString("common_delete_row"), webComponentMode );
			
			

			String addRowHtmlCode = "<div class=\"hide\" style=\"display:none\"><table id=\"corporate_action_event_table_row_template\"><tr class=\"product_data_row\">" + enptyRowHtmlCode + "</tr></table></div>";
			
			html.append("<div class=\"btn_add_row left\" data-add-row-target=\"corporate_action_event_table\" data-add-row-html-source=\"corporate_action_event_table_row_template\"><a>");
			html.append(getDisplay(resourceBundle, "common_add_row")).append("</a></div>");
			html.append(addRowHtmlCode);
			
		}
		
		html.append("<div style=\"width:100%;overflow-x:scroll;\">");
		html.append("<table class=\"display cell-border searchResultTable\" id=\"corporate_action_event_table\" style=\"width:100%;\">");
		html.append("    <tr>");
		html.append("        <td style=\"width: 150px;\" class=\"form_label\">").append(getDisplay(resourceBundle, "common_id")).append("</td>");
		html.append("        <td style=\"width: 150px;\" class=\"form_label\">").append(getDisplay(resourceBundle, "order_product_order_id")).append("</td>");
		html.append("        <td style=\"width: 150px;\" class=\"form_label\">").append(getDisplay(resourceBundle, "order_product_product_id")).append("</td>");
		html.append("        <td style=\"width: 150px;\" class=\"form_label\">").append(getDisplay(resourceBundle, "common_name")).append("</td>");
		html.append("        <td style=\"width: 150px;\" class=\"form_label\">").append(getDisplay(resourceBundle, "product_model")).append("</td>");
		html.append("        <td style=\"width: 150px;\" class=\"form_label\">").append(getDisplay(resourceBundle, "common_quantity")).append("</td>");
		html.append("        <td style=\"width: 150px;\" class=\"form_label\">").append(getDisplay(resourceBundle, "product_price")).append("</td>");
		html.append("    </tr>");
		
		if (items != null) {
			
			for (int i = 0; i < itemSize; i++) {
				
				OrderProductMessage OrderProductMessage = (OrderProductMessage) items.get(i);
				OrderProductMessage origEventMessage = null;
				
				int orderProductId = OrderProductMessage.getOrderProductId();
				int orderId = OrderProductMessage.getOrderId();
				int productId = OrderProductMessage.getProductId();
				String name = OrderProductMessage.getName();
				String model = OrderProductMessage.getModel();
				int quantity = OrderProductMessage.getQuantity();
				BigDecimal price = OrderProductMessage.getPrice();

				
				if ( i%2 == 0 ){
				
					html.append("<tr id=\"row_" + i + "\" class=\"product_data_row searchResultTableRowEven\">");
					
				}else{
					
					html.append("<tr id=\"row_" + i + "\" class=\"product_data_row searchResultTableRowOdd\">");
					
				}
				
				
				html.append( TableCellTextInput.renderHtml( i, "order_product_id", "" + orderProductId, "", WebComponent.MODE_READONLY ) );				
				html.append( TableCellTextInput.renderHtml( i, "order_product_order_id", "" + orderId, "", WebComponent.MODE_READONLY ) );
				html.append( TableCellTextInput.renderHtml( i, "order_product_product_id", "" + productId, "", webComponentMode ) );
				html.append( TableCellTextInput.renderHtml( i, "order_product_name", name, null, webComponentMode ) );
				html.append( TableCellTextInput.renderHtml( i, "order_product_model", model, null, webComponentMode ) );
				html.append( TableCellTextInput.renderHtml( i, "order_product_quantity", "" + quantity, "", webComponentMode ) );
				html.append( TableCellTextInput.renderHtml( i, "order_product_price", "" + price, "", webComponentMode ) );

				
				html.append("</tr>");				
				
			}
		}

		html.append("</table></div>\n");		
		

		return html.toString();
	}
	
	
}
