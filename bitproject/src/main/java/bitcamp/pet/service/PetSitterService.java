package bitcamp.pet.service;

import java.util.List;

import bitcamp.pet.vo.PetSitter;

public interface PetSitterService {
  void add(PetSitter petsitter);
  void delete(int pno);
  PetSitter retrieveByNo(int pno);
  PetSitter retrieveByKakao(String kakao);
  void change(PetSitter petsitter);
  int countPage(int pageSize);
  boolean exist(int no);
  
  List<PetSitter> list(String order);
}
