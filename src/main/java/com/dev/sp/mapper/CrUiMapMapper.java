package com.dev.sp.mapper;

import java.util.List;

import com.dev.sp.vo.ChatRoom;
import com.dev.sp.vo.CrUiMap;

public interface CrUiMapMapper {
	
	int insertCrUiMap(ChatRoom crUi);
	int deleteCrUiMap(CrUiMap crUi);
	List<CrUiMap> selectCrUiMapList(int roomId);

}
