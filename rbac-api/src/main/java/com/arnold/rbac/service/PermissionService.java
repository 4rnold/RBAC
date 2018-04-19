package com.arnold.rbac.service;

import com.arnold.rbac.model.SysPermission;

import java.util.List;

public interface PermissionService {
	Integer savePermission(SysPermission permission);

	/*Integer updatePermission(SysPermission permission);*/

	Integer deletePermission(int id);

	SysPermission getPermissionById(int id);

	void deleteBatch(List<Integer> permissionIds);
}
