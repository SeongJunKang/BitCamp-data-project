package step22$File.exam04;
import java.io.IOException;
import java.io.OutputStream;
public class MyDataOutputStream3 {

  private OutputStream out;
  public MyDataOutputStream3(OutputStream date) {
    this.out = date;
  }
  // 생성자의 존재 이유?
  // => 객체를 사용하는 필요한 최소한의 준비를 시키는 것.
  public void writeOut(int value) {
    try {
      for (int i = 0;i <= 3 ; i++ ) {
        out.write(value >> 24 - 8 * i);
      }
    } catch(IOException e) {}
  }
  public void writeOut(short value) {
    try {
      for (int i = 0;i < 2 ; i++ ) {
        out.write(value >> 16 - 8 * i);
      }
    } catch(IOException e) {}
  }
}
