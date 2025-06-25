package btic.full502.board2.service;

import btic.full502.board2.dto.BoardDTO;
import btic.full502.board2.dto.FileDTO;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface BoardService {
  List<BoardDTO> selectBoardList() throws Exception;

  BoardDTO selectBoardDetail(int boardIdx) throws Exception;

//  첨부파일 정보가 저장된 MultipartHttpServletRequest 객체를 두번째 매개변수로 받음
  void boardWrite(BoardDTO board, MultipartHttpServletRequest multipart) throws Exception;

  FileDTO selectBoardFileInfo(int fileIdx, int boardIdx);
}








