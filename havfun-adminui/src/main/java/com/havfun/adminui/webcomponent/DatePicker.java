package com.havfun.adminui.webcomponent;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TimeZone;

import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.adminui.utils.DateTimeFormatUtil;

public class DatePicker extends WebComponent{
	
	private static final Logger LOGGER = LogManager.getLogger(DatePicker.class.getName());
	protected int maxLength;
	protected boolean enableSwitch = false;
	protected int type;
	private int defaultValue;
	private int minValue;
	private int maxValue;
	protected boolean skipWeekends = false;
	protected boolean skipHolidays = false;
	
	public final static int DATE_SELECT_MAXLENGTH = 50;
	
	
	public DatePicker(Map<String, Object> valueMap) {
		
		super( valueMap);

		this.maxLength = DATE_SELECT_MAXLENGTH;
		this.type = WebComponent.DATE_PICKER_TYPE_YEAR_DATE;
		
	}
	
	public DatePicker(Map<String, Object> valueMap, boolean enableSwitch ) {
		
		super( valueMap);

		this.enableSwitch = enableSwitch;
		this.maxLength = DATE_SELECT_MAXLENGTH;
		this.type = WebComponent.DATE_PICKER_TYPE_YEAR_DATE;
		
	}
	
	public DatePicker(Map<String, Object> valueMap, boolean enableSwitch, int type ) {
		
		super( valueMap);

		this.enableSwitch = enableSwitch;
		this.maxLength = DATE_SELECT_MAXLENGTH;
		this.type = type;
		
	}
	
	public DatePicker(Map<String, Object> valueMap, boolean enableSwitch, int type, boolean skipWeekends, boolean skipHolidays ) {
		
		super( valueMap );

		this.enableSwitch = enableSwitch;
		this.maxLength = DATE_SELECT_MAXLENGTH;
		this.type = type;
		this.skipWeekends = skipWeekends;
		this.skipHolidays = skipHolidays;
	}
	
