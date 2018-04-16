package com.arnold.rbac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Arnold
 */
@RequestMapping("/rbac/role")
@Controller
public class RoleController {

	@RequestMapping("list")
	public String list() {
		return "rbac/role-list";
	}
}
