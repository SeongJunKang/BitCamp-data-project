package step04;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// web.xml에 배치 정보를 등록 했기 때문에 다음 애노테이션을 제거하라.
// @WebFilter("/*")
public class CharacterEncodingFilter implements Filter{
  FilterConfig filterConfig;  
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    this.filterConfig = filterConfig;
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
//    web.xml에 선언된 필터 초기화 파라미터 값 꺼내기
    String encoding = filterConfig.getInitParameter("encoding");
//    System.out.println("캐릭터 인코딩 필터 호출 ===> " + encoding);
    request.setCharacterEncoding(encoding);
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {
    
  }

}
