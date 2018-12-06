package bitcamp.pms.controller;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.TeachsDao;
import bitcamp.pms.domain.Teachs;

@Controller
@RequestMapping("teachs/")
public class TeachsController {
  @Autowired
  private TeachsDao teachsDao;
//teachs/add.do?tnm=김선생&tel=111-1111&email=kim@test.com
  @RequestMapping("add.do")
    public void add(Map<String, String> paramMap, PrintStream out) {
      Teachs teachs = new Teachs();
    teachs.setTnm(paramMap.get("tnm"));
    teachs.setTel(paramMap.get("tel"));
    teachs.setEmail(paramMap.get("email"));
    teachs.setPhot(paramMap.get("phot"));
    try {
      teachsDao.insert(teachs);
      out.println("저장하였습니다.");
    } catch (Exception e) {
      out.println("데이터를 저장하는데 실패했습니다.");
    }
  }

  @RequestMapping("delete.do")
  public void delete(Map<String, String> paramMap, PrintStream out) {
    try {
      int count = teachsDao.delete(Integer.parseInt(paramMap.get("tno")));
      if (count > 0) {
        out.println("삭제하였습니다.");
      } else {
        out.println("유효하지 않은 번호이거나, 이미 삭제된 항목입니다.");
      }
    } catch (Exception e) {
      out.println("데이터 처리에 실패했습니다.");
    }
  }

  @RequestMapping("list.do")
  public void list(PrintStream out) {
    try {
      List<Teachs> teachs = teachsDao.selectList();
      out.println("강사 목록");
      for (Teachs teach : teachs) {
        out.printf("%d, %s, %s, %s\n", teach.getTno(), teach.getTnm(), teach.getTel(), teach.getEmail());
      }
    } catch (Exception e) {
      throw new RuntimeException("회원 데이터 로딩 실패!", e);
    }
  }

  @RequestMapping("update.do")
  public void update(Map<String, String> paramMap, PrintStream out) {
    try {
      int tno = Integer.parseInt(paramMap.get("tno"));

      Teachs teachs = teachsDao.selectOne(tno);
      if (teachs == null) {
        out.println("유효하지 않은 번호입니다.");
        return;
      }
      teachs.setTno(tno);
      teachs.setTnm(paramMap.get("rnm"));
      teachs.setTel(paramMap.get("tel"));
      teachs.setEmail(paramMap.get("email"));
      teachs.setPhot(paramMap.get("phot"));
      int count = teachsDao.update(teachs);
      if (count > 0) {
        out.println("변경하였습니다.");
      } else {
        out.println("유효하지 않은 번호이거나, 이미 삭제된 항목입니다.");
      }
    } catch (Exception e) {
      out.println("데이터 처리에 실패했습니다.");
    }
  }
}
