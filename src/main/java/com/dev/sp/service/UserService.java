package com.dev.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.sp.mapper.UserMapper;
import com.dev.sp.util.SHA256Util;
import com.dev.sp.vo.UserVO;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	
	public UserVO insertUser(UserVO user) {
		if(userMapper.selectUserById(user.getUiId())!=null) {
			throw new RuntimeException(user.getUiId() + "는 이미 존재하는 아이디입니다.");
		}
		user.setUiPwd(SHA256Util.encodePwd(user.getUiPwd()));
		userMapper.insertUser(user);
		return userMapper.selectUserById(user.getUiId());
	}
	
	public UserVO login(UserVO user) {
		String encodePwd = SHA256Util.encodePwd(user.getUiPwd());
		UserVO dbUser = userMapper.selectUserById(user.getUiId());
		
		if(dbUser==null || !encodePwd.equals(dbUser.getUiPwd())) {
			throw new RuntimeException("아이디나 비밀번호를 확인해주세요");
		}
		return dbUser;
	}
	public UserVO join(UserVO user) {
	    if (user.getUiId() == null || user.getUiId().length() < 4) {
	        throw new IllegalArgumentException("아이디는 4자 이상이어야 합니다.");
	    }
	    if (user.getUiPwd() == null || user.getUiPwd().length() < 8) {
	        throw new IllegalArgumentException("비밀번호는 8자 이상이어야 합니다.");
	    }

	    return insertUser(user);
	}
}
