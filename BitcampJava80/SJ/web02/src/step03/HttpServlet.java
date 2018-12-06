package step03;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class HttpServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;
  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    HttpServletRequest httpreq = (HttpServletRequest) req;
    HttpServletResponse httpres = (HttpServletResponse) res;
    this.service(httpreq, httpres);
  }
  public abstract void service(
      HttpServletRequest httpreq, HttpServletResponse httpres)
      throws ServletException, IOException;
    
}
