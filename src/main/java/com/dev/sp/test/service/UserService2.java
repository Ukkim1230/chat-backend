package com.dev.sp.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.sp.test.mapper.UserMapper2;
import com.dev.sp.test.vo.UserVO2;
import com.dev.sp.util.SHA256Util;
@Service
public class UserService2 {
	@Autowired
	private UserMapper2 userMapper;
	
	public UserVO2 insertUser(UserVO2 user) {
		if(userMapper.selectUserById(user.getUiId())!=null) {
			throw new RuntimeException(user.getUiId() + "는 이미 존재하는 아이디입니다.");
		}
		user.setUiPwd(SHA256Util.encodePwd(user.getUiPwd()));
		userMapper.insertUser(user);
		return userMapper.selectUserById(user.getUiId());
	}
	
	public UserVO2 login(UserVO2 user) {
		String encodePwd = SHA256Util.encodePwd(user.getUiPwd());
		UserVO2 dbUser = userMapper.selectUserById(user.getUiId());
		
		if(dbUser==null || !encodePwd.equals(dbUser.getUiPwd())) {
			throw new RuntimeException("아이디나 비밀번호를 확인해주세요");
		}
		return dbUser;
	}
	
}
