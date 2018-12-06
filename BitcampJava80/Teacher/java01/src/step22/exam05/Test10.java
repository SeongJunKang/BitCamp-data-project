// 주제: 인스턴스 출력하기 - ObjectOutputStream 데코레이터 사용
package step22.exam05;

import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectOutputStream;

public class Test10 {
  public static void main(String[] args) throws IOException {
    Member2 m1 = new Member2("홍길동", 20, 180, 70);
    Member2 m2 = new Member2("임꺽정", 45, 178, 98);

    FileOutputStream out0 = new FileOutputStream("exam05.Test10.data");
    BufferedOutputStream out1 = new BufferedOutputStream(out0);
    ObjectOutputStream out = new ObjectOutputStream(out1);

    out.writeObject(m1);
    out.writeObject(m2);

    out.close();
    out1.close();
    out0.close();
  }






}
