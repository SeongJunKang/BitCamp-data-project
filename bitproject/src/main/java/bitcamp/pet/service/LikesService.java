package bitcamp.pet.service;

import bitcamp.pet.vo.Likes;

public interface LikesService {
  void add(Likes likes);
  void delete(int mno);
  int retrieveByMNO(int mno);
  int countAll(int pno);
}
