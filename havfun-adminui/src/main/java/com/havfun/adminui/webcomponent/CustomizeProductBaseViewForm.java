package com.havfun.adminui.webcomponent;

import java.math.BigDecimal;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.service.message.data.CustomizeProductBaseViewMessage;

public class CustomizeProductBaseViewForm {

	/* static member */
	private static final Logger LOGGER = LogManager.getLogger(CustomizeProductBaseViewList.class.getName());
	
	public static String renderHtml( int index, CustomizeProductBaseViewMessage viewMessage, ResourceBundle resourceBundle, int webComponentMode ){
		
		int viewId = viewMessage.getViewId();
		String title = viewMessage.getTitle();
		long boundWidth = viewMessage.getBoundWidth();
		long boundHeight = viewMessage.getBoundHeight();
		int z = viewMessage.getZ();
		BigDecimal scale = viewMessage.getScale();
		
		StringBuilder html = new StringBuilder();
		
		html.append( "<table style=\"width:100%;border: 1px solid black;\">" );
		html.append( "<tr><td width=\"20%\"></td><td width=\"30%\"></td>" );
		html.append( "<td width=\"20%\"></td><td width=\"30%\"></td></tr>" );
		
		html.append( "<tr><td>ID</td>" + TableCellTextInput.renderHtml( index, "customize_product_base_view_id", "" + viewId, "", WebComponent.MODE_READONLY ) );
		html.append( "<td>Title</td>" + TableCellTextInput.renderHtml( index, "customize_product_base_view_title", title, "", webComponentMode ) + "</tr>");
		
		html.append( "<tr><td>Bound Width</td>" + TableCellNumberInput.renderHtml( index, "customize_product_base_view_bound_width", "" + boundWidth, null, webComponentMode, 0, 0 ) + "" );
		html.append( "<td>Bound Height</td>" + TableCellNumberInput.renderHtml( index, "customize_product_base_view_bound_height", "" + boundHeight, null, webComponentMode, 0, 0 ) + "</tr>" );
		html.append( "<tr><td>z</td>" + TableCellNumberInput.renderHtml( index, "customize_product_base_view_z", "" + z, null, webComponentMode, 0, 0 ) + "" );
		html.append( "<td>scale</td>" + TableCellNumberInput.renderHtml( index, "customize_product_base_view_scale", "" + scale, null, webComponentMode, 4 ) + "</tr>" );
		
		html.append( "<tr><td colspan=\"4\">" );
		html.append( CustomizeProductBorderDetailsList.renderHtml( index, resourceBundle, viewMessage.getBorderList(), null, webComponentMode) );
		html.append( "</td></tr>" );
		
		html.append( "</table>");
		
		return html.toString();
	}

}
