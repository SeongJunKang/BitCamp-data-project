// 주제: 원시 타입 값을 출력하기 - Refactoring(코드 개선) : 클래스 사용
package step22.exam04;

import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Test03 {
  public static void main(String[] args) throws IOException {
    FileOutputStream out = new FileOutputStream("exam04.Test03.data");

    short no = 17;
    int kor = 100;
    int eng = 89;
    int math = 75;

    MyDataOutputStream.writeShort(out, no);
    MyDataOutputStream.writeInt(out, kor);
    MyDataOutputStream.writeInt(out, eng);
    MyDataOutputStream.writeInt(out, math);

    out.close();
  }






}
