package com.dev.sp.mapper;

import java.util.List;

import com.dev.sp.vo.BoardVO2;

public interface BoardMapper2 {

	List<BoardVO2> selectBoardList(BoardVO2 board);
	BoardVO2 selectBoard(int biNum);
	int insertBoard(BoardVO2 board);
	int updateBoard(BoardVO2 board);
	int deleteBoard(int biNum);
}
