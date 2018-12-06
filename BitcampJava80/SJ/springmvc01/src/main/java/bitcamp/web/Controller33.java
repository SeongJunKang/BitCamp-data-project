//쿠키 사용하기 - 로그인 폼에서 아이디 저장하기.
package bitcamp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller33")
public class Controller33 {
  
  @RequestMapping
  public String page() {
    System.out.println("Controller33.page()");
    return "/Controller33.jsp";
  }
}

/*
# 
- 
 */
