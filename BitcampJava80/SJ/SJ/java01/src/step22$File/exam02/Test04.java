// 바이트 출력하기

package step22$File.exam02;
import java.io.FileOutputStream;
public class Test04 {

  public static void main(String[] args) {
    try{
      FileOutputStream out = new FileOutputStream("exam02.Test04.data");
      byte[] bytes = {0x2a,0x3b,0x4c,0x5d,0x6f,0x7a};
      out.write(bytes,2,3);
      out.close();
    } catch(Exception e) {

    }
  }
}


/*
* OffSet
  - 자바 JVM 에서 절대적인 주소가 아닌 상대적인 주소를 표현.
*/
