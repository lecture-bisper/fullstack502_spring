package btic.full502.board2.controller;

import btic.full502.board2.dto.UserDTO;
import btic.full502.board2.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private AuthService authService;

//  회원가입
//  1. 회원 가입 View 템플릿을 연동
  @RequestMapping("/join.do")
  public String join() {
    return "board/auth/join";
  }

//  회원가입 프로세스
//  1. 클라이언트에서 전달한 사용자 정보를 파라미터로 받아옴
//  2. 서비스를 사용하여 전달받은 사용자 정보를 데이터베이스에 등록
//  3. 로그인 페이지로 리다이렉트
  @RequestMapping("/joinProcess.do")
  public String joinProcess() {
    return "/auth/joinProcess";
  }

//  로그인
//  1. 로그인 view 템플릿과 연동
  @RequestMapping("/login.do")
  public String login() {
    return "board/auth/login";
  }

//  로그인 정보 인증 프로세스
//  1. 클라이언트에서 전달 받은 데이터 가져오기 (id/pw)
//  2. 서비스를 이용하여 DB에 해당 id/pw 를 사용하는 사용자가 있는지 여부 확인
//  3-1. 사용자가 있을 경우 세션 생성
//  3-2. 사용자가 없을 경우 로그인 실패 페이지로 리다이렉트
//  4. 서비스를 이용하여 DB에서 해당 id를 사용하는 사용자 정보를 모두 가져옴
//  5. 생성된 세션에 가져온 사용자 정보를 저장
//  6. 로그인 성공 페이지로 리다이렉트
  @RequestMapping("/loginProcess.do")
  public String loginProcess(@RequestParam("userId") String userId, @RequestParam("userPw") String userPw, HttpServletRequest req) throws Exception {

//    사용자가 입력한 ID/pw 를 사용하는 사용자 정보가 있는지 확인
    int result = authService.isUserInfo(userId, userPw);

//    사용자가 있는지 없는지 확인
    if (result == 1) {
//      사용자가 있을 경우 id 를 사용하여 사용자 정보 가져오기
      UserDTO user = authService.selectUserInfo(userId);

//      Request 객체에 저장되어 있는 session 을 가져옴
      HttpSession session = req.getSession();
//      세션에 데이터베이스에서 가져온 정보를 저장
      session.setAttribute("userId", user.getUserId());
      session.setAttribute("userName", user.getUserName());
      session.setAttribute("userEmail", user.getUserEmail());
//      세션 유지 시간 설정 (초로 계산)
      session.setMaxInactiveInterval(60 * 5);

      return "redirect:/auth/loginOK.do";
    }
    else {
      return "redirect:/auth/loginFail.do";
    }
  }

//  로그인 성공
//  1. 매개변수로 세션 정보가 들어있는 HttpServletRequest 객체를 받아옴
//  2. HttpServletRequest 객체에서 세션 정보를 가져옴
//  3. ModelAndView 객체를 생성하고 템플릿 파일과 연동
//  4. 가져온 세션 정보를 ModelAndView 객체에 저장
//  5. ModelAndView 객체를 클라이언트로 반환
  @RequestMapping("/loginOK.do")
  public ModelAndView loginOK(HttpServletRequest req) throws Exception {
    ModelAndView mv = new ModelAndView("board/auth/loginOK");

//    Request 객체에서 Session 을 가져옴
    HttpSession session = req.getSession();

//    UserDTO 타입의 객체 생성
    UserDTO user = new UserDTO();
//    세션에 저장된 정보를 UserDTO 객체에 저장
//    세션에 저장된 데이터는 모두 Object 타입이기 때문에 강제 타입 변환 필수
    user.setUserId((String) session.getAttribute("userId"));
    user.setUserName((String) session.getAttribute("userName"));
    user.setUserEmail((String) session.getAttribute("userEmail"));

//    ModelAndView 객체에 데이터 저장
    mv.addObject("user", user);

    return mv;
  }

//  로그인 실패
//  1. 로그인 실패 내용 출력 후 로그인 페이지로 이동 (자바스크립트를 통한 알림창을 출력해도 상관없음)
  @RequestMapping("/loginFail.do")
  public String loginFail() {
    return "board/auth/loginFail";
  }

//  로그아웃
//  1. 매개변수로 세션정보를 가지고 있는 HttpServletRequest 객체를 받아옴
//  2. HttpServletRequest 객체에서 세션 정보를 가져옴
//  3. 세션에 저장된 모든 정보를 삭제
//  4. 로그아웃 템플릿 을 클라이언트로 반환
  @RequestMapping("/logout.do")
  public String logout(HttpServletRequest req) throws Exception {

//    Request 객체에서 Session을 가져옴
    HttpSession session = req.getSession();

//    세션에 저장된 데이터를 지정하여 삭제
    session.removeAttribute("userId");
    session.removeAttribute("userName");
    session.removeAttribute("userEmail");

//    세션에 저장된 모든 데이터를 삭제
    session.invalidate();

    return "board/auth/logout";
  }
}














