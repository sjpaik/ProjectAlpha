package com.project.alpha.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.alpha.board.model.BoardModel;

@Mapper
public interface BoardMapper {

	/**
	 * 게시판 목록 조회
	 * @param boardModel BoardModel
	 * @return List<BoardModel>
	 */
	public List<BoardModel> selectBoardList(BoardModel boardModel);
	
}
