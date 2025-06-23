package btic.full502.jquerytest.controller;

import btic.full502.jquerytest.dto.AreaDTO;
import btic.full502.jquerytest.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ajax")
public class AjaxController {

  @Autowired
  private AreaService areaService;

//  ajax 를 사용하지 않은 계산기 페이지
  @RequestMapping("/nonAjaxCalView")
  public String nonAjaxCalView() throws Exception {
    return "ajax/nonAjaxCalView";
  }

//  ajax 를 사용하지 않은 계산기 결과 페이지
//  @RequestParam : 클라이언트에서 전달한 파라미터를 가져오는 어노테이션
  @RequestMapping("/nonAjaxCalResult")
  public ModelAndView nonAjaxCalResult(@RequestParam("num1") int num1, @RequestParam("num2") int num2) throws Exception {
//    ModelAndView : 데이터인 Model 과 View 템플릿을 함께 가지고 있는 클래스
    ModelAndView mv = new ModelAndView("ajax/nonAjaxCalResult");

//    파라미터로 받아온 데이터를 연산
    int result = num1 + num2;
//    ModelAndView 클래스 타입의 객체에 데이터 저장
    mv.addObject("result", result);
    mv.addObject("num1", num1);
    mv.addObject("num2", num2);

//    클라이언트에 ModelAndView 클래스 타입의 객체 반환
    return mv;
  }

  @RequestMapping(value = "/ajaxCalResult", method =  RequestMethod.GET)
  public String ajaxCalView() throws Exception {
    return "ajax/ajaxCalView";
  }

//  @RequestParam : JSP 의 request.getParameter() 메소드와 동일한 역할을 하는 어노테이션, 클라이언트에서 전달한 데이터를 가져오는 어노테이션
// value : 클라이언트에서 전달한 데이터의 파라미터 명을 설정
// required : true(기본값)/false 로 설정, 해당 파라미터의 값이 없을 경우 오류를 표시할지 여부 설정 (false 시 오류 무시)
//  defaultValue : required 속성과 함께 사용하여 사용자가 해당 파라미터에 값을 입력하지 않을 경우 defaultValue 로 설정된 값을 사용

//  @ResponseBody : 클라이언트의 요청에 대한 서버의 응답으로 반환할 데이터를 html 템플릿이 아닌 데이터 자체를 전달하도록 하는 어노테이션

//  @RequestMapping : 클라이언트가 서버에 접속할 수 있도록 URL을 설정하는 어노테이션
//  value : 해당 클래스 및 메소드와 연동할 URL 을 설정
//  method : 클라이언트가 서버와 통신 시 사용할 데이터 전송 방식을 설정, 생략할 경우 스프링프레임워크가 자동 설정
//  method 를 설정 시 접속 방식(GET, POST, PUT, DELETE)을 다르게 하면 동일한 URL 로 접속하도록 설정할 수 있음
  @ResponseBody
  @RequestMapping(value = "/ajaxCalResult", method = RequestMethod.POST)
  public Object ajaxCalResult(@RequestParam("num1") int num1, @RequestParam(value = "num2", required = false, defaultValue = "200") int num2) throws Exception {
    int result = num1 + num2;

    Map<String, String> mapResult = new HashMap<>();
    mapResult.put("result", "success");
    mapResult.put("data", String.valueOf(result));

    return mapResult;
  }

//  사용자가 입력을 하기 위한 템플릿 뷰 화면, GET 방식 접속 시 사용
  @RequestMapping(value = "/selectBox", method = RequestMethod.GET)
  public String selectBox() throws Exception {
    return "ajax/selectBox";
  }

//  사용자가 입력한 데이터를 기반으로 내부 연산을 진행, POST 방식 접속 시 사용
//  파라미터로 areaName 을 받음
  @ResponseBody
  @RequestMapping(value = "/selectBox", method = RequestMethod.POST)
  public Object selectBox(@RequestParam("areaName") String areaName) throws Exception {
//    서비스를 사용하여 전달받은 파라미터에 대응하는 지역명을 모두 가져옴
    List<AreaDTO> areaList = areaService.getAreaList(areaName);

//    @ResponseBody 를 사용하였으므로 데이터만 클라이언트로 전달
    return areaList;
  }

  @RequestMapping(value = "/quiz1", method = RequestMethod.GET)
  public String quiz1() throws Exception {
    return "ajax/quiz1";
  }

  @ResponseBody
  @RequestMapping(value = "/quiz1", method = RequestMethod.POST)
  public Object quiz1(@RequestParam("num1") int num1, @RequestParam("num2") int num2, @RequestParam("op") String op) {
    Map<String, String> result = new HashMap<>();

    switch (op) {
      case "+":
        result.put("result", "success");
        result.put("value", String.valueOf(num1 + num2));
        break;

      case "-":
        result.put("result", "success");
        result.put("value", String.valueOf(num1 - num2));
        break;

      case "*":
        result.put("result", "success");
        result.put("value", String.valueOf(num1 * num2));
        break;

      case "/":
        result.put("result", "success");
        result.put("value", String.valueOf(num1 / num2));
        break;
    }

    return result;
  }

  @RequestMapping("/quiz2")
  public String quiz2() throws Exception {
    return "ajax/quiz2";
  }

  @ResponseBody
  @RequestMapping(value = "/quiz2result1", method = RequestMethod.POST)
  public Object quiz2Result1(@RequestParam("areaName") String areaName) throws Exception {
    List<AreaDTO> areaList = areaService.getDistrictList(areaName);

    return areaList;
  }

  @ResponseBody
  @RequestMapping(value = "/quiz2result2", method = RequestMethod.POST)
  public Object quiz2Result2(@RequestParam("areaName") String areaName) throws Exception {
    List<AreaDTO> areaList = areaService.getTownList(areaName);

    return areaList;
  }
}














