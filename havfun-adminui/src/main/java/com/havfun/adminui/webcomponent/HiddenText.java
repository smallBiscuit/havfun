package com.havfun.adminui.webcomponent;

import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class HiddenText extends WebComponent {

	public HiddenText(Map<String, Object> valueMap)
	{
		super( valueMap);
	}
		
	@Override
	public String getWebComponentHtml(ResourceBundle resourceBundle, int pageMode, List<String> choiceList, Object value, Object origValue) {
		
		String finalHtml = "<input type=\"hidden\" id=\"" + key + "\" name=\"" + key + "\" value=\"" + objectToString(value) + "\">";
		
		return finalHtml;
	}

}