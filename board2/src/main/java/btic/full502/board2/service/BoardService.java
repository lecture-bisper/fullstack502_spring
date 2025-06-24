package btic.full502.board2.service;

import btic.full502.board2.dto.BoardDTO;

import java.util.List;

public interface BoardService {
  List<BoardDTO> selectBoardList() throws Exception;

  BoardDTO selectBoardDetail(int boardIdx) throws Exception;

  void boardWrite(BoardDTO board) throws Exception;
}








