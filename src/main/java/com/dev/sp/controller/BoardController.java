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

import com.dev.sp.service.BoardService;
import com.dev.sp.vo.BoardVO;
import com.dev.sp.vo.UserVO;

import jakarta.servlet.http.HttpSession;

@RestController
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/boards")
	public List<BoardVO> getBoards(BoardVO board){
		return boardService.getBoards(board);
	}
	@GetMapping("/boards/{biNum}")
	public BoardVO getBoard(@PathVariable("biNum")int biNum) {
		return boardService.getBoard(biNum);
	}
	@GetMapping("/boards/update/{biNum}")
	public BoardVO getBoardforUpdate(@PathVariable("biNum")int biNum) {
		return boardService.getBoardforUpdate(biNum);
	}
	@PostMapping("/boards")
	public int insertBoard(@RequestBody BoardVO board) {
		return boardService.insertBoard(board);
	}
	@PutMapping("/boards")
	public int updateBoard(@RequestBody BoardVO board) {
		return boardService.updateBoard(board);
	}
	@DeleteMapping("/boards/{biNum}")
	public int deleteBoard(@PathVariable("biNum") int biNum) {
		return boardService.deleteBoard(biNum);
	}
}
