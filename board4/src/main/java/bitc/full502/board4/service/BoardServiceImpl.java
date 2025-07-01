package bitc.full502.board4.service;

import bitc.full502.board4.entity.BoardEntity;
import bitc.full502.board4.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

  private final BoardRepository boardRepository;

  @Override
  public List<BoardEntity> selectBoardList() throws Exception {
    return boardRepository.findAllByOrderByBoardIdxDesc();
  }

  @Override
  public BoardEntity selectBoardDetail(int boardIdx) throws Exception {
//    BoardEntity board = boardRepository.findById(boardIdx).orElse(null);
    Optional<BoardEntity> optBoard = boardRepository.findById(boardIdx);

    if (optBoard.isPresent()) {
      BoardEntity board = optBoard.get();
      board.setHitCnt(board.getHitCnt() + 1);
      boardRepository.save(board);

      return board;
    }
    else {
//      throw new NullPointerException();
      return null;
    }
  }

  @Override
  public void saveBoard(BoardEntity board) throws Exception {
    boardRepository.save(board);
  }

  @Override
  public void deleteBoard(int boardIdx) throws Exception {
    boardRepository.deleteById(boardIdx);
  }
}














