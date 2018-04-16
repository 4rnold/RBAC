package com.arnold.rbac.controller;

import com.jayway.jsonpath.JsonPath;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * MenuController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>04/16/2018</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextHierarchy({
		@ContextConfiguration(name = "parent", locations = "classpath:spring-context.xml"),
		@ContextConfiguration(name = "child",locations = "classpath:spring-mvc.xml")
})
public class MenuControllerTest {
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void before() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@After
	public void after() throws Exception {
	}

	/**
	 * Method: menuList()
	 */
	@Test
	public void testMenuList() throws Exception {
//TODO: Test goes here... 
	}

	/**
	 * Method: menuList2()
	 */
	@Test
	public void testMenuList2() throws Exception {
//TODO: Test goes here... 
	}

	/**
	 * Method: getZtreeNodes()
	 */
	@Test
	public void testGetZtreeNodes() throws Exception {
//TODO: Test goes here... 
	}

	/**
	 * Method: getElementsById(String id)
	 */
	@Test
	public void testGetElementsById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/rbac/menu/getElementsById")).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(0))
				.andExpect(MockMvcResultMatchers.jsonPath("$.object.length()").value(1));
	}

	/**
	 * Method: getZnodeById(String id)
	 */
	@Test
	public void testGetZnodeById() throws Exception {
//TODO: Test goes here... 
	}

	/**
	 * Method: editMenu(@Valid MenuVo menuVo, BindingResult bindingResult)
	 */
	@Test
	public void testEditMenu() throws Exception {
//TODO: Test goes here... 
	}


} 
