package com.arnold.rbac.service;

import com.arnold.rbac.model.SysRole;
import com.arnold.rbac.model.SysUser;

import java.util.List;

public interface UserService {

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;

	List<SysRole> getUserRolesList(Integer userId);

	SysUser getUserById(Integer userId);

	SysUser getUserByName(String name);
}
