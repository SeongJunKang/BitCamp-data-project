// 주제 : 원시 타입 값을 출력하기.
package step22$File.exam04;
import java.io.FileOutputStream;
public class Test01 {

  public static void main(String[] args)  {
    try {
      FileOutputStream out = new FileOutputStream("exam04.Test01.data");
      short no = 17;
      int kor = 100;
      int eng = 89;
      int math = 75;

      for (int i = 8;i >= 0 ; i-=8 ) {
        out.write(no>>i);
      }
      for (int i = 24;i >= 0 ; i-=8 ) {
        out.write(kor>>i);
      }
      for (int i = 24;i >= 0 ; i-=8 ) {
        out.write(eng>>i);
      }
      for (int i = 24;i >= 0 ; i-=8 ) {
        out.write(math>>i);
      }

      out.close();
    } catch (Exception e) {}

  }
}


/*
#
*/
