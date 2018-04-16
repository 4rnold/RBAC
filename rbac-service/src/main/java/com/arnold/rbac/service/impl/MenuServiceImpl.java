package com.arnold.rbac.service.impl;

import com.arnold.rbac.dao.SysMenuMapper;
import com.arnold.rbac.dao.SysPermissionMapper;
import com.arnold.rbac.dao.SysUserMapper;
import com.arnold.rbac.model.SysMenu;
import com.arnold.rbac.model.SysPermission;
import com.arnold.rbac.service.MenuService;
import com.arnold.rbac.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.peer.MenuPeer;
import java.util.Date;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private SysMenuMapper menuMapper;

	@Autowired
	PermissionService permissionService;

	@Override
	public List<SysMenu> getMenuList() {
		return menuMapper.selectAllMenus();
	}

	@Override
	public SysMenu getMenuById(Integer id) {
		SysMenu sysMenu = menuMapper.selectByPrimaryKey(id);
		return sysMenu;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void saveMenu(SysMenu sysMenu) {
		SysPermission sysPermission = sysMenu.getPermission();
		if (sysPermission != null) {
			permissionService.savePermission(sysPermission);
		}
		if (sysMenu.getId() == 0) {
			sysMenu.setCreateBy("Admin");
			sysMenu.setCreateDate(new Date());
			sysMenu.setEditDate(new Date());
			sysMenu.setEditor("Admin");
			menuMapper.insert(sysMenu);
		} else {
			sysMenu.setEditDate(new Date());
			sysMenu.setEditor("Admin");
			menuMapper.updateByPrimaryKeySelective(sysMenu);
		}
	}


}
