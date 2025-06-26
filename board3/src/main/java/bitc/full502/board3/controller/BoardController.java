package bitc.full502.board3.controller;

import bitc.full502.board3.dto.BoardDTO;
import bitc.full502.board3.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//  REST 이란 : URL을 리소스의 이름을 구분하여 해당 리소스의 정보를 주고 받는 방식
//  HTTP URI 를 통해서 리소스를 명시하고, HTTP Method(GET, POST, PUT, DELETE)를 통해 리소스에 대한 CRUD 명령을 적용하는 방식

//  URI : Uniform Resource Identifier 의 줄임말, 자원 식별자
//  URL : Uniform Resource Locator 의 줄임말, 자원의 위치
//  현재는 거의 같은 의미로 사용

//  REST 방식은 데이터를 전송하는 방법을 지정하여 사용
//  HttpMethod 를 사용하여 GET(조회, select), POST(입력, insert), PUT(수정, update), DELETE(삭제, delete) 로 구분해서 사용

//  REST 방식을 사용하여 전체 URL 설정 방법
//  서버URL:포트번호/기본주소/추가주소/게시물번호

//  게시물 목록 : /board/boardList.do                =>  /board              GET
//  게시물 상세 보기 : /board/boardDetail.do         =>  /board/게시물번호   GET
//  게시물 작성 화면 : /board/boardWrite.do          =>  /board/write        GET
//  게시물 작성 처리 : /board/boardWriteProcess.do   =>  /board/write        POST
//  게시물 수정 : /board/boardUpdate.do              =>  /board/게시물번호   PUT
//  게시물 삭제 : /board/boardDelete.do              =>  /board/게시물번호   DELETE

//  URL 설정을 위해서 사용하는 @RequestMapping 어노테이션 사용 시 URL를 value 속성을 사용하여 설정, method 속성을 사용하여 GET, POST, PUT, DELETE 를 설정
//  GET, POST, PUT, DELETE 를 쉽게 사용하기 위해서 @GetMapping, @PostMapping, @PutMapping, @DeleteMapping 어노테이션을 제공함

//  주의사항
//  Spring Framework 의 기본 설정은 GET, POST 방식만 존재
//  GET, POST, PUT, DELETE 방식을 사용하기 위해 application.properties 설정 파일에 spring.mvc.hiddenmethod.filter.enabled=true 설정을 추가해야 함

//  HTML 에서는 기본적으로 GET, POST 방식만 인식하기 때문에 Spring Framework 에서 PUT, DELETE 방식을 인식하기 위해서 input 태그에 type=hidden 으로 설정하고, name 속성에 name=_method 로 설정하여 데이터 전송 방식을 지정해야 함

@RequiredArgsConstructor
@Controller
public class BoardController {

//  @Autowired
//  private BoardService boardService;
  private final BoardService boardService;

//  게시물 목록 (데이터를 조회하여 가져오는 부분이기 때문에 GET 사용)
//  기존의 @RequestMapping 사용방법에서 value, method 속성을 추가하여 사용
//  value 에 URL 를 입력, method 에 RequestMethod 클래스를 사용하여 데이터 전달방식을 설정
  @RequestMapping(value = "/board", method = RequestMethod.GET)
  public ModelAndView boardList() throws Exception {
    ModelAndView mv = new ModelAndView("board/boardList");

    List<BoardDTO> boardList = boardService.selectBoardList();
    mv.addObject("boardList", boardList);

    return mv;
  }

//  @PathVariable : @RequestParam 과 동일한 역할을 하는 어노테이션, REST 방식 사용 시 URI 에 {} 로 지정해 놓은 리소스의 값을 받아오는 어노테이션
//  게시물 상세보기 (지정한 데이터를 조회하여 가져오는 부분이기 때문에 GET 사용)
  @RequestMapping(value = "/board/{boardIdx}", method = RequestMethod.GET)
  public ModelAndView boardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
    ModelAndView mv = new ModelAndView("board/boardDetail");

    BoardDTO board = boardService.selectBoardDetail(boardIdx);
    mv.addObject("board", board);

    return mv;
  }

//  @GetMapping : 클라이언트에서 데이터 전송 방식을 GET 으로 설정한 URL 만 접속
//  @RequestMapping(method = RequestMethod.GET) 과 동일한 방식
//  게시물 등록 화면
  @GetMapping("/board/write")
  public String boardWrite() throws Exception {
    return "board/boardWrite";
  }

//  클라이언트가 접근하는 URL 이 동일하더라도 데이터 전송방식이 다르면 최종적으로 서로 다른 URL 로 인식하기 때문에 동일한 URL 을 사용할 수 있음

//  @PostMapping : 클라이언트에서 데이터 전송 방식을 POST 로 설정한 URL 만 접속
//  @RequestMapping(method = RequestMethod.POST) 와 동일한 방식
//  게시물 등록 처리
  @PostMapping("/board/write")
  public String boardWrite(BoardDTO board) throws Exception {
    boardService.boardInsert(board);

    return "redirect:/board";
  }

//  @PutMapping : 클라이언트에서 데이터 전송 방식을 PUT 으로 설정한 URL 만 접속
//  @RequestMapping(method = RequestMethod.PUT) 과 동일한 방식
//  게시물 수정
  @PutMapping("/board/{boardIdx}")
  public String boardUpdate(BoardDTO board) throws Exception {
    boardService.boardUpdate(board);

    return "redirect:/board";
  }

//  @DeleteMapping : 클라이언트에서 데이터 전송 방식을 DELETE 로 설정한 URL 만 접속
//  @RequestMapping(method = RequestMethod.POST) 와 동일한 방식
//  게시물 삭제
  @DeleteMapping("/board/{boardIdx}")
  public String boardDelete(@PathVariable("boardIdx") int boardIdx) throws Exception {
    boardService.boardDelete(boardIdx);

    return "redirect:/board";
  }
}














