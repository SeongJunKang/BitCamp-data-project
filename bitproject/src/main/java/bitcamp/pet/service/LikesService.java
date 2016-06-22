package bitcamp.pet.service;

import bitcamp.pet.vo.Likes;

public interface LikesService {
  void add(Likes likes);
  void delete(int mno,int pno);
  Likes retrieveByNO(int mno,int pno);
  int countAll(int pno);
}
