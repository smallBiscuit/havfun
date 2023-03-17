package com.havfun.adminui.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.havfun.adminui.helper.TimeDisplayHelper;

public class TimeDisplayTagHandler extends TagSupport {
	
	private static final long serialVersionUID = 1L;
	private long time;
	private String displayUnit;
	
	@Override
	public int doStartTag() {
		try {
			String [] displayUnitArray  = displayUnit.split("\\|");

            //Get the writer object for output.
            JspWriter out = pageContext.getOut();
            
            //Assume the input time and server are in the same timezone...
            //For our case, both of them should be in GMT...
            long now = System.currentTimeMillis();
            
            long diff = now - time;
            
            String value = TimeDisplayHelper.getTimeDisplayTag(diff, displayUnitArray);
            
            out.println(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
		return SKIP_BODY;
	}
	
	public long getTime() {
		return this.time;
	}
	
	public void setTime(long time) {
		this.time = time;
	}
	
	public String getDisplayUnit() {
		return this.displayUnit;
	}
	
	public void setDisplayUnit(String displayUnit) {
		this.displayUnit = displayUnit;
	}
}
