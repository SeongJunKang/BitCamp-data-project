package bitcamp.pms.service;

import java.util.List;

import bitcamp.pms.vo.Board;

public interface BoardService {
  void add(Board board);
  void delete(int no);
  Board retrieve(int no);
  void change(Board board);
  List<Board> list(int pageNo,int pageSize);
  int countPage(int pageSize);
}
