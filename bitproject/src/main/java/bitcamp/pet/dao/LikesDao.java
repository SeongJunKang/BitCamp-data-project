package bitcamp.pet.dao;

import java.util.Map;

import bitcamp.pet.vo.Likes;

public interface LikesDao {

  Likes selectOne(Map<String, Object> paramMap);

  int insert(Likes likes);

  int delete(Map<String, Object> paramMap);

  int countAll(int pno);
}
