package com.arnold.rbac.service.impl;

import com.arnold.rbac.constant.UserStatus;
import com.arnold.rbac.dao.SysUserMapper;
import com.arnold.rbac.model.SysRole;
import com.arnold.rbac.model.SysUser;
import com.arnold.rbac.service.UserService;
import com.arnold.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Arnold
 */
@Service
public class UserServiceImpl implements UserService {



	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public List<SysRole> getUserRolesList(Integer userId) {
		return null;
	}

	@Override
	public SysUser getUserById(Integer userId) {
		if (userId == null) {
			return null;
		}
		SysUser user = sysUserMapper.getUserWithRoleAndPermission(userId);
		return user;
	}

	@Override
	public SysUser getUserByName(String name) {
		if (StringUtils.isBlank(name)) {
			return null;
		}
		SysUser user = sysUserMapper.getByUsername(name);
		return user;
	}
}
