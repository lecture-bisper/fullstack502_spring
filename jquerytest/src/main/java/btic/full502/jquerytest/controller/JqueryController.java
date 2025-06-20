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

  @RequestMapping("/test3")
  public String test3() {
    return "jquery/test3";
  }

  @RequestMapping("/test4")
  public String test4() {
    return "jquery/test4";
  }

  @RequestMapping("/test5")
  public String test5() {
    return "jquery/test5";
  }

  @RequestMapping("/test6")
  public String test6() {
    return "jquery/test6";
  }
}














