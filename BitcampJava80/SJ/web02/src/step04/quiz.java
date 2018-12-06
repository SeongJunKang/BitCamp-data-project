//GET 요청과 POST 요청의 차이점
package step04;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

@WebServlet("/step04/quiz")
public class quiz extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest httpreq, HttpServletResponse httpres)
throws ServletException, IOException {
    httpres.setContentType("text/plain;charset=UTF-8");
    httpreq.setCharacterEncoding("UTF-8");
    PrintWriter out = httpres.getWriter();
    out.println("quiz");
    String folderPath = "C:\\Users\\bit\\workspace\\.metadata\\.plugins"
        + "\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\web02\\files";
    MultipartRequest mRequest = new MultipartRequest(httpreq, folderPath, "UTF-8");

    String key, value;
    Enumeration<?> enumer = mRequest.getParameterNames();
    while (enumer.hasMoreElements()) {
      key = (String)enumer.nextElement();
      value = mRequest.getParameter(key);
      out.println(key + " : " + value);
    }
    File file;
    enumer = mRequest.getFileNames();
    while (enumer.hasMoreElements()) {
      key = (String)enumer.nextElement();
      file = mRequest.getFile(key);
      out.println(key + " : " + file.getName());
      out.println("파일 크기 : " + file.length()+" byte");
    }

    // name ,email ,tel 값을 화면에 출력
    // 사진 파일은 배치 폴더의 files/ 디렉토리에 둔다.
    // 
  }
}
