package com.project.alpha.board.service;

import java.util.List;

import com.project.alpha.board.model.BoardModel;

public interface BoardService {
	
	/**
	 * 게시판 목록 조회
	 * @param boardModel BoardModel
	 * @return List<BoardModel>
	 */
	public List<BoardModel> selectBoardList(BoardModel boardModel);

}
