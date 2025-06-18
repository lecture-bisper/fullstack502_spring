package bitc.full502.board1.service;

import bitc.full502.board1.dto.BoardDTO;
import bitc.full502.board1.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//  @Service : 해당 클래스가 상속받은 interface 이름으로 동작하도록 설정하는 어노테이션
@Service
public class BoardServiceImpl implements BoardService {

//  BoardMapper 인터페이스 타입의 변수 선언
  @Autowired
  private BoardMapper boardMapper;

//  부모인 BoardService 에서 상속받은 메소드 구현
  @Override
  public List<BoardDTO> selectBoardList() throws Exception {
//    BoardMapper 인터페이스가 제공하는 메소드를 호출
    return boardMapper.selectBoardList();
  }

  @Override
  public void insertBoard(BoardDTO board) throws Exception {
//    Mapper 를 사용하여 데이터베이스에 게시글 정보를 등록
    boardMapper.insertBoard(board);
  }

  @Override
  public BoardDTO selectBoardDetail(int boardIdx) throws Exception {
//    Mapper 을 이용하여 지정한 게시글의 조회수를 데이터베이스에서 수정
    boardMapper.updateHitCount(boardIdx);

//    Mapper 를 사용하여 데이터베이스에서 지정한 게시글 정보를 가져옴
    return boardMapper.selectBoardDetail(boardIdx);
  }

//  게시글 삭제
  @Override
  public void deleteBoard(int boardIdx) throws Exception {
//    1. 매개변수로 게시글 번호를 받아옴
//    2. mapper 를 이용하여 지정한 게시글 번호의 게시글을 DB에서 삭제

    boardMapper.deleteBoard(boardIdx);
  }

//  게시글 수정
  @Override
  public void updateBoard(BoardDTO board) throws Exception {
//    1. 매개변수로 수정된 BoardDTO 객체를 받아옴
//    2. mapper 를 이용하여 매개변수로 받아온 BoardDTO 타입의 객체로 실제 DB의 내용을 수정

    boardMapper.updateBoard(board);
  }
}










