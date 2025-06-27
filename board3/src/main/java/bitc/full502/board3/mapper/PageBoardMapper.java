package bitc.full502.board3.mapper;

import bitc.full502.board3.dto.BoardDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PageBoardMapper {
  Page<BoardDTO> selectPageBoardList() throws Exception;
}
