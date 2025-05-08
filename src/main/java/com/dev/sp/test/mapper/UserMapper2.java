package com.dev.sp.test.mapper;

import java.util.List;

import com.dev.sp.test.vo.UserVO2;

public interface UserMapper2 {
	List<UserVO2> selectUserList(UserVO2 user);
	UserVO2 selectUser(int uiNum);
	UserVO2 selectUserById(String uiId);
	int insertUser(UserVO2 user);
	int updateUser(UserVO2 user);
	int deleteUser(int uiNum);
}
