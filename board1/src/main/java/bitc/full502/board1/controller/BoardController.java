package bitc.full502.board1.controller;


import bitc.full502.board1.dto.BoardDTO;
import bitc.full502.board1.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//  MVC 패턴 : 웹 애플리케이션을 구성 시 필요한 데이터와 데이터 제어부 및 화면 출력 부분을 모두 따로 분리하여 개발하는 형태
//  Model : 데이터베이스
//  View : 클라이언트 화면에 출력되는 view template (html 파일)
//  Controller : 사용자가 접속할 수 있는 URL 과 사용자가 전달한 데이터를 전달받아 연산하고, 가공하여 실제 데이터베이스와 연결 및 View 를 표시하기 위해서 제어하는 모든 부분 (jsp의 서블릿 파일)


//  @Controller : 해당 클래스가 Spring MVC 패턴에서 Controller 로 동작하는 클래스라는 것으로 설정하는 어노테이션
//  @Controller, @RestController 2가지 타입이 존재
//  @Controller - 일반적인 SOAP 방식의 HTTP 응답 처리를 할 경우 사용함, 통신방법을 GET/POST 만 사용, 클라이언트로 전달하는 데이터가 html 형식
//  @RestController - RESTful 방식의 HTTP 응답 처리를 할 경우 사용함, 통신방법이 GET/POST/PUT/DELETE 를 사용함, 클라이언트로 전달하는 데이터가 데이터 그 자체임
@Controller
@RequestMapping("/board")
public class BoardController {

//  @Autowired : 해당 객체를 사용자가 직접 생성하지 않고 스프링 프레임워크에서 관리하도록 설정하는 어노테이션
  @Autowired
  private BoardService boardService;

//  @RequestMapping : 클라이언트 요청을 받는 URL 을 설정하는 어노테이션
//  url 주소 입력이 기본값 이므로 value 속성 생략 가능
//  get/post 와 같은 주소 및 다른 추가 옵션을 url과 함께 사용 시 반드시 속성명이 필요함
//  url 주소를 2개 이상 입력하고자 할 경우 { url1, url2, url3, ... } 형태로 사용

//  지정한 메소드의 반환 타입을 사용하여 View 의 출력 형태를 결정
//  반환 타입이 String 일 경우 templates 의 html 파일의 이름을 의미함 (대소문자 구분)

//  @RequestMapping 어노테이션을 클래스와 메소드에 사용할 수 있음
//  클래스에 사용 시 기본 주소로 사용, 메소드에는 상세 주소를 입력하는 형식으로 사용
  
//  @RequestMapping 대신 @GetMapping, @PostMapping, @PutMapping, @DeleteMapping 을 사용할 수 있음
  @RequestMapping({"/", "/index", "/main"})
  public String index() {

    return "index";
  }


//  @RequestMapping(value = "/board/boardList.do")
@RequestMapping(value = "/boardList.do")
  public ModelAndView boardList() throws Exception {
//    ModelAndView : View 템플릿과 데이터 Model 이 하나로 합쳐진 클래스
//    해당 클래스의 객체 생성 시 생성자의 매개변수로 html 파일의 경로를 지정
//  html 파일의 경로는 templates 폴더를 기본으로 함
    ModelAndView mv = new ModelAndView("board/boardList");

//    Service 객체를 통해서 데이터베이스에서 정보 가져오기
    List<BoardDTO> boardList = boardService.selectBoardList();

//    가져온 데이터 정보를 ModelAndView 객체에 저장
//  jsp의 request.settAttribute("이름", 데이터) 와 동일한 기능
    mv.addObject("boardList", boardList);

//    설정된 ModelAndView 객체를 클라이언트로 전달
    return mv;
  }

//  글 쓰기 View
//  사용자 입력을 위한 웹 페이지 이므로 html 파일 연결
  @RequestMapping("/boardWrite.do")
  public String boardWrite() throws Exception {
    return "board/boardWrite";
  }

//  글 쓰기 처리
//  boardWrite.html 파일에서 form 태그에 설정된 url
//  사용자가 입력한 데이터를 BoardDTO 타입으로 가져옴
//  input 태그의 name 속성값이 BoardDTO 클래스의 필드와 이름이 같아야 함(다를 경우 전달받는 데이터 없음)
  @RequestMapping("/boardInsert.do")
  public String boardInsert(BoardDTO board) throws Exception {

//    서비스를 이용하여 데이터베이스 게시글 정보 등록
    boardService.insertBoard(board);

//    JSP의 response.sendRedirect() 와 동일한 기능, 클라이언트에게 지정한 URL로 다시 접속 요청
    return "redirect:/board/boardList.do";
  }

//  글 상세보기, 지정한 게시글 번호를 사용
  @RequestMapping("/boardDetail.do")
  public ModelAndView boardDetail(int boardIdx) throws Exception {
    ModelAndView mv = new ModelAndView("board/boardDetail");

//    서비스를 사용하여 지정한 게시글 번호의 내용을 가져옴
    BoardDTO board = boardService.selectBoardDetail(boardIdx);
//    가져온 데이터를 ModelAndView 클래스 타입의 객체에 저장
    mv.addObject("board", board);

    return mv;
  }

//  글 수정
  @RequestMapping("/updateBoard.do")
  public String updateBoard(BoardDTO board) throws Exception {
//    1. 클라이언트에서 전달받은 수정된 데이터와 게시글 번호 받아오기
//    2. 서비스를 이용하여 전달받은 데이터로 DB 내용 수정
//    3. 목록 페이지로 리다이렉트

    boardService.updateBoard(board);

    return "redirect:/board/boardList.do";
  }

//  글 삭제
  @RequestMapping("/deleteBoard.do")
  public String deleteBoard(@RequestParam int boardIdx) throws Exception {
//    1. 클라이언트에서 전달한 삭제할 게시물 번호를 받아오기
//    2. 서비스를 이용하여 지정한 게시물 번호의 DB를 삭제
//    3. 목록 페이지로 리다이렉트

    boardService.deleteBoard(boardIdx);

    return "redirect:/board/boardList.do";
  }
}











