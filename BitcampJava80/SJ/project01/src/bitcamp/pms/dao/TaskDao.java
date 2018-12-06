package bitcamp.pms.dao;

import java.util.List;

import bitcamp.pms.domain.Task;

public interface TaskDao {
  void insert(Task task)  ;

  List<Task> selectList()  ;

  Task selectOne(int no)  ;

  int update(Task task)  ;

  int delete(int no)  ;
}
