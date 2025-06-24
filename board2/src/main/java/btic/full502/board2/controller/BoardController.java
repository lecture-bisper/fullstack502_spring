package btic.full502.board2.controller;

import btic.full502.board2.dto.BoardDTO;
import btic.full502.board2.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

  @Autowired
  private BoardService boardService;

//  게시물 목록
  @RequestMapping("/boardList.do")
  public ModelAndView boardList() throws Exception {
    ModelAndView mv = new ModelAndView("board/boardList");

//    1. 서비스를 이용하여 게시물 목록 가져오기
//    2. 가져온 게시물 정보를 ModelAndView 객체에 저장
    List<BoardDTO> boardList = boardService.selectBoardList();
    mv.addObject("boardList", boardList);

    return mv;
  }

//  게시물 상세보기
//  1. 클라이언트에서 전달한 데이터를 파라미터로 가져옴
//  2. ModelAndView 객체 생성 및 템플릿 파일 위치 연동
//  3. 서비스를 이용하여 파라미터로 받아온 게시글 번호에 맞는 게시글 상세 정보를 가져옴
//  4. ModelAndView 객체에 게시글 정보를 저장
//  5. ModelAndView 객체 반환
  @RequestMapping(value = "/boardDetail.do", method = RequestMethod.GET)
  public ModelAndView boardDetail(@RequestParam("boardIdx") int boardIdx) throws Exception {
    ModelAndView mv = new ModelAndView("board/boardDetail");

    BoardDTO board = boardService.selectBoardDetail(boardIdx);
    mv.addObject("board", board);

    return mv;
  }
  
//  게시글 등록하기 사용자 입력 페이지
//  1. 템플릿 파일과 연동
  @RequestMapping(value = "/boardWrite.do", method = RequestMethod.GET)
  public String boardWrite() {
    return "board/boardWrite";
  }
  
//  게시글 등록하기 프로세스 페이지
//  1. 클라이언트에서 전달받은 데이터를 파라미터로 가져오기 (BoardDTO 타입으로 받아옴)
//  2. 서비스를 이용하여 클라이언트에서 가져온 데이터를 데이터베이스에 등록
//  3. 게시글 목록 페이지로 리다이렉트
  @RequestMapping(value = "/boardWrite.do", method = RequestMethod.POST)
  public String boardWrite(BoardDTO board) throws Exception {
    boardService.boardWrite(board);

    return "redirect:/board/boardList.do";
  }
}














