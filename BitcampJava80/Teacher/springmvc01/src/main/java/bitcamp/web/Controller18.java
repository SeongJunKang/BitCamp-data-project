package bitcamp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller18")
public class Controller18 {
  @RequestMapping
  public String m1(java.util.Date createdDate) {
    
    System.out.println("m1()-----------------------");
    System.out.printf("createdDate=%s\n", createdDate.toString());
    
    return "/hello.jsp";
  }
}

/*
# String --> java.util.Date
- GlobalInitBinder 객체로 처리한다. 
- v3.2에서 추가된 방법.  
*/
















