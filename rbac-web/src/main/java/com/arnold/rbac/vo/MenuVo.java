package com.arnold.rbac.vo;

import com.arnold.rbac.model.SysMenu;
import com.arnold.rbac.model.SysPermission;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于menu元素和前端交互
 */
public class MenuVo {


	private Integer id;

	private Integer pId;

	@Length(min = 5)
	private String name;

	@NotEmpty
	private String url;

	private Integer permissionId;
	private String permissionStr;
	private String permissionName;


	private List<MenuVo> subMenus = new ArrayList<>();

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	public List<MenuVo> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<MenuVo> subMenus) {
		this.subMenus = subMenus;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionStr() {
		return permissionStr;
	}

	public void setPermissionStr(String permissionStr) {
		this.permissionStr = permissionStr;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public MenuVo() {
	}

	public MenuVo(SysMenu sysMenu) {
		this.id = sysMenu.getId();
		this.pId = sysMenu.getParentId();
		this.name = sysMenu.getName();
		this.url = sysMenu.getHref();


		if (sysMenu.getPermission() != null) {
			this.permissionStr = sysMenu.getPermission().getPermissionStr();
			this.permissionId = sysMenu.getPermission().getId();
			this.permissionName = sysMenu.getPermission().getPermissionName();
		}
	}

	public SysMenu ConvertToSysMenu() {
		SysMenu sysMenu = new SysMenu();
		sysMenu.setId(this.id);
		sysMenu.setParentId(this.pId);
		sysMenu.setParentIds(String.valueOf(this.pId));
		sysMenu.setHref(this.url);
		sysMenu.setName(this.name);
		sysMenu.setIsLeaf(false);
		sysMenu.setPermissionId(this.permissionId);
		SysPermission sysPermission = new SysPermission();
		sysPermission.setPermissionName(this.name);
		sysPermission.setPermissionStr(this.permissionStr);
		sysPermission.setId(this.permissionId);
		sysMenu.setPermission(sysPermission);
		return sysMenu;
	}
}
