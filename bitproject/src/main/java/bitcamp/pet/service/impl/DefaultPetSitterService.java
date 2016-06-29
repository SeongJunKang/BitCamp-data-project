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

  public PetSitter retrieveByKakao(String kakao) {
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("kakao", kakao);
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

  public List<PetSitter> list(String order) {
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
    return petsitterDao.selectList(paramMap);
  }
}
/*
 * # Service 객체 - 비즈니스 로직을 수행한다. - 트랜잭션을 제어한다 - 메서드의 이름은 업무 용어에 가깝게 정의하라 - 업무
 * 처리에 필요하다면, 여러 개의 DAO 를 사용할 수 있다.
 */
