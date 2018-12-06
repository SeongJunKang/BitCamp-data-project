// 바이트 읽기

package step22$File.exam02;
import java.io.FileInputStream;
public class Test08 {
  public static void main(String[] args) {
    try {
      FileInputStream in = new FileInputStream("exam02.Test05.data");
      byte[] buf = new byte[100];
      int len = in.read(buf,10,3); // 10번방부터 최대 3개
      len = in.read(buf,10 +len,5); // 13번방부터 최대 5개

      for (int i = 0; i <20 ; i++ ) {
        System.out.println(Integer.toHexString(buf[i]));
      }
      in.close();
    } catch(Exception e) {
    }
  }
}


/*

*/
