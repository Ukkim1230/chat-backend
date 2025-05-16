package com.dev.sp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.dev.sp.vo.ChatMessage;

@Controller
public class ChatController {

	@Autowired
	private SimpMessagingTemplate smt;
	
	@MessageMapping("/chat/message")
	public void sendMessage(@Payload ChatMessage msg) {
		smt.convertAndSend("/topic/room/" + msg.getRoomId(), msg);
	}
	@MessageMapping("/chat/enter")
	public void enterRoom(@Payload ChatMessage msg) {
		smt.convertAndSend("/topic/room/" + msg.getRoomId(), msg);
	}
	@MessageMapping("/chat/leave")
	public void leaveRoom(@Payload ChatMessage msg) {
		smt.convertAndSend("/topic/room/" + msg.getRoomId(), msg);
	}
}
