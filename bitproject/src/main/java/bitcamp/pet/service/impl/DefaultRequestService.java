package bitcamp.pet.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.pet.dao.RequestDao;
import bitcamp.pet.service.RequestService;
import bitcamp.pet.vo.Request;

@Service
public class DefaultRequestService implements RequestService {

  @Autowired
  RequestDao requestDao;

  public void add(Request request) {
    requestDao.insert(request);
  }

  public void delete(int mno) {
    requestDao.delete(mno);
  }

  public Request retrieveByNo(int pno) {
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("pno", pno);
    return requestDao.selectOne(paramMap);
  }

  public Request retrieveByNick(String nick) {
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("nick", nick);
    return requestDao.selectOne(paramMap);
  }

  public void change(Request request) {
    requestDao.update(request);
  }




  public boolean exist(int no) {
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("pno", no);
    if (requestDao.isPetSitter(paramMap) > 0) {
      return true;
    }
    return false;
  }

  public List<Request> list(String order) {
    HashMap<String, Object> paramMap = new HashMap<>();
    switch(order) {
    case "pno": paramMap.put("pno", order);
      break;
    case "likes":paramMap.put("likes", order);
      break;
    case "nick":paramMap.put("nick", order);
      break;
    case "amt":paramMap.put("amt", order);
      break;
    }
    return requestDao.selectList(paramMap);
  }

}
/*
 * # Service 객체 - 비즈니스 로직을 수행한다. - 트랜잭션을 제어한다 - 메서드의 이름은 업무 용어에 가깝게 정의하라 - 업무
 * 처리에 필요하다면, 여러 개의 DAO 를 사용할 수 있다.
 */
