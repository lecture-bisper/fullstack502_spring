package btic.full502.jquerytest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JqueryController {

  @RequestMapping("/")
  public String index() {
    return "index";
  }

  @RequestMapping("test1")
  public String test1() {
    return "jquery/test1";
  }

  @RequestMapping("/test2")
  public String test2() {
    return "jquery/test2";
  }
}














