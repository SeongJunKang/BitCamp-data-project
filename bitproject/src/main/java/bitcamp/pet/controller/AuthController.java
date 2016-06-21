//쿠키 사용하기 - 로그인 폼에서 아이디 저장하기.
package bitcamp.pet.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.google.gson.Gson;

import bitcamp.pet.service.MemberService;
import bitcamp.pet.vo.Member;

@Controller
@RequestMapping("/auth/")
public class AuthController {
  
  @Autowired
  MemberService memberService;
  
  @RequestMapping(produces="application/json;charset=UTF-8", value="login")
  @ResponseBody
  public String login(
      String email ,
      String password ,
      HttpSession session) {
    HashMap<String,Object> result = new HashMap<>();
    if ( memberService.exist(email, password)) {
      Member member = memberService.retrieveByEmail(email);
      System.out.println(member);
      session.setAttribute("loginUser",member);
      result.put("status", "success");
    } else {
      result.put("status", "failure");
    }
    return new Gson().toJson(result);
  }
  
  @RequestMapping(value="logout")
  public String logout(HttpSession session,SessionStatus status) {
    status.setComplete(); //@SessionAttributes로 관리하는 값 제거
    session.invalidate(); // HttpSession 객체 무효화시킨다.
    // =>invalidate()는 스프링에서 @SessionAttributes로 관리하는 값을 제거하지 못한다.
    return "redirect:../main/index.html";
  }
  
  @RequestMapping(produces="application/json;charset=UTF-8", value="loging")
  @ResponseBody
  public String loging(HttpSession session) {
    HashMap<String,Object> result = new HashMap<>();
    if ( session.getAttribute("loginUser") != null) {
      result.put("status", "success");
    } else {
      result.put("status", "failure");
    }
    return new Gson().toJson(result);
  }
}

/*
# 
- 
 */
