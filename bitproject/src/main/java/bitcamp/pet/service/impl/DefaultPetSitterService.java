package bitcamp.pet.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.pet.dao.PetSitterDao;
import bitcamp.pet.service.PetSitterService;
import bitcamp.pet.vo.PetSitter;

@Service
public class DefaultPetSitterService implements PetSitterService {

  @Autowired
  PetSitterDao petsitterDao;

  public void add(PetSitter petsitter) {
    petsitterDao.insert(petsitter);
  }

  public void delete(int pno) {
    petsitterDao.delete(pno);
  }

  public PetSitter retrieveByNo(int pno) {
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("pno", pno);
    return petsitterDao.selectOne(paramMap);
  }

  public PetSitter retrieveByNick(String nick) {
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("nick", nick);
    return petsitterDao.selectOne(paramMap);
  }

  public void change(PetSitter petsitter) {
    petsitterDao.update(petsitter);
  }

  public int countPage(int pageSize) {
    int count = petsitterDao.countAll();
    int pages = count / pageSize;
    if ((count % pageSize) > 0) {
      pages++;
    }
    return pages;
  }
  public boolean exist(int no) {
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("pno", no);
    if (petsitterDao.isPetSitter(paramMap) > 0) {
      return true;
    }
    return false;
  }

/*  public List<PetSitter> list(String order, int index) {
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("index", index);
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
    return petsitterDao.selectList(paramMap);
  }*/
  public List<PetSitter> list(String order,int pageNo, int pageSize) {
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
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
    return petsitterDao.selectList(paramMap);
  }

  @Override
  public void setInfo(PetSitter petsitter) {
    // TODO Auto-generated method stub
    petsitterDao.setInfo(petsitter);
  }

  @Override
  public List<PetSitter> mainlist() {
    // TODO Auto-generated method stub
    return petsitterDao.mainList();
  }

  @Override
  public List<PetSitter> search(String index,int pageNo, int pageSize) {
    HashMap<String, Object> paramMap = new HashMap<>();
    System.out.println("vpdlw넘버"+pageNo);
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    System.out.println(paramMap.get("startIndex")+"이게 스타트인덱스");
    paramMap.put("length", pageSize);
    System.out.println(paramMap.get("length") +"이게 길이");
    if ( index.equals("전체") ) {
      paramMap.put("pno", "pno");
      return petsitterDao.selectList(paramMap);
    }
    paramMap.put("index", "%"+index+"%");
    return petsitterDao.search(paramMap);
  }
/*  public int countPage(int pageSize) {
    int count = petsitterDao.countAll();
    int pages = count / pageSize;
    if ((count % pageSize) > 0) {
      pages++;
    }
    return pages;
  }*/
  @Override
  public int searchCount(String index,int pageSize) {
    int count = petsitterDao.searchCount("%"+index+"%");
    int pages= count/pageSize;
    if(pages == 0) {
      pages=1;
    }
    else if((count % pageSize) > 0 ) {
      pages++;
    }
    return pages;
  }
}
/*
 * #Service 객체 - 비즈니스 로직을 수행한다. - 트랜잭션을 제어한다 - 메서드의 이름은 업무 용어에 가깝게 정의하라 - 업무
 * 처리에 필요하다면, 여러 개의 DAO 를 사용할 수 있다.
 */
