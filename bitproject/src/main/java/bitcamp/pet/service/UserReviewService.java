package bitcamp.pet.service;

import java.util.List;

import bitcamp.pet.vo.UserReview;

public interface UserReviewService {
  void add(UserReview userreview);
  void delete(int mno,int pno);
  void change(UserReview userreview);
  List<UserReview> list(int pno,int page);
  UserReview retrieveByNo(int mno, int pno);
}
