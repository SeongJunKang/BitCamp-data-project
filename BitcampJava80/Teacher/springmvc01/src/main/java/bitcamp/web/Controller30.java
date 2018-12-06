package bitcamp.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/controller30")
public class Controller30 {
  @RequestMapping(value="/logout", produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String page1(HttpSession session) {
    session.invalidate();
    return "로그아웃";
  }
  
}
















