package bitcamp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller22")
public class Controller22 {
  @RequestMapping
  public String m1(Model storage) {
    
    storage.addAttribute("name", "홍길동");
    
    return "/Controller20.jsp";
  }
}

/*
# 뷰 컴포넌트(JSP)에게 값 전달하기
- Model 객체도 바구니 역할을 한다.
- 프론트 컨트롤러에게 뷰 컴포넌트에 전달할 값을 담을 바구니를 달라고 요청한다.
- 바구니에 값을 담으면,
  프론트 컨트롤러는 그 바구니에 담긴 값을 모두 꺼내서 ServletRequest 보관소에
  옮겨 담는다.
- 뷰 컴포넌트(JSP)는 원래 하던 대로 값을 꺼내면 된다. 
*/
















