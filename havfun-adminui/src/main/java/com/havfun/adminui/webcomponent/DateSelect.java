package com.havfun.adminui.webcomponent;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TimeZone;

import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.adminui.helper.DisplayFormatHelper;

public class DateSelect extends WebComponent{
	private static final Logger LOGGER = LogManager.getLogger(DateSelect.class.getName());
	protected int maxLength;
	protected String htmlClass = "";
	protected boolean checkbox = false;
	protected int type;
	protected String holidayClass = "";
	
	public final static int DATE_SELECT_MAXLENGTH = 50;
	
	
	public DateSelect(Map<String, Object> valueMap) {
		super( valueMap);

		this.maxLength = DATE_SELECT_MAXLENGTH;
		this.type = WebComponent.DATE_SELECT_TYPE_DATE;
	}
	
	public DateSelect(Map<String, Object> valueMap, int type, String htmlClass) {
		super(valueMap);

		this.maxLength = DATE_SELECT_MAXLENGTH;
		this.type = type;
		this.htmlClass = htmlClass;
	}
	public DateSelect(Map<String, Object> valueMap, String htmlClass) {
		super( valueMap);
		
		this.maxLength = DATE_SELECT_MAXLENGTH;
		this.htmlClass = htmlClass;
	}
	
	public DateSelect(Map<String, Object> valueMap, String htmlClass, boolean checkbox)
	{
		super(valueMap);
		
		this.maxLength = DATE_SELECT_MAXLENGTH;
		this.htmlClass = htmlClass;
		this.checkbox = checkbox;
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
		String borderStyle = "";
		String output = "";
		String inputId = "";
		String className = "";
		FastDateFormat fastDateFormat = null;
		String displayValue = "";
		String inputPartReadOnly = ""; 
		
		if ( this.type == WebComponent.DATE_SELECT_TYPE_DATE_TIME || this.type == WebComponent.DATE_SELECT_TYPE_TIME) {
			inputId = this.htmlClass;
			className = "dateTimeSelect";
			fastDateFormat = FastDateFormat.getInstance(  DisplayFormatHelper.DISPLAY_DATE_FORMAT_YEAR_DATE_TIME, TimeZone.getTimeZone("Asia/Hong_Kong")  );
			inputPartReadOnly = "readonly"; //DateTimePicker cannot be readonly, otherwise no selection box can be triggered
		}else{
			inputId = this.htmlClass;
			className = "dateSelect " + this.holidayClass;
			fastDateFormat = FastDateFormat.getInstance(  DisplayFormatHelper.DISPLAY_DATE_FORMAT_YEAR_DATE, TimeZone.getTimeZone("Asia/Hong_Kong")  );
			inputPartReadOnly = "readonly";
		}
		
		String inputPartHtml = "<input id=\"%s\" name=\"%s\" type=\"hidden\" maxlength=\"%s\" style=\"%s\" value=\"%s\">"
								+ "<input type=\"%s\" class=\"%s\" maxlength=\"%s\" style=\"width:150px;border:0px;text-align:center;background:#0099da;color:#ffffff;cursor:pointer;\" value=\"%s\" %s>";
		
		//String checkboxHtml = "<input type=\"checkbox\" class=\" web_component_input\" id=\"%s\" name=\"%s\" ><label for=\"%s\" style=\" float:label; line-height: 32px;\" ><span></span></label>";
		
		//New
		String buttonYes = resourceBundle.getString("common_yes");
		String buttonNo = resourceBundle.getString("common_no");
//		buttonYes = "YES";
//		buttonNo = "NO";
		
		String checkboxHtml = "<input type=\"checkbox\" class=\" web_component_input\" id=\"%s\" name=\"%s\" ><label for=\"%s\"><span class=\"checkboxLabelYes\">" + buttonYes + "</span><span class=\"checkboxLabelNo\">" + buttonNo + "</span></label>";
		//String checkboxHtml = "<div class=\"buttonYes %s\" style=\"display:none;\">" + buttonYes + "</div><div class=\"buttonNo %s\" style=\"display:inline;\">" + buttonNo + "</div><input type=\"checkbox\" class=\"web_component_input web_component_input_yes_no\" id=\"%s\" name=\"%s\">";
		String finalHtml = "";
		
		switch(webComponentMode){
		
			case MODE_EDITABLE:
				if(checkbox){
					//finalHtml = String.format(checkboxHtml, "checkbox" + htmlClass, "checkbox" + htmlClass, "checkbox" + htmlClass);
					finalHtml = String.format(checkboxHtml, "checkbox" + htmlClass, "checkbox" + htmlClass, "checkbox" + htmlClass, "checkbox" + htmlClass);
				}
				
				finalHtml += String.format(inputPartHtml, inputId, key, maxLength, borderStyle, value,
						"text", className + " " + htmlClass, maxLength, value, inputPartReadOnly);
				break;
			
			case MODE_READONLY:
			case MODE_DISABLED:
			case MODE_HIDDEN:
			case MODE_PENDING_CONFIRM:

				borderStyle = " border:0px;";
				inputId = this.htmlClass;
				className = "";
				
				try{
					if ( value instanceof Long ){
						displayValue = fastDateFormat.format( new Date( (Long)value) );
					}
				}catch( Exception e){ 
					LOGGER.debug( "DataSelect Exception " + e.getLocalizedMessage() );
				}
				
				finalHtml = String.format(inputPartHtml, inputId, key, maxLength, borderStyle, value,
						"hidden", className, maxLength, displayValue, inputPartReadOnly);
				break;
		
				default:
					break;
		}
		LOGGER.debug(finalHtml);
		return finalHtml;

	}

