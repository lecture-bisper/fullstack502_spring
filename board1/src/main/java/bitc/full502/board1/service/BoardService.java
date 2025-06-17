package bitc.full502.board1.service;

import bitc.full502.board1.dto.BoardDTO;

import java.util.List;

public interface BoardService {

//  게시판 글 목록 보기
  List<BoardDTO> selectBoardList() throws Exception;

//  게시글 등록
  public void insertBoard(BoardDTO board) throws Exception;

//  게시글 상세보기
  BoardDTO selectBoardDetail(int boardIdx) throws Exception;
}
