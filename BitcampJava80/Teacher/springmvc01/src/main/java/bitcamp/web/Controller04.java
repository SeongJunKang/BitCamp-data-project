package bitcamp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller04/")
public class Controller04 {
  
  @RequestMapping("hello")
  public String hello() {
    return "/hello.jsp";
  }
  
  @RequestMapping("hello2")
  public String hello2() {
    return "/hello2.jsp";
  }
}

/*
# 요청 핸들러의 리턴 값
- 리턴 타입이 String인 경우,
  리턴 값은 뷰 컴포넌트의 URL이다.
*/
















