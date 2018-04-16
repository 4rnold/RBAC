package com.arnold.rbac.utils;

import com.arnold.rbac.model.SysMenu;
import com.arnold.rbac.service.MenuService;
import com.arnold.rbac.vo.MenuVo;
import com.arnold.utils.SpringContextHolder;
import com.arnold.utils.StringUtils;
import org.apache.commons.collections.ListUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PageUtils {

	public static List<SysMenu> getMenus() {
		List<SysMenu> menus = new ArrayList<>();
		return menus;
	}

	public static List<MenuVo> getMenuVoList() {
		MenuService menuService = SpringContextHolder.getBean(MenuService.class);
		List<SysMenu> menuList = menuService.getMenuList();
		List<MenuVo> menuVos = new ArrayList<>();

		MenuVo rootMenu = new MenuVo();
		rootMenu.setId(0);

		//递归生成菜单树
		getMenuTree(rootMenu, menuList);

		return rootMenu.getSubMenus();
	}

	private static void getMenuTree(MenuVo thisNode, List<SysMenu> menuList) {
		for (SysMenu sysMenu : menuList) {
			if (sysMenu.getParentId().equals(thisNode.getId())){
				MenuVo menuVo = new MenuVo(sysMenu);
				thisNode.getSubMenus().add(menuVo);
				getMenuTree(menuVo, menuList);
			}
		}

		/*if (thisNode.getSubMenus() == null || thisNode.getSubMenus().size() ==0) {
			return;
		}

		for (MenuVo subMenu : thisNode.getSubMenus()) {
			getMenuTree(subMenu,menuList);
		}*/
	}

/*	private static void getMenuTree(MenuVo thisNode, List<SysMenu> menuList) {
		for (SysMenu sysMenu : menuList) {
			if (sysMenu.getParentId().equals(String.valueOf(thisNode.getId()))){
				thisNode.getSubMenus().add(new MenuVo(sysMenu));
			}
		}

		if (thisNode.getSubMenus() == null || thisNode.getSubMenus().size() ==0) {
			return;
		}

		for (MenuVo subMenu : thisNode.getSubMenus()) {
			getMenuTree(subMenu,menuList);
		}
	}*/

}
