// 주제: 바이트 출력하기2
package step22.exam02;

import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;

public class Test02 {
  public static void main(String[] args) throws IOException {
    FileOutputStream out = new FileOutputStream("exam02.Test02.data");

    int value = 0x2a3b4c5d; // 7_0852_9245(10진수)

    out.write(value >> 24); // 비록 파라미터 타입이 int라 하더라도 맨 끝 1바이트만 출력.
    out.write(value >> 16);
    out.write(value >> 8);
    out.write(value);

    // 주의! OS 자원을 사용하는 경우, 사용 후 반드시 해제해야 한다.
    out.close();
  }
}
