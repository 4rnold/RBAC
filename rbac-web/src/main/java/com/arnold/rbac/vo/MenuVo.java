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

	private Integer permission_id;
	private String permission_str;
	private String permission_name;


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

	public MenuVo() {
	}

	public MenuVo(SysMenu sysMenu) {
		this.id = sysMenu.getId();
		this.pId = sysMenu.getParentId();
		this.name = sysMenu.getName();
		this.url = sysMenu.getHref();


		if (sysMenu.getPermission() != null) {
			this.permission_str = sysMenu.getPermission().getPermissionStr();
			this.permission_id = sysMenu.getPermission().getId();
			this.permission_name = sysMenu.getPermission().getPermissionName();
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
		sysMenu.setPermissionId(this.permission_id);
		SysPermission sysPermission = new SysPermission();
		sysPermission.setPermissionName(this.permission_name);
		sysPermission.setPermissionStr(this.permission_str);
		sysPermission.setId(this.permission_id);

		return sysMenu;
	}
}
