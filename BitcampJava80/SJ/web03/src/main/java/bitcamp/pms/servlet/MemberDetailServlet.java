package bitcamp.pms.servlet;

import java.io.IOException;
import java.util.HashMap;

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

@WebServlet("/member/detail.do")
public class MemberDetailServlet extends HttpServlet {
  
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    
    resp.setContentType("text/html;charset=UTF-8");
    ServletContext servletContext = this.getServletContext();
    ApplicationContext iocContainer = 
        (ApplicationContext)servletContext.getAttribute("iocContainer");
    MemberDao memberDao =iocContainer.getBean(MemberDao.class);
    HashMap<String,Object> paramMap = new HashMap<>(); 
    paramMap.put("no", Integer.parseInt(req.getParameter("no")));
    Member member = memberDao.selectOne(paramMap);
    RequestDispatcher rd = req.getRequestDispatcher("/member/MemberDetail.jsp");
    req.setAttribute("memberSelectOne", member);
    rd.include(req, resp);
  }
}
