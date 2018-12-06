package bitcamp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/controller10")
public class Controller10 {
  
  @RequestMapping
  public String m1(
      @RequestParam(value="name", required=false) String name,
      @RequestParam(value="tel", required=false) String tel,
      @RequestParam(value="age", required=false, defaultValue="0") int age) {
    
    System.out.println("m1()-----------------------");
    System.out.printf("name=%s\n", name);
    System.out.printf("tel=%s\n", tel);
    System.out.printf("age=%s\n", age);
    
    return "/hello.jsp";
  }
}

/*
# 요청 파라미터의 필수 여부 지정하기
- @RequestParam의 required 속성(기본 값: true)
- 숫자 타입의 경우 null을 숫자로 변환할 수 없기 때문에 오류가 발생한다.
  해결책?
  => defaultValue 속성으로 기본 값을 지정한다.
*/
















