package step22$File.exam04;
import java.io.IOException;
import java.io.OutputStream;
public class MyDataOutputStream {

  static void writeOut(OutputStream out, int value) {
    try {
      for (int i = 0;i <= 3 ; i++ ) {
        out.write(value >> 24 - 8 * i);
      }
    } catch(IOException e) {}
  }

  static void writeOut(OutputStream out, short value) {
    try {
      for (int i = 0;i <= 2 ; i++ ) {
        out.write(value >> 16 - 8 * i);
      }
    } catch(IOException e) {}
  }
}
