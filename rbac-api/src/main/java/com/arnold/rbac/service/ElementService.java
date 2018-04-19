package com.arnold.rbac.service;

import com.arnold.rbac.model.SysElement;
import com.arnold.rbac.model.SysMenu;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ElementService {
	List<SysElement> getElements();
	SysElement getElementById(Integer id);


	@Transactional(rollbackFor=Exception.class)
	void saveElement(SysElement sysElement);

	void deleteElement(int id);

	void deleteBatch(List<Integer> elementIds);

	/**
	 * 删除父目录用
	 */
	//void deleteBatchByPIds(List<Integer> pIds);
	List<SysElement> getElementsByMenuIds(List<Integer> menuIds);

}
