package com.arnold.rbac.service.impl;

import com.arnold.rbac.model.SysMenu;
import com.arnold.rbac.service.MenuService;
import com.arnold.utils.JsonMapper;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * MenuServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>04/16/2018</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MenuServiceImplTest {

	@Autowired
	MenuService menuService;

	@Before
	public void before() throws Exception {
	}

	@After
	public void after() throws Exception {
	}

	/**
	 * Method: getMenuList()
	 */
	@Test
	public void testGetMenuList() throws Exception {
//TODO: Test goes here... 
	}

	/**
	 * Method: getMenuById(Integer id)
	 */
	@Test
	public void testGetMenuById() throws Exception {
		SysMenu menuById = menuService.getMenuById(10);
		System.out.println(JsonMapper.toJsonString(menuById));
	}

	/**
	 * Method: saveMenu(SysMenu sysMenu)
	 */
	@Test
	public void testSaveMenu() throws Exception {
//TODO: Test goes here... 
	}


} 
