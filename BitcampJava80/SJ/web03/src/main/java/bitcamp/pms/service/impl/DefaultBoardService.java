package bitcamp.pms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.service.BoardService;
import bitcamp.pms.vo.Board;

@Service
public class DefaultBoardService implements BoardService {
  
  @Autowired
  BoardDao boardDao;
  
  public void add(Board board) {
    
    boardDao.insert(board);
//    boardDao.insert(board);
//    
//     암호를 컬럼의 크기보다 크게 만든다.
//     그러면 오류가 발생할 것이다.
//     확인? 이전에 입력한 내용은 어떻게 되는가 ?
//    board.setPassword("12345678901");
//    boardDao.insert(board);
  }
  
  public void delete(int no) {
    boardDao.delete(no);
  }
  
  public Board retrieve(int no) {
    Board board = boardDao.selectOne(no);
    return board;
  }
  
  public void change(Board board) {
    boardDao.update(board);
  }

  public List<Board> list(int pageNo,int pageSize) {
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", (pageNo - 1) * pageSize);
    paramMap.put("length",pageSize);
    return boardDao.selectList(paramMap);
  }

  public int countPage(int pageSize) {
    int count = boardDao.countAll();
    int pages = count / pageSize;
    if ((count % pageSize) > 0) {
      pages++;
    }
    return pages;
  }

}
/*
# Service 객체
- 비즈니스 로직을 수행한다.
- 트랜잭션을 제어한다
- 메서드의 이름은 업무 용어에 가깝게 정의하라
- 업무 처리에 필요하다면, 여러 개의 DAO 를 사용할 수 있다.  
 */
