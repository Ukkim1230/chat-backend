package com.dev.sp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.dev.sp.enums.MessageType;
import com.dev.sp.service.ChatRoomService;
import com.dev.sp.vo.ChatMessage;
import com.dev.sp.vo.ChatRoom;
import com.dev.sp.vo.CrUiMap;

@Controller
public class ChatController {

	@Autowired
	private SimpMessagingTemplate smt;
	@Autowired
	private ChatRoomService crService;
	
	@MessageMapping("/chat/message")
	public void sendMessage(@Payload ChatMessage msg) {
		String destination = "/topic/room/" + msg.getRoomId();
		if(msg.getType() == MessageType.WHISPER) {
			smt.convertAndSend(destination +"/"+msg.getUiNum(),msg);
			destination += "/" + msg.getTargetUiNum();
		}
		smt.convertAndSend(destination , msg);
	}
	@MessageMapping("/chat/enter")
	public void enterRoom(@Payload ChatMessage msg) {
		ChatRoom cr = new ChatRoom();
		cr.setRoomId(msg.getRoomId());
		cr.setUiNum(msg.getUiNum());
		crService.insertCrUiMap(cr);
		List<CrUiMap> list = crService.selectCrUiMapList(msg.getRoomId());
		smt.convertAndSend("/topic/users/" + msg.getRoomId(), list);
		smt.convertAndSend("/topic/room/" + msg.getRoomId(), msg);
	}
	@MessageMapping("/chat/leave")
	public void leaveRoom(@Payload ChatMessage msg) {
		CrUiMap cu = new CrUiMap();
		cu.setRoomId(msg.getRoomId());
		cu.setUiNum(msg.getUiNum());
		crService.deleteCrUiMap(cu);
		List<CrUiMap> list = crService.selectCrUiMapList(msg.getRoomId());
		smt.convertAndSend("/topic/users/" + msg.getRoomId(), list);
		smt.convertAndSend("/topic/room/" + msg.getRoomId(), msg);
	}
}
