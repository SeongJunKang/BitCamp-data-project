package bitcamp.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.pms.dao.ProjectDao;
import bitcamp.pms.vo.Project;

@WebServlet("/project/add")
public class ProjectAddServlet extends HttpServlet {
  
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>프로젝트</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>프로젝트 - 새 프로젝트</h1>");
    out.println("<form action='add.do' method='post'>");
    out.println("<p>* 항목은 필수 항목입니다.</p>");
    out.println("*제목 : <input type='text' name='title'><br>");
    out.println("*시작날짜 : <input type='date' name='startdate'><br>");
    out.println("*종료날짜 : <input type='date' name='enddate'><br>");
    out.println("기수 : <input type='text' name='description' placeholder='ex) 자바 80기'><br>");
    out.println("상태 : <input type='number' name='state' placeholder='숫자만 입력'><br>");
    out.println("<button>프로젝트 등록</button>");
    out.println("<button type='reset'>초기화</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    ServletContext servletContext = this.getServletContext();
    
    ApplicationContext iocContainer = 
        (ApplicationContext)servletContext.getAttribute("iocContainer");
    ProjectDao projectDao = iocContainer.getBean(ProjectDao.class);
    
    Project project = new Project();
    project.setTitle(req.getParameter("title"));
    project.setStartDate(Date.valueOf(req.getParameter("startdate")));
    project.setEndDate(Date.valueOf(req.getParameter("enddate")));
    project.setDescription(req.getParameter("description"));
    project.setState(Integer.parseInt(req.getParameter("state")));
    
    projectDao.insert(project);
    
    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>프로젝트</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>프로젝트 - 등록 결과</h1>");
    out.println("<p>프로젝트 등록 성공입니다.</p>");
    out.println("<a href='list.do'>프로젝트 목록</a>");
    out.println("</body>");
    out.println("</html>");
  }
  
}
