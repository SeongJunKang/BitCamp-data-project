package designPattern.proxy.step03.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import designPattern.proxy.step03.server.Calculator;

// 실제 서비스를 하는 객체와 같은 인터페이스를 구현하지만,
// 사실상 작업 요청이 들어오면 실제 서비스에게 위험하다.
public class CalcStub implements Calculator {

  String host;
  int port;

  public CalcStub() {
    this.host = "localhost";
    this.port = 9999;
  }

  private double calculate(String method, double a, double b) {
    try(// closable 구현체인 경우 여기에 객체를 선언하면
        // try 블록을 나갈 때 자동으로 close()를 호출해준다.
        Socket socket = new Socket(this.host, this.port);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    ) {
      out.writeUTF(method);
      out.writeDouble(a);
      out.writeDouble(b);
      return in.readDouble();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public double plus(double a, double b) {
    return calculate("plus", a, b);
  }

  @Override
  public double minus(double a, double b) {
    return calculate("minus", a, b);
  }

  @Override
  public double multiple(double a, double b) {
    return calculate("multiple", a, b);
  }

  @Override
  public double divide(double a, double b) {
    return calculate("divide", a, b);
  }

}
