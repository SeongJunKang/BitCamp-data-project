// 원시 타입 값을 출력하기 - java 에서 제공하는 데코레이터 사용하기
package step22$File.exam06;

import java.io.IOException;
import java.io.FileReader;
import java.io.FileInputStream;

public class Test02 {
  public static void main(String[] args)  {
    try {
      FileReader in = new FileReader("exam06.Test01.data");

      int c;
      while ((c = in.read()) >= 0) {
        System.out.println(Integer.toHexString(c));     //UTF8 -->UTF16
        // 데이터가 UTF-8(OS 기본 문자 집합)이라고 간주하고
        // 해당 바이트 들을 읽어서 2바이트 UTF-16 으로 변환하여 리턴한다.
        // -->binary 데이터를 FileReader 를 사용해서 읽으면 안된다.
      }
      in.close();
      System.out.println("----------------------------------");



      FileInputStream in2 = new FileInputStream("exam06.Test01.data");
      while ((c = in2.read()) >= 0) {
        System.out.println(Integer.toHexString(c));    //UTF8
      }
      in2.close();

    } catch(IOException e) {}
      catch(NullPointerException e){}

  }
}



/*

*/
