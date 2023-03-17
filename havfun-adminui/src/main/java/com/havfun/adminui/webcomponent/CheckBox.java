package com.havfun.adminui.webcomponent;

import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckBox extends WebComponent {

	private static final Logger LOGGER = LogManager.getLogger(CheckBox.class.getName());

	private String htmlCheckProperty = "";
	private String cssColorFontClass = "";
	private String htmlAmendedMessage = "";
	
	//New
	private String buttonYes = "";
	private String buttonNo = "";

	public CheckBox(Map<String, Object> valueMap) {
		super(valueMap);
	}


	@Override
	public String getWebComponentHtml(ResourceBundle resourceBundle, int pageMode, List<String> choiceList,
			Object value, Object origValue) {

		int webComponentMode = getComponentMode(pageMode);
		String finalHtml = "";

		htmlCheckProperty = "";
		cssColorFontClass = "";
		htmlAmendedMessage = "";
		
		configCheckBox(value, origValue);
		
		//New
		buttonYes = resourceBundle.getString("common_yes");
		buttonNo = resourceBundle.getString("common_no");
//		buttonYes = "YES";
//		buttonNo = "NO";
		
		//String htmlCheckboxFormat = "<input type=\"%s\" class=\"web_component_input\" id=\"%s\" name=\"%s\" %s %s %s><label for=\"%s\" %s %s><span %s></span>%s</label>";
		String htmlCheckboxFormat = "<input type=\"%s\" class=\"web_component_input\" id=\"%s\" name=\"%s\" %s %s %s>";
		htmlCheckboxFormat		+=	"<label for=\"%s\" %s %s><span class=\"checkboxLabelYes\" %s>" + buttonYes + "</span><span class=\"checkboxLabelNo\" %s>" + buttonNo + "</span></label><div style=\"float:left;\" %s>%s</div>";
		//New
		//String htmlCheckboxFormat = "<div class=\"buttonYes\" id=\"%s\" style=\"display:%s;%s\">" + buttonYes + "</div>";
		//htmlCheckboxFormat		 += "<div class=\"buttonNo\" id=\"%s\" style=\"display:%s;%s\">" + buttonNo + "</div>";
		//htmlCheckboxFormat		 += "<div %s style=\"float:left;padding-left:5px;\">%s</div>";
		//htmlCheckboxFormat		 += "<input type=\"%s\" class=\"web_component_input web_component_input_yes_no\" id=\"%s\" name=\"%s\" %s %s %s>";
		
		switch(webComponentMode){
			
			case MODE_EDITABLE:
		
				//finalHtml = String.format(htmlCheckboxFormat, "checkbox", key, key, htmlCheckProperty, "", "", key, cssColorFontClass, "", "", "");
				finalHtml = String.format(htmlCheckboxFormat, "checkbox", key, key, htmlCheckProperty, "", "", key, "", "", "", "", cssColorFontClass, "");
				//New
				//finalHtml = String.format(htmlCheckboxFormat, "", buttonYesDisplay, "", "", buttonNoDisplay, "", cssColorFontClass, "", "checkbox", key, key, htmlCheckProperty, "", "");
				
				break;

			case MODE_READONLY:
			case MODE_DISABLED:
				if ( value != null ){
					
					//finalHtml = String.format(htmlCheckboxFormat, "checkbox", key + "_checkbox", key + "_checkbox", htmlCheckProperty, "disabled", "style=\"cursor:default;\"", key + "_checkbox", cssColorFontClass, "style=\"cursor:default;\"", "style=\"cursor:default;\"", "");
					finalHtml = String.format(htmlCheckboxFormat, "checkbox", key + "_checkbox", key + "_checkbox", htmlCheckProperty, "disabled", "style=\"cursor:default;\"", key + "_checkbox", "style=\"cursor:default;\"", "style=\"cursor:default;\"", "style=\"cursor:default;\"", "style=\"cursor:default;\"", cssColorFontClass, "");
					//New
					//finalHtml = String.format(htmlCheckboxFormat, "", buttonYesDisplay, "cursor:default;", "", buttonNoDisplay, "cursor:default;", cssColorFontClass, "", "checkbox", key + "_checkbox", key + "_checkbox", htmlCheckProperty, "disabled", "style=\"cursor:default;\"");
					finalHtml += "<input type=\"hidden\" id=\"" + key + "\" name =\"" + key + "\" value=\"" + ((Boolean.valueOf(value.toString()))?"on":"off") + "\" >";
					
				}
				
				break;
				 
			case MODE_HIDDEN:
				//finalHtml = String.format(htmlCheckboxFormat, "checkbox", key, key, htmlCheckProperty, "", "", key, cssColorFontClass, "", "", "");
				finalHtml = String.format(htmlCheckboxFormat, "checkbox", key, key, htmlCheckProperty, "", "hidden", key, "style=\"display:none\"", "", "style=\"display:none\"", "style=\"display:none\"", cssColorFontClass, "");
				//New
				//finalHtml = String.format(htmlCheckboxFormat, "", "none", "", "", "none", "", cssColorFontClass, "", "hidden", key, key, htmlCheckProperty, "", "");
				
				break;
				
			
			case MODE_PENDING_CONFIRM:	
				
				//finalHtml = String.format(htmlCheckboxFormat, "checkbox", key, key, htmlCheckProperty, "disabled", "style=\"cursor:default;\"", key, cssColorFontClass, "style=\"cursor:default;\"", "style=\"cursor:default;\"", htmlAmendedMessage);
				finalHtml = String.format(htmlCheckboxFormat, "checkbox", key, key, htmlCheckProperty, "disabled", "style=\"cursor:default;\"", key, "style=\"cursor:default;\"", "style=\"cursor:default;\"", "style=\"cursor:default;\"", "style=\"cursor:default;\"", cssColorFontClass, htmlAmendedMessage);
				//New
				//finalHtml = String.format(htmlCheckboxFormat, "", buttonYesDisplay, "cursor:default;", "", buttonNoDisplay, "cursor:default;", cssColorFontClass, htmlAmendedMessage, "checkbox", key, key, htmlCheckProperty, "disabled", "style=\"cursor:default;\"");
				
				break;
		
			default:
				break;
		}
		
		
		LOGGER.debug(finalHtml);
		return finalHtml;
	}

	private void configCheckBox(Object value, Object origValue) {
		boolean isValueChecked = (value != null) ? ((Boolean) value).booleanValue() : false;
		boolean isOrigValueChecked = (origValue != null) ? ((Boolean) origValue).booleanValue() : false;

		if (value != null && isValueChecked) {

			htmlCheckProperty = "checked=\"checked\"";
			
			if (origValue != null && !isOrigValueChecked) {
				cssColorFontClass = "    class=\"blueFont\"";
				htmlAmendedMessage = "(Checked)";
			}
		} else if ((value != null && !isValueChecked) && (origValue != null && isOrigValueChecked)) {
			cssColorFontClass = "    class=\"redFont\"";
			htmlAmendedMessage = "(Unchecked)";
		}
	}

}