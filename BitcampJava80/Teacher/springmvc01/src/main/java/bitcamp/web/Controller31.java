package bitcamp.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import bitcamp.vo.Member;

@Controller
@RequestMapping("/controller31")
@SessionAttributes("userInfo")
public class Controller31 {
  @RequestMapping(value="/login", method=RequestMethod.GET)
  public String form(@CookieValue(required=false) String id, Model model) {
    if (id != null) {
      model.addAttribute("id", id);
      model.addAttribute("checked", "checked");
    }
    return "/controller31/form.jsp";
  }
  
  @RequestMapping(value="/login", method=RequestMethod.POST)
  public String login(
      String id,
      String password,
      String idsave,
      HttpServletResponse response,
      Model model) {
    if (idsave != null) {
      Cookie cookie = new Cookie("id", id);
      cookie.setMaxAge(3600);
      response.addCookie(cookie);
    } else {
      Cookie cookie = new Cookie("id", "");
      cookie.setMaxAge(0);
      response.addCookie(cookie);
    }
    
    if (id.equals("admin") && password.equals("1111")) { // 로그인 성공!
      // 로그인 사용자 정보 준비
      Member member = new Member();
      member.setId(id);
      member.setPassword(password);
      member.setName("홍길동");
      
      // 모델에 담는다. 
      // => @SessionAttributes()에 지정된 이름이기 때문에 세션에 저장한다.
      model.addAttribute("userInfo", member);
      
      return "redirect:../controller32/page4.do";
    } else { // 로그인 실패!
      return "redirect:login.do";
    }
  }
}

/*
# 쿠키 값 받기/보내기
*/
















