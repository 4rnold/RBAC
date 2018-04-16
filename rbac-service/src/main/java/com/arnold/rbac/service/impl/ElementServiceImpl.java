package com.arnold.rbac.service.impl;

import com.arnold.rbac.dao.SysElementMapper;
import com.arnold.rbac.model.SysElement;
import com.arnold.rbac.service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementServiceImpl implements ElementService{

	@Autowired
	SysElementMapper sysElementMapper;

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
}
