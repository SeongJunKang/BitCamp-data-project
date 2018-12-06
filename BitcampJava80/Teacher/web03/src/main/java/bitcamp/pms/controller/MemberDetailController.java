package bitcamp.pms.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.vo.Member;

@Component("/member/detail")
public class MemberDetailController {
  @Autowired
  MemberDao memberDao;
  
  public String execute(
      HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException {
    
    Map<String,Object> paramMap = new HashMap<>();
    paramMap.put("no", Integer.parseInt(request.getParameter("no")));
    
    Member member = memberDao.selectOne(paramMap);
    
    response.setContentType("text/html;charset=UTF-8");
    
    request.setAttribute("member", member);
    return "/member/MemberDetail.jsp";
  }
}










