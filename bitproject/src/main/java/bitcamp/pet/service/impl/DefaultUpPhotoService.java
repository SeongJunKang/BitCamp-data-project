//defaultupphotoservice.java

package bitcamp.pet.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.pet.dao.UpPhotoDao;
import bitcamp.pet.service.UpPhotoService;
import bitcamp.pet.vo.UpPhoto;

@Service
public class DefaultUpPhotoService implements UpPhotoService {
  @Autowired
  UpPhotoDao upphotoDao;

  @Override
  public void add(UpPhoto upphoto) {
    upphotoDao.insert(upphoto);
  }

  @Override
  public void delete(int pno, String ptos) {
    HashMap<String, Object> paramMap = new HashMap<>();
    paramMap.put("pno", pno);
    paramMap.put("ptos", ptos);
    upphotoDao.delete(paramMap);
  }

  @Override
  public List<UpPhoto> list(int pno) {
    return upphotoDao.selectList(pno);
  }

}
/*
 * # Service 객체 - 비즈니스 로직을 수행한다. - 트랜잭션을 제어한다 - 메서드의 이름은 업무 용어에 가깝게 정의하라 - 업무
 * 처리에 필요하다면, 여러 개의 DAO 를 사용할 수 있다.
 */