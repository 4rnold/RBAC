package com.arnold.rbac.controller;

import com.arnold.rbac.security.utils.PasswordUtils;
import com.arnold.rbac.utils.PageUtils;
import com.arnold.rbac.vo.MenuVo;
import com.arnold.utils.CacheUtils;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * LoginController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>03/08/2018</pre>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml",})
public class LoginControllerTest {

	@Before
	public void before() throws Exception {
	}

	@After
	public void after() throws Exception {
	}

	/**
	 * Method: login()
	 */
	@Test
	public void testLogin() throws Exception {
		Map<String,Integer> loginFailMap = (Map<String, Integer>) CacheUtils.get("loginFailMap");
		System.out.println(11);
	}

	@Test
	public void test(){
		System.out.println(PasswordUtils.entryptPassword("123456"));
	}

	@Test
	public void test2() {
		List<MenuVo> menuVoList = PageUtils.getMenuVoList();
		System.out.println(1);
	}


} 
