package bitcamp.pet.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.pet.dao.RequestDao;
import bitcamp.pet.service.RequestService;
import bitcamp.pet.vo.Petrequest;
import bitcamp.pet.vo.Request;

@Service
public class DefaultRequestService implements RequestService {

  @Autowired
  RequestDao requestDao;

  public void add(Request request) {
    requestDao.insert(request);
  }

  public void delete(int req) {
    requestDao.delete(req);
  }

/*  public boolean exist(int req) {
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("req", req);
    if (requestDao.isPetSitter(paramMap) > 0) {
      return true;
    }
    return false;
  }*/
  public Petrequest retrieve(int req) {
    return requestDao.selectOne(req);
  }
  public List<Request> list(int pageNo, int pageSize) {
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    return requestDao.selectList(paramMap);
  }
  


  public int countPage(int pageSize) {
    int count = requestDao.countAll();
    int pages = count / pageSize;
    if ((count % pageSize) > 0)
      pages++;
    return pages;
  }



  @Override
  public void change(Request Request) {
    requestDao.update(Request);
    
  }

  @Override
  public List<Petrequest> petrequestlist(int pageNo, int pageSize, int pno) {
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("pno", pno);
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    return requestDao.selectListpet(paramMap);
  }

  @Override
  public List<Petrequest> myrequestlist(int pageNo, int pageSize, int mno) {
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("mno", mno);
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    return requestDao.selectListpet(paramMap);
  }

  @Override
  public int getAccrue(int pno) {
    // TODO Auto-generated method stub
    return requestDao.accrue(pno);
  }


/*  @Override
  public List<Request> list(String order, int pno) {
   HashMap<String, Object> paramMap = new HashMap<>();
   paramMap.put(key, value)
    return null;
  }*/

}
/*
 * # Service 객체 - 비즈니스 로직을 수행한다. - 트랜잭션을 제어한다 - 메서드의 이름은 업무 용어에 가깝게 정의하라 - 업무
 * 처리에 필요하다면, 여러 개의 DAO 를 사용할 수 있다.
 */
