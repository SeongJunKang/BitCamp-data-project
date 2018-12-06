package bitcamp.ems.dao;

import java.util.List;
import java.util.Map;

import bitcamp.ems.domain.Lects;

public interface LectsDao {
  List<Lects> selectList();

  Lects selectOne(Map<String, Object> paramMap);

  int insert(Lects lects);

  int delete(int no);

  int update(Lects lects)  ;
}
