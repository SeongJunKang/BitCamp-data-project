package bitcamp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/controller09")
public class Controller09 {
  
  @RequestMapping
  public String m1(
      @RequestParam("name") String name,
      @RequestParam("tel") String tel,
      @RequestParam("age") int age) {
    
    System.out.println("m1()-----------------------");
    System.out.printf("name=%s\n", name);
    System.out.printf("tel=%s\n", tel);
    System.out.printf("age=%s\n", age);
    
    return "/hello.jsp";
  }
}

/*
# 파라미터 값 받기
- 요청 핸들러의 파라미터를 선언할 때 @RequestParam 애노테이션을 붙인다.
- 문법
  @RequestParam("파라미터명") String 변수명
- 스프링의 프론트 컨트롤러는 기본으로 문자열을 원시 타입
  (byte,short,int,long,float,double,boolean,char)으로 자동변환해 준다.
- 실행 예)  
1) http://localhost:8080/springmvc01/controller09.do?name=aaa&tel=1111&age=20
   => OK
2) http://localhost:8080/springmvc01/controller09.do?tel=1111&age=20
   => 모든 파라미터는 기본으로 필수 항목이다. 없으면 오류 발생!
3) http://localhost:8080/springmvc01/controller09.do?tel=1111&age=$20&name=%ED%99%8D%EA%B8%B8%EB%8F%99
   => age=$20의 경우처럼 String을 파라미터 변수 타입으로 형변환할 수 없을 때
      오류 발생!      
   => 자동 변환할 수 없다면 오류가 발생한다.   
*/
















