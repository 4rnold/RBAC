package com.arnold.rbac.security.Token;

public class UsernamePasswordToken extends org.apache.shiro.authc.UsernamePasswordToken {

	/**
	 * 验证码
	 */
	private String captcha;

	public UsernamePasswordToken() {
		super();
	}

	public UsernamePasswordToken(String username, String password, boolean rememberMe, String host, String captcha) {
		super(username, password, rememberMe, host);
		this.captcha = captcha;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
}
