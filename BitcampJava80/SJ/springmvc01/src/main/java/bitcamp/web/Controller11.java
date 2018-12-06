//요청 핸들러 파라미터 - @RequestParam 애노테이션의 value 속성 생략
package bitcamp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/controller11")
public class Controller11 {

  @RequestMapping
  public String m1(
      @RequestParam String name,
      @RequestParam String tel,
      @RequestParam int age) {
    System.out.println("m1()-----------------------------");
    System.out.printf("name = %s \n tel = %s \n age = %d \n",name,tel,age);
    return "/hello.jsp";
  }
}

/*
# @RequestParam에서 파라미터명 생략
- value 속성을 생략하면, 변수명을 이용하여 파라미터 값을 꺼낸다.

 */
