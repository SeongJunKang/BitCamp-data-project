package bitcamp.pet.service;

import java.util.List;

import bitcamp.pet.vo.Request;

public interface RequestService {
  void add(Request request);
  void delete(int mno);
  Request retrieveByNo(int req);
  List<Request> list(String order, int pno);
}
