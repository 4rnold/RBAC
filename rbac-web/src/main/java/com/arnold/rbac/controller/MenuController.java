package com.arnold.rbac.controller;

import com.arnold.rbac.model.SysElement;
import com.arnold.rbac.model.SysMenu;
import com.arnold.rbac.service.ElementService;
import com.arnold.rbac.service.MenuService;
import com.arnold.rbac.vo.ElementVo;
import com.arnold.rbac.vo.MenuVo;
import com.arnold.common.vo.Result;
import com.arnold.rbac.vo.ZtreeNode;
import com.arnold.utils.JsonMapper;
import org.apache.ibatis.binding.BindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Arnold
 */
@Controller
@RequestMapping("/rbac/menu")
public class MenuController {

	@Autowired
	MenuService menuService;

	@Autowired
	ElementService elementService;

	@RequestMapping("list")
	public String menuList() {
		return "rbac/menu-list";
	}

	@RequestMapping("list2")
	public String menuList2() {
		return "rbac/menu-list2";
	}

	/**
	 * 获取ztreeNodes，包括menus和elements
	 * @return
	 */
/*	@RequestMapping("getZtreeNodes")
	@ResponseBody
	public Result<List<MenuVo>> getZtreeNodes(){
		List<SysMenu> menuList = menuService.getMenuList();
		if (menuList == null) {
			return Result.newFailure(500,"获取菜单失败");
		}
		List<MenuVo> ztreeNodes = new ArrayList<>();
		for (SysMenu sysMenu : menuList) {
			ztreeNodes.add(new MenuVo(sysMenu));
		}

		return Result.newSuccess(ztreeNodes);
	}*/

	/**
	 * 获取ztreeNodes，包括menus和elements
	 * @return
	 */
	@RequestMapping("getZtreeNodes")
	@ResponseBody
	public Result<List<ZtreeNode>> getZtreeNodes() {
		List<SysMenu> menus = menuService.getMenuList();
		List<SysElement> elements = elementService.getElements();
		List<ZtreeNode> menuZtreeNodes = menus.stream().map(m -> new ZtreeNode(m)).collect(Collectors.toList());
		List<ZtreeNode> elementZtreeNodes = elements.stream().map(m -> new ZtreeNode(m)).collect(Collectors.toList());
		menuZtreeNodes.addAll(elementZtreeNodes);
		return Result.newSuccess(menuZtreeNodes);
	}


	@RequestMapping("getElementById")
	@ResponseBody
	public Result<ElementVo> getElementById(String id) {
		if (id.startsWith(ElementVo.ID_PREFIX)) {
			//去掉Element-id前缀
			id = id.replaceAll(ElementVo.ID_PREFIX,"");
		}
		SysElement element = elementService.getElementById(Integer.valueOf(id));
		if (element == null)
			throw new RuntimeException("元素不存在");
		ElementVo elementVo = new ElementVo(element);
		return Result.newSuccess(elementVo);
	}

	/**
	 * 根据id获取menu
	 * @param id
	 * @return
	 */
	@RequestMapping("getMenuById")
	@ResponseBody
	public Result<MenuVo> getmenuById(String id) {
		SysMenu menu = menuService.getMenuById(Integer.parseInt(id));
		if (menu == null) {
			throw new RuntimeException("菜单信息不存在");
		}
		MenuVo ztreeNode = new MenuVo(menu);
		return Result.newSuccess(ztreeNode);

	}

	/*通过X-PJAX-URL 设置pjax url*/
	/*@RequestMapping("editMenu")
	//@ResponseBody
	public String editMenu(Model model, HttpServletResponse response) {
		model.addAttribute("message","edit");
		//return "rbac/menu-list";
		//return Result.newSuccess();
		response.setHeader("X-PJAX-URL","/rbac/menu/list");
		return menuList();
	}*/

	/*@RequestMapping("editMenu")
	public String editMenu(Model model, HttpServletResponse response) {
		model.addAttribute("message","edit");


		return menuList();
	}*/

	@RequestMapping("editMenu")
	@ResponseBody
	public Result editMenu(@Valid MenuVo menuVo, BindingResult bindingResult) throws BindException {
		if (bindingResult.hasErrors()) {
			throw new BindException(bindingResult);
		}
		SysMenu sysMenu = menuVo.ConvertToSysMenu();
		menuService.saveMenu(sysMenu);
		return Result.newSuccess();
	}

	/*@RequestMapping("addMenu")
	@ResponseBody
	public Result addMenu(@Valid MenuVo menuVo,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new BindException(bindingResult);
		}
	}*/
}
