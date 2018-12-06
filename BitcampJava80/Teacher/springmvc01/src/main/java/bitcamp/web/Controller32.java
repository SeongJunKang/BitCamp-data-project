package bitcamp.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import bitcamp.vo.Member;

@Controller
@RequestMapping("/controller32")
@SessionAttributes("userInfo")
public class Controller32 {
  @RequestMapping(value="/page1", method=RequestMethod.GET)
  public String page1(@ModelAttribute("userInfo") Member member) {
    if (member.getId() == null) { // 세션에 로그인 사용자 정보가 들어있지 않다면,
      return "redirect:../controller31/login.do";
    }
    return "/controller32/page.jsp";
  }
  
  @RequestMapping(value="/page2", method=RequestMethod.GET)
  public String page2(HttpSession session) {
    Member member = (Member)session.getAttribute("userInfo");
    
    if (member == null) { // 세션에 로그인 사용자 정보가 들어있지 않다면,
      return "redirect:../controller31/login.do";
    }
    return "/controller32/page.jsp";
  }
  
  @RequestMapping(value="/page3", method=RequestMethod.GET)
  public String page3(@SessionAttribute(value="userInfo", required=false) Member member) {
    if (member == null) { // 세션에 로그인 사용자 정보가 들어있지 않다면,
      return "redirect:../controller31/login.do";
    }
    return "/controller32/page.jsp";
  }
  
  @RequestMapping(value="/page4", method=RequestMethod.GET)
  public String page4() {
    // 필터 또는 인터셉터에서 로그인 여부를 검사하기 때문에
    // 이 메서드에서 굳이 로그인 여부를 검사할 필요가 없다.
    // 그냥 원래 하고자 하는 일을 수행하면 된다.
    
    return "/controller32/page.jsp";
  }
 
}

/*
# 세션 데이터의 사용
1) page1()
- 만약 해당 이름의 값이 세션에 들어있지 않으면 프론트 컨트롤러(DispatcherServlet)
  쪽에서 예외를 발생시킨다.
- 페이지 컨트롤러 쪽에서 제어할 방법이 없다.
- 비추!

2) page2()
- page1()의 문제를 해결하기 위해 @ModelAttribute 대신 직접 HttpSession 객체를
  사용하여 세션 데이터를 검사한다.
    
3) page3()
- @SessionAttribute 를 사용하여 세션 값을 받기
  이 애노테이션은 required 속성이 있어서 null 값을 허용할 수 있다.
  
4) page4()
- 로그인 여부를 필터 또는 인터셉터에게 맡긴다.
  => 로그인 여부를 검사하는 코드를 중복해서 작성할 필요가 없다.
*/
















