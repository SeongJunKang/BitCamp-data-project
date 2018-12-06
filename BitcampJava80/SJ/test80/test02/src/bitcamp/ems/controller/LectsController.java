package bitcamp.ems.controller;

import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import bitcamp.ems.annotation.RequestMapping;
import bitcamp.ems.dao.LectsDao;
import bitcamp.ems.domain.Lects;
import bitcamp.ems.util.TableText;

@Controller
@RequestMapping("/lects/")
public class LectsController {
  @Autowired
  private LectsDao lectsDao;
//lects/add.do?title=새거&description=맞아&startdate=2011-05-05&enddate=2012-12-12&deadline=2010-10-10&totalhour=960&dayhour=10
  @RequestMapping("add.do")
  public void add(Map<String, String> paramMap, PrintWriter out) {
    Lects lect = new Lects();
    
    lect.setTitl(paramMap.get("title"));
    lect.setDesct(paramMap.get("description"));
    lect.setSt_dt(Date.valueOf(paramMap.get("startdate")));
    lect.setEn_dt(Date.valueOf(paramMap.get("enddate")));
    lect.setDay_hr(Integer.parseInt(paramMap.get("dayhour")));
    lect.setTot_hr(Integer.parseInt(paramMap.get("totalhour")));
    lect.setFi_dt(Date.valueOf(paramMap.get("deadline")));
    lect.setRno(paramMap.get("rno"));
    
    try {
      lectsDao.insert(lect);
      TableText.show(out, "강의 정보를 저장하였습니다.");
    } catch (Exception e) {
      TableText.show(out, "데이터를 저장하는데 실패했습니다.");
    }
  }
  //lects/regist.do?no=&rno=K001
  @RequestMapping("regist.do")
  public void regist(Map<String, String> paramMap, PrintWriter out) {
    HashMap<String, Object> sqlParamMap = new HashMap<>();
    int no = Integer.parseInt(paramMap.get("no"));
    sqlParamMap.put("lno", no);
    Lects lect = lectsDao.selectOne(sqlParamMap);
    lect.setLno(no);
    lect.setRno(paramMap.get("rno"));
    int count = lectsDao.update(lect);
    if (count > 0) {
      TableText.show(out,"강의에 사용할 강의장이 등록되었습니다☆.");
    } else {
      TableText.show(out, "강의실 등록 실패 ☆.");
    }
  }
//lects/delete.do?no=
  @RequestMapping("delete.do")
  public void delete(Map<String, String> paramMap, PrintWriter out) {
    try {
      int count = lectsDao.delete(Integer.parseInt(paramMap.get("no")));
      if (count > 0) {
        TableText.show(out, "강의 내용을 삭제하였습니다.");
      } else {
        TableText.show(out,"유효하지 않은 번호이거나, 이미 삭제된 항목입니다.");
      }
    } catch (Exception e) {
      TableText.show(out, "데이터 처리에 실패했습니다.");
    }
  }
// lects/list.do
  @RequestMapping("list.do")
  public void list(PrintWriter out) {
    try {
      List<Lects> lects = lectsDao.selectList();
      out.println("강의 목록");
      out.println("-------------------------------------------------");
      for (Lects lect : lects) {
        out.printf("| %d | 강의명 : %s | 기간 %s ~ %s | 마감일 : %s \n",
            lect.getLno(),lect.getTitl(),lect.getSt_dt(),lect.getEn_dt(),lect.getFi_dt());
      }
      out.println("-------------------------------------------------");
    } catch (Exception e) {
      out.println("회원 데이터 로딩 실패!");
      out.println("-------------------------------------------------");      
    }
  }
//  lects/update.do?no=2&title=바뀐다&description=바꼇다&startdate=2011-10-10&enddate=2012-12-12&deadline=2010-10-10&totalhour=960&dayhour=10&rno=k001
  @RequestMapping("update.do")
  public void update(Map<String, String> paramMap, PrintWriter out) {
    try {
      HashMap<String, Object> sqlParamMap = new HashMap<>();
      int no =Integer.parseInt(paramMap.get("no"));
      sqlParamMap.put("lno", no);
      Lects lect = lectsDao.selectOne(sqlParamMap);
      if (lect == null) {
        TableText.show(out, "유효하지 않은 번호입니다.");
        return;
      }
      
      lect.setLno(no);
      lect.setTitl(paramMap.get("title"));
      lect.setDesct(paramMap.get("description"));
      lect.setSt_dt(Date.valueOf(paramMap.get("startdate")));
      lect.setEn_dt(Date.valueOf(paramMap.get("enddate")));
      lect.setDay_hr(Integer.parseInt(paramMap.get("dayhour")));
      lect.setTot_hr(Integer.parseInt(paramMap.get("totalhour")));
      lect.setFi_dt(Date.valueOf(paramMap.get("deadline")));
      lect.setRno(paramMap.get("rno"));
      int count = lectsDao.update(lect);
      if (count > 0) {
        TableText.show(out, "강의 내용을 변경하였습니다.");
      } else {
        TableText.show(out,"유효하지 않은 번호이거나, 이미 삭제된 항목입니다.");
      }
    } catch (Exception e) {
      TableText.show(out,"데이터 처리에 실패했습니다.");
    }
  }
}
