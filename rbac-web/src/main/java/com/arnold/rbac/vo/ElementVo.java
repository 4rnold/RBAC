package com.arnold.rbac.vo;

import com.arnold.rbac.model.SysElement;
import com.arnold.rbac.model.SysPermission;

import java.io.Serializable;

public class ElementVo implements Serializable{
	public static final String ID_PREFIX = "element-";
	private Integer id;
	private String name;
	private Integer menu_id;
	private Integer permission_id;
	private String permission_str;
	private String permission_name;

	public ElementVo() {}
	public ElementVo(SysElement element) {
		this.id = element.getId();
		this.name = element.getName();
		this.menu_id = element.getMenuId();
		this.permission_id = element.getPermissionId();
		if (element.getPermission() != null) {
			this.permission_str = element.getPermission().getPermissionStr();
			this.permission_name = element.getPermission().getPermissionName();
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}

	public Integer getPermission_id() {
		return permission_id;
	}

	public void setPermission_id(Integer permission_id) {
		this.permission_id = permission_id;
	}

	public String getPermission_str() {
		return permission_str;
	}

	public void setPermission_str(String permission_str) {
		this.permission_str = permission_str;
	}

	public String getPermission_name() {
		return permission_name;
	}

	public void setPermission_name(String permission_name) {
		this.permission_name = permission_name;
	}

	public SysElement ConvertToSysElement() {
		SysElement sysElement = new SysElement();
		sysElement.setName(this.name);
		sysElement.setId(this.id);
		sysElement.setMenuId(this.menu_id);
		sysElement.setPermissionId(this.permission_id);
		SysPermission sysPermission = new SysPermission();
		sysPermission.setPermissionStr(this.permission_str);
		sysPermission.setPermissionName(this.name);
		sysPermission.setId(this.permission_id);
		sysElement.setPermission(sysPermission);
		return sysElement;
	}
}
