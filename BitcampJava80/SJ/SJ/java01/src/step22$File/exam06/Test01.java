// 원시 타입 값을 출력하기 - java 에서 제공하는 데코레이터 사용하기
package step22$File.exam06;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileOutputStream;

public class Test01 {
  public static void main(String[] args)  {
    try {
      FileWriter out = new FileWriter("exam06.Test01.data");
      char c1 = '가';  //0xAC00 UTF16 in JVM   --> 0xEAB080 UTF8 in OS
      // 1010_1100_0000_0000
      // 1110_xxxx_10xx_xxxx_10xx_xxxx UTF8 변환 형식
      // 1110_1010_1011_0000_1000_0000 EA_B0_80
      char c2 = 'A';   //0x0041 UTF16 in JVM --> 0x41 UTF8

      out.write(c1);
      out.write(c2);
      out.close();

      FileOutputStream out2 = new FileOutputStream("exam06.Test01.data2");
      out2.write(c1);
      out2.write(c2);
      out2.close();

    } catch(IOException e) {}
      catch(NullPointerException e){}

  }
}

/*

*/
