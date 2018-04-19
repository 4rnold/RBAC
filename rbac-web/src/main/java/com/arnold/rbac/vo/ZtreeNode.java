
package com.arnold.rbac.vo;

import com.arnold.rbac.model.SysElement;
import com.arnold.rbac.model.SysMenu;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ZtreeNode {
	private String id;
	private String pId;
	private String name;
	private String permission;
	private String url;
	private boolean isMenu;
	private boolean isParent;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty(value = "isMenu")
	public boolean isMenu() {
		return isMenu;
	}

	public void setMenu(boolean menu) {
		isMenu = menu;
	}

	@JsonProperty(value = "isParent")
	public boolean isParent() {
		return isParent;
	}

	public void setParent(boolean parent) {
		isParent = parent;
	}

	public ZtreeNode() {

	}


	public ZtreeNode(SysMenu sysMenu) {
		if (sysMenu != null) {
			this.id = String.valueOf(sysMenu.getId());
			this.pId = String.valueOf(sysMenu.getParentId());
			this.name = sysMenu.getName();
			this.url = sysMenu.getHref();
			this.isMenu = true;
			this.isParent = true;
		}

	}

	public ZtreeNode(SysElement sysElement) {
		this.id = ElementVo.ID_PREFIX + String.valueOf(sysElement.getId());
		this.pId = String.valueOf(sysElement.getMenuId());
		this.name = sysElement.getName();
		this.isMenu = false;
		this.isParent = false;
	}


}

