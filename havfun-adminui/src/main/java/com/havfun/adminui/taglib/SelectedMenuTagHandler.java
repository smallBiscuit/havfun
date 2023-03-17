package com.havfun.adminui.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SelectedMenuTagHandler extends TagSupport {
	
	private static final long serialVersionUID = 1L;
	
	private String menu;
	private String selectedMenu;
	
	@Override
	public int doStartTag() {
		try {
            //Get the writer object for output.
            JspWriter out = pageContext.getOut();
            
            if (menu != null && menu.equals(selectedMenu)) {
            	out.println(" class=\"current-menu-item\" ");
            }
             
        } catch (IOException e) {
            e.printStackTrace();
        }
		return SKIP_BODY;
	}
	
	public String getMenu() {
		return this.menu;
	}
	
	public void setMenu(String menu) {
		this.menu = menu;
	}
	
	public String getSelectedMenu() {
		return this.selectedMenu;
	}
	
	public void setSelectedMenu(String selectedMenu) {
		this.selectedMenu = selectedMenu;
	}

}
