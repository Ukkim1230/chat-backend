package com.dev.sp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.sp.service.BoardService2;
import com.dev.sp.vo.BoardVO2;

@RestController
public class BoardController2 {

	@Autowired
	private BoardService2 boardService2;
	
	@GetMapping("/boards2")
	public List<BoardVO2> getBoards(BoardVO2 board){
		return boardService2.getBoards(board);
	}
	@GetMapping("/boards2/{biNum}")
	public BoardVO2 getBoard(@PathVariable("biNum") int biNum) {
		return boardService2.getBoard(biNum);
	}
	@PostMapping("/boards2")
	public int insertBoard(@RequestBody BoardVO2 board) {
		return boardService2.insertBoard(board);
	}
	@PutMapping("/boards2")
	public int updateBoard(@RequestBody BoardVO2 board) {
		return boardService2.updateBoard(board);
	}
	@DeleteMapping("/boards2")
	public int deleteBoard(@PathVariable("biNum") int biNum) {
		return boardService2.deleteBoard(biNum);
	}
}
