package btic.full502.board2.mapper;

import btic.full502.board2.dto.BoardDTO;
import btic.full502.board2.dto.FileDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
  List<BoardDTO> selectBoardList() throws Exception;

  BoardDTO selectBoardDetail(@Param("boardIdx") int boardIdx) throws Exception;

  void boardWrite(BoardDTO board) throws Exception;

  void insertBoardFileList(List<FileDTO> fileList) throws Exception;

  FileDTO selectBoardFileInfo(@Param("fileIdx") int fileIdx, @Param("boardIdx") int boardIdx);

  List<FileDTO> selectBoardFileList(@Param("boardIdx") int boardIdx);
}









