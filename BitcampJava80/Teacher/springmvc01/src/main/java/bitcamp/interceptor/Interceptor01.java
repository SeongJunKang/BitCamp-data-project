package bitcamp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor01 implements HandlerInterceptor {

  @Override
  public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
      throws Exception {
    System.out.println("afterCompletion()");
  }

  @Override
  public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
      throws Exception {
    System.out.println("postHandle()");
    
  }

  @Override
  public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
    System.out.println("preHandle()");
    return true;
  }

}

/*
# 스프링 인터셉터
- 프론트 컨트롤러와 페이지 컨트롤러 사이에 끼워 넣는 객체이다.
- 요청 처리 앞, 뒤로 작업을 추가할 때 사용한다. 
- 작성 방법
  1) HandlerInterceptor 인터페이스를 구현해야 한다.
  2) 스프링 설정 파일에 인터셉터를 등록해야 한다.
  <mvc:interceptors>
      <mvc:interceptor>
          <mvc:mapping path="/controller33*"/>
          <bean class="bitcamp.interceptor.Interceptor01"/>
      </mvc:interceptor>
    </mvc:interceptors>
- 메서드 호출 순서
  preHandle()       => 페이지 컨트롤러의 메서드 호출 전
  postHandle()      => 페이지 컨트롤러의 메서드 호출 후
  afterCompletion() => 뷰 컴포넌트 실행 후
*/









