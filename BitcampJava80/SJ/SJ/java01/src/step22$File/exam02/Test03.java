// 바이트 배열 출력하기

package step22$File.exam02;
import java.io.FileOutputStream;
public class Test03 {

  public static void main(String[] args) {
    try{
      FileOutputStream out = new FileOutputStream("exam02.Test03.data");
      byte[] bytes = {0x2a,0x3b,0x4c,0x5d,0x6f,0x7a};
      out.write(bytes);
      out.close();
    } catch(Exception e) {

    }
  }
}


/*

*/
