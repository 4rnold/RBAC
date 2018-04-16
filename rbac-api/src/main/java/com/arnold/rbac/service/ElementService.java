package com.arnold.rbac.service;

import com.arnold.rbac.model.SysElement;

import java.util.List;

public interface ElementService {
	List<SysElement> getElements();
	SysElement getElementById(Integer id);
}
