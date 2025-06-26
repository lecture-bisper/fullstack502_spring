package bitc.full502.board3.controller.api;

import bitc.full502.board3.dto.BoardDTO;
import bitc.full502.board3.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//  REST API : REST 방식과 동일한 형태로 HTTP 프로토콜을 사용하지만, 클라이언트로 전달하는 데이터가 View 를 제외한 순수 데이터만 전달하는 방식
//  예전에는 클라이언트가 컴퓨터 밖에 없었기 때문에 웹 브라우저 혹은 전용 프로그램이 클라이언트의 기능을 모두 담당함
//  서버의 기능 중 웹 서버의 기능만 주로 사용되었기 때문에 클라이언트로 전달하는 데이터가 View 와 Model 데이터 모두 필요한 형태였음
//  현재는 클라이언트가 다양한 디바이스로 동작하기 때문에 View 부분이 반드시 웹 브라우저일 필요가 없기 때문에 데이터만 전달하는 방식으로 변경되었음

//  @RestController : @Controller 과 @ResponseBody 어노테이션이 하나로 합쳐진 어노테이션
//  @Controller 의 기능인 스프링 프레임워크에 해당 클래스가 스프링 MVC 의 Controller 를 담당하는 클래스라는 것을 알려주는 기능과 @ResponseBody 의 기능인 클라이언트에게 View 없이 데이터만 전달하는 기능이 합쳐진 어노테이션
//  클래스에 @Controller 를 사용하고, 메소드에 @ResponseBody 어노테이션을 따로 입력하여 사용해도 @RestController 와 동일한 효과를 가짐
//  ajax 통신 시 REST API 방식으로 데이터를 전송하는 컨트롤러를 따로 생성하여 사용하면 편리함
//  안드로이드나 리액트 사용 시 프론트엔드 부분과 백엔드 부분이 완전히 분리되어 있는 형태이기 때문에 데이터를 주고 받기 위해서 ajax 통신으로 REST API 방식을 사용함

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardApiController {

  private final BoardService boardService;

//  게시물 목록 API
  @GetMapping("/board")
  public Object apiBoardList() throws Exception {
    List<BoardDTO> boardList = boardService.selectBoardList();

    return boardList;
  }
  
//  게시물 상세 정보 API
  @GetMapping("/board/{boardIdx}")
  public Object apiBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
    return boardService.selectBoardDetail(boardIdx);
  }
  
//  게시물 등록 API
  @PostMapping("/board/write")
  public void apiBoardInsert(@RequestBody BoardDTO board) throws Exception {
    boardService.boardInsert(board);
  }
  
//  게시물 수정 API
  @PutMapping("/board/{boardIdx}")
  public void apiBoardUpdate(@PathVariable("boardIdx") int boardIdx, @RequestBody BoardDTO board) throws Exception {
    board.setBoardIdx(boardIdx);
    boardService.boardUpdate(board);
  }
  
//  게시물 삭제 API
  @DeleteMapping("/board/{boardIdx}")
  public void apiBoardDelete(@PathVariable("boardIdx") int boardIdx) throws Exception {
    boardService.boardDelete(boardIdx);
  }
  
}














