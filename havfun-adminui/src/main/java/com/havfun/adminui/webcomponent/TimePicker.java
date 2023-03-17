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
import com.havfun.adminui.utils.DisplayFormatHelper;

public class TimePicker extends WebComponent{
	
	private static final Logger LOGGER = LogManager.getLogger(TimePicker.class.getName());
	protected boolean enableSwitch = false;
	protected int type;
	private int defaultValue;
	
	public final static int DATE_SELECT_MAXLENGTH = 50;
	
	
	public TimePicker(Map<String, Object> valueMap) {
		
		super( valueMap );
		this.type = WebComponent.TIME_PICKER_TYPE_YEAR_DATE_TIME;
		
	}
	
	public TimePicker(Map<String, Object> valueMap, boolean enableSwitch ) {
		
		super( valueMap );

		this.enableSwitch = enableSwitch;
		this.type = WebComponent.TIME_PICKER_TYPE_YEAR_DATE_TIME;
		
	}
	
	public TimePicker(Map<String, Object> valueMap, boolean enableSwitch, int type ) {
		
		super( valueMap );

		this.enableSwitch = enableSwitch;
		this.type = type;
		
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
		
		String timePickerClassType = "";
		String timePickerDisplayFormatter = "";
		String timePickerButtonWidth = "100";
		
		if ( this.type == WebComponent.TIME_PICKER_TYPE_YEAR_DATE_TIME ){
		
			timePickerClassType = "time_picker_type_year_date_time";
			
			timePickerDisplayFormatter = "YYYY-MM-DD HH:mm";
			
			timePickerButtonWidth = "140";
			
		}else if ( this.type == WebComponent.TIME_PICKER_TYPE_TIME ){
			
			timePickerClassType = "time_picker_type_time";
			
			timePickerDisplayFormatter = "HH:mm";
			
			timePickerButtonWidth = "100";
			
		}
			
		String buttonYes = resourceBundle.getString("common_yes");
		String buttonNo = resourceBundle.getString("common_no");		
		
		String checkboxHtml = "<input type=\"checkbox\" class=\"time_picker_switch web_component_input\" id=\"%s\" name=\"%s\" ><label for=\"%s\"><span class=\"checkboxLabelYes\">" + buttonYes + "</span><span class=\"checkboxLabelNo\">" + buttonNo + "</span></label>";
		
		String hiddenInputPartHtml = "<input type=\"hidden\" class=\"time_picker_alter\" id=\"%s\" name=\"%s\" value=\"%s\">";
						
		String timePickerPartHtml = "<input type=\"text\" class=\"time_picker time_picker_button %s\" data-display-formatter=\"%s\" style=\"margin:5px 0px;width:height:18px;width:%spx;border:0px;text-align:center;background:#0099da;color:#ffffff;cursor:pointer;\" readonly>";
		
		String finalHtml = "";
		
		switch(webComponentMode){
		
			case MODE_EDITABLE:
				
				if( enableSwitch ){
					
					String checkboxSelectorId = key + "_switch";
							
					finalHtml = String.format(checkboxHtml, checkboxSelectorId, checkboxSelectorId, checkboxSelectorId );
					
				}
				
				finalHtml += String.format(hiddenInputPartHtml, key, key, value );
				finalHtml += String.format(timePickerPartHtml, timePickerClassType, timePickerDisplayFormatter, timePickerButtonWidth );

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
		
		if (this.type == WebComponent.TIME_PICKER_TYPE_TIME) {
			
			try {
				newDisplayDate = DateTimeFormatUtil.convertServerTimeToDisplayFormat((Number)value);
				origDisplayDate = DateTimeFormatUtil.convertServerTimeToDisplayFormat((Number)origValue);
			} catch (Exception e) {
				LOGGER.debug("Exception", e);
			}
			
			if(value != null && origValue != null){
				if(!newDisplayDate.equals(origDisplayDate)){
					isValueChange = true;
				}
			}
			
		}else if (this.type == WebComponent.TIME_PICKER_TYPE_DATE_TIME) {


		}else if (this.type == WebComponent.TIME_PICKER_TYPE_YEAR_DATE_TIME ) {
			

			FastDateFormat df = FastDateFormat.getInstance(  DisplayFormatHelper.DISPLAY_DATE_FORMAT_YEAR_DATE_TIME, TimeZone.getTimeZone("Asia/Hong_Kong")  );

			
			try{	
				if (value instanceof Long){
					
					if ( (Long)value > 0 ){
						newDisplayDate = df.format( new Date( (Long)value) );	
					}else{
						newDisplayDate = "-";
					}
					
				}
				
				if (origValue instanceof Long){
					
					if ( origValue != null && (Long)origValue > 0 ){
						origDisplayDate = df.format( new Date( (Long)origValue) );
					}else{
						origDisplayDate = "-";
					}
					
				}
				
				if ( (value instanceof Long) && (origValue instanceof Long)){
					if (  (Long)value !=  (Long)origValue ){
						
						if ( !newDisplayDate.equals(origDisplayDate) ){
							isValueChange = true;
						}
					}
				}
				
			}catch( Exception e){ 
				LOGGER.debug( "TimeSelect Exception ", e);
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
	
	
	
}

