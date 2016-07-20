package bitcamp.pet.service;

import java.util.List;

import bitcamp.pet.vo.UpPhoto;

public interface UpPhotoService {
  void add(UpPhoto UpPhoto);
  void delete(int pno,String ptos);
  List<UpPhoto> list(int pno);
}
