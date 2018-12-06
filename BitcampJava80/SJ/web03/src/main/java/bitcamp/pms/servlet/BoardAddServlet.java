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

import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.vo.Board;

@WebServlet("/board/add.do")
public class BoardAddServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // 포워드 할 것이라면 setContentType이 필요 없지만
    // include 할것이기 때문에 필요하다.
    resp.setContentType("text/html;charset=UTF-8");
    
//    뭔가 작업을 추가하기 위해서 포워드 하지않고 보통 인클루드를 사용한다.
    RequestDispatcher rd = req.getRequestDispatcher("/board/BoardAdd.jsp");
    rd.include(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ServletContext servletContext = this.getServletContext();

    ApplicationContext iocContainer = (ApplicationContext) servletContext.getAttribute("iocContainer");
    BoardDao boardDao = iocContainer.getBean(BoardDao.class);
    Board board = new Board();
    board.setTitle(req.getParameter("title"));
    board.setContent(req.getParameter("content"));
    board.setPassword(req.getParameter("password"));
    boardDao.insert(board);
    resp.sendRedirect("list.do");
  }

}
