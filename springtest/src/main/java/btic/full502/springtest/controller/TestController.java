package btic.full502.springtest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    public String test() throws Exception {
        return "안녕하세요. 처음 만들어 보는 스프링 페이지 입니다.";
    }

    @RequestMapping("/test2")
    public String test2() throws Exception {
        return "JSP 와는 달리 메소드에 주소를 연동함.";
    }
}
