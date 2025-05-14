package com.dev.sp.mapper;

import java.util.List;

import com.dev.sp.vo.BoardVO;

public interface BoardMapper {
	
	List<BoardVO> selectBoardList(BoardVO board);
	BoardVO selectBoard(int biNum);
	int insertBoard(BoardVO board);
	int updateBoard(BoardVO board);
	int updateBoardViewCnt(int biNum);
	int deleteBoard(int biNum);
}
