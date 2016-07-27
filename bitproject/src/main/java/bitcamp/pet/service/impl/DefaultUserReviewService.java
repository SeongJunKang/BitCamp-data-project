package bitcamp.pet.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.pet.dao.UserReviewDao;
import bitcamp.pet.service.UserReviewService;
import bitcamp.pet.vo.UserReview;

@Service
public class DefaultUserReviewService implements UserReviewService {

  @Autowired
  UserReviewDao userreviewDao;

  public void add(UserReview userreview) {
    userreviewDao.insert(userreview);
  }

  @Override
  public void delete(int mno, int pno) {
    // TODO Auto-generated method stub
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("pno", pno);
    paramMap.put("mno", mno);
    userreviewDao.delete(paramMap);
  }

  @Override
  public void change(UserReview userreview) {
    // TODO Auto-generated method stub
    userreviewDao.update(userreview);
  }

  @Override
  public List<UserReview> list(int pno,int page) {
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("pno", pno);
    paramMap.put("start", (page - 1) * 6 );
    paramMap.put("end", 6);
    return userreviewDao.selectList(paramMap);
  }

  @Override
  public UserReview retrieveByNo(int mno, int pno) {
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("pno", pno);
    paramMap.put("mno", mno);
    return userreviewDao.selectOne(paramMap);
  }

  @Override
  public void deleteAll(int mno) {
    // TODO Auto-generated method stub
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("mno", mno);
    userreviewDao.deleteAll(paramMap);
    
  }

}
/*
 * # Service 객체 - 비즈니스 로직을 수행한다. - 트랜잭션을 제어한다 - 메서드의 이름은 업무 용어에 가깝게 정의하라 - 업무
 * 처리에 필요하다면, 여러 개의 DAO 를 사용할 수 있다.
 */
