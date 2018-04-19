package com.arnold.rbac.service.impl;

import com.arnold.rbac.dao.SysPermissionMapper;
import com.arnold.rbac.model.SysPermission;
import com.arnold.rbac.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author Arnold
 */
@Service
public class PermissionServiceImpl implements PermissionService{
	@Autowired
	SysPermissionMapper permissionMapper;

	@Override
	public Integer savePermission(SysPermission permission) {
		if (permission.getId() == null || permission.getId() == 0) {
			//新增
			permission.setCreater("Admin");
			permission.setCreateTime(new Date());
			permission.setEditor("Admin");
			permission.setEditTime(new Date());
			return permissionMapper.insertSelective(permission);
		} else {
			//更新
			permission.setEditor("Admin");
			permission.setEditTime(new Date());
			return permissionMapper.updateByPrimaryKeySelective(permission);
		}
	}

	@Override
	public Integer deletePermission(int id) {
		SysPermission sysPermission = getPermissionById(id);
		Assert.notNull(sysPermission,"id: " + id + " not find");
		sysPermission.setEditor("Admin");
		sysPermission.setEditTime(new Date());
		sysPermission.setIsDel(true);
		return permissionMapper.updateByPrimaryKeySelective(sysPermission);
	}

	@Override
	public SysPermission getPermissionById(int id) {
		SysPermission sysPermission = permissionMapper.selectByPrimaryKey(id);
		//Assert.notNull(sysPermission,"id: " + id + " not find");
		return sysPermission;
	}

	@Override
	public void deleteBatch(List<Integer> permissionIds) {
		//Assert.notNull(permissionIds);
		if (CollectionUtils.isEmpty(permissionIds))
			return;
		permissionMapper.deleteBatch(permissionIds);
	}


}
