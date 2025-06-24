package btic.full502.board2.service;

import btic.full502.board2.dto.BoardDTO;
import btic.full502.board2.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

  @Autowired
  private BoardMapper boardMapper;

  @Override
  public List<BoardDTO> selectBoardList() throws Exception {
    return boardMapper.selectBoardList();
  }

//  게시글 상세 보기
//  1. mapper 를 이용하여 매개변수로 받아온 게시글 번호에 맞는 게시글 상세 정보를 가져옴
//  2. 가져온 게시글 상세 정보를 반환
  @Override
  public BoardDTO selectBoardDetail(int boardIdx) throws Exception {
    BoardDTO board = boardMapper.selectBoardDetail(boardIdx);
    return board;
  }

//  게시글 등록하기
//  1. 매개변수로 데이터 받아오기
//  2. mapper 를 이용하여 매개변수로 받아온 데이터를 데이터베이스에 등록
  public void boardWrite(BoardDTO board) throws Exception {
    boardMapper.boardWrite(board);
  }
}














