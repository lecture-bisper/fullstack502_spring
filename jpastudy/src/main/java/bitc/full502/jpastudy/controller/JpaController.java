package bitc.full502.jpastudy.controller;

import bitc.full502.jpastudy.domain.entity.JpaBoardEntity;
import bitc.full502.jpastudy.domain.repository.JpaBoardRepository;
import bitc.full502.jpastudy.service.JpaBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class JpaController {

  private final JpaBoardService jpaBoardService;

  @GetMapping("/")
  public String index() {

    return "index 페이지";
  }

  @GetMapping("/insert")
  public String insertBoard() {
    //    JpaBoardEntity 에 1개 데이터 입력
//    jpaBoardService.insertBoard();

//    JpaBoardEntity 에 여러개 데이터 한번에 입력
    jpaBoardService.insertBoardList();

    return "JpaRepository 기본 메소드 save() 사용";
  }

  @GetMapping("/select")
  public String selectBoard() {

    System.out.println("\n----- findById() -----\n");
    JpaBoardEntity board = jpaBoardService.selectBoard(5);

    System.out.println("\n----- findAll() -----\n");
    List<JpaBoardEntity> boardList = jpaBoardService.selectBoardList();


    return "JpaRepository 기본 메소드 find() 사용";
  }

  @GetMapping("/update")
  public String updateBoard() {

    System.out.println("\n----- save()를 통한 수정 -----\n");
    jpaBoardService.updateBoard();

    return "JpaRepository 기본 메소드 save() 사용";
  }

  @GetMapping("/delete")
  public String deleteBoard() {

    System.out.println("\n----- deleteById(), deleteAll()를 통한 삭제 -----\n");
    jpaBoardService.deleteBoard();

    return "JpaRepository 기본 메소드 deleteById(), deleteAll() 사용";
  }
}














