package bitcamp.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/controller29")
// 세션에서 관리할 값에 대해 이름을 지정한다.
// => 값 중에서 name, age, tel, email 이름을 갖는 값을 세션에 따로 보관하라는 명령!
@SessionAttributes({"name","age","tel","email"})
public class Controller29 {
  @RequestMapping("/page1")
  public String page1(HttpSession session) {
    // 세션 객체에 직접 값을 저장한다.
    session.setAttribute("fax", "1234-5678");
    return "/controller28/page1.jsp";
  }
  
  @RequestMapping("/page2")
  public String page2(String name, String age, Model model) {
    model.addAttribute("name", name);
    model.addAttribute("age", age);
    return "/controller28/page2.jsp";
  }
  
  @RequestMapping("/page3")
  public String page3(String tel, String email, Model model) {
    model.addAttribute("tel", tel);
    model.addAttribute("email", email);
    return "/controller28/page3.jsp";
  }
  
  @RequestMapping("/page4")
  public String page4(
      @ModelAttribute("name") String name, 
      @ModelAttribute("age") String age, 
      @ModelAttribute("tel") String tel, 
      @ModelAttribute("email") String email,
      SessionStatus sessionStatus) {
    // DBMS에 저장하기 
    // 1) 세션에서 값을 꺼낸다.
    System.out.println(name);
    System.out.println(age);
    System.out.println(tel);
    System.out.println(email);
    
    // 2) DBMS에 저장한다.
    // => 저장했다고 가정하고!
    
    // 3) 이 페이지 컨트롤러에서 관리하는 세션의 값만 무효화시키기
    // => @SessionAttributes에 선언된 이름의 값만 무효화시킨다.
    // => 즉 name, age, tel, email만 무효화시킨다.
    // => 다른 페이지 컨트롤러나 세션에 직접 저장한 값은 무효화시키지 않는다.
    //    따라서 세션에 직접 저장한 "fax"는 무료화되지 않는다.
    sessionStatus.setComplete();
    
    // => 만약 세션 전체를 무효화시키고 싶다면 다음과 같이 원래의 방법을 사용하라!
    //    session.invalidate()
    
    return "/controller28/page4.jsp";
  }
}

/*
# @SessionAttributes({"이름","이름",...})
- Model 객체에 담은 값 중에서 세션에 보관해야 할 값의 이름을 지정한다.
- 프론트 컨트롤러(DispatcherServlet)는 메서드를 호출한 후, 
  보통 Model 객체에 들어 있는 값을 ServletRequest 보관소에 옮겨 싣는다.
  그래야만 JSP가 사용할 수 있기 때문이다.
- 이 애노테이션에 지정된 이름을 갖는 값에 대해서는
  HttpSession 보관소에도 저장한다.  
  
# @ModelAttribute("이름")
- 요청 핸들러의 파라미터 변수 앞에 선언한다.
- 이 변수에 저장할 값은 클라이언트가 보낸 값이 아니라 
  세션에 보관된 값임을 지정한다.
- 세션에 보관된 값을 꺼낼 때 마다 다음과 같이 메서드를 호출하는 것은 번거롭다. 
  session.getAttribute("이름")
 */














