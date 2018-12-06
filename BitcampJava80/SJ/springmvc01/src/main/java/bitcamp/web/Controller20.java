//뷰 컴포넌트 값 전달 - ServletRequest 보관소에 직접 담기
package bitcamp.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller20")
public class Controller20 {
  
  @RequestMapping
  public String m1(HttpServletRequest request) {
    request.setAttribute("name", "홍길동");
    return "/Controller20.jsp";
  }
  
}

/*
# 뷰 컴포넌트(JSP)에게 값 전달하기 
- 프론트 컨트롤러에게 값을 담을 바구니를 요청하라.
 */
