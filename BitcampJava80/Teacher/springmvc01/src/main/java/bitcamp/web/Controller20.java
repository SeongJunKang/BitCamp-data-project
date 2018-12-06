package bitcamp.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller20")
public class Controller20 {
  @RequestMapping
  public String m1(HttpServletRequest request) {
    
    request.setAttribute("name", "홍길동");
    
    return "/Controller20.jsp";
  }
}

/*
# 뷰 컴포넌트(JSP)에게 값 전달하기
- ServletRequest 객체에 담는다.
*/
















