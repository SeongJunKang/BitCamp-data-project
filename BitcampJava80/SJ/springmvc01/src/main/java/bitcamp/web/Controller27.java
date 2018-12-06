//쿠키 사용하기 - 마지막 방문일 확인하기.
package bitcamp.web;

import java.text.SimpleDateFormat;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller27")
public class Controller27 {
  
  @RequestMapping()
  public String m1(HttpServletResponse response) {
    response.setContentType("text/plain;charset=UTF-8");
      Cookie cookie = new Cookie(
          "lastVisited",
          new SimpleDateFormat("yy-MM-dd hh:mm:ss").format(new java.util.Date()));
      cookie.setMaxAge(3600 * 24 * 5);
      response.addCookie(cookie);
    return "/Controller27.jsp";
  }
}
