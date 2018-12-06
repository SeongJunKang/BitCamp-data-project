package bitcamp.web;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller16")
public class Controller16 {
  @RequestMapping
  public String m1(
      @DateTimeFormat(pattern="yyyy-MM-dd") java.util.Date createdDate) {
    
    System.out.println("m1()-----------------------");
    System.out.printf("createdDate=%s\n", createdDate.toString());
    
    return "/hello.jsp";
  }
}

/*
# String을 다른 타입의 값으로 변환하기 
- 문자열로 된 요청 파라미터 값을 원시 타입이 아닌 
  다른 타입의 값으로 변환하려면 별도의 변환기를 장착해야 한다.

# String --> java.util.Date
- @DateTimeFormat 애노테이션을 사용하라!
- 단 이 애노테이션을 처리할 객체를 스프링 설정 파일에 등록해야 한다.
  방법?
  스프링 설정 파일에 다음의 설정을 추가하라!
  <mvc:annotation-driven/>
- 스프링 3.0 버전부터 사용할 수 있다.
  
*/
















