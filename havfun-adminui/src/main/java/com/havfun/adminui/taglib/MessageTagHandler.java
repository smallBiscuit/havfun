package com.havfun.adminui.taglib;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MessageTagHandler extends TagSupport {

	private static final long serialVersionUID = 1L;
	private String message;
	private List<String> substituteList;
	
	@Override
	public int doStartTag() {
		try {
            //Get the writer object for output.
            JspWriter out = pageContext.getOut();
            
            if (substituteList != null) {
            	for (int i=0; i<substituteList.size(); i++) {
            		message = message.replaceFirst("\\$" + i, substituteList.get(i));
            	}
            }
 
            //Perform substr operation on string.
            out.println(message);
 
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return SKIP_BODY;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<String> getSubstituteList() {
		return this.substituteList;
	}
	
	public void setSubstituteList(List<String> substituteList) {
		this.substituteList = substituteList;
	}
}
