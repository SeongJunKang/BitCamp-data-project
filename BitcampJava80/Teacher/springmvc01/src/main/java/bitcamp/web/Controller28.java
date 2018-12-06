package bitcamp.web;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller28")
public class Controller28 {
  @RequestMapping("/page1")
  public String page1() {
    return "/controller28/page1.jsp";
  }
  
  @RequestMapping("/page2")
  public String page2(String name, String age, HttpSession session) {
    session.setAttribute("name", name);
    session.setAttribute("age", age);
    return "/controller28/page2.jsp";
  }
  
  @RequestMapping("/page3")
  public String page3(String tel, String email, HttpSession session) {
    session.setAttribute("tel", tel);
    session.setAttribute("email", email);
    return "/controller28/page3.jsp";
  }
  
  @RequestMapping("/page4")
  public String page4(HttpServletResponse response) {
    return "/controller28/page4.jsp";
  }
}
















