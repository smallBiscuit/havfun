package com.havfun.adminui.taglib;


import java.io.IOException;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.jstl.fmt.LocalizationContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.havfun.adminui.webcomponent.WebComponent;

public class WebComponentHandler extends TagSupport {
	
	private static final Logger LOGGER = LogManager.getLogger(WebComponentHandler.class.getName());
	
	private static final long serialVersionUID = 1L;
	
	private WebComponent webComponent;
	private LocalizationContext bundle;
	private String labelKey;
	private int pageMode;
	private boolean skipLabel;	
	private List<String> choiceList;
	private List<String> labelList;
	private Object value;
	private Object origValue;
	
	public String getDisplay(ResourceBundle resourceBundle, String key) {
		String message = "";
		try {
			message = resourceBundle.getString(key);
		} catch (MissingResourceException e) {
			message = key;
		}
		
		return message;
	}
	
	@Override
	public int doStartTag() {
		
		if ( webComponent != null && !webComponent.isHidden(pageMode)) {
		
			ResourceBundle resourceBundle = bundle.getResourceBundle();	
			try {
	            //Get the writer object for output.
	            JspWriter out = pageContext.getOut();
	            
	            if ( !skipLabel ){
					
					out.print("<td class=\"form_label\">");
					
					
					if ( !webComponent.isHidden(pageMode) ){
						
						if ( labelKey != null ){
							out.print(getDisplay(resourceBundle, labelKey ));
						}else{
							out.print(getDisplay(resourceBundle, webComponent.getKey()));
						}
						
						if ( webComponent.getMandatoryFlag()) {
							out.print("<span class=\"mandatory_symbol\">*</span>");
						}
						out.print(":");
						
					}
					
					out.print("</td>");
				
				}

				out.print("<td>");
            	
            	if ( labelList != null ){
            		out.print( webComponent.getWebComponentHtmlSelection(resourceBundle, pageMode, choiceList, labelList, value, origValue) );
            	}else{
            		out.print( webComponent.getWebComponentHtml(resourceBundle, pageMode, choiceList, value, origValue) );
            	}	            	
            	out.print("</td>");

	            
	        } catch (IOException e) {
	        	LOGGER.warn("WebComponentHandler Exception: " , e );
	        }
		}
		
		return SKIP_BODY;
	}

	public WebComponent getWebComponent() {
		return webComponent;
	}

	public void setWebComponent(WebComponent webComponent) {
		this.webComponent = webComponent;
	}

	public String getLabelKey() {
		return labelKey;
	}

	public void setLabelKey(String labelKey) {
		this.labelKey = labelKey;
	}

	public int getPageMode() {
		return pageMode;
	}

	public void setPageMode(int pageMode) {
		this.pageMode = pageMode;
	}

	public boolean isSkipLabel() {
		return skipLabel;
	}

	public void setSkipLabel(boolean skipLabel) {
		this.skipLabel = skipLabel;
	}

	public List<String> getChoiceList() {
		return choiceList;
	}

	public void setChoiceList(List<String> choiceList) {
		this.choiceList = choiceList;
	}

	public List<String> getLabelList() {
		return labelList;
	}

	public void setLabelList(List<String> labelList) {
		this.labelList = labelList;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Object getOrigValue() {
		return origValue;
	}

	public void setOrigValue(Object origValue) {
		this.origValue = origValue;
	}

	public LocalizationContext getBundle() {
		return bundle;
	}

	public void setBundle(LocalizationContext bundle) {
		this.bundle = bundle;
	}
	
}
