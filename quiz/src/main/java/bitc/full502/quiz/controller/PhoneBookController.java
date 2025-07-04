package bitc.full502.quiz.controller;

import bitc.full502.quiz.domain.entity.PhoneBookEntity;
import bitc.full502.quiz.service.PhoneBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PhoneBookController {

//  서비스를 사용하기 위한 객체, 스프링 프레임워크가 관리
  private final PhoneBookService phoneBookService;

  @GetMapping("/")
  public String index() {
    return "index";
  }

//  메인페이지, 연락처 목록 페이지
  @GetMapping("/phoneBook")
  public ModelAndView phoneBookList() {
    ModelAndView mv = new ModelAndView("phoneBook/phoneBookList");

    List<PhoneBookEntity> phoneBookList = phoneBookService.selectPhoneBookList();
    mv.addObject("phoneBookList", phoneBookList);

    return mv;
  }

//  연락처 등록 페이지(View)
  @GetMapping("/phoneBook/write")
  public String phoneBookWrite() {
    return "phoneBook/phoneBookWrite";
  }

//  연락처 등록(process)
  @PostMapping("/phoneBook/write")
  public String phoneBookWrite(PhoneBookEntity phoneBook) {

    phoneBookService.insertPhoneBook(phoneBook);

    return "redirect:/phoneBook";
  }

//  연락처 상세 페이지
  @GetMapping("/phoneBook/{seq}")
  public ModelAndView phoneBookDetail(@PathVariable("seq") int seq) {
    ModelAndView mv = new ModelAndView("phoneBook/phoneBookDetail");

    PhoneBookEntity phoneBook = phoneBookService.selectPhoneBookDetail(seq);
    mv.addObject("phoneBook", phoneBook);

    return mv;
  }

//  연락처 수정
  @PutMapping("/phoneBook/{seq}")
  public String phoneBookUpdate(@PathVariable("seq") int seq, PhoneBookEntity phoneBook) {

    phoneBook.setSeq(seq);
    phoneBookService.updatePhoneBook(phoneBook);

    return "redirect:/phoneBook";
  }

//  연락처 삭제
  @DeleteMapping("/phoneBook/{seq}")
  public String phoneBookDelete(@PathVariable("seq") int seq) {

    phoneBookService.deletePhoneBook(seq);

    return "redirect:/phoneBook";
  }

  @ResponseBody
  @GetMapping("/phoneBook/search")
  public Object phoneBookSearch(@RequestParam("searchText") String searchText, @RequestParam("option") String opt) {

    List<PhoneBookEntity> phoneBookList = phoneBookService.selectPhoneBookSearchList(searchText, opt);

    return phoneBookList;
  }
}














