package com.arnold.rbac.dao;

import com.arnold.rbac.model.SysUser;
import com.arnold.utils.JsonMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SysUserMapperTest {

	@Autowired
	SysUserMapper sysUserMapper;

	@Test
	public void test1() {
		SysUser user = sysUserMapper.getUserWithRoleAndPermission(1);
		System.out.println(JsonMapper.toJsonString(user));
	}

	@Test
	public void getByUsernameTest() {
		SysUser arnold = sysUserMapper.getByUsername("arnold");
		System.out.println(JsonMapper.toJsonString(arnold));
	}
}
