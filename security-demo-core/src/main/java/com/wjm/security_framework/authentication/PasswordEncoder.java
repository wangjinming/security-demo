package com.wjm.security_framework.authentication;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class PasswordEncoder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();

		String md5Password = md5.encodePassword("123456", "Russell");

		System.out.println("koala:" + md5Password);
		
	}

}
