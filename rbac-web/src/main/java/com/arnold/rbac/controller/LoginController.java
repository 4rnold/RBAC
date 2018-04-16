package com.arnold.rbac.controller;

import com.arnold.rbac.security.filter.FormAuthenticationFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String login() {
		return "rbac/login";
	}


	/**
	 * shiro通过拦截器登录，登录失败才执行此controller
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String loginFail(HttpServletRequest request, HttpServletResponse response, Model model) {
		String failMessage = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_MESSAGE_PARAM);
		model.addAttribute("message", failMessage);

		return "rbac/login";
	}
}
