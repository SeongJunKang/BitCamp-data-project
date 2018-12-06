package quiz;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class PMSClient {
  static Scanner keyScan = new Scanner(System.in);
  Socket socket;
  Scanner in;
  PrintStream out;
  
  public PMSClient(String server, int port) throws Exception {
      socket = new Socket(server, port);
      in = new Scanner(new BufferedInputStream(socket.getInputStream()));
      out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
  }
  public void close() {
    try {in.close();} catch (Exception e) {}
    try {out.close();} catch (Exception e) {}
    try {socket.close();} catch (Exception e) {}
  }
  
  public void execute() {
    String command = null;
    do {
      command = sendCommand();
      receiveMessage();
    } while (!command.equals("quit"));
    
    keyScan.close();
  }
  
  private String sendCommand(){
  System.out.print("명령? ");
  String command = keyScan.nextLine();
  out.println(command);
  out.flush();
  return command;
  //out.println(keyScan.nextLine());
}
  
  private String sendCommand(String command){
//    System.out.print("명령? ");
//    String command = keyScan.nextLine();
    out.println(command);
    out.flush();
    return command;
    //out.println(keyScan.nextLine());
  }
  
  private void receiveMessage() {
    String message = null;
    do {
      message = in.nextLine(); //읽는다. 서버로부터
      System.out.println(message);
    } while (!message.equals(""));
  }
  
  public static void main(String[] args) {
    System.out.print("서버? ");
    String server = keyScan.nextLine();
    
    System.out.print("포트번호? ");
    int port = Integer.parseInt(keyScan.nextLine());
    PMSClient client = null;
    try {
    client = new PMSClient(server, port);
    client.menu();
//    client.execute();
    
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      client.close();
    }
  }
  
  public void menu() {
    while (true) {
      System.out.println("1. 강사관리");
      System.out.println("2. 강의관리");
      System.out.println("3. 강사배정");
      System.out.println("4. 나가기");
      System.out.print("명령? ");
      String command = keyScan.nextLine();
      if (command.equals("1")) {
        doTa();
      } else if (command.equals("2")) {
        doLe();
      } else if (command.equals("3")) {
        doTe();
      } else if (command.equals("4")) {
        break;
      }
    }
  }
  private void doTa() {
    while (true) {
      System.out.println("1. 추가");
      System.out.println("2. 삭제");
      System.out.println("3. 변경");
      System.out.println("4. 보기");
      System.out.println("5. 나가기");
      System.out.print("명령? ");      
      String command = keyScan.nextLine();
      if (command.equals("1")) {       
        execute();
      } else if (command.equals("2")) {
        execute();
      } else if (command.equals("3")) {
        execute();
      } else if (command.equals("4")) {
        sendCommand("teacher/list.do");
        receiveMessage();
      } else if (command.equals("5")) {
        break;
      }      
    }
  }
  private void doLe() {
    while (true) {
      System.out.println("1. 추가");
      System.out.println("2. 삭제");
      System.out.println("3. 변경");
      System.out.println("4. 보기");
      System.out.println("5. 나가기");
      System.out.print("명령? ");
      String command = keyScan.nextLine();
      if (command.equals("1")) {
        execute();
      } else if (command.equals("2")) {
        execute();
      } else if (command.equals("3")) {
        execute();
      } else if (command.equals("4")) {
        sendCommand("lects/list.do");
        receiveMessage();
      } else if (command.equals("5")) {
        break;
      }      
    }
    
  }
  private void doTe() {
    while (true) {
      System.out.println("1. 추가");
      System.out.println("2. 삭제");
      System.out.println("3. 변경");
      System.out.println("4. 보기");
      System.out.println("5. 나가기");
      System.out.print("명령? ");
      String command = keyScan.nextLine();
      if (command.equals("1")) {
        execute();
      } else if (command.equals("2")) {
        execute();
      } else if (command.equals("3")) {
        execute();
      } else if (command.equals("4")) {
        sendCommand("ta/assign.do");
        receiveMessage();
      } else if (command.equals("5")) {
        break;
      }
    }
  }
}

