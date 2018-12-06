package step34$Server_Client.exam03;

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
      System.out.println("사용법 : FileClinet 서버주소 파일경로");
    }
    String serverAddress = args[0];
    File file= new File(args[1]);
    Socket socket = null;
    BufferedInputStream filein = null;
    
    if (!file.exists() || !file.isFile()) {
      System.out.println("유효하지 않은 파일 경로입니다.");
      return;
    }
    // 파일에서 읽기
    Scanner in = null;
    // 서버에서 읽기
    DataOutputStream out = null;
    try {
        filein = new BufferedInputStream(new FileInputStream(file));
        socket = new Socket(serverAddress, 9999);
        in= new Scanner(socket.getInputStream());
        out = new DataOutputStream (
            new BufferedOutputStream(socket.getOutputStream()));
        // 1. 파일명을 보낸다
        out.writeUTF(file.getName());
        System.out.println("파일명 : "+ file.getName());
        
        // 2. 파일의 크기를 보낸다.
        out.writeLong(file.length());
        // 3. 서버에 전송한다.
        int b;
        while ((b = filein.read()) > -1) {
          out.write(b);
          System.out.print(".");
          // BufferedOutputStream 에서는
          // 내부 버퍼 메모리에 출력 데이터가 꽉 찰 때 서버에 전송한다.
          // Write()를 호출할 때 마다 서버에 전송하는 것이 아니다.
        }
        out.flush();
        String message = in.nextLine();
        if(message.equals("ok")) {
          System.out.println("전송 성공");
        } else {
          System.out.println("전송 실패");
        }
        
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      try{ out.close(); }catch(Exception e) {}
      try{ in.close(); }catch(Exception e) {}
      try{ socket.close(); }catch(Exception e) {}
      try{ filein.close(); }catch(Exception e) {}
    }
  }
}
