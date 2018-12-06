// 바이트 읽기

package step22$File.exam02;
import java.io.FileInputStream;
public class Test05 {
  public static void main(String[] args) {
    try {
      FileInputStream in = new FileInputStream("exam02.Test05.data");
      int b = in.read();
      System.out.println(Integer.toHexString(b));
      b = in.read();
      System.out.println(Integer.toHexString(b));
      b = in.read();
      System.out.println(Integer.toHexString(b));

      in.close();
    } catch(Exception e) {
    }
  }
}


/*

*/
