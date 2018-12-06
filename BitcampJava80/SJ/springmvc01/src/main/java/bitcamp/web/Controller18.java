//요청 핸들러 파라미터 - String을 다른 타입으로 변환하기3
package bitcamp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller18")
public class Controller18 {
  
  @RequestMapping
  public String m1(java.util.Date createdDate) {
    System.out.println("createdDate = " + createdDate);
    return "/hello.jsp";
  }
  
}

/*
# String --> java.util.Date 
- GlobalInitBinder 객체로 처리한다.
- 3.2v 에서 추가된 방법
 */
