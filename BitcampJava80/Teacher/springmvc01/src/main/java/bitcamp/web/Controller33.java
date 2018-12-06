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







