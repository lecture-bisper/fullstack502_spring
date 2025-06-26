package bitc.full502.board3.mapper;

import bitc.full502.board3.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
  List<BoardDTO> selectBoardList() throws Exception;

  BoardDTO selectBoardDetail(@Param("boardIdx") int boardIdx) throws Exception;

  void boardInsert(BoardDTO board) throws Exception;

  void boardUpdate(BoardDTO board) throws Exception;

  void boardDelete(@Param("boardIdx") int boardIdx) throws Exception;

  void updateHitCnt(@Param("boardIdx") int boardIdx) throws Exception;
}
