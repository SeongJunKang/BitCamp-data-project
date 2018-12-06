/* 주제: 중복 이름의 파라미터 값 다루기 */
package step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step03/servlet06")
public class Servlet06 extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      ServletRequest request, ServletResponse response) 
      throws ServletException, IOException {
    
    // 파라미터 값 알아내기
    // => .../step03/servlet06?name=aaa&name=bbb&name=ccc
    //String name = request.getParameter("name"); // 첫 번째 파라미터 값만 꺼낸다.
    String[] names = request.getParameterValues("name");
    
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    //out.printf("이름:%s\n", name);
    for (String name : names) {
      out.printf("이름:%s\n", name);
    }
  }
}

/*
# 
 */

















