// 주제: 원시 타입 값을 출력하기 - Refactoring(코드 개선) : 스태틱 변수 사용
package step22.exam04;

import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Test04 {
  public static void main(String[] args) throws IOException {
    FileOutputStream out = new FileOutputStream("exam04.Test04.data");

    short no = 17;
    int kor = 100;
    int eng = 89;
    int math = 75;

    MyDataOutputStream2.out = out;
    MyDataOutputStream2.writeShort(no);
    MyDataOutputStream2.writeInt(kor);
    MyDataOutputStream2.writeInt(eng);
    MyDataOutputStream2.writeInt(math);

    out.close();
  }






}
