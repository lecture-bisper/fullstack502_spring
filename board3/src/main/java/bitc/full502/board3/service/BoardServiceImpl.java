package bitc.full502.board3.service;

import bitc.full502.board3.dto.BoardDTO;
import bitc.full502.board3.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//  @RequiredArgsConstructor : lombok 라이브러리에서 제공하는 어노테이션
//  @Autowired 어노테이션과 같이 지정한 클래스를 스프링 프레임워크에서 자동으로 객체를 생성, 사용, 삭제 관리할 수 있도록 해주는 어노테이션
//  final 키워드가 붙은 필드의 생성자 파라미터를 자동으로 생성하여 스프링 프레임워크에서 관리함
//  @Autowired 를 사용하던 클래스에 @RequiredArgsConstructor 를 사용하고, @Autowired 를 사용하던 필드에 final 키워드를 추가해서 사용함

//  스프링 프레임워크 4.3 버전 이상부터 @Autowired 대신 @RequiredArgsConstructor 를 추천하고 있음
//  @Autowired 를 사용 시 순환 참조가 발생할 수 있음

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

//  @Autowired
//  private BoardMapper boardMapper;
  private final BoardMapper boardMapper;

  @Override
  public List<BoardDTO> selectBoardList() throws Exception {
    return boardMapper.selectBoardList();
  }

  @Override
  public BoardDTO selectBoardDetail(int boardIdx) throws Exception {
    boardMapper.updateHitCnt(boardIdx);
    BoardDTO board = boardMapper.selectBoardDetail(boardIdx);
    return board;
  }

  @Override
  public void boardInsert(BoardDTO board) throws Exception {
    boardMapper.boardInsert(board);
  }

  @Override
  public void boardUpdate(BoardDTO board) throws Exception {
    boardMapper.boardUpdate(board);
  }

  @Override
  public void boardDelete(int boardIdx) throws Exception {
    boardMapper.boardDelete(boardIdx);
  }
}