	public int getMaxLength() {
		return maxLength;
	}
	
	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}
	
	@Override
	public String getWebComponentHtml(ResourceBundle resourceBundle, int pageMode, List<String> choiceList, Object value, Object origValue) {
		
		if (value == null) {
			value = "";
		}

		return getInputPartHtml( resourceBundle, pageMode, choiceList, value, origValue) + 
				getDisplayPartHtml( resourceBundle, pageMode, choiceList, value, origValue);		
		
	}
	
	private String getInputPartHtml(ResourceBundle resourceBundle, int pageMode, List<String> choiceList, Object value, Object origValue) {

		int webComponentMode = getComponentMode(pageMode);
		
		if ( value == null || value.equals( "" ) ){
			
			if ( !this.enableSwitch && defaultValue > 0 ){
				//use the default Value only when without switch				
				value = defaultValue;
				
			}
		}
		
		String datePickerClassType = "";
		String datePickerDisplayFormatter = "";
		String datePickerSkipWeekendsClass = "";
		String datePickerSkipHolidaysClass = "";
		String datePickerDefaultValue = "";
		String datePickerDefaultDisplayValue = "";
		
		if ( this.type == WebComponent.DATE_PICKER_TYPE_YEAR_DATE ){
			
			datePickerClassType = "date_picker_type_year_date";
			
			datePickerDisplayFormatter = "YYYY-MM-DD";

			if ( defaultValue > 0 ){
			
				datePickerDefaultValue = String.valueOf( defaultValue );
				
				datePickerDefaultDisplayValue = DateTimeFormatUtil.convertServerDateToDisplayFormat( defaultValue );
				
			}else{
				
				datePickerDefaultValue = String.valueOf( DateTimeFormatUtil.dateToInt( new Date() ) );
				
				datePickerDefaultDisplayValue = DateTimeFormatUtil.convertServerDateToDisplayFormat( DateTimeFormatUtil.dateToInt( new Date() ) );
				
			}
			
			
			
		}else if ( this.type == WebComponent.DATE_PICKER_TYPE_DATE ){
						
			datePickerClassType = "date_picker_type_date";
			
			datePickerDisplayFormatter = "MM-DD";
			
			String dateStr = String.format("%04d", defaultValue);
			
			String monthStr = dateStr.substring(0, 2);
			String dayStr = dateStr.substring(2, 4);
			
			datePickerDefaultDisplayValue = monthStr + "-" + dayStr;
			
		}
		
		if ( this.skipWeekends ){
			
			datePickerSkipWeekendsClass = "date_picker_skip_weekends";
			
		}
		
		if ( this.skipHolidays ){
			
			datePickerSkipHolidaysClass = "date_picker_skip_holidays";
			
		}
		
		String buttonYes = resourceBundle.getString("common_yes");
		String buttonNo = resourceBundle.getString("common_no");		
		
		String checkboxHtml = "<input type=\"checkbox\" class=\"date_picker_switch web_component_input\" id=\"%s\" name=\"%s\" ><label for=\"%s\"><span class=\"checkboxLabelYes\">" + buttonYes + "</span><span class=\"checkboxLabelNo\">" + buttonNo + "</span></label>";
		
		String hiddenInputPartHtml = "<input type=\"hidden\" class=\"date_picker_alter\" id=\"%s\" name=\"%s\" value=\"%s\">";
						
		String datePickerPartHtml = "<input type=\"text\" class=\"date_picker date_picker_button %s %s %s\" data-display-formatter=\"%s\" data-default-value=\"%s\" data-default-display-value=\"%s\" data-min-value=\"%s\" data-max-value=\"%s\" style=\"margin:5px 0px;width:height:18px;width:100px;border:0px;text-align:center;background:#0099da;color:#ffffff;cursor:pointer;\" readonly>";
		
		String finalHtml = "";
		
		switch(webComponentMode){
		
			case MODE_EDITABLE:
				
				if( enableSwitch ){
					
					String checkboxSelectorId = key + "_switch";
							
					finalHtml = String.format(checkboxHtml, checkboxSelectorId, checkboxSelectorId, checkboxSelectorId );
					
				}
				
				finalHtml += String.format(hiddenInputPartHtml, key, key, value );
				finalHtml +=  String.format(datePickerPartHtml, datePickerClassType, datePickerSkipWeekendsClass, datePickerSkipHolidaysClass, datePickerDisplayFormatter, datePickerDefaultValue, datePickerDefaultDisplayValue, minValue, maxValue );
				
				break;
			
			case MODE_READONLY:
			case MODE_DISABLED:
			case MODE_HIDDEN:
			case MODE_PENDING_APPROVAL:
			
				finalHtml = String.format( hiddenInputPartHtml, key, key, value );
				
				break;
		
				default:
					break;
		}
		//LOGGER.debug(finalHtml);
		return finalHtml;

	}

	private String getDisplayPartHtml(ResourceBundle resourceBundle, int pageMode, List<String> choiceList, Object value, Object origValue) {
		
		int webComponentMode = getComponentMode(pageMode);
		
		String finalHtml = "";
		boolean isValueChange = false;

		String origDisplayDate = "";
		String newDisplayDate = "";
		
		
		if ( this.type == WebComponent.DATE_PICKER_TYPE_YEAR_DATE) {
			
			if ( value != null && value instanceof Integer && (Integer)value > 0 ){
				newDisplayDate = DateTimeFormatUtil.convertServerDateToDisplayFormat((Number)value);
			}
			if ( origValue != null && origValue instanceof Integer && (Integer)origValue > 0 ){
				origDisplayDate = DateTimeFormatUtil.convertServerDateToDisplayFormat((Number)origValue);
			}
			
			if(value != null && origValue != null){
				if(!newDisplayDate.equals(origDisplayDate)){
					isValueChange = true;
				}
			}
			
		} else if ( this.type == WebComponent.DATE_PICKER_TYPE_DATE ) {

			if ( value != null && value instanceof Integer && (Integer)value > 0 ){
				newDisplayDate = DateTimeFormatUtil.convertServerSimpleDateToDisplayFormat((Number)value);
			}
			if ( origValue != null && origValue instanceof Integer &&  (Integer)origValue > 0 ){
				origDisplayDate = DateTimeFormatUtil.convertServerSimpleDateToDisplayFormat((Number)origValue);
			}
			
			if(value != null && origValue != null){
				if(!newDisplayDate.equals(origDisplayDate)){
					isValueChange = true;
				}
			}

		}
		
		String labelEffectHtml = "<span class= \"%s\"> %s </span>";

		switch(webComponentMode){
		
			case MODE_EDITABLE: 				
			case MODE_HIDDEN:
				break;
				
			case MODE_READONLY:				
			case MODE_DISABLED:				
	
				finalHtml = newDisplayDate;
			
				break;
				
			case MODE_PENDING_APPROVAL:

				if ( !isValueChange ){
					
					finalHtml+= newDisplayDate;
					
				}else{
					
					if( origValue.equals("") || origValue.equals("0") ){
				
						finalHtml+= String.format(labelEffectHtml, "blueFont", newDisplayDate);
					}else{	
								
						finalHtml+= String.format(labelEffectHtml, "grayFont", origDisplayDate) + " > " + String.format( labelEffectHtml, "redFont", newDisplayDate);
					
					}
				}		
	
			break;

		}
		

		return finalHtml;
	}
	
	public int getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(int defaultValue) {
		this.defaultValue = defaultValue;
	}

	public int getMinValue() {
		return minValue;
	}

	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}
	
	
}

