package step22$File.exam04;
import java.io.IOException;
import java.io.OutputStream;
public class OutputStreamDecorator1 extends OutputStream {

  OutputStream base;

  @Override
  public void write(int b) throws IOException {    //상속받은 기능을 쓰는 대신
      base.write(b);                   // 생성자에 받은 객체 기능을 사용한다.
  }


  public OutputStreamDecorator1(OutputStream base) throws IOException {
    this.base = base;
  }
  // 생성자의 존재 이유?
  // => 객체를 사용하는 필요한 최소한의 준비를 시키는 것.
  public void writeInt(int value) {
    try {
      for (int i = 0;i <= 3 ; i++ ) {
        this.write(value >> 24 - 8 * i);
      }
    } catch(IOException e) {}
  }

}
