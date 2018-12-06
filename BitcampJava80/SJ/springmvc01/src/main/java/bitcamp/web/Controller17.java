//요청 핸들러 파라미터 - String을 다른 타입으로 변환하기2
package bitcamp.web;

import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller17")
public class Controller17 {
  
  @RequestMapping
  public String m1(java.util.Date createdDate) {
    System.out.println("m1()-----------------------------");
    System.out.println("createdDate = " + createdDate);
    return "/hello.jsp";
  }
  
  
  // 3.0v 이상은 DateTimeFormat을 사용하면 되지만 2.5v 이상는 아래 기술을 사용
  // 다음 메서드가 자동으로 호출되게 하려면 이 애노테이션을 붙여야 한다.
  // => 다만 이 메서드는 현재 컨트롤러에만 적용된다.
  // => 전체 페이지 컨트롤러에 적용하는 방법 ?
  //    클로벌 InitBinder를 생성하라.
  // => 스프링 Web MVC 2.5 부터 사용가능.
  @InitBinder 
  protected void initBinder(WebDataBinder binder) {
    System.out.println("initBinder()");
    // 1) 문자열을 java.util.Date 객체로 바꿔줄 변환기 준비
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      dateFormat.setLenient(false); //패턴에 일치하는지 여부를 엄격히 검사할것인지 지정.
    // 2) 스프링에 등록할 커스텀 에디터 준비
    // => SimpleDateFormat 객체를 바로 스프링에 등록 할 수 없다.
    // => 스프링에서 정한 규격(PropertyEditer 인터페이스)에 맞추어 클래스를 등록해야 한다.
    // => 그런데 스프링에서는 PropertyEditer 구현체를 만들기 쉽도록
    //    구현체를 제공하고 있다.
    // => CustomDateEditor 클래스도 그 중 하나이다.
    //    특히 문자열을 java.util.Date 객체로 바꿔주는 에디터를 등록할 때 유용하다.
      CustomDateEditor cde = new CustomDateEditor(dateFormat, false);
    // 3) 커스텀 에디터를 스프링에 등록.
    // =>커스텀 에디터란?
    //   입력 파라미터로 넘어온 문자열을 다른 타입의 값으로 바꿔주는 객체를 말한다. 
       
      binder.registerCustomEditor(java.util.Date.class, cde);
  }
}

/*
# String --> java.util.Date 
- 문자열로 된 요청 파라미터 값을 원시 타입이 아닌
  다른 타입의 값으로 변환하려면 별도의 변환기를 장착해야한다.
- WebDataBinder를 이용하여 문자열을 다른 타입으로 변환할 수 있다.
 */
