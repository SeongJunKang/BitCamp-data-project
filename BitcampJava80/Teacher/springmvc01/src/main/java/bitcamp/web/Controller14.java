package bitcamp.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller14")
public class Controller14 {
  
  @RequestMapping
  public String m1(HttpServletRequest request, HttpServletResponse response) {
    
    System.out.println("m1()-----------------------");
    System.out.printf("no=%s\n", request.getParameter("no"));
    System.out.printf("title=%s\n", request.getParameter("title"));
    
    return "/hello.jsp";
  }
}

/*
# HttpServletRequest, HttpServletResponse 객체를 파라미터로 받을 수 있다.
*/
















