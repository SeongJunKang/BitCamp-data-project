package bitcamp.pms.controller;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.RoomsDao;
import bitcamp.pms.domain.Rooms;

@Controller
@RequestMapping("rooms/")
public class RoomsController {
  @Autowired
  private RoomsDao roomsDao;
//rooms/add.do?rno=K001&rnm=강남
  @RequestMapping("add.do")
    public void add(Map<String, String> paramMap, PrintStream out) {
      Rooms rooms = new Rooms();
    rooms.setRno(paramMap.get("roomcode"));
    rooms.setRnm(paramMap.get("roomname"));
    try {
      roomsDao.insert(rooms);
      out.println("저장하였습니다.");
    } catch (Exception e) {
      out.println("데이터를 저장하는데 실패했습니다.");
    }
  }

  @RequestMapping("delete.do")
  public void delete(Map<String, String> paramMap, PrintStream out) {
    try {
      HashMap<String, Object> sqlParamMap = new HashMap<>();
      sqlParamMap.put("rno", paramMap.get("roomcode"));
      int count = roomsDao.delete(sqlParamMap);
      if (count > 0) {
        out.println("삭제하였습니다.");
      } else {
        out.println("유효하지 않은 번호이거나, 이미 삭제된 항목입니다.");
      }
    } catch (Exception e) {
      out.println("데이터 처리에 실패했습니다.");
    }
  }

  @RequestMapping("list.do")
  public void list(PrintStream out) {
    try {
      List<Rooms> rooms = roomsDao.selectList();
      out.println("강의장 목록");
      for (Rooms room : rooms) {
        out.printf("강의장 이름 : %s , 강의장 코드 %s\n",
            room.getRnm(), room.getRno());
      }
    } catch (Exception e) {
      throw new RuntimeException("회원 데이터 로딩 실패!", e);
    }
  }

  @RequestMapping("update.do")
  public void update(Map<String, String> paramMap, PrintStream out) {
    try {
      HashMap<String, Object> sqlParamMap = new HashMap<>();
      sqlParamMap.put("rno", paramMap.get("roomcode"));
      Rooms rooms = roomsDao.selectOne(sqlParamMap);
      if (rooms == null) {
        out.println("유효하지 않은 번호입니다.");
        return;
      }
      rooms.setRno(paramMap.get("roomcode"));
      rooms.setRnm(paramMap.get("roomname"));
      
      int count = roomsDao.update(rooms);
      if (count > 0) {
        out.println("변경하였습니다.");
      } else {
        out.println("유효하지 않은 번호이거나, 이미 삭제된 항목입니다.");
      }
    } catch (Exception e) {
      out.println("데이터 처리에 실패했습니다.");
    }
  }
}
