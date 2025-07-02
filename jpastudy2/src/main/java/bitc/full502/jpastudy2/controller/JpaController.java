package bitc.full502.jpastudy2.controller;

import bitc.full502.jpastudy2.service.EmployeesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class JpaController {

  private final EmployeesService employeesService;

  @GetMapping("/")
  public String index() {

    return "JPA 의 쿼리메소드 사용하기";
  }

  @GetMapping("/method")
  public String method() throws Exception {

    employeesService.finds();

    return "쿼리메소드 사용";
  }


}














