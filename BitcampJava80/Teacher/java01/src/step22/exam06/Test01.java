// 주제: 문자 출력하기
package step22.exam06;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileOutputStream;

public class Test01 {
  public static void main(String[] args) throws IOException {
    FileWriter out = new FileWriter("exam06.Test01.data");

    char c1 = '가'; // 0xAC00(UTF-16 in JVM) --> 0xEAB080(UTF-8 in OS)
    // 1010_1100_0000_0000 (UTF-16)
    // 1110_xxxx_10xx_xxxx_10xx_xxxx (UTF-8 변환 형식)
    // 1110_1010_1011_0000_1000_0000 (UTF-8) = EA_B0_80

    char c2 = 'A'; // 0x0041(UTF-16 in JVM) --> 0x41(UTF-8 in OS)

    out.write(c1); // UTF-16 --> UTF-8 변환하여 출력한다.
    out.write(c2); // UTF-16 --> UTF-8 변환하여 출력한다.

    out.close();

    FileOutputStream out2 = new FileOutputStream("exam06.Test01.data2");
    out2.write(c1); // 맨 끝 1바이트 출력 --> 00
    out2.write(c2); // 맨 끝 1바이트 출력 --> 41
    out2.close();
  }





}
