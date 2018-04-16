package com.arnold.rbac.security.realm;


import com.arnold.rbac.constant.UserStatusEnum;
import com.arnold.rbac.model.SysUser;
import com.arnold.rbac.security.Token.UsernamePasswordToken;
import com.arnold.rbac.security.servlet.ValidateCodeServlet;
import com.arnold.rbac.security.utils.LoginUtils;
import com.arnold.rbac.security.utils.Userutils;
import com.arnold.rbac.service.UserService;
import com.arnold.utils.Encodes;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author Arnold
 */
@Service
public class SystemAuthorizingRealm extends AuthorizingRealm {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken authcToken = (UsernamePasswordToken) token;

		//是否验证验证码
		if (LoginUtils.isValidateCodeLogin(authcToken.getUsername(), false, false)) {
			Session session = Userutils.getSession();
			//session.getAttribute();
			String code = (String) session.getAttribute(ValidateCodeServlet.VALIDATE_CODE);
			if (authcToken.getCaptcha() == null || !authcToken.getCaptcha().equals(code)) {
				throw new AuthenticationException("msg:验证码错误");
			}
		}

		SysUser user = userService.getUserByName(authcToken.getUsername());

		if (user != null) {
			if (UserStatusEnum.FROZEN.name().equals(user.getStatus())) {
				throw new AuthenticationException("msg:帐号被冻结");
			}

			//password字段的前16位是salt，密码从16之后取
			byte[] salt = Encodes.decodeHex(user.getPassword().substring(0, 16));

			return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword().substring(16), ByteSource.Util.bytes(salt), getName());
		}


		return null;
	}

	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(UserService.HASH_ALGORITHM);
		matcher.setHashIterations(UserService.HASH_INTERATIONS);
		setCredentialsMatcher(matcher);
	}
}
