package bitcamp.pms.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.vo.Board;

@WebServlet("/board/update.do")
public class BoardUpdateServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ServletContext servletContext = this.getServletContext();
    ApplicationContext iocContainer = (ApplicationContext) servletContext.getAttribute("iocContainer");
    BoardDao boardDao = iocContainer.getBean(BoardDao.class);
    int no = Integer.parseInt(req.getParameter("no"));
    Board board = boardDao.selectOne(no);
    board.setTitle(req.getParameter("title"));
    board.setContent(req.getParameter("content"));
    boardDao.update(board);
    resp.sendRedirect("list.do");
  }

}
