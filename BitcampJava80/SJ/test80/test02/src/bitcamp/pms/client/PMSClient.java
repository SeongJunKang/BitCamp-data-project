package bitcamp.pms.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class PMSClient {
  Socket socket;
  Scanner in;
  PrintStream out;
  static Scanner keyScan = new Scanner(System.in);

  public PMSClient(String server, int port) throws Exception {
    socket = new Socket(server, port);
    in = new Scanner(new BufferedInputStream(socket.getInputStream()));
    out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
  }

  public void close() {
    try {
      in.close();
    } catch (Exception e) {
    }
    try {
      out.close();
    } catch (Exception e) {
    }
    try {
      socket.close();
    } catch (Exception e) {
    }
  }

  public void execute() {
    String command = null;
    do {
      command = sendCommand(keyScan);
      receiveMessage();
    } while (!command.equals("quit"));
    keyScan.close();
  }

  private String sendCommand(Scanner keyScan) {
    System.out.print("명령? ");
    String command = keyScan.nextLine();
    out.println(command);
    out.flush();
    return command;
  }

  private void receiveMessage() {
    String message = null;
    do {
      message = in.nextLine();
      System.out.println(message);
    } while (!message.equals(""));
  }

  public static void main(String[] args) {
    try {
      System.out.print("서버? ");
      String server = keyScan.nextLine();
      int port = 9999;
      try {
        System.out.print("포트번호? ");
        port = Integer.parseInt(keyScan.nextLine());
      } catch (Exception e) {
        System.out.println("포트번호 오류. default 9999.");
      }
      System.out.println("명령어 모음 \n-roomsHelp,teachsHelp,assignHelp,lectsHelp");
      PMSClient client = null;
      try {
        client = new PMSClient(server, port);
        client.execute();
      } catch (Exception e) {
      } finally {
        client.close();
      }
    } catch (Exception e) {
      System.out.println("서버연결 실패.");
    }

  }
  /*
   lects/add.do?title=새거&description=맞아&startdate=2011-05-05&enddate=2012-12-12&deadline=2010-10-10&totalhour=960&dayhour=10
   lects/regist.do?no=&rno=K001
   lects/delete.do?no=
   lects/list.do
   lects/update.do?no=2&title=바뀐다&description=바꼇다&startdate=2011-10-10&enddate=2012-12-12&deadline=2010-10-10&totalhour=960&dayhour=10&rno=k001
   
   rooms/add.do?rno=G001&rnm=구리
   rooms/update.do?rno=K001&rnm=천호
   
   teaAssign/add.do?lno=2&tno=1
   teaAssign/delete.do?lno=2&tno=2
   teaAssign/update.do?tano=6&lno=2&tno=2&stdt=2020-02-02&endt=2020-06-06&desct=java90
   
   teachs/add.do?tnm=김선생&tel=111-1111&email=kim@test.com
   teachs/add.do?tnm=김선생&tel=111-1111&email=kim@test.com
   */
  
}
