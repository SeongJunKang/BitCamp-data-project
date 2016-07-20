package bitcamp.pet.dao;

import java.util.List;
import java.util.Map;

import bitcamp.pet.vo.UpPhoto;

public interface UpPhotoDao {

  int insert(UpPhoto UpPhoto);

  int delete(Map<String, Object> paramMap);
  
  List<UpPhoto> selectList(int pno);
  
}
