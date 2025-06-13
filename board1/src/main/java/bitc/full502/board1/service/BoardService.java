package bitc.full502.board1.service;

import bitc.full502.board1.dto.BoardDTO;

import java.util.List;

public interface BoardService {

//  게시판 글 목록 보기
  List<BoardDTO> selectBoardList() throws Exception;
}
