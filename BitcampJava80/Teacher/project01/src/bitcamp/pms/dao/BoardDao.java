package bitcamp.pms.dao;

import java.util.List;

import bitcamp.pms.domain.Board;

public interface BoardDao {
  List<Board> selectList();
  int insert(Board board);
  Board selectOne(int no);
  int update(Board board);
  int delete(int no);
}










