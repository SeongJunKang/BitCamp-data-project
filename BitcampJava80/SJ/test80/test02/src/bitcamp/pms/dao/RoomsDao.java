package bitcamp.pms.dao;

import java.util.List;
import java.util.Map;

import bitcamp.pms.domain.Rooms;

public interface RoomsDao {
  List<Rooms> selectList();

  Rooms selectOne(Map<String, Object> paramMap);

  int insert(Rooms rooms);

  int update(Rooms rooms);

  int delete(Map<String, Object> paramMap);

}
