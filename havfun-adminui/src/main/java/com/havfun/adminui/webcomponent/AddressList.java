package com.havfun.adminui.webcomponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.message.data.AddressMessage;


public class AddressList extends WebComponent{

	/* static member */
	private static final Logger LOGGER = LogManager.getLogger(AddressList.class.getName());
	private ResourceBundle resourceBundle;
	
	public AddressList(Map<String, Object> valueMap) {
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

		List<String> countryList = new ArrayList<String>();
		List<String> countryLabelList = new ArrayList<String>();
		
		countryList.add( "HK" ); 
		countryList.add( "CN" ); 
		
		countryLabelList.add( "Hong Kong" ); 
		countryLabelList.add( "China" ); 
		
		html.append( "</td></tr>" );
		html.append( "<tr><td colspan=\"4\">" );
		
		if ( webComponentMode == MODE_EDITABLE ){
			
			String enptyRowHtmlCode = "";
			
			enptyRowHtmlCode += TableCellTextInput.renderHtml( -1, "address_id", "", "", WebComponent.MODE_READONLY  );
			enptyRowHtmlCode += TableCellTextInput.renderHtml( -1, "address_client_id", "", "", WebComponent.MODE_READONLY );
			enptyRowHtmlCode += TableCellTextInput.renderHtml( -1, "address_first_name", "", "", webComponentMode );
			enptyRowHtmlCode += TableCellTextInput.renderHtml( -1, "address_last_name", "", "", webComponentMode );
			enptyRowHtmlCode += TableCellTextInput.renderHtml( -1, "address_city", "", "", webComponentMode );
			enptyRowHtmlCode += TableCellTextInput.renderHtml( -1, "address_postcode", "", "", webComponentMode );
			enptyRowHtmlCode += TableCellSelect.renderHtml( "address_country_id", "", "", countryList, countryLabelList,  webComponentMode );
			enptyRowHtmlCode += TableCellTextInput.renderHtml( -1, "address_zone_id", "", "", webComponentMode );
			enptyRowHtmlCode += TableCellTextInput.renderHtml( -1, "address_telephone", "", "", webComponentMode );

			enptyRowHtmlCode += TableCellButton.renderHtmlRemoveButton( this.resourceBundle.getString("common_delete_row"), webComponentMode );
			
			

			String addRowHtmlCode = "<div class=\"hide\" style=\"display:none\"><table id=\"corporate_action_event_table_row_template\"><tr class=\"address_data_row\">" + enptyRowHtmlCode + "</tr></table></div>";
			
			html.append("<div class=\"btn_add_row left\" data-add-row-target=\"corporate_action_event_table\" data-add-row-html-source=\"corporate_action_event_table_row_template\"><a>");
			html.append(getDisplay(resourceBundle, "client_add_address")).append("</a></div>");
			html.append(addRowHtmlCode);
			
		}
		
		html.append("<div style=\"width:100%;overflow-x:scroll;\">");
		html.append("<table class=\"display cell-border searchResultTable\" id=\"corporate_action_event_table\" style=\"width:100%;\">");
		html.append("    <tr>");
		html.append("        <td style=\"width: 150px;\" class=\"form_label\">").append(getDisplay(resourceBundle, "address_id")).append("</td>");
		html.append("        <td style=\"width: 150px;\" class=\"form_label\">").append(getDisplay(resourceBundle, "client_id")).append("</td>");
		html.append("        <td style=\"width: 150px;\" class=\"form_label\">").append(getDisplay(resourceBundle, "client_first_name")).append("</td>");
		html.append("        <td style=\"width: 150px;\" class=\"form_label\">").append(getDisplay(resourceBundle, "client_last_name")).append("</td>");
		html.append("        <td style=\"width: 150px;\" class=\"form_label\">").append(getDisplay(resourceBundle, "address_city")).append("</td>");
		html.append("        <td style=\"width: 150px;\" class=\"form_label\">").append(getDisplay(resourceBundle, "address_postcode")).append("</td>");
		html.append("        <td style=\"width: 150px;\" class=\"form_label\">").append(getDisplay(resourceBundle, "address_country_id")).append("</td>");
		html.append("        <td style=\"width: 150px;\" class=\"form_label\">").append(getDisplay(resourceBundle, "address_zone_id")).append("</td>");
		html.append("        <td style=\"width: 160px;\" class=\"form_label\">").append(getDisplay(resourceBundle, "address_telephone")).append("</td>");
		html.append("    </tr>");
		
		if (items != null) {
			
			for (int i = 0; i < itemSize; i++) {
				
				AddressMessage addressMessage = (AddressMessage) items.get(i);
				AddressMessage origEventMessage = null;
				
				int addressId = addressMessage.getAddressId();
				int clientId = addressMessage.getClientId();
				String firstName = addressMessage.getFirstName();
				String lastName = addressMessage.getLastName();
				String city = addressMessage.getCity();
				String postcode = addressMessage.getPostcode();
				int countryId = addressMessage.getCountryId();
				int zoneId = addressMessage.getZoneId();
				String telephone = addressMessage.getTelephone();

				/*
				int origCorporateActionEventId = -1;
				String origAnnounceNumber = null;
				String origEventNumber = null;
				String origEntitlementTypeStr = null;
				String origDeadlineDate = null;
				String origDividendCurrency = null;
				String origDividendRateStr = null;			
				String origPaidCurrency = null;
				String origDividendRateInPaidCurrency = null;
				String origBonusExchangeCode = null;
				String origBonusInstrumentCode = null;
				String origScripRatioFrom = null;
				String origScripRatioTo = null;
				String origReInvestmentPrice = null;
				String origSubscriptionPrice = null;
				boolean origDefaultOption = false;
				String origEntitleType = null;
				
				if(origItems != null && origItemSize >  i){
					
					origEventMessage = (CorporateActionEventMessage) origItems.get(i);
					
					origCorporateActionEventId = origEventMessage.getCorporateActionEventId();
					origAnnounceNumber = origEventMessage.getAnnounceNumber();
					origEventNumber = origEventMessage.getEventNumber();
					
					if ( origEventMessage.getEntitlementType() != null ){
						origEntitlementTypeStr = origEventMessage.getEntitlementType().getValue();
					}
					
					origDeadlineDate = "" + origEventMessage.getDeadlineDate();
					
					if ( origEventMessage.getDividendRateInPaidCurrency() != null && !origEventMessage.getDividendRateInPaidCurrency().equals("") ){
						origDividendRateInPaidCurrency = String.valueOf( origEventMessage.getDividendRateInPaidCurrency() );
					}
					
					if ( origEventMessage.getDividendRate() != null && !origEventMessage.getDividendRate().equals("") ){
						origDividendRateStr = origEventMessage.getDividendRate().toPlainString();
					}					
					
					origPaidCurrency = origEventMessage.getPaidCurrency();
					origDividendRateInPaidCurrency = String.valueOf( origEventMessage.getDividendRateInPaidCurrency() );
					origBonusExchangeCode = origEventMessage.getBonusExchangeCode();
					origBonusInstrumentCode = origEventMessage.getBonusInstrumentCode();
					
					if ( origEventMessage.getScripRatioFrom() != null && !origEventMessage.getScripRatioFrom().equals("")  ){ 	
						origScripRatioFrom = String.valueOf( origEventMessage.getScripRatioFrom() );
					}
					
					if ( origEventMessage.getScripRatioTo() != null && !origEventMessage.getScripRatioTo().equals("")  ){
						origScripRatioTo = String.valueOf( origEventMessage.getScripRatioTo() );
					}
					
					if( origEventMessage.getReInvestmentPrice() != null && !origEventMessage.getReInvestmentPrice().equals("")  ){
						origReInvestmentPrice = origEventMessage.getReInvestmentPrice().toPlainString();
					}
					
					
					if ( origEventMessage.getSubscriptionPrice() != null && !origEventMessage.getSubscriptionPrice().equals("")  ){
						origSubscriptionPrice = origEventMessage.getSubscriptionPrice().toPlainString();
					}

					
					origDefaultOption = origEventMessage.isDefaultOption();
					origEntitleType = origEventMessage.getEntitleType();
				}
				*/
				
				if ( i%2 == 0 ){
				
					html.append("<tr id=\"row_" + i + "\" class=\"address_data_row searchResultTableRowEven\">");
					
				}else{
					
					html.append("<tr id=\"row_" + i + "\" class=\"address_data_row searchResultTableRowOdd\">");
					
				}
				
				
				html.append( TableCellTextInput.renderHtml( i, "address_id", "" + addressId, "", WebComponent.MODE_READONLY ) );
				
				html.append( TableCellTextInput.renderHtml( i, "address_client_id", "" + clientId, "", WebComponent.MODE_READONLY ) );
				html.append( TableCellTextInput.renderHtml( i, "address_first_name", firstName, null, webComponentMode ) );
				html.append( TableCellTextInput.renderHtml( i, "address_last_name", lastName, null, webComponentMode ) );

				html.append( TableCellTextInput.renderHtml( i, "address_city", city, null, webComponentMode ) );
				
				html.append( TableCellTextInput.renderHtml( i, "address_postcode", postcode, null, webComponentMode ) );

				
				//commissionDiscountType
				html.append( TableCellSelect.renderHtml( i, "address_country_id", 
						"" + countryId, 
						"", 
						countryList, 
						countryLabelList,
						webComponentMode ) );
				
				html.append( TableCellTextInput.renderHtml( i, "address_zone_id", "" + zoneId, null, webComponentMode ) );
				
				html.append( TableCellTextInput.renderHtml( i, "address_telephone", telephone, null, webComponentMode ) );

				
				html.append("</tr>");				
				
			}
		}

		html.append("</table></div>\n");		
		

		return html.toString();
	}
	
	
}
