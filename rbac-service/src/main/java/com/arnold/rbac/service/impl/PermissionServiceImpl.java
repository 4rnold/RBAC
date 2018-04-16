package com.arnold.rbac.service.impl;

import com.arnold.rbac.dao.SysPermissionMapper;
import com.arnold.rbac.model.SysPermission;
import com.arnold.rbac.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PermissionServiceImpl implements PermissionService{
	@Autowired
	SysPermissionMapper permissionMapper;

	@Override
	public void savePermission(SysPermission permission) {
		if (permission.getId() == 0) {
			//新增
			permission.setCreater("Admin");
			permission.setCreateTime(new Date());
			permission.setEditor("Admin");
			permission.setEditTime(new Date());
			permissionMapper.insert(permission);
		} else {
			//更新
			permission.setEditor("Admin");
			permission.setEditTime(new Date());
			permissionMapper.updateByPrimaryKey(permission);
		}
	}
}
