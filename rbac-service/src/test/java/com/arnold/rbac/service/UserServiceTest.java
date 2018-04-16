package com.arnold.rbac.service;

import com.arnold.rbac.model.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceTest {

	@Autowired
	UserService userService;

	@Test
	public void test1() {
		SysUser userById = userService.getUserById(1);
		System.out.println("aaaaaaaaaa" + userById.getPassword());
	}
}
