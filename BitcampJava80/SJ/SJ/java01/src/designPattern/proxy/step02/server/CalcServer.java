package designPattern.proxy.step02.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CalcServer {
  //원격의 요청을 처리할 비즈니스 객체
  static Calculator calc = new Calculatorimpl();
  public static void main(String[] args) throws IOException {
    ServerSocket ss = new ServerSocket(9999);
    System.out.println("서버실행중");
    while (true) {
      service(ss.accept());
    }
  }
  
  public static void service(Socket socket) throws IOException {
    DataInputStream in = new DataInputStream(socket.getInputStream());
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    
    String method = in.readUTF();
    double a = in.readDouble();
    double b = in.readDouble();
    double result = 0;
    switch (method) {
    case "plus":
      result = calc.plus(a, b);
      break;
    case "minus":
      result = calc.minus(a, b);
      break;
    case "multiple":
      result = calc.multiple(a, b);
      break;
    case "divide":
      result = calc.divide(a, b);
      break;
    default:
      return ;
    }
    
    out.writeDouble(result);
    try{in.close();}catch(Exception e) {}
    try{out.close();}catch(Exception e) {}
    try{socket.close();}catch(Exception e) {}
  }
}
