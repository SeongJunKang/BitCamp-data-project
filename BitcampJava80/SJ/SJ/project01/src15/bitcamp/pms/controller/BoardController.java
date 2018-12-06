/* 기능 요구사항
 *  목록 --> 제목 , 조회수, 생성일
 *  추가 --> 제목 , 내용, 암호
 *  변경 --> 제목 , 내용, 암호
 *  삭제 --> 인덱스로 삭제할 게시물 지정.
 */
package bitcamp.pms.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.Scanner;

import bitcamp.pms.domain.Board;



public class BoardController implements MenuController {
  private static final String filename = "board.data";
  private Scanner keyScan ;
  private ArrayList<Board> boards ;

  public BoardController() {
    boards = new ArrayList<Board>();
  }
  
  public void load() {
    try {
      FileReader in0 = new FileReader(filename);
      BufferedReader in = new BufferedReader(in0);
      String text;
      String[] values;
      Board board ;
      while ( (text = in.readLine()) != (null) ) {
        values = text.split(",");
        board = new Board();
        board.setTitle(values[0]);
        board.setContent(values[1]);
        board.setView(Integer.parseInt(values[2]));
        board.setPassword(values[3]);
        board.setCreatedDate(Date.valueOf(values[4]));

        boards.add(board);
      }
      in.close();
      in0.close();
    } catch (Exception e){
      e.printStackTrace();
    }
  }
  public void save() throws Exception {
    FileWriter out0 = new FileWriter(filename);
    BufferedWriter out1 = new BufferedWriter(out0);
    PrintWriter out = new PrintWriter(out1);

    for (Board board : boards ) {
      out.println(board.toCSV());
    }

    out.close();
    out1.close();
    out0.close();
  }
  
  @Override
  public String toString() {
    return "board";
  }

  @Override
  public void destroy() {
    try {
      this.save();
    } catch(Exception e){
      e.printStackTrace();
    }
  }

  @Override
  public void init() {
    this.load();
  }

  @Override
  public void service(Map<String,Object> paramMap) {
    System.out.println("--------------프로젝트관리에 오신걸 환영합니다.-------------");
    keyScan = (Scanner)paramMap.get("stdin");
    String input = null;
    try {
      do {
        input = prompt();
        BoardAct(input);
      } while (!input.equals("main"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private String prompt() {
    System.out.print("게시판 관리> ");
    return keyScan.nextLine().toLowerCase();
  }

  private void BoardAct(String input) {
    try{
      if (input.equals("add")) {
        doAdd();
      } else if (input.equals("update")) {
        doUpdate();
      } else if (input.equals("list")) {
        doList();
      } else if (input.equals("delete")) {
        doDelete();
      } else if (input.equals("main")) {
        doMain();
      } else{
        doError();
      }
    } catch (IndexOutOfBoundsException e) {
        System.out.println("인덱스 유효범위를 벗어났습니다.");
    }
  }


  private void doError() {
    System.out.println("올바르지 않은 명령어입니다.");
  }

  private void doAdd() {
    Board board = new Board();

    System.out.print("게시판명 ? ");
    board.setTitle(keyScan.nextLine());
    
    System.out.print("내용 ? ");
    board.setContent(keyScan.nextLine());
    
    System.out.print("비밀번호 ? ");
    board.setPassword(keyScan.nextLine());
    board.setView(0);
    
    Calendar now = Calendar.getInstance();
    String nowstr =
             now.get(Calendar.YEAR)+"-"
            +(now.get(Calendar.MONTH)+1)+"-"
            +now.get(Calendar.DATE);//+"-"
//            +now.get(Calendar.HOUR)+"-"
//            +now.get(Calendar.MINUTE);
    board.setCreatedDate(Date.valueOf(nowstr));
    
    if (confirm("저장하시겠습니까?", true)) {
      boards.add(board);
      System.out.println("저장하였습니다.");
    } else {
      System.out.println("저장을 취소하였습니다.");
    }
  }

  private void doUpdate() {

    System.out.print("변경할 게시판 번호 입력 ? ");
    int no = Integer.parseInt(keyScan.nextLine());
    if( no >= boards.size() || no < 0) {
      doCheckNo();
      return;
    } else {
        Board board = new Board();
        System.out.printf("게시판명(%s) ? ",boards.get(no).getTitle());
        board.setTitle(keyScan.nextLine());
        
        System.out.printf("내용(%s) ? ",boards.get(no).getContent());
        board.setContent(keyScan.nextLine());
        
        System.out.printf("비밀번호 ? ");
        board.setPassword(keyScan.nextLine());
        board.setView(boards.get(no).getView());
        board.setCreatedDate(boards.get(no).getCreatedDate());
        if (confirm("변경하시겠습니까?", true)) {
          boards.set(no,board);
          System.out.println("변경하였습니다.");
        } else {
          System.out.println("변경을 취소하였습니다.");
      }
    }
  }

  private void doList() {
    for (int i = 0; i < boards.size(); i++) {
      System.out.println( i  + "  " + boards.get(i));
    }
  }
  private void doMain() {
    System.out.println("--------------메인화면 입니다.-------------------");
  }

  private void doDelete() {
    System.out.print("삭제할 게시판 번호는? ");
    int no = Integer.parseInt(keyScan.nextLine());
    if( no >= boards.size() || no < 0) {
      doCheckNo();
      return;
    } else {
      if (confirm("정말 삭제하시겠습니까?", true)) {
        boards.remove(no);
        System.out.println("삭제하였습니다.");
      } else {
        System.out.println("삭제를 취소하였습니다.");
      }
    }
  }

  private boolean confirm(String message, boolean strictMode) {
    String input = null;
    do {
      System.out.printf("%s(y/n) ", message);
      input = keyScan.nextLine().toLowerCase();

      if (input.equals("y")) {
        return true;
      } else if (input.equals("n")) {
        return false;
      } else {
        if (!strictMode) {
          return false;
        }
        System.out.println("잘못된 명령어입니다.");
      }
    } while(true);
  }

  private void doCheckNo() {
    if (boards.size() != 0) {
      System.out.printf("게시판 번호가 잘못되었습니다. (0 ~ %d)\n", boards.size() - 1);
    } else {
      System.out.println("등록된 프로젝트가 없습니다.");
    }
  }

}
