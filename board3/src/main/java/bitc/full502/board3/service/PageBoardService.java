package bitc.full502.board3.service;

import bitc.full502.board3.dto.BoardDTO;
import com.github.pagehelper.Page;

public interface PageBoardService {
  Page<BoardDTO> selectPageBoardList(int pageNum) throws Exception;
}
