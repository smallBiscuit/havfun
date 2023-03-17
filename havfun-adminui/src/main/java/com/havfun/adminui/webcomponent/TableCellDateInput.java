package com.havfun.adminui.webcomponent;

import java.util.Date;
import java.util.ResourceBundle;
import java.util.TimeZone;

import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.adminui.utils.DateTimeFormatUtil;
import com.havfun.adminui.utils.DisplayFormatHelper;

public class TableCellDateInput {

	private static final Logger LOGGER = LogManager.getLogger(TableCellDateInput.class.getName());
	
	public static String renderHtml( String key, Object value, Object origValue, int webComponentMode, ResourceBundle resourceBundle, boolean enableSwitch ){
		
		return renderHtml( -1, key, value, origValue, webComponentMode, resourceBundle, enableSwitch );
		
	}
	
	public static String renderHtml( int rowIndex, String key, Object value, Object origValue, int webComponentMode, ResourceBundle resourceBundle, boolean enableSwitch ){
		
		return "<td>" + 
				getInputPartHtml( rowIndex, key, value, origValue, webComponentMode, resourceBundle, enableSwitch ) + 
				getDisplayPartHtml( rowIndex, key, value, origValue, webComponentMode, resourceBundle) +
				"</td>";
		
	}
	
	public static String getInputPartHtml( int rowIndex, String key, Object value, Object origValue, int webComponentMode, ResourceBundle resourceBundle, boolean enableSwitch ){
		
		//[Checkbox][Input][Button]
		//ToBeMove: common-basic change start with checkbox
		String checkboxKey = "checkbox_" + key + "_checkbox";
		String inputKey = key + "_input";
		String buttonKey = key + "_button";
		
		String checkboxName = "";
		String inputName = "";
		String buttonName = "";
		
		if ( rowIndex >= 0 ){
			
			checkboxName = checkboxKey + "_" + rowIndex;
			inputName = inputKey + "_" + rowIndex;
			buttonName = buttonKey + "_" + rowIndex;
			
		}
		
		String datePickerClassType = "";
		String datePickerDisplayFormatter = "";
		String datePickerDefaultValue = "";
		String datePickerDefaultDisplayValue = "";
		int minValue = 0;
		int maxValue = 0;
		
		
		//For TableCellDateInput only have 1 type: date with year
		datePickerClassType = "date_picker_type_year_date";
		
		datePickerDisplayFormatter = "YYYY-MM-DD";
		
		datePickerDefaultValue = String.valueOf( DateTimeFormatUtil.dateToInt( new Date() ) );
		
		datePickerDefaultDisplayValue = DateTimeFormatUtil.convertServerDateToDisplayFormat( DateTimeFormatUtil.dateToInt( new Date() ) );
		
		String buttonYes = resourceBundle.getString("common_yes");
		
		String buttonNo = resourceBundle.getString("common_no");
		
		String checkboxHtml = "<input type=\"checkbox\" data-key=\"%s\" class=\"date_picker_switch web_component_input\" id=\"%s\" name=\"%s\" ><label for=\"%s\"><span class=\"checkboxLabelYes\">" + buttonYes + "</span><span class=\"checkboxLabelNo\">" + buttonNo + "</span></label>";

		String hiddenInputPartHtml = "<input type=\"hidden\" class=\"date_picker_alter\" data-key=\"%s\" id=\"%s\" name=\"%s\" value=\"%s\">";

		String datePickerPartHtml = "<input type=\"text\" class=\"date_picker date_picker_button %s\" key-data=\"%s\" id=\"%s\" name=\"%s\" data-display-formatter=\"%s\" data-default-value=\"%s\" data-default-display-value=\"%s\" data-min-value=\"%s\" data-max-value=\"%s\" style=\"width:120px;border:0px;text-align:center;background:#0099da;color:#ffffff;cursor:pointer;margin-top: 6px;\" readonly>";
		
		String finalHtml = "";
		
		switch(webComponentMode){
		
			case WebComponent.MODE_EDITABLE:
				
				if( enableSwitch ){

					finalHtml = String.format(checkboxHtml, checkboxKey, checkboxName, checkboxName, checkboxName );
					
				}
				
				finalHtml += String.format(hiddenInputPartHtml, inputKey, inputName, inputName , value );

				finalHtml += String.format(datePickerPartHtml, datePickerClassType, buttonKey, buttonName, buttonName, datePickerDisplayFormatter, datePickerDefaultValue, datePickerDefaultDisplayValue, minValue, maxValue );
				
				break;
			
			case WebComponent.MODE_READONLY:
			case WebComponent.MODE_DISABLED:
			case WebComponent.MODE_HIDDEN:
			case WebComponent.MODE_PENDING_APPROVAL:

				finalHtml = String.format(hiddenInputPartHtml, inputKey, inputName, inputName , value );
				
				break;
		
				default:
					break;
		}
		
		//LOGGER.debug(finalHtml);
		return finalHtml;		
		
	}
	
	public static String getDisplayPartHtml( int rowIndex, String key, Object value, Object origValue, int webComponentMode, ResourceBundle resourceBundle ){
		
		String contentHtml = "";
		
		boolean isValueChange = false;

		String origDisplayDate = "";
		String newDisplayDate = "";
		
		FastDateFormat df = null;
		FastDateFormat serverDateFormat = FastDateFormat.getInstance(  DisplayFormatHelper.DATA_DATE_FORMAT_YEAR_DATE, TimeZone.getTimeZone("Asia/Hong_Kong")  );


		df = FastDateFormat.getInstance(  DisplayFormatHelper.DISPLAY_DATE_FORMAT_YEAR_DATE, TimeZone.getTimeZone("Asia/Hong_Kong")  );
			
		try{	
			
			if (value instanceof Integer){
				if ( value != null && (Integer)value > 0 ){
					Date date = serverDateFormat.parse( String.valueOf( value ) );
					newDisplayDate = df.format( date );
				}else {
					newDisplayDate = "-";
				}
			}
			
			if (value instanceof Integer){
				if ( origValue != null && (Integer)origValue > 0 ){
					Date date = serverDateFormat.parse( String.valueOf( origValue ) );				
					origDisplayDate = df.format( date );
				}else {
					origDisplayDate = "-";
				}
			}
			
			if ( (value instanceof Integer) && (origValue instanceof Integer)){
				if (  (Integer)value !=  (Integer)origValue ){
					
					if ( !newDisplayDate.equals(origDisplayDate) ){
						isValueChange = true;
					}
				}
			}
			
		}catch( Exception e){ 
			LOGGER.debug( "DataSelect Exception ", e);
		}


		String labelEffectHtml = "<span class= \"%s\"> %s </span>";

		switch(webComponentMode){
		
			case WebComponent.MODE_EDITABLE: 				
			case WebComponent.MODE_HIDDEN:
				break;
				
			case WebComponent.MODE_READONLY:				
			case WebComponent.MODE_DISABLED:				
	
				contentHtml = newDisplayDate;
			
				break;
				
			case WebComponent.MODE_PENDING_APPROVAL:

				if ( !isValueChange ){
					
					contentHtml+= newDisplayDate;
					
				}else{
					
					if( origValue.equals("") || origValue.equals("0") ){
				
						contentHtml+= String.format(labelEffectHtml, "blueFont", newDisplayDate);
					}else{	
								
						contentHtml+= String.format(labelEffectHtml, "grayFont", origDisplayDate) + " > " + String.format( labelEffectHtml, "redFont", newDisplayDate);
					
					}
				}		
	
			break;

		}
		

		return contentHtml;

	}
	
}
