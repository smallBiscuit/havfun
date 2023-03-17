package com.havfun.adminui.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MenuHelper {
	
	private static final Logger LOGGER = LogManager.getLogger(MenuHelper.class.getName());
	
	private List<Menu> menuList;

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
	
	public List<Menu> generateMenu(Map<String, Boolean> actionMap) {
		List<Menu> generatedMenuList = new ArrayList<Menu>();
		
		if (menuList != null && actionMap != null) {
			for (Menu menu : menuList) {
				if (menu.getSubMenuList() != null) {
					List<SubMenu> generatedSubMenuList = new ArrayList<SubMenu>();
					
					for (SubMenu subMenu : menu.getSubMenuList()) {
//						if (actionMap.get(subMenu.getKey()) != null) {
							generatedSubMenuList.add(subMenu);
//						}
					}
					
					if (generatedSubMenuList.size() > 0) {
						Menu generatedMenu = new Menu();
						
						generatedMenu.setKey(menu.getKey());
						generatedMenu.setUrl(generatedSubMenuList.get(0).getUrl());
						generatedMenu.setSubMenuList(generatedSubMenuList);
						
						generatedMenuList.add(generatedMenu);
					}
				}
			}
		}
		
		return generatedMenuList;
	}
}
