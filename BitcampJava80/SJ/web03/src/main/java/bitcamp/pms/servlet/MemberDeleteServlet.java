package bitcamp.pms.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.pms.dao.MemberDao;

@WebServlet("/member/delete.do")
public class MemberDeleteServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ServletContext servletContext = this.getServletContext();

    ApplicationContext iocContainer = (ApplicationContext) servletContext.getAttribute("iocContainer");
    MemberDao memberDao = iocContainer.getBean(MemberDao.class);
//    HashMap<String, Object> paramMap = new HashMap<>();
//    paramMap.put("no", Integer.parseInt(req.getParameter("no")));
//    Member member = memberDao.selectOne(paramMap);
//    if (member.getPassword().equals(req.getParameter("password"))) {
      memberDao.delete(Integer.parseInt(req.getParameter("no")));
      resp.sendRedirect("list.do");
//    } else {
//      resp.setContentType("text/html;charset=UTF-8");
//      PrintWriter out = resp.getWriter();
//      out.println("<html>");
//      out.println("<head>");
//      out.println("<title>회원</title>");
//      out.println("</head>");
//      out.println("<body>");
//      out.println(member.getPassword());
//      out.println(req.getParameter("password"));
//      out.println("<h1>회원 - 삭제 실패</h1>");
//      out.println("<p>회원님의 비밀번호가 다릅니다.</p>");
//      out.println("<p>한영키, 대소문자를 구분하십시오.</p>");
//      out.println("<a href='list.do'>목록</a><a href='detail.do?no="+paramMap.get("no")+">뒤로</a>");
//      out.println("</body>");
//      out.println("</html>");
//    }
  }

}
