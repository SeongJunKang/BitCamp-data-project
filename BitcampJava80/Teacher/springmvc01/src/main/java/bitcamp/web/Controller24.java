package bitcamp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/controller24")
public class Controller24 {
  @RequestMapping(produces="text/html;charset=UTF-8")
  @ResponseBody
  public String m1() {
    return "hello안녕";
  }
}

/*
# 요청 핸들러에서 직접 콘텐츠를 클라이언트로 출력하기
- 리턴 타입이 String이다.
- 메서드 선언부에 @ResponseBody를 붙여 리턴하는 문자열이
  뷰 URL이 아니라 콘텐츠임을 알려야한다.
- 응답하는 콘텐츠의 기본 Content-Type은 다음과 같다.
  Content-Type:text/html;charset=ISO-8859-1
  => 따라서 한글은 ?로 변환될 것이다.
- 해결책?
  @RequestMapping의 produces 속성을 이용하여 콘텐츠 타입을 지정하라!
*/
















