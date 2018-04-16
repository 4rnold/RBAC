package com.arnold.rbac.dao;

import com.arnold.rbac.model.SysMenu;
import com.arnold.rbac.model.SysUser;
import com.arnold.utils.JsonMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SysMenuMapperTest {

	/*@Autowired
	SysUserMapper sysUserMapper;*/

	@Autowired
	SysMenuMapper sysMenuMapper;

	@Test
	public void test1() {
		List<SysMenu> menus = sysMenuMapper.selectAllMenus();
		System.out.println(JsonMapper.toJsonString(menus));
	}
}
