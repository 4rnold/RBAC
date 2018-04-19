package com.arnold.rbac.service.impl;

import com.arnold.rbac.dao.SysElementMapper;
import com.arnold.rbac.model.SysElement;
import com.arnold.rbac.model.SysMenu;
import com.arnold.rbac.model.SysPermission;
import com.arnold.rbac.service.ElementService;
import com.arnold.rbac.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class ElementServiceImpl implements ElementService{

	@Autowired
	SysElementMapper sysElementMapper;

	@Autowired
	PermissionService permissionService;

	@Override
	public List<SysElement> getElements() {
		List<SysElement> elementList = sysElementMapper.getElementList();
		return elementList;
	}

	@Override
	public SysElement getElementById(Integer id) {
		if (id == null)
			return null;
		SysElement sysElement = sysElementMapper.selectByPrimaryKey(id);
		return sysElement;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void saveElement(SysElement sysElement) {
		SysPermission sysPermission = sysElement.getPermission();
		if (sysPermission != null) {
			permissionService.savePermission(sysPermission);
		}
		if (sysElement.getId() == null || sysElement.getId() == 0) {
			sysElement.setCreater("Admin");
			sysElement.setCreateDate(new Date());
			sysElement.setEditDate(new Date());
			sysElement.setEditor("Admin");
			sysElement.setPermissionId(sysPermission.getId());
			sysElementMapper.insertSelective(sysElement);
		} else {
			sysElement.setEditDate(new Date());
			sysElement.setEditor("Admin");
			sysElement.setPermissionId(sysPermission.getId());
			sysElementMapper.updateByPrimaryKeySelective(sysElement);
		}
	}

	@Override
	public void deleteElement(int id) {
		SysElement element = getElementById(id);
		Assert.notNull(element,"id: " + id + " not exist");

		Integer permissionId = element.getPermissionId();
		permissionService.deletePermission(permissionId);
		element.setIsDel(true);
		saveElement(element);
	}

	@Override
	public void deleteBatch(List<Integer> elementIds) {
		if (CollectionUtils.isEmpty(elementIds))
			return;
		sysElementMapper.deleteBatch(elementIds);
	}

	@Override
	public List<SysElement> getElementsByMenuIds(List<Integer> menuIds) {
		Assert.notNull(menuIds);
		return sysElementMapper.getElementsByMenuIds(menuIds);
	}
}
