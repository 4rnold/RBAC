package com.arnold.rbac.security.utils;

import com.arnold.utils.Encodes;

import static com.arnold.rbac.service.UserService.HASH_INTERATIONS;
import static com.arnold.rbac.service.UserService.SALT_SIZE;

public class PasswordUtils {

	/**
	 * 生成安全的密码，生成随机的8个byte，64位的salt并经过1024次 sha-1 hash
	 */
	public static String entryptPassword(String plainPassword) {
		String plain = Encodes.unescapeHtml(plainPassword);
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, HASH_INTERATIONS);
		return Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword);
	}
}
