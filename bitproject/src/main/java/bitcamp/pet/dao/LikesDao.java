package bitcamp.pet.dao;

import bitcamp.pet.vo.Likes;

public interface LikesDao {

  int selectOne(int mno);

  int insert(Likes likes);

  int delete(int pno);

  int countAll(int pno);
}
