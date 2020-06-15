package com.project.alpha.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.alpha.board.mapper.BoardMapper;
import com.project.alpha.board.model.BoardModel;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardModel> selectBoardList(BoardModel boardModel) {
		return boardMapper.selectBoardList(boardModel);
	}
	
}
