package bitc.full502.board5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

  @GetMapping("/")
  public String index() {
    return "index 페이지";
  }

}














