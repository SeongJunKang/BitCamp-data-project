package bitcamp.ems.dao;

import java.util.List;

import bitcamp.ems.domain.Teachs;

public interface TeachsDao {
  List<Teachs> selectList();

  Teachs selectOne(int no);

  int insert(Teachs teachs);

  int update(Teachs teachs);

  int delete(int no);

}
