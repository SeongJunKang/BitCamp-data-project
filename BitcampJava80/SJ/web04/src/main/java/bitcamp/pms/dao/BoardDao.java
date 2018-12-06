package bitcamp.pms.dao;

import java.util.List;

import bitcamp.pms.vo.Board;

public interface BoardDao {
  
  List<Board> selectList()  ; 
  Board selectOne(int no)   ;
  int insert(Board board)   ;
  int update(Board board)  ;
  int delete(int no)  ;
}

