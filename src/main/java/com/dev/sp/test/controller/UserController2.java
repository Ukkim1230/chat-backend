package com.dev.sp.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.sp.test.service.UserService2;
import com.dev.sp.test.vo.UserVO2;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController2 {

	@Autowired
	private UserService2 userService;
	
	@PostMapping("/users2")
	public UserVO2 insertUser(@Valid @RequestBody UserVO2 user) {
		return userService.insertUser(user);
	}
	
	@PostMapping("/users/login2")
	public UserVO2 login(@RequestBody UserVO2 user) {
		return userService.login(user);
	}
}
