package bitcamp.pms.dao;

import java.util.List;

import bitcamp.pms.domain.Teachs;

public interface TeachsDao {
  List<Teachs> selectList();

  Teachs selectOne(int no);

  int insert(Teachs teachs);

  int update(Teachs teachs);

  int delete(int no);

}
