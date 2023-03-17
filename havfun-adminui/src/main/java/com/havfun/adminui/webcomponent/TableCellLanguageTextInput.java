package com.havfun.adminui.webcomponent;

public class TableCellLanguageTextInput {

	public static String renderHtml( int rowIndex, String key, String valueEn, String valueHk, String valueCn, String origValueEn, String origValueHk, String origValueCn, int webComponentMode ){
		
		return renderHtml( rowIndex, key, valueEn, valueHk, valueCn, origValueEn, origValueHk, origValueCn, webComponentMode, 0, 100, "" );
		
	}
	
	public static String renderHtml( int rowIndex, String key, String valueEn, String valueHk, String valueCn, String origValueEn, String origValueHk, String origValueCn, int webComponentMode, int width, int maxlength ){
		
		return renderHtml( rowIndex, key,  valueEn, valueHk, valueCn, origValueEn, origValueHk, origValueCn, webComponentMode, width, maxlength, "" );
		
	}
	
	public static String renderHtml( int rowIndex, String key, String valueEn, String valueHk, String valueCn, String origValueEn, String origValueHk, String origValueCn, int webComponentMode, int width, int maxlength, String placeholder ){
		
		String keyEn = key + "_en";
		String keyHk = key + "_hk";
		String keyCn = key + "_cn";
		
		String contentHtmlEn = TableCellTextInput.renderCellContentHtml(rowIndex, keyEn, valueEn, origValueEn, webComponentMode, width, maxlength, placeholder);
		String contentHtmlHk = TableCellTextInput.renderCellContentHtml(rowIndex, keyHk, valueHk, origValueHk, webComponentMode, width, maxlength, placeholder);
		String contentHtmlCn = TableCellTextInput.renderCellContentHtml(rowIndex, keyCn, valueCn, origValueCn, webComponentMode, width, maxlength, placeholder);
		
		String contentHtml = "";
		contentHtml += "<td>";
		contentHtml += "<div>EN:" + contentHtmlEn + "</div>";
		contentHtml += "<div>HK:" + contentHtmlHk + "</div>";
		contentHtml += "<div>CN:" + contentHtmlCn + "</div>";
		contentHtml += "</td>";
		
		return contentHtml;
		
		
	}
	
}
