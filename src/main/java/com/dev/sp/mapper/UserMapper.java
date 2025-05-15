package com.dev.sp.mapper;

import java.util.List;

import com.dev.sp.vo.UserVO;

public interface UserMapper {
	 	List<UserVO> selectUsers(UserVO user);
	    UserVO selectUser(int uiNum);
	    UserVO selectUserById(String uiId);
	    int insertUser(UserVO user);
	    int updateUser(UserVO user);
	    int deleteUser(int uiNum);
}
