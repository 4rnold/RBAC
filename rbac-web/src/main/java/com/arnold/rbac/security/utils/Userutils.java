package com.arnold.rbac.security.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class Userutils {


	public static Session getSession() {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession(true);
		return session;
	}

}
