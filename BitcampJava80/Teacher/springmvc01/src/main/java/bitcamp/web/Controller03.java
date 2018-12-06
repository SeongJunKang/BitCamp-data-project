package bitcamp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller03/")
public class Controller03 {
  
  @RequestMapping("hello")
  public void hello() {System.out.println("/controller03/hello");}
  
  @RequestMapping("hello2")
  public void hello2() {System.out.println("/controller03/hello2");}
}

/*
# @RequestMapping
- 클래스에도 RequestMapping이 있다면, 
  메서드의 URL과 합쳐서 요청 URL로 지정한다.
*/
















