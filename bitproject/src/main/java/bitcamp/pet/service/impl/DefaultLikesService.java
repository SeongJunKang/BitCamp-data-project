package bitcamp.pet.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.pet.dao.LikesDao;
import bitcamp.pet.service.LikesService;
import bitcamp.pet.vo.Likes;

@Service
public class DefaultLikesService implements LikesService {

  @Autowired
  LikesDao likesDao;

  public void add(Likes likes) {
    likesDao.insert(likes);
  }

  public void delete(int mno,int pno) {
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("mno", mno);
    paramMap.put("pno", pno);
    likesDao.delete(paramMap);
  }
  
  public Likes retrieveByNO(int mno,int pno) {
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("mno", mno);
    paramMap.put("pno", pno);
    return likesDao.selectOne(paramMap);
  }

  @Override
  public int countAll(int pno) {
    return likesDao.countAll(pno);
  }

}
/*
 * # Service 객체 - 비즈니스 로직을 수행한다. - 트랜잭션을 제어한다 - 메서드의 이름은 업무 용어에 가깝게 정의하라 - 업무
 * 처리에 필요하다면, 여러 개의 DAO 를 사용할 수 있다.
 */
