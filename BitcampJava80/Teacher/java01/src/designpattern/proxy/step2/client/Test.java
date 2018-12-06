/* 주제: 서버에서 Calculator 객체를 서비스하기.
 * => 이점
 *    여러 클라이언트에서 공유해 사용할 수 있다.
 * => 단점
 *    직접 객체를 만들어 사용하는 것 보다 사용법이 복잡하다. 
 * 
 */

package designpattern.proxy.step2.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Test {

  public static void main(String[] args) throws Exception {
    // 계산기 객체 사용하기
    // 1) 소켓을 통해 계산 수행
    // 2) 메서드 호출
    System.out.printf("10 + 20 = %f\n", calculate("plus", 10, 20));
    System.out.printf("10 - 20 = %f\n", calculate("minus", 10, 20));
    System.out.printf("10 * 20 = %f\n", calculate("multiple", 10, 20));
    System.out.printf("10 / 20 = %f\n", calculate("divide", 10, 20));
  }
  
  public static double calculate(String method, double a, double b) throws Exception {
    Socket socket = new Socket("localhost", 9999);
    DataInputStream in = new DataInputStream(socket.getInputStream());
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    
    out.writeUTF(method);
    out.writeDouble(a);
    out.writeDouble(b);
    
    double result = in.readDouble();
    
    try {in.close();} catch (Exception e) {}
    try {out.close();} catch (Exception e) {}
    try {socket.close();} catch (Exception e) {}
    
    return result;
  }

}






