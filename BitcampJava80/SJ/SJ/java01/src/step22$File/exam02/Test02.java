// 바이트 출력하기

package step22$File.exam02;
import java.io.FileOutputStream;
public class Test02 {

  public static void main(String[] args) {

    try{
      FileOutputStream out = new FileOutputStream("exam02.Test02.data");
      int value = 0x2a3b4c5d; //708529245
      for (int i = 24; i >= 0 ; i-=8 ) {
          out.write(value>>i);
      }
      out.close();
    } catch(Exception e) {

    }
  }
}


/*
*/
