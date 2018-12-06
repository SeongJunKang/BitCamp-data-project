package step34$Server_Client.exam03;

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
      System.out.println("서버 준비중");
      serverSocket = new ServerSocket(9999);
      while (true) {
        System.out.println("클라이언트 대기중...");
        socket = serverSocket.accept();
        receiveFile(socket);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try{serverSocket.close();} catch(Exception e) {}
    }

  }
  private static void receiveFile(Socket socket) {
    PrintStream out = null;
    DataInputStream in = null;
    FileOutputStream fileOut =null;
    try{
      in = new DataInputStream (new 
                    BufferedInputStream(socket.getInputStream()));
      out = new PrintStream(socket.getOutputStream());
      //1) 파일명을 읽는다.
      String filename = in.readUTF();
      System.out.println("파일명 : "+filename);
      //2) 파일의 크기를 읽는다.
      long filesize = in.readLong();
      System.out.println("파일크기 : "+ filesize);
      //3) 출력 스트림을 만든다.
      fileOut= new FileOutputStream("./download/"+filename);
      //4) 서버가 보낸 데이터를 읽어서 파일로 출력한다.
      for (int i = 0; i < filesize; i++) {
        fileOut.write(in.read());
      }
      
      out.println("ok");
      System.out.println("전송 완료");
      
      } catch(Exception e) {
        e.printStackTrace();
        if (out != null) {
          out.println("error");
        }
        System.out.println("클라이언트 통신 오류");
      } finally {
        try{ in.close(); }catch(Exception e) {}
        try{ fileOut.close(); }catch(Exception e) {}
        try{ out.close(); }catch(Exception e) {}
        try{socket.close();} catch(Exception e) {}
      }
  }
}
