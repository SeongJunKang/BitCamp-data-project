/* 서버에서 calculator 객체 실행하기
 *  => 이점 
 *    여러 클라이언트에서 공유해 사용할 수 있다
 *  => 단점
 *    직접 객체를 만들어 사용하는 것 보다 사용법이 복잡하다.
 */

package designPattern.proxy.step02.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Test {

  public static void main(String[] args) throws IOException{
    System.out.println("10 + 20 = " +calculate("plus",10, 20));
    System.out.println("10 - 20 = " +calculate("minus",10, 20));
    System.out.println("10 * 20 = " +calculate("multiple",10, 20));
    System.out.println("10 / 20 = " +calculate("divide",10, 20));
    System.out.println("오호라");
  }
  public static double calculate(String method, double a, double b)  throws IOException{
    Socket socket = new Socket("localhost",9999);
    DataInputStream in = new DataInputStream(socket.getInputStream());
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    
    out.writeUTF(method);
    out.writeDouble(a);
    out.writeDouble(b);
    double result = in.readDouble();
    
    try{in.close();}catch(Exception e) {}
    try{out.close();}catch(Exception e) {}
    try{socket.close();}catch(Exception e) {}
    return result;
  }
}
