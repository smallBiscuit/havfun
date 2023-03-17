package com.havfun.adminui.webcomponent;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.adminui.utils.DisplayFormatHelper;

public class NumberInput extends WebComponent {

	private static final Logger LOGGER = LogManager.getLogger(NumberInput.class.getName());

	protected int width;
	protected int displayFormatType; //DisplayFormatHelper
	protected int digit = -1;
	protected int decimalPlace = 0;
	protected int minimum = -1;
	
	public NumberInput(Map<String, Object> valueMap, int displayFormatType, int digit, int decimalPlace ) {
		
		super( valueMap);
		this.displayFormatType = displayFormatType;
		this.digit = digit;
		this.decimalPlace = decimalPlace;
		
	}
	
	public NumberInput(Map<String, Object> valueMap, int displayFormatType, int digit, int decimalPlace, int minimum ) {
		super( valueMap);
		this.displayFormatType = displayFormatType;
		this.digit = digit;
		this.decimalPlace = decimalPlace;
		this.minimum = minimum;
	}
		
	@Override
	public String getWebComponentHtml(ResourceBundle resourceBundle, int pageMode, List<String> choiceList,
			Object value, Object origValue) {
		
		int webComponentMode = getComponentMode(pageMode);
		String valueString = objectToString(value);
		String origValueString = objectToString(origValue);

		String numberFormatString = "";
		boolean isValueChange = isNumberChange(value, origValue);
		
		int maxLength = 20;
		
		if (decimalPlace >= 0 ) {
			numberFormatString = numberFormatString + " data-m-dec=\"" + decimalPlace + "\" ";
		}
		
		if ( this.minimum >= 0 ) {
			
			numberFormatString = numberFormatString + " data-v-min=\"0\" ";
			
		}
		
		
		String inputHtmlFormat = "<input type=\"%s\" class=\"numberInput web_component_input\" id=\"%s\" name=\"%s\" maxlength=\"%s\" autocomplete=\"off\" value=\"%s\" %s>";
		String finalHtml = "";

		switch(webComponentMode){
			
			case MODE_EDITABLE:
			
				finalHtml = String.format(inputHtmlFormat, "text", key, key, maxLength, valueString, numberFormatString);
				break;
		
			case MODE_READONLY:
			case MODE_DISABLED:
			case MODE_HIDDEN:	
			case MODE_PENDING_APPROVAL:	
				finalHtml = String.format(inputHtmlFormat, "hidden", key, key, maxLength, valueString, numberFormatString);
				break;		
		}
		
		String labelEffectHtml = "<span class= \"%s\"> %s </span>";
		
		switch(webComponentMode){
		
			case MODE_EDITABLE:
			case MODE_HIDDEN:
				break;
			
			case MODE_READONLY:
			case MODE_DISABLED:
		
				
				finalHtml+= displayFormatHelperFunction(value, this.displayFormatType, this.decimalPlace );
				break;
				
			case MODE_PENDING_APPROVAL:
				
				if ( !isValueChange ){
					finalHtml+= displayFormatHelperFunction(value, this.displayFormatType, this.decimalPlace );
				}else{

					if(origValueString.equals("")){
						finalHtml += String.format(labelEffectHtml, "blueFont", displayFormatHelperFunction(value, this.displayFormatType, this.decimalPlace ));
					}else{
						finalHtml+= String.format(labelEffectHtml, "grayFont", displayFormatHelperFunction(origValue, this.displayFormatType, this.decimalPlace )) + " > " + String.format(labelEffectHtml, "redFont", displayFormatHelperFunction(value, this.displayFormatType, this.decimalPlace ));
					}
				}
				break;
				
			default: 
				break;
			
		}
		
		//LOGGER.debug(finalHtml);
		return finalHtml;
	}

	
	private boolean isNumberChange(Object value, Object origValue) {
		
		if (value == null && origValue == null) {
			return false;
		} else if (value == null && origValue != null) {
			return true;
		} else if (value != null && origValue == null) {
			return true;
		}
		
		try {
			if(new BigDecimal(String.valueOf(value)).compareTo(new BigDecimal(String.valueOf(origValue))) == 0) {
				return false;
			}
		} catch (NumberFormatException e) {
			LOGGER.debug("Exception", e);
			return false;
		}
		
		return true;
	}

	private String displayFormatHelperFunction(Object value, int displayFormatType, int decimalPlace ){
		try{
			switch(displayFormatType){
			case NUMBER_INPUT_TYPE_NUMBER:
				return DisplayFormatHelper.getDisplayValue((Number) value, DisplayFormatHelper.DISPLAY_NUMBER_FORMAT_NUMBER);
			case NUMBER_INPUT_TYPE_BALANCE:
				return DisplayFormatHelper.getDisplayValue((Number) value, DisplayFormatHelper.DISPLAY_NUMBER_FORMAT_BALANCE);
			case NUMBER_INPUT_TYPE_PRICE:
				return DisplayFormatHelper.getDisplayValue((Number) value, DisplayFormatHelper.DISPLAY_NUMBER_FORMAT_PRICE);
			case NUMBER_INPUT_TYPE_AVERAGE_PRICE:
				return DisplayFormatHelper.getDisplayValue((Number) value, DisplayFormatHelper.DISPLAY_NUMBER_FORMAT_AVERAGE_PRICE);	
			case NUMBER_INPUT_TYPE_PERCENTAGE:
				return DisplayFormatHelper.getDisplayValue((Number) value, DisplayFormatHelper.DISPLAY_NUMBER_FORMAT_PERCENTAGE);
			case NUMBER_INPUT_TYPE_QUANTITY:
				return DisplayFormatHelper.getDisplayValue((Number) value, DisplayFormatHelper.DISPLAY_NUMBER_FORMAT_QUANTITY);
			case NUMBER_INPUT_TYPE_AMOUNT:
				
				//return DisplayFormatHelper.getDisplayValue((Number) value, DisplayFormatHelper.DISPLAY_NUMBER_FORMAT_SMALL_AMOUNT);
				String pattern = "#,###,##0.";
				
				for ( int i = 0; i < decimalPlace; i ++ ){
					
					pattern += "0";
					
				}
								
				DecimalFormat formatter = new DecimalFormat( pattern );
				
				return formatter.format( (Number) value );
				
			default:
				return objectToString(value);
			}
		}catch(Exception e){
			LOGGER.debug("Exception NumberInput displayFormatHelperFunction " + e);
			return objectToString(value);
		}
	}
	
}