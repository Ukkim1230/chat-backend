package com.dev.sp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.sp.mapper.ChatRoomMapper;
import com.dev.sp.mapper.CrUiMapMapper;
import com.dev.sp.vo.ChatRoom;

@Service
public class ChatRoomService {
	
	@Autowired
	private ChatRoomMapper crMapper;
	@Autowired
	private CrUiMapMapper cuMapper;
	
	public List<ChatRoom> selectChatRoomList(ChatRoom chat){
		return crMapper.selectChatRoomList(chat);
	}
	public ChatRoom selectChatRoom(int roomId){
		return crMapper.selectChatRoom(roomId);
	}
	@Transactional
	public int insertChatRoom(ChatRoom chat) {
		int result = crMapper.insertChatRoom(chat);
		cuMapper.insertCrUiMap(chat);
		return chat.getRoomId();
	}
	public int updateChatRoom(ChatRoom chat) {
		return crMapper.updateChatRoom(chat);
	}
	public int deleteChatRoom(int roomId) {
		return crMapper.deleteChatRoom(roomId);
	}
}
