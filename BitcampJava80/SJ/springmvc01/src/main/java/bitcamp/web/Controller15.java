//요청 핸들러 파라미터 - ServletContext 받기(불가!)
package bitcamp.web;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller15")
public class Controller15 {
  
  @Autowired
  ServletContext application;
  
  @RequestMapping
  public String m1(/*ServletContext application*/) {
    System.out.println("m1()-----------------------------");
    System.out.println(application.getRealPath("/"));
    System.out.println(application.getRealPath("."));
    return "/hello.jsp";
  }
}

/*
# ServletContext는 파라미터로 받을 수 없다.
- 의존 객체로 주입 받을 수는 있다.
 */
