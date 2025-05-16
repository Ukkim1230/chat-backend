package com.dev.sp.mapper;

import java.util.List;

import com.dev.sp.vo.ChatRoom;

public interface ChatRoomMapper {

	List<ChatRoom> selectChatRoomList(ChatRoom chat);
	ChatRoom selectChatRoom(int roomId);
	int insertChatRoom(ChatRoom chat);
	int updateChatRoom(ChatRoom chat);
	int deleteChatRoom(int roomId);
}
