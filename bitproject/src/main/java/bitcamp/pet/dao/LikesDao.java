package bitcamp.pet.dao;

import java.util.Map;

import bitcamp.pet.vo.Likes;

public interface LikesDao {

  int selectOne(Map<String, Object> paramMap);

  int insert(Likes likes);

  int delete(int pno);

}
