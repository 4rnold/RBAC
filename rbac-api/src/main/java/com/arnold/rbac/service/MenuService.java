package com.arnold.rbac.service;

import com.arnold.rbac.model.SysMenu;

import java.util.List;

public interface MenuService {

	List<SysMenu> getMenuList();

	SysMenu getMenuById(Integer id);

	void saveMenu(SysMenu sysMenu);

	void deleteMenu(int id);

	List<SysMenu> getChildrenMenus(int id);

	void deleteBatch(List<Integer> menuIds);

}
