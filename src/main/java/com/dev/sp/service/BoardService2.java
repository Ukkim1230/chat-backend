package com.dev.sp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.sp.mapper.BoardMapper2;
import com.dev.sp.vo.BoardVO2;

@Service
public class BoardService2 {
	
	@Autowired
	private BoardMapper2 boardMapper2;
	
	public List<BoardVO2> getBoards(BoardVO2 board){
		return boardMapper2.selectBoardList(board);
	}
	public BoardVO2 getBoard(int biNum) {
		return boardMapper2.selectBoard(biNum);
	}
	public int insertBoard(BoardVO2 board) {
		return boardMapper2.insertBoard(board);
	}
	public int updateBoard(BoardVO2 board) {
		return boardMapper2.updateBoard(board);
	}
	public int deleteBoard(int biNum) {
		return boardMapper2.deleteBoard(biNum);
	}

}
