package bitcamp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller02 {
  
  @RequestMapping("/controller02/hello")
  public void hello() {}
  
  @RequestMapping("/controller02/hello2")
  public void hello2() {}
}

/*
# @RequestMapping
- 클래스에 붙이지 않고 메서드에만 붙일 수 있다.
*/
















