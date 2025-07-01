package bitc.full502.board4.service;

import bitc.full502.board4.entity.BoardEntity;

import java.util.List;

public interface BoardService {
  List<BoardEntity> selectBoardList() throws Exception;

  BoardEntity selectBoardDetail(int boardIdx) throws Exception;

  void saveBoard(BoardEntity board) throws Exception;

  void deleteBoard(int boardIdx) throws Exception;
}














