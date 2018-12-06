/* 기능 요구사항
 *  목록 --> 제목 , 조회수, 생성일
 *  추가 --> 제목 , 내용, 암호
 *  변경 --> 제목 , 내용, 암호
 *  삭제 --> 인덱스로 삭제할 게시물 지정.
 */
 package bitcamp.pms.controller;

 import java.util.*;
 import java.io.*;
 import java.sql.Date;
 import java.lang.*;
 import bitcamp.pms.domain.Board;
 import bitcamp.pms.annotation.Component;

 @Component("board")
 public class BoardController implements MenuController {
   static final String filename = "board.data";
   Scanner keyScan;
   ArrayList<Board> boards;

   public BoardController ( ) {
     boards = new ArrayList<>();
   }

   @Override
   public void init () {
     try{
     FileReader in0 = new FileReader(filename);
     BufferedReader in = new BufferedReader(in0);

     String line;
     String[] values;
     Board board;
     while((line = in.readLine())!=null) {
       values = line.split(",");
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
   }catch(Exception e) {
     System.out.println("데이터 로딩 실패");
   }
   }
   @Override
   public void destroy() {
     try{
     FileWriter out0 = new FileWriter(filename);
     BufferedWriter out1 = new BufferedWriter(out0);
     PrintWriter out = new PrintWriter(out1);


     for (Board board : boards){
       out.println(board.toCSV());
     }


     out.close();
     out1.close();
     out0.close();
   } catch(Exception e) {
     System.out.println("데이터 저장 실패");
   }
   }




 public String prompt() {
     System.out.print("게시판관리> ");
     return keyScan.nextLine().toLowerCase();
   }
   @Override
   public void service(Map<String,Object> paramMap) {
     keyScan = (Scanner)paramMap.get("stdin");
     String input="";
     while (!input.equals("main")) {
       try {
     input = prompt();
     if(input.equals("add")) {
       doAdd();
     } else if(input.equals("update")) {
       doUpdate();
     } else if (input.equals("delete")) {
       doDelete();
     } else if (input.equals("list")) {
       doList();
     } else if(input.equals("main")){
     } else {
       System.out.println("잘못된 명령입니다.");
     }
   } catch(IndexOutOfBoundsException e){
     System.out.println("유효한 인덱스가 아닙니다.");
   } catch (Exception e) {
     System.out.println("오류발생 !");
   }
   }
   }

   public void doAdd() {
      Board board = new Board();
      System.out.print("게시판명? ");
      board.setTitle(keyScan.nextLine());
      System.out.print("내용? ");
      board.setContent((keyScan.nextLine()));
      System.out.print("암호? ");
      board.setPassword((keyScan.nextLine()));
      board.setCreatedDate(new Date(System.currentTimeMillis()));


      if (confirm("저장하시겠습니까")) {
        boards.add(board);
        System.out.println("저장되었습니다.");
      } else {
        System.out.println("저장이 취소되었습니다.");
      }

   }
     public void doUpdate() {
          Board board = new Board();
          System.out.print("변경하실 게시물 번호? ");
          int no = Integer.parseInt(keyScan.nextLine());
          System.out.printf("게시물명(%s)? ",boards.get(no).getTitle());
          board.setTitle(keyScan.nextLine());
          System.out.printf("내용(%s)? ",boards.get(no).getContent());
         board.setContent(keyScan.nextLine());
          System.out.printf("암호? ");
          board.setPassword(keyScan.nextLine());

          board.setCreatedDate(new Date(System.currentTimeMillis()));


          if (confirm("변경하시겠습니까")) {
            boards.set(no,board);
            System.out.println("변경되었습니다.");
          } else {
            System.out.println("변경이 취소되었습니다.");
          }
     }
       public void doDelete() {
         System.out.print("삭제하실 게시물 번호? ");
         int no = Integer.parseInt(keyScan.nextLine());
         if (confirm("삭제하시겠습니까")) {
           boards.remove(no);
           System.out.println("삭제되었습니다.");
         } else {
           System.out.println("삭제가 취소되었습니다.");
         }
       }
         public void doList() {
             for(int i = 0; i < boards.size(); i++) {
               System.out.printf("%d, %s\n", i, boards.get(i).toString());
             }
         }

           public boolean confirm(String msg) {
             System.out.printf("%s (y/n)? ",msg);
             String input;
             while(true){

               input = keyScan.nextLine().toLowerCase();
               if(input.equals("y")) {
                 return true;
               } else if(input.equals("n")) {
                 return false;
               } else {
                 System.out.print("다시 입력하세요. ");
               }

             }
           }









 }
