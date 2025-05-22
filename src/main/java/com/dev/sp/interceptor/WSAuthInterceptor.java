package com.dev.sp.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.stereotype.Component;

import com.dev.sp.common.exception.ServiceException;
import com.dev.sp.util.JWTUtil;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class WSAuthInterceptor implements ChannelInterceptor {
	
	@Autowired
	private JWTUtil jwtUtil;
	public Message<?> preSend(Message<?> message, MessageChannel channel) {
		StompHeaderAccessor stompAccessor = MessageHeaderAccessor.getAccessor(message,StompHeaderAccessor.class);
		log.info("command =>{}",stompAccessor.getCommand());
		if(StompCommand.CONNECT.equals(stompAccessor.getCommand()) || StompCommand.SEND.equals(stompAccessor.getCommand())) {
			String token = stompAccessor.getFirstNativeHeader("Authorization");
			if(token == null || !token.startsWith("Bearer") ) {
				throw new ServiceException("정상적인 token이 아닙니다.");
			}
			token = token.substring(7);
			if(!jwtUtil.validToken(token)) {
				throw new ServiceException("정상적인 token이 아닙니다.");
			}
		}
		return message;
	}
}
