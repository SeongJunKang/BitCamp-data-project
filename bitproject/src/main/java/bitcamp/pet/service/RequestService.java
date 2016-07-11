package bitcamp.pet.service;

import java.util.List;

import bitcamp.pet.vo.Petrequest;
import bitcamp.pet.vo.Request;

public interface RequestService {
  void add(Request request);
  void delete(int req);
  Request retrieve(int req);
  List<Request> list(int pageNo, int pageSize);
  List<Petrequest> petrequestlist(int pageNo, int pageSize, int pno);
  void change(Request Request);
  int countPage(int pageSize);
}
