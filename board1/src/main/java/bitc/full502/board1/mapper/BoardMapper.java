package bitc.full502.board1.mapper;

import bitc.full502.board1.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//  @Mapper : mybatis 라이브러리에서 제공하는 어노테이션
//  데이터베이스의 SQL 문과 연동하기 위한 인터페이스
//  해당 인터페이스의 추상 메소드와 xml 파일의 태그명을 1:1로 연동해주는 어노테이션
@Mapper
public interface BoardMapper {

//  게시글 목록 보기
  List<BoardDTO> selectBoardList() throws Exception;

//  게시글 등록
  void insertBoard(BoardDTO board) throws Exception;

//  게시글 상세보기
  BoardDTO selectBoardDetail(int boardIdx) throws Exception;

//  @Param : mapper 파일과 연동된 xml 파일에서 사용할 매개변수명을 새로 지정하는 어노테이션
//  게시글 삭제하기
  void deleteBoard(@Param("idx") int boardIdx) throws Exception;

//  게시글 수정하기
  void updateBoard(BoardDTO board) throws Exception;

//  게시글 조회수 증가
  void updateHitCount(@Param("boardIdx") int boardIdx) throws Exception;
}










