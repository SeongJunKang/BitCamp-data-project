//요청 핸들러 파라미터 - @RequestParam 애노테이션
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
    System.out.println("m1()-----------------------------");
    System.out.printf("name = %s \n tel = %s \n age = %d \n",name,tel,age);
    return "/hello.jsp";
  }
}

/*
# 파라미터 값 받기
- 요청 핸들러의 파라미터를 선언할 때 @RequestParam 애노테이션을 붙인다.
- 문법
  @RequestParam("파라미터명) String 변수명
- 스프링의 프론트 컨트롤러는 기본으로 문자열을 
  원시 타입(byte,short,int,long,float,double,boolean,char)으로 자동으로 변환해준다.
- 자동 변환할 수 없다면, 오류가 발생한다.
- 실행 예)
1) http://localhost:8080/springmvc01/controller09.do?name=aaa&tel=1111-1111&age=20
    => OK
2) http://localhost:8080/springmvc01/controller09.do?tel=1111-1111&age=20
    => 모든 파라미터는 기본으로 필수 항목이다. 없으면 오류! (name이 없다.)
3) http://localhost:8080/springmvc01/controller09.do?name=aaa&tel=1111-1111&age=$20
    => The request sent by the client was syntactically incorrect.
    => age=$20 의 경우처럼 String을 파라미터 변수 타입으로 형변환 할 수 없을 때
       실행 오류 발생.
 */
