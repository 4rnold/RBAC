package com.arnold.rbac.service.impl;

import com.arnold.rbac.dao.SysMenuMapper;
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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	@Autowired
	SysMenuMapper sysMenuMapper;

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

	@Test
	public void test() {
		SysMenu sysMenu = new SysMenu();
		//sysMenu.setName("33333");
		sysMenu.setParentIds(",6,");
		List<SysMenu> list = sysMenuMapper.getMenusBycondition(sysMenu);
		System.out.println(list.size());
	}


	@Test
	public void test2() {
		List<Integer> list = Arrays.asList(6,7);
		Integer integer = sysMenuMapper.deleteBatch(list);
		System.out.println(integer);
	}

} 
