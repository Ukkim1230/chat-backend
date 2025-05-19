package com.dev.sp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.sp.mapper.ChatRoomMapper;
import com.dev.sp.mapper.CrUiMapMapper;
import com.dev.sp.vo.ChatRoom;
import com.dev.sp.vo.CrUiMap;

@Service
public class ChatRoomService {
	
	@Autowired
	private ChatRoomMapper crMapper;
	@Autowired
	private CrUiMapMapper cuMapper;
	
	public int insertCrUiMap(ChatRoom chat) {
		return cuMapper.insertCrUiMap(chat);
	}
	public List<CrUiMap> selectCrUiMapList(int roomId){
		return cuMapper.selectCrUiMapList(roomId);
	}
	public int deleteCrUiMap(CrUiMap cu) {
		return cuMapper.deleteCrUiMap(cu);
	}
	
	public List<ChatRoom> selectChatRoomList(ChatRoom chat){
		return crMapper.selectChatRoomList(chat);
	}
	
	public ChatRoom selectChatRoom(int roomId){
		return crMapper.selectChatRoom(roomId);
	}
	public int deleteChatRoom(int roomId){
		return crMapper.deleteChatRoom(roomId);
	}
	@Transactional
	public int insertChatRoom(ChatRoom chat){
		crMapper.insertChatRoom(chat);
		return chat.getRoomId();
	}
	public int updateChatRoom(ChatRoom chat){
		return crMapper.updateChatRoom(chat);
	}
}
