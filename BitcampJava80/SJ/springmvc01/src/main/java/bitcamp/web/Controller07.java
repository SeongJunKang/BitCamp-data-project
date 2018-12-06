// @RequestMapping 사용법 - 파라미터 이름으로 요청 구분하기
package bitcamp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller07")
public class Controller07 {

  @RequestMapping(params="name")
  public String hello() {
    System.out.println("hello1");
    return "/hello.jsp";
  }

  @RequestMapping(params={"age"})
  public String hello2() {
    System.out.println("hello2");
    return "/hello.jsp";
  }
  
  @RequestMapping(params={"tel","email"})
  public String hello3() {
    System.out.println("hello3");
    return "/hello.jsp";
  }

}

/*
# 파라미터 이름으로 요청을 구분하기
- params 프로퍼티에 파라미터 이름을 지정한다.

  
 */
