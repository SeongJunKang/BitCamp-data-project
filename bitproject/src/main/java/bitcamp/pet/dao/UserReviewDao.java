package bitcamp.pet.dao;

import java.util.List;
import java.util.Map;

import bitcamp.pet.vo.UserReview;

public interface UserReviewDao {
  List<UserReview> selectList(Map<String,Object> paramMap);
  void insert(UserReview userreview);
  void delete(Map<String,Object> paramMap);
  void deleteAll(Map<String,Object> paramMap);
  void update(UserReview userreview);
  UserReview selectOne(Map<String, Object> paramMap);
}
