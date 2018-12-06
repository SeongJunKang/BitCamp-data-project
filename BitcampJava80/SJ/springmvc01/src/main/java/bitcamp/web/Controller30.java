//쿠키 사용하기 - 마지막 방문일 확인하기.
package bitcamp.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/controller30")
// 세션에서 관리할 값에 대해 이름을 지정한다.
// => 값 중에서 name, age, tel, email 이름을 갖는 값을 세션에서 따로 보관하라는 명령
@SessionAttributes({"name","age","tel","email"})
public class Controller30 {
  
  @RequestMapping(value="/logout",produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String page1(HttpSession session) {
    session.invalidate();
    return "로그아웃";
  }
}
