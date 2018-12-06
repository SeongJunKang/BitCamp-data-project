package bitcamp.pms.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;

@Controller
@RequestMapping("/member/")
public class MemberController {
  @Autowired
  private MemberDao memberDao;

  @RequestMapping("add.do")
  public void add(Map<String, String> paramMap, PrintWriter out) {
    Member member = new Member();
    HashMap<String, Object> sqlParamMap = new HashMap<>();
    sqlParamMap.put("email", paramMap.get("email"));
    
    member.setName(paramMap.get("name"));
    member.setEmail(paramMap.get("email"));
    member.setPassword(paramMap.get("password"));
    member.setTel(paramMap.get("tel"));
    try {
      memberDao.insert(member);
      out.println("저장하였습니다.");
    } catch (Exception e) {
      out.println("데이터를 저장하는데 실패했습니다.");
    }
  }

  @RequestMapping("delete.do")
  public void delete(Map<String, String> paramMap, PrintWriter out) {
    try {
      int no = Integer.parseInt(paramMap.get("no"));
      int count = memberDao.delete(no);
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
  public void list(PrintWriter out) {
    try {
      List<Member> members = memberDao.selectList();
      out.println("회원 목록");
      for (Member member : members) {
        out.printf("%d, %s, %s, %s\n", member.getNo(), member.getName(), member.getEmail(), member.getTel());
      }
    } catch (Exception e) {
      throw new RuntimeException("회원 데이터 로딩 실패!", e);
    }
  }

  @RequestMapping("update.do")
  public void update(Map<String, String> paramMap, PrintWriter out) {
    try {
      int no = Integer.parseInt(paramMap.get("no"));
      HashMap<String, Object> sqlParamMap = new HashMap<>();
      sqlParamMap.put("no", no);
      Member member = memberDao.selectOne(sqlParamMap);
      if (member == null) {
        out.println("유효하지 않은 번호입니다.");
        return;
      }
      member.setNo(no);
      member.setName(paramMap.get("name"));
      member.setEmail(paramMap.get("email"));
      member.setPassword(paramMap.get("password"));
      member.setTel(paramMap.get("tel"));
      int count = memberDao.update(member);
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
