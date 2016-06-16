package bitcamp.pet.service;

import java.util.List;

import bitcamp.pet.vo.Member;

public interface MemberService {
  void add(Member member);
  void delete(int no);
  Member retrieveByNo(int no);
  Member retrieveByEmail(String email);
  void change(Member member);
  List<Member> list(int pageNo,int pageSize);
  boolean exist(String email, String password);
  int countPage(int pageSize);
}
