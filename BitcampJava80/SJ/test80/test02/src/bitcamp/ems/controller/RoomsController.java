package bitcamp.ems.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import bitcamp.ems.annotation.RequestMapping;
import bitcamp.ems.dao.RoomsDao;
import bitcamp.ems.domain.Rooms;
import bitcamp.ems.util.TableText;

@Controller
@RequestMapping("/rooms/")
public class RoomsController {
  @Autowired
  private RoomsDao roomsDao;

  // rooms/add.do?rno=K001&rnm=강남
  @RequestMapping("add.do")
  public void add(Map<String, String> paramMap, PrintWriter out) {
    Rooms rooms = new Rooms();
    rooms.setRno(paramMap.get("roomcode"));
    rooms.setRnm(paramMap.get("roomname"));
    try {
      roomsDao.insert(rooms);
      TableText.show(out, "강의실 정보를 저장하였습니다.");
    } catch (Exception e) {
      TableText.show(out, "데이터를 저장하는데 실패했습니다.");
    }
  }

  @RequestMapping("delete.do")
  public void delete(Map<String, String> paramMap, PrintWriter out) {
    try {
      HashMap<String, Object> sqlParamMap = new HashMap<>();
      sqlParamMap.put("rno", paramMap.get("roomcode"));
      int count = roomsDao.delete(sqlParamMap);
      if (count > 0) {
        TableText.show(out, "삭제하였습니다.");
      } else {
        TableText.show(out, "유효하지 않은 번호이거나, 이미 삭제된 항목입니다.");
      }
    } catch (Exception e) {
      TableText.show(out, "데이터 처리에 실패했습니다.");
    }
  }

  @RequestMapping("list.do")
  public void list(PrintWriter out) {
    try {
      List<Rooms> rooms = roomsDao.selectList();
      TableText.show(out, "강의장 목록",45);
      for (Rooms room : rooms) {
        out.printf("|강의장 이름 : %s | 강의장 코드 : %s|\n", room.getRnm(), room.getRno());
      }
      for(int i = 0 ; i < 45 ; i++) {
        out.print("-");
      }
      out.println();
    } catch (Exception e) {
      throw new RuntimeException("회원 데이터 로딩 실패!", e);
    }
  }

  @RequestMapping("update.do")
  public void update(Map<String, String> paramMap, PrintWriter out) {
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
        TableText.show(out, "강의실 정보를 변경하였습니다.");
      } else {
        TableText.show(out, "유효하지 않은 번호이거나, 이미 삭제된 항목입니다.");
      }
    } catch (Exception e) {
      TableText.show(out, "데이터 처리에 실패했습니다.");
    }
  }
}
