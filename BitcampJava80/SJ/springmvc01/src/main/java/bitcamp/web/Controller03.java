//@RequestMapping 사용법 - 클래스와 메서드에 모두 붙이기
package bitcamp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller03/")
public class Controller03 {

  @RequestMapping("hello")
  public void Hello() {
    System.out.println("03/01");
  }

  @RequestMapping("hello2")
  public void Hello2() {
    System.out.println("03/02");
  }

}

/*
# 요청 핸들러의 리턴 값
- 리턴 타입이 String인 경우,
  리턴 값은 뷰 컴포넌트의 URL 이다.
 */
