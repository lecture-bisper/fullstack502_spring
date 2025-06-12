package btic.full502.test2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//  @Controller : 스프링 MVC 방식으로 웹 페이지를 구성하는 어노테이션
//  지정한 메소드와 view 리소스를 연동하여 화면에 출력하는 방식
@Controller
public class TestController {

//    @RequestMapping : 사용자가 서버에 접속할 수 있도록 URL 을 제공하고, 해당 URL와 메소드를 연동하는 어노테이션
//    클래스와 메소드에 모두 사용할 수 있음
//    하나의 메소드에 여러개의 URL을 설정할 수 있음

//    @RequestMapping 을 사용하여 연결된 메소드의 반환 타입이 String 이면 View 리소스의 파일 경로를 의미함
    @RequestMapping("/")
    public String index() {

//        메소드의 반환 타입이 String 일 경우 return 에 view 리소스의 전체 경로를 입력하면 resources/templates 아래에 있는 폴더 및 파일을 찾아감, 확장자명은 생략
//        예시) return "board/list" => resources/templates/board/list.html
        return "board/list";
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }
}
