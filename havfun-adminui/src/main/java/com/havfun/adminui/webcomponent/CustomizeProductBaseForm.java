package com.havfun.adminui.webcomponent;

import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.message.data.CustomizeProductBaseMessage;


public class CustomizeProductBaseForm extends WebComponent{

	/* static member */
	private static final Logger LOGGER = LogManager.getLogger(CustomizeProductBaseForm.class.getName());
	
	public CustomizeProductBaseForm(Map<String, Object> valueMap) {
		super(valueMap);
	}

	@Override
	public String getWebComponentHtml(ResourceBundle resourceBundle, int pageMode, List<String> choiceList, Object value, Object origValue) {
		
		LOGGER.debug("PRODUCT_CUSTOMIZE_PRODUCT_BASE.getWebComponentHtml");
		
		int webComponentMode = getComponentMode(pageMode);
		StringBuilder html = new StringBuilder();
		List<?> items = null;
		List<?> origItems  = null;
		
		CustomizeProductBaseMessage baseMessage = (CustomizeProductBaseMessage) value;
		
		if ( baseMessage == null ){
			
			baseMessage = new CustomizeProductBaseMessage();
			
		}
		
		html.append( "</td></tr>" );
		
		html.append( "<tr><td>Base ID:</td>" );
		html.append( TableCellTextInput.renderHtml( -1, "customize_product_base_id", "" + baseMessage.getBaseId(), "", WebComponent.MODE_READONLY ) );
		html.append( "</td></tr>" );
		
		html.append( "<tr><td colspan=\"4\">" );
		html.append( CustomizeProductBaseViewList.renderHtml(resourceBundle, baseMessage.getViews(), null, webComponentMode) );
		html.append( "</td></tr>" );
		
		html.append( "<tr><td colspan=\"4\">" );
		html.append( CustomizeProductColorDetailsList.renderHtml(resourceBundle, baseMessage.getColorItemList(), null, webComponentMode) );
		html.append( "</td></tr>" );

		return html.toString();
	}
	
	
}
