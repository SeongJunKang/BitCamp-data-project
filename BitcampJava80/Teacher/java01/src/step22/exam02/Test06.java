// 주제: 바이트 읽기2
package step22.exam02;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;

public class Test06 {
  public static void main(String[] args) throws IOException {
    FileInputStream in = new FileInputStream("exam02.Test05.data");

    int b;
    while ((b = in.read()) != -1) {
      System.out.println(Integer.toHexString(b));
    }

    // 주의! OS 자원을 사용하는 경우, 사용 후 반드시 해제해야 한다.
    in.close();
  }
}
