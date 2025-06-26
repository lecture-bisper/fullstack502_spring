package bitc.full502.board3.service;

import bitc.full502.board3.dto.BoardDTO;

import java.util.List;

public interface BoardService {
  List<BoardDTO> selectBoardList() throws Exception;

  BoardDTO selectBoardDetail(int boardIdx) throws Exception;

  void boardInsert(BoardDTO board) throws Exception;

  void boardUpdate(BoardDTO board) throws Exception;

  void boardDelete(int boardIdx) throws Exception;
}














