package bitcamp.pms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.vo.Member;

@WebServlet("/member/list.do")
public class MemberListServlet extends HttpServlet {
  
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    ServletContext servletContext = this.getServletContext();
    
    ApplicationContext iocContainer = 
        (ApplicationContext)servletContext.getAttribute("iocContainer");
    
    MemberDao memberDao = iocContainer.getBean(MemberDao.class);
    
    List<Member> list = memberDao.selectList();
    
    resp.setContentType("text/html;charset=UTF-8");
    
    RequestDispatcher rd = req.getRequestDispatcher("/member/MemberList.jsp");
    req.setAttribute("memberlist", list);
    rd.include(req, resp);

  }

}
