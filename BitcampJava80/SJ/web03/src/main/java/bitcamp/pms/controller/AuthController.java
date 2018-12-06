//쿠키 사용하기 - 로그인 폼에서 아이디 저장하기.
package bitcamp.pms.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import bitcamp.pms.service.MemberService;
import bitcamp.pms.vo.Member;

@Controller
@RequestMapping("/auth")
@SessionAttributes("loginUser")
public class AuthController {
  
  @Autowired
  MemberService memberService;
  
  @RequestMapping(value="/login",method=RequestMethod.GET)
  public String form(
      @CookieValue(required=false) String email, Model model) {
    if (email != null) {
      model.addAttribute("email",email);
      model.addAttribute("checked","checked='checked'");
    } 
    return "/auth/form";
  }
  @RequestMapping(value="/login",method=RequestMethod.POST)
  public String login(
      String email ,
      String password ,
      String emailsave,
      Model model,
      HttpServletResponse response) {
    
    if (emailsave != null) {
      Cookie cookie = new Cookie("email",email);
      cookie.setMaxAge(3600*24*7);
      response.addCookie(cookie);
    } else {
      Cookie cookie = new Cookie("email","");
      cookie.setMaxAge(0);
      response.addCookie(cookie);
    }
    
    
    if ( memberService.exist(email, password)) {
      Member member = memberService.retrieveByEmail(email);
      model.addAttribute("loginUser",member);
      return "redirect:../board/list.do";
    } else {
      return "redirect:login.do";
    }
  }
  
  @RequestMapping(value="/logout")
  public String logout(HttpSession session,SessionStatus status) {
    status.setComplete(); //@SessionAttributes로 관리하는 값 제거
    session.invalidate(); // HttpSession 객체 무효화시킨다.
    // =>invalidate()는 스프링에서 @SessionAttributes로 관리하는 값을 제거하지 못한다.
    return "redirect:login.do";
  }
}

/*
# 
- 
 */
