package com.arnold.rbac.service.impl;

import com.arnold.rbac.dao.SysMenuMapper;
import com.arnold.rbac.dao.SysPermissionMapper;
import com.arnold.rbac.dao.SysUserMapper;
import com.arnold.rbac.model.SysElement;
import com.arnold.rbac.model.SysMenu;
import com.arnold.rbac.model.SysPermission;
import com.arnold.rbac.service.ElementService;
import com.arnold.rbac.service.MenuService;
import com.arnold.rbac.service.PermissionService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.awt.peer.MenuPeer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private SysMenuMapper menuMapper;

	@Autowired
	PermissionService permissionService;

	@Autowired
	ElementService elementService;

	@Override
	public List<SysMenu> getMenuList() {
		return menuMapper.selectAllMenus();
	}

	@Override
	public SysMenu getMenuById(Integer id) {
		SysMenu sysMenu = menuMapper.selectByPrimaryKey(id);
		return sysMenu;
	}

	/**
	 * 保存一条menu记录
	 * @param sysMenu
	 */
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void saveMenu(SysMenu sysMenu) {
		SysPermission sysPermission = sysMenu.getPermission();
		if (sysPermission != null) {
			permissionService.savePermission(sysPermission);
		}
		if (sysMenu.getParentId() == 0) {
			//根目录
			sysMenu.setParentIds("0,");
		} else {
			SysMenu parentMenu = getMenuById(sysMenu.getParentId());
			Assert.notNull(parentMenu);
			sysMenu.setParentIds(parentMenu.getParentIds() + parentMenu.getId() + ",");
		}

		if (sysMenu.getId() == null || sysMenu.getId() == 0) {
			sysMenu.setCreateBy("Admin");
			sysMenu.setCreateDate(new Date());
			sysMenu.setEditDate(new Date());
			sysMenu.setEditor("Admin");
			sysMenu.setPermissionId(sysPermission.getId());
			menuMapper.insertSelective(sysMenu);
		} else {
			sysMenu.setEditDate(new Date());
			sysMenu.setEditor("Admin");
			sysMenu.setPermissionId(sysPermission.getId());
			menuMapper.updateByPrimaryKeySelective(sysMenu);
		}
	}

	/*@Override
	@Transactional
	public void deleteMenu(int id) {
		SysMenu menu = getMenuById(id);
		Assert.notNull(menu);
		//层级删除
		List<SysMenu> childrenMenus = getChildrenMenus(menu.getId());
		List<Integer> childrenPermissionIds = new ArrayList<>();
		for (SysMenu childrenMenu : childrenMenus) {
			childrenPermissionIds.add(childrenMenu.getPermissionId());
		}

		Integer permissionId = menu.getPermissionId();
		permissionService.deletePermission(permissionId);
		menu.setIsDel(true);
		saveMenu(menu);
	}*/

	/**
	 * 删除，批量删除
	 * 删除menu
	 * 删除Element
	 * 删除permission
	 * @param id
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteMenu(int id) {
		SysMenu menu = getMenuById(id);
		Assert.notNull(menu);
		//层级删除
		List<SysMenu> childrenMenus = getChildrenMenus(menu.getId());
		List<SysMenu> delMenus = childrenMenus;
		delMenus.add(menu);

		List<Integer> delMenusIds = delMenus.stream().map(SysMenu::getId).collect(Collectors.toList());

		List<Integer> delMenuPIds = delMenus.stream().map(SysMenu::getPermissionId).collect(Collectors.toList());

		List<SysElement> delElements = elementService.getElementsByMenuIds(delMenusIds);

		List<Integer> delEleIds = delElements.stream().map(SysElement::getId).collect(Collectors.toList());

		List<Integer> delElePIds = delElements.stream().map(SysElement::getPermissionId).collect(Collectors.toList());

		List<Integer> delPIds = new ArrayList<>();
		delPIds.addAll(delElePIds);
		delPIds.addAll(delMenuPIds);
		delPIds.add(menu.getPermissionId());

		deleteBatch(delMenusIds);
		elementService.deleteBatch(delEleIds);
		permissionService.deleteBatch(delPIds);
	}




	@Override
	public List<SysMenu> getChildrenMenus(int id) {
		SysMenu sysMenu = new SysMenu();
		sysMenu.setParentIds(","+id+",");
		List<SysMenu> menus = menuMapper.getMenusBycondition(sysMenu);
		return menus;
	}

	@Override
	public void deleteBatch(List<Integer> menuIds) {
		if (CollectionUtils.isEmpty(menuIds))
			return;
		menuMapper.deleteBatch(menuIds);
	}


}
