package bitcamp.pms.servlet;

import java.io.IOException;

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

@WebServlet("/member/add.do")
public class MemberAddServlet extends HttpServlet {
  
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html;charset=UTF-8");
    RequestDispatcher rd = req.getRequestDispatcher("/member/MemberAdd.jsp");
    rd.include(req, resp);
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    ServletContext servletContext = this.getServletContext();
    
    ApplicationContext iocContainer = 
        (ApplicationContext)servletContext.getAttribute("iocContainer");
    MemberDao memberDao = iocContainer.getBean(MemberDao.class);
    
    Member member = new Member();
    member.setName(req.getParameter("name"));
    member.setEmail(req.getParameter("email"));
    member.setPassword(req.getParameter("password"));
    member.setTel(req.getParameter("tel"));
    
    memberDao.insert(member);
    resp.sendRedirect("list.do");
  }
  
}
