package com.arnold.rbac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/test")
@Controller
public class TestController {

	@RequestMapping("/userlist")
	public String test() {
		return "test/userList";
	}

	@RequestMapping("index")
	public String index() {
		return "test/index";
	}

	@RequestMapping("pjax1")
	public String pjaxIndex() {
		return "test/pjax/pjax1";
	}

	@RequestMapping("pjax2")
	public String pjaxIndex2() {
		return "test/pjax/pjax2";
	}

	@RequestMapping("one")
	public String pjaxIndex21() {
		return "test/pjax-demo/index";
	}

	@RequestMapping("two")
	public String pjaxIndex22() {
		return "test/pjax-demo/two";
	}

	@RequestMapping("three")
	public String pjaxIndex23() {
		return "test/pjax-demo/three";
	}
}
