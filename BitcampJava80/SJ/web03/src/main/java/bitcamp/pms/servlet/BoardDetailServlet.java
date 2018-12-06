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

@WebServlet("/board/detail.do")
public class BoardDetailServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    ServletContext servletContext = this.getServletContext();
    ApplicationContext iocContainer =
        (ApplicationContext) servletContext.getAttribute("iocContainer");
    BoardDao boardDao = iocContainer.getBean(BoardDao.class);
    int no = Integer.parseInt(req.getParameter("no"));
    Board board = boardDao.selectOne(no);
    board.setViews(board.getViews()+1);
    boardDao.update(board);
    resp.setContentType("text/html;charset=UTF-8");
    RequestDispatcher rd = req.getRequestDispatcher("/board/BoardDetail.jsp");
    req.setAttribute("boardSelectOne", board);
    rd.include(req, resp);
  }
}
