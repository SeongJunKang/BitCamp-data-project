package bitcamp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller12")
public class Controller12 {
  
  @RequestMapping
  public String m1(
      String name,
      String tel,
      int age) {
    
    System.out.println("m1()-----------------------");
    System.out.printf("name=%s\n", name);
    System.out.printf("tel=%s\n", tel);
    System.out.printf("age=%s\n", age);
    
    return "/hello.jsp";
  }
}

/*
# @RequestParam 애노테이션을 생략
- 변수 이름으로 요청 파라미터 값을 꺼낸다.
- @RequestParam(value="변수명", required=false)와 같다.
  물론 int age의 경우 요청 파라미터가 없다면 null을 숫자로 바꿀 수 없기 때문에
  오류가 발생할 것이다. 
*/
















