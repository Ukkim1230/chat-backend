package com.dev.sp.test.util;

import org.apache.commons.codec.digest.DigestUtils;

public class SHA256Util {
	
	private static final String SALT = "123456789123456789123456789123456";
	
	public static String encodePwd(String pwd) {
		return DigestUtils.sha256Hex(pwd + SALT);
	}
	
	public static void main(String[] args) {
		String pwd="12345678";
		String encode = SHA256Util.encodePwd(pwd);
		System.out.println(encode);
	}

}
