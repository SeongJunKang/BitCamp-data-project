package bitcamp.pms.controller;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.LectsDao;
import bitcamp.pms.dao.TeaAssignDao;
import bitcamp.pms.domain.Lects;
import bitcamp.pms.domain.TeaAssign;

@Controller
@RequestMapping("teaAssign/") // 매핑정보 일부를 선언한다.
public class TeaAssignController {  
  @Autowired
  TeaAssignDao teaAssignDao;
  @Autowired
  LectsDao lectsDao;
  
  
  //teaAssign/add.do?lno=2&tno=1
  @RequestMapping("add.do") // 매핑정보 나머지를 선언한다.
  public void add(Map<String, String> paramMap, PrintStream out) {    
    
    TeaAssign teaAssign = new TeaAssign();
    int lno = Integer.parseInt(paramMap.get("lno"));
    teaAssign.setLno(lno);
    teaAssign.setTno(Integer.parseInt(paramMap.get("tno")));
    HashMap<String, Object> sqlParamMap = new HashMap<>();
    sqlParamMap.put("lno", lno);
    Lects lect = lectsDao.selectOne(sqlParamMap);
    teaAssign.setStdt(lect.getSt_dt());
    teaAssign.setEndt(lect.getEn_dt());
    teaAssign.setHr(lect.getTot_hr());
    teaAssign.setDesct(lect.getDesct());
    
    try {
      teaAssignDao.insert(teaAssign);   
      out.println("---------------------------------");
      out.println("저장하였습니다.");
      out.println("---------------------------------");      
    } catch (Exception e) {
        out.println("데이터 저장을 실패하였습니다.");
        e.printStackTrace(out);
    }
  }
  
  @RequestMapping("delete.do")
  public void delete(Map<String, String> paramMap, PrintStream out) {      
    try {     
      teaAssignDao.delete(Integer.parseInt(paramMap.get("tano")));
      out.println("---------------------------------");
      out.println("삭제하였습니다.");
      out.println("---------------------------------");
      this.list(out);      
    } catch (Exception e) {
      out.println("데이터 처리중 오류 발생");
    }    
  } 
  
  @RequestMapping("list.do")
  public void list(PrintStream out) {
    try {
      List<TeaAssign> teaAssigns = teaAssignDao.selectList();
      out.println("---------------------------------");
      out.println("저장된 강의관리 목록입니다.");
      out.println("---------------------------------");
      out.println("|강사배치번호| 강의명 | 강사명 |  시 작 일  |  종 료 일  | 기 수 | 총 시 간 |");
      for (TeaAssign teaAssign : teaAssigns) {
        out.printf("    %d번          %s        %s       %s   %s    %s\t%d\n", teaAssign.getTano(),
            teaAssign.getLno(), teaAssign.getTno(), teaAssign.getStdt(),
            teaAssign.getEndt(), teaAssign.getDesct(), teaAssign.getHr());        
      }
    } catch (Exception e) {
      throw new RuntimeException("강의관리 데이터 로딩 실패!", e);
    }      
  }
  
  //teaAssign/update.do?tano=6&lno=2&tno=2&stdt=2020-02-02&endt=2020-06-06&desct=java90
  @RequestMapping("update.do")
  public void update(Map<String, String> paramMap, PrintStream out) {

    try {
    TeaAssign teaAssign = teaAssignDao.selectOne(Integer.parseInt(paramMap.get("tano")));
    teaAssign.setLno(Integer.parseInt(paramMap.get("lno")));
    teaAssign.setTno(Integer.parseInt(paramMap.get("tno")));    
    
      teaAssignDao.update(teaAssign);
      out.println("---------------------------------");
      out.println("변경하였습니다.");
      out.println("---------------------------------");
      this.list(out);
    } catch (Exception e) {
      out.println("데이터 변경을 실패하였습니다.");
      e.printStackTrace(out);
    }
  }

}
