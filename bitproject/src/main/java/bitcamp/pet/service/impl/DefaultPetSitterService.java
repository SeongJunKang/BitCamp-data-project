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

  public List<PetSitter> list(int pageNo, int pageSize) {
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length", pageSize);
    return petsitterDao.selectList(paramMap);
  }

  public int countPage(int pageSize) {
    int count = petsitterDao.countAll();
    int pages = count / pageSize;
    if ((count % pageSize) > 0) {
      pages++;
    }
    return pages;
  }

}
/*
 * # Service 객체 - 비즈니스 로직을 수행한다. - 트랜잭션을 제어한다 - 메서드의 이름은 업무 용어에 가깝게 정의하라 - 업무
 * 처리에 필요하다면, 여러 개의 DAO 를 사용할 수 있다.
 */
