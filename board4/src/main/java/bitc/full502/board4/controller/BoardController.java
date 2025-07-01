package bitc.full502.board4.controller;

import bitc.full502.board4.entity.BoardEntity;
import bitc.full502.board4.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/jpa")
@RequiredArgsConstructor
public class BoardController {

  private final BoardService boardService;

  @GetMapping("/")
  public String index() {
    return "index";
  }

//  게시물 목록
  @GetMapping("/board")
  public ModelAndView boardList() throws Exception {
    ModelAndView mv = new ModelAndView("board/boardList");

//    DTO 클래스 대신 Entity 클래스 타입을 사용
    List<BoardEntity> boardList = boardService.selectBoardList();
    mv.addObject("boardList", boardList);

    return mv;
  }

//  게시물 상세보기
  @GetMapping("/board/{boardIdx}")
  public ModelAndView boardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
    ModelAndView mv = new ModelAndView("board/boardDetail");

//    DTO 클래스 대신 Entity 클래스 타입을 사용
    BoardEntity board = boardService.selectBoardDetail(boardIdx);
    mv.addObject("board", board);

    return mv;
  }

//  게시물 등록(뷰페이지)
  @GetMapping("/board/write")
  public String boardWrite() {
    return "board/boardWrite";
  }

//  게시물 등록(처리)
//  매개변수로 DTO 클래스가 아닌 Entity 클래스 타입을 사용
  @PostMapping("/board/write")
  public String boardWrite(BoardEntity board) throws Exception {
    boardService.saveBoard(board);

    return "redirect:/jpa/board";
  }

//  게시물 수정
  @PutMapping("/board/{boardIdx}")
  public String boardUpdate(@PathVariable("boardIdx") int boardIdx, BoardEntity board) throws Exception {
//    매개변수로 받아온 BoardEntity 에는 boardIdx가 현재 없기 때문에 매개변수로 받아온 게시물 번호를 추가
    board.setBoardIdx(boardIdx);
    boardService.saveBoard(board);

    return "redirect:/jpa/board";
  }

//  게시물 삭제
  @DeleteMapping("/board/{boardIdx}")
  public String boardDelete(@PathVariable("boardIdx") int boardIdx) throws Exception {
    boardService.deleteBoard(boardIdx);

    return "redirect:/jpa/board";
  }
}














