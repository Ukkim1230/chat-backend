package com.dev.sp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.sp.service.UserService;
import com.dev.sp.vo.UserVO;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public UserVO insertUser(@Valid @RequestBody UserVO user) {
		return userService.insertUser(user);
	}
	
	@PostMapping("/users/login")
	public UserVO login(@RequestBody UserVO user) {
		return userService.login(user);
	}
	@PostMapping("/users/join")
	public UserVO join(@RequestBody UserVO user) {
		return userService.join(user);
	}
}
