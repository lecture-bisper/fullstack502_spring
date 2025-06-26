package bitc.full502.outsidedir.controller;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableScheduling
@Controller
public class OutSideController {

  @RequestMapping("/")
  public String index() {
    return "index";
  }

  @RequestMapping("/outside/imgLoad")
  public String imgLoad() {
    return "outside/imgLoad";
  }
}














