package bitcamp.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.pms.dao.ProjectDao;
import bitcamp.pms.vo.Project;

@WebServlet("/project/list")
public class ProjectListServlet extends HttpServlet {
  
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    ServletContext servletContext = this.getServletContext();
    ApplicationContext iocContainer = 
        (ApplicationContext)servletContext.getAttribute("iocContainer");
    ProjectDao projectDao = iocContainer.getBean(ProjectDao.class);
    
    // 3) ProjectDao 객체
    List<Project> list = projectDao.selectList();
    
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>프로젝트</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>프로젝트 - 목록</h1>");
    out.println("<p><a href='add.do'>새 프로젝트</a></p>");
    out.println("<table border='1'>");
    out.println("<thead>");
    out.println("<tr>");
    out.println("<th>번호</th>");
    out.println("<th>제목</th>");
    out.println("<th>시작일</th>");
    out.println("<th>종료일</th>");
    out.println("<th>기수</th>");
    out.println("<th>상태</th>");
    out.println("</tr>");
    out.println("</thead>");
    out.println("<tbody>");
    for (Project project : list) {
      out.printf("<tr><td>%d</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>\n",
          project.getNo(),
          project.getTitle(),
          project.getStartDate() == null ? "" : project.getStartDate(),
          project.getEndDate() == null ? "" : project.getEndDate(),
          project.getDescription(),
          project.getState());
    }
    out.println("</tbody>");
    out.println("</table>");
    out.println("</body>");
    out.println("</html>");
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    super.doPost(req, resp);
  }

}
