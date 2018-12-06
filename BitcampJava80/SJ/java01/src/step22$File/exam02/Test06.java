// 바이트 읽기

package step22$File.exam02;
import java.io.FileInputStream;
public class Test06 {
  public static void main(String[] args) {
    try {
      FileInputStream in = new FileInputStream("exam02.Test05.data");
      int b ;
      while( (b = in.read()) >= 0 ) {
        if(b == 10)
          System.out.println("a");
        else
          System.out.print(Integer.toHexString(b)+ " ");
      }
      in.close();
    } catch(Exception e) {
    }
  }
}


/*

*/
