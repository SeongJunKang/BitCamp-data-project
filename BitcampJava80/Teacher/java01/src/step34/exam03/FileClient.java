package step34.exam03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.Scanner;

public class FileClient {

  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("사용법: FileClient 서버주소 파일경로");
      return;
    }
    
    String serverAddress = args[0];
    File file = new File(args[1]);
    
    if (!file.exists() || !file.isFile()) {
      System.out.println("유효하지 않은 파일경로입니다.");
      return;
    }
    
    Socket socket = null;
    BufferedInputStream fileIn = null;
    Scanner in = null;
    DataOutputStream out = null;
    
    try {
      fileIn = new BufferedInputStream(new FileInputStream(file));
      socket = new Socket(serverAddress, 9999);
      in = new Scanner(socket.getInputStream());
      out = new DataOutputStream(
                new BufferedOutputStream(socket.getOutputStream()));
      
      //1) 파일명을 보낸다.
      out.writeUTF(file.getName());
      System.out.println("파일명 전송");
      
      //2) 파일의 크기를 보낸다.
      out.writeLong(file.length());
      System.out.println("파일크기 전송");
      
      //3) 파일을 전송한다.
      int b;
      while ((b = fileIn.read()) != -1) {
        out.write(b);
        // BufferedOutputStream에서는
        // 내부 버퍼 메모리에 출력 데이터가 꽉 찰 때 서버에 전송한다.
        // write()를 호출할 때 마다 서버에 전송하는 것이 아니다.
      }
      out.flush(); // 버퍼의 잔여 내용 강제 송출.
      
      String message = in.nextLine();
      if (message.equals("ok")) {
        System.out.println("전송 완료했습니다.");
      } else {
        System.out.println("전송 실패입니다.");
      }
      
    } catch (Exception e) {
      e.printStackTrace();

    } finally {  
      try {out.close();} catch (Exception e) {}
      try {in.close();} catch (Exception e) {}
      try {socket.close();} catch (Exception e) {}
    }
  }
}







