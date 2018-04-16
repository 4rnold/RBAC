package com.arnold.rbac.security.utils;

import com.arnold.utils.CacheUtils;
import com.google.common.collect.Maps;

import java.util.Map;

public class LoginUtils {

	public static boolean isValidateCodeLogin(String username, boolean isFail, boolean clean) {
		Map<String,Integer> loginFailMap = (Map<String, Integer>) CacheUtils.get("loginFailMap");

		if (loginFailMap == null) {
			loginFailMap = Maps.newHashMap();
			CacheUtils.put("loginFailMap",loginFailMap);
		}

		Integer failCount = loginFailMap.get(username);
		if (failCount == null) {
			failCount = 0;
		}
		if (isFail) {
			failCount++;
			loginFailMap.put(username, failCount);
		}

		if (clean) {
			loginFailMap.remove(username);
		}
		return failCount >= 3;
	}
}
