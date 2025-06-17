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
//    Mapper 를 사용하여 데이터베이스에서 지정한 게시글 정보를 가져옴
    return boardMapper.selectBoardDetail(boardIdx);
  }
}










