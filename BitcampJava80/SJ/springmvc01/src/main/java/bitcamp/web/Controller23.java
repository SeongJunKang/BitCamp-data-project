//뷰 컴포넌트 값 전달 - ModelAndView 객체 사용
package bitcamp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/controller23")
public class Controller23 {
  
  @RequestMapping
  public ModelAndView m1() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("name", "홍길동");
    mv.setViewName("/Controller20.jsp");
    return mv;
  }
  
}

/*
# 뷰 컴포넌트(JSP)에게 값 전달하기 
- 데이터와 뷰 URL을 묶어서 리턴할 수 있다. 
 */
