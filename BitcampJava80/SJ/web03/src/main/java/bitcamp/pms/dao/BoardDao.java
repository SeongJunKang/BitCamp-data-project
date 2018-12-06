package bitcamp.pms.dao;

import java.util.List;
import java.util.Map;

import bitcamp.pms.vo.Board;

public interface BoardDao {
  List<Board> selectList(Map<String, Object> paramMap);

  Board selectOne(int no);

  int insert(Board board);

  int update(Board board);

  int delete(int no);

  int countAll();
}