	private String getDisplayPartHtml(ResourceBundle resourceBundle, int pageMode, List<String> choiceList, Object value, Object origValue) {
		
		int webComponentMode = getComponentMode(pageMode);
		
		String finalHtml = "";
		boolean isValueChange = false;

		String origDisplayDate = "";
		String newDisplayDate = "";
		
		FastDateFormat df = null;
		FastDateFormat serverDateFormat = FastDateFormat.getInstance(  DisplayFormatHelper.DISPLAY_DATE_FORMAT_SERVER_DATE, TimeZone.getTimeZone("Asia/Hong_Kong")  );

		if (this.type == WebComponent.DATE_SELECT_TYPE_TIME) {
			try {
				newDisplayDate = DisplayFormatHelper.convertServerTimeToDisplayFormat((Number)value);
				origDisplayDate = DisplayFormatHelper.convertServerTimeToDisplayFormat((Number)origValue);
			} catch (Exception e) {
				LOGGER.debug("Exception", e);
			}
			
			if(value != null && origValue != null){
				if(!newDisplayDate.equals(origDisplayDate)){
					isValueChange = true;
				}
			}
			
		} else {

			if ( this.type == WebComponent.DATE_SELECT_TYPE_DATE_TIME ) {
				df = FastDateFormat.getInstance(  DisplayFormatHelper.DISPLAY_DATE_FORMAT_YEAR_DATE_TIME, TimeZone.getTimeZone("Asia/Hong_Kong")  );
			} else {
				df = FastDateFormat.getInstance(  DisplayFormatHelper.DISPLAY_DATE_FORMAT_YEAR_DATE, TimeZone.getTimeZone("Asia/Hong_Kong")  );
			}
			
			try{	
				if (value instanceof Long){
					
					if ( (Long)value > 0 ){
						newDisplayDate = df.format( new Date( (Long)value) );	
					}else{
						newDisplayDate = "-";
					}
					
				}else if (value instanceof Integer){
					if ( value != null && (Integer)value > 0 ){
						Date date = serverDateFormat.parse( String.valueOf( value ) );
						newDisplayDate = df.format( date );
					}else {
						newDisplayDate = "-";
					}
				}
				
				if (origValue instanceof Long){
					
					if ( origValue != null && (Long)origValue > 0 ){
						origDisplayDate = df.format( new Date( (Long)origValue) );
					}else{
						origDisplayDate = "-";
					}
					
				}else if (value instanceof Integer){
					if ( origValue != null && (Integer)origValue > 0 ){
						Date date = serverDateFormat.parse( String.valueOf( origValue ) );				
						origDisplayDate = df.format( date );
					}else {
						origDisplayDate = "-";
					}
				}
				
				if ( (value instanceof Long) && (origValue instanceof Long)){
					if (  (Long)value !=  (Long)origValue ){
						
						if ( !newDisplayDate.equals(origDisplayDate) ){
							isValueChange = true;
						}
					}
				}else if ( (value instanceof Integer) && (origValue instanceof Integer)){
					if (  (Integer)value !=  (Integer)origValue ){
						
						if ( !newDisplayDate.equals(origDisplayDate) ){
							isValueChange = true;
						}
					}
				}
				
			}catch( Exception e){ 
				LOGGER.debug( "DataSelect Exception ", e);
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
				
			case MODE_PENDING_CONFIRM:

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
	

}
