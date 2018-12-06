package bitcamp.pms.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.vo.Member;

@WebServlet("/member/detail")
public class MemberDetailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    ServletContext servletContext = this.getServletContext();
    ApplicationContext iocContainer = 
        (ApplicationContext)servletContext.getAttribute("iocContainer");
    MemberDao memberDao = iocContainer.getBean(MemberDao.class);
    
    Map<String,Object> paramMap = new HashMap<>();
    paramMap.put("no", Integer.parseInt(request.getParameter("no")));
    
    Member member = memberDao.selectOne(paramMap);
    
    response.setContentType("text/html;charset=UTF-8");
    
    request.setAttribute("member", member);
    request.setAttribute("view", "/member/MemberDetail.jsp");
  }
}










