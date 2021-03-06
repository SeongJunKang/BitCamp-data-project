package bitcamp.pet.service;

import java.util.List;

import bitcamp.pet.vo.Member;

public interface MemberService {
  void add(Member member);
  void delete(int mno);
  Member retrieveByNo(int mno);
  Member retrieveByEmail(String email);
  void change(Member member);
  List<Member> list();
  boolean exist(String email, String password);
  int countPage(int pageSize);
}
