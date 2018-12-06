// 요청 핸들러에서 뷰 url 리턴하기
package bitcamp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller04")
public class Controller04 {

  @RequestMapping("hello")
  public String Hello() {
    return "/hello.jsp";
  }

  @RequestMapping("hello2")
  public String Hello2() {
    return "/hello2.jsp";
  }

}

/*
# @RequestMapping 
- 클래스에도 RequestMapping이 있다면, 
메서드의 URL과 합쳐서 요청 URL로 지정한다.
 */
