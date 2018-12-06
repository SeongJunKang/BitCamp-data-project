package bitcamp.ems.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import bitcamp.ems.annotation.RequestMapping;
import bitcamp.ems.dao.LectsDao;
import bitcamp.ems.dao.TeaAssignDao;
import bitcamp.ems.domain.Lects;
import bitcamp.ems.domain.TeaAssign;
import bitcamp.ems.domain.TeaAssignAdv;
import bitcamp.ems.util.TableText;

@Controller
@RequestMapping("/teaAssign/") // 매핑정보 일부를 선언한다.
public class TeaAssignController {  
  @Autowired
  TeaAssignDao teaAssignDao;
  @Autowired
  LectsDao lectsDao;
  
  
  //teaAssign/add.do?lno=2&tno=1
  @RequestMapping("add.do") // 매핑정보 나머지를 선언한다.
  public void add(Map<String, String> paramMap, PrintWriter out) {    
    
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
      TableText.show(out, "강의하실 강사 정보를 저장하였습니다.");
    } catch (Exception e) {
      TableText.show(out,"데이터 저장을 실패하였습니다.");
    }
  }
  
  @RequestMapping("delete.do")
  public void delete(Map<String, String> paramMap, PrintWriter out) {      
    try {     
      teaAssignDao.delete(Integer.parseInt(paramMap.get("tano")));
      TableText.show(out, "강의, 강사 정보를 삭제하였습니다.");
      this.list(out);      
    } catch (Exception e) {
      TableText.show(out,"데이터 처리중 오류 발생"); 
    }    
  } 
  
  @RequestMapping("list.do")
  public void list(PrintWriter out) {
    try {
      List<TeaAssignAdv> teaAssigns = teaAssignDao.selectList();
      out.println("--------------------------------------------------------------------------------------------");
      out.println("저장된 강의관리 목록입니다.");
      out.println("--------------------------------------------------------------------------------------------");
      out.println("|강사배치번호|  강  의  명  | 강 사 명 |  시 작 일  |  종 료 일  | 기 수 | 총 시 간 |");
      for (TeaAssignAdv teaAssign : teaAssigns) {
        out.printf("    %d번       %s\t%s  %s    %s    %s \t%d\n", teaAssign.getTano(),
            teaAssign.getTitl(), teaAssign.getTnm(), teaAssign.getStdt(),
            teaAssign.getEndt(), teaAssign.getDesct(), teaAssign.getHr());        
      }
      out.println("--------------------------------------------------------------------------------------------");
    } catch (Exception e) {
      TableText.show(out, "강의 관리 목록 불러오기 실패.");
    }      
  }
  
  //teaAssign/update.do?tano=6&lno=2&tno=2&stdt=2020-02-02&endt=2020-06-06&desct=java90
  @RequestMapping("update.do")
  public void update(Map<String, String> paramMap, PrintWriter out) {

    try {
    TeaAssign teaAssign = teaAssignDao.selectOne(Integer.parseInt(paramMap.get("tano")));
    teaAssign.setLno(Integer.parseInt(paramMap.get("lno")));
    teaAssign.setTno(Integer.parseInt(paramMap.get("tno")));    
    
      teaAssignDao.update(teaAssign);
      TableText.show(out, "강의 - 강사 내용 변경하였습니다.");
      this.list(out);
    } catch (Exception e) {
      TableText.show(out, "데이터 변경을 실패하였습니다.");
    }
  }

}
