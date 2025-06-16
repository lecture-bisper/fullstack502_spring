package bitc.full502.board1.controller;

import bitc.full502.board1.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

  @RequestMapping("/")
  public String index() {
    return "thymeleaf/index";
  }

  @RequestMapping("/test1")
  public ModelAndView test1() throws Exception {
    ModelAndView mv = new ModelAndView("thymeleaf/test1");

    mv.addObject("value1", "서버에서 전달한 문자열");
    mv.addObject("value2", 100);
    mv.addObject("value3", 200);
    mv.addObject("utext", "문자열과 <strong>html 태그</strong> 가 혼합된 문자열");
    mv.addObject("idx", 16);

    return mv;
  }

  @RequestMapping("/test2")
  public ModelAndView test2() throws Exception {
    ModelAndView mv = new ModelAndView("thymeleaf/test2");

    MemberDTO member = new MemberDTO();
    member.setMemberIdx(1);
    member.setMemberName("아이유");
    member.setMemberId("iu");
    member.setMemberAge(32);
    member.setMemberEmail("iu@bitc.ac.kr");

    mv.addObject("member", member);

    mv.addObject("str1", "첫번째");
    mv.addObject("str2", "두번째");
    mv.addObject("str3", null);

    mv.addObject("num1", 100);
    mv.addObject("num2", 3);
    mv.addObject("num3", 11);

    mv.addObject("grade", "B");

    String[] strArray = {"첫번째", "두번째", "세번째", "네번째", "다섯번째"};
    List<String> strList = new ArrayList<String>();
    strList.add("첫번째");
    strList.add("두번째");
    strList.add("세번째");
    strList.add("네번째");
    strList.add("다섯번째");

    mv.addObject("itemArray", strArray);
    mv.addObject("itemList", strList);

    MemberDTO mem1 = new MemberDTO();
    mem1.setMemberIdx(1);
    mem1.setMemberName("테스터1");
    mem1.setMemberId("test1");
    mem1.setMemberAge(10);
    mem1.setMemberEmail("tester1@bitc.ac.kr");

    MemberDTO mem2 = new MemberDTO();
    mem2.setMemberIdx(2);
    mem2.setMemberName("테스터2");
    mem2.setMemberId("test2");
    mem2.setMemberAge(20);
    mem2.setMemberEmail("tester2@bitc.ac.kr");

    MemberDTO mem3 = new MemberDTO();
    mem3.setMemberIdx(3);
    mem3.setMemberName("테스터3");
    mem3.setMemberId("test3");
    mem3.setMemberAge(30);
    mem3.setMemberEmail("tester3@bitc.ac.kr");

    List<MemberDTO> memberList = new ArrayList<>();
    memberList.add(mem1);
    memberList.add(mem2);
    memberList.add(mem3);

    mv.addObject("memberList", memberList);

    return mv;
  }
}












