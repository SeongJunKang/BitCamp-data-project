//페이지 컨트롤러 클래스의 기본 구조
package bitcamp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller01")
public class Controller01 {

  @RequestMapping
  public void Hello() {}

}

/*  
 # 페이지 컨트롤러 만들기
 1) 스프링 IoC 컨테이너에서 관리할 수 있도록 @Controller 애노테이션을 붙인다.
 2) @RequestMapping("url")을 사용하여 어떤 요청을 처리할 지 지정해야 한다.
 3) 요청이 들어 왔을 때 호출될 메서드 앞에 @RequestMapping을 선언해야 한다.
 
 # 스프링 빈에 붙이는 애노테이션
 1) @Component : IoC 컨테이너에서 관리할 클래스에 대해 붙인다.
 2) @Controller : 페이지 컨트롤러 임을 특별히 표현할 때 붙인다.
 3) @Service : 비즈니스 로직을 수행하는 객체에 붙인다.
 4) @Repository : DAO 와 같은 데이터 처리하는 객체에 붙인다.
    => Component를 붙여도 되지만 클래스의 역할에 따라 다른 애노테이션을 붙임으로써
    클래스를 유지보수하는데 더 도움이 된다.
  
 # 요청 핸들러
 - 요청이 들어왔을 떄 호출되는 메서드
 - 리턴 값은 뷰 컴포넌트 URL이다.
 - 만약 리턴 타입이 void이면 url을 기준으로 파일을 자동으로 찾는다.
 */
