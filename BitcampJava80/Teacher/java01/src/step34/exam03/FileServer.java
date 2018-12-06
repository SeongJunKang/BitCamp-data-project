package step34.exam03;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {

  public static void main(String[] args) {
    ServerSocket serverSocket = null;
    Socket socket = null;
    
    try {
      System.out.println("서버 준비 중...");
      serverSocket = new ServerSocket(9999);
      while (true) {
        System.out.println("클라이언트 대기 중...");
        socket = serverSocket.accept();
        receiveFile(socket);
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      try {serverSocket.close();} catch (Exception e) {}
    }
  }
  
  private static void receiveFile(Socket socket) {
    DataInputStream in = null;
    PrintStream out = null;
    
    try {
      in = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));
      out = new PrintStream(socket.getOutputStream());
      
      //1) 파일명을 읽는다.
      String filename = in.readUTF();
      System.out.printf("파일명: %s\n", filename);
      
      //2) 파일의 크기를 읽는다.
      long len = in.readLong();
      System.out.printf("파일크기: %d\n", len);
      
      //3) 파일 출력 스트림을 만든다.
      FileOutputStream fileOut = new FileOutputStream("./download/" + filename);
      
      //4) 서버가 보낸 데이터를 읽어서 파일로 출력한다.
      for (long i = 0; i < len; i++) {
        fileOut.write(in.read());
      }
      
      fileOut.close();
      
      //4) 출력 완료 메시지를 보낸다.
      out.println("ok");
      
    } catch (Exception e) {
      if (out != null) {
        out.println("error");
      }
      System.out.println("클라이언트 통신 오류!");
    } finally {
      try {in.close();} catch (Exception e) {}
      try {out.close();} catch (Exception e) {}
      try {socket.close();} catch (Exception e) {}
    }
  }

}









