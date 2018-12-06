package step22$File.exam04;
import java.io.IOException;
import java.io.FileOutputStream;
public class MyDataOutputStream4 extends FileOutputStream {

  public MyDataOutputStream4(String name) throws IOException {
    super(name);
  }
  // 생성자의 존재 이유?
  // => 객체를 사용하는 필요한 최소한의 준비를 시키는 것.
  public void writeOut(int value) {
    try {
      for (int i = 0;i <= 3 ; i++ ) {
        this.write(value >> 24 - 8 * i);
      }
    } catch(IOException e) {}
  }
  public void writeOut(short value) {
    try {
      for (int i = 0;i < 2 ; i++ ) {
        this.write(value >> 8 - 8 * i);
      }
    } catch(IOException e) {}
  }
}
