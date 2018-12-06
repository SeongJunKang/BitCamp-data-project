// 주제: 원시 타입 값을 출력하기 - Refactoring(코드 개선) : 상속
package step22.exam04;

import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Test07 {
  public static void main(String[] args) throws IOException {
    MyDataOutputStream4 out = new MyDataOutputStream4("exam04.Test06.data");

    short no = 17;
    int kor = 100;
    int eng = 89;
    int math = 75;

    out.writeShort(no);
    out.writeInt(kor);
    out.writeInt(eng);
    out.writeInt(math);

    out.close();
  }






}
