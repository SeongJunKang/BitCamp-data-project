// 주제 : 원시 타입 값을 출력하기.- Refactoring(코드개선) : 메서드 사용
package step22$File.exam04;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
public class Test02 {

  public static void main(String[] args)  {
    try {
      FileOutputStream out = new FileOutputStream("exam04.Test01.data");
      short no = 17;
      int kor = 100;
      int eng = 89;
      int math = 75;

      writeOut(out,no);
      writeOut(out,kor);
      writeOut(out,eng);
      writeOut(out,math);

      out.close();
    } catch(IOException e) {}

  }

  private static void writeOut(OutputStream out, int value) {
    try {
      for (int i = 0;i <= 3 ; i++ ) {
        out.write(value >> 24 - 8 * i);
      }
    } catch(IOException e) {}
  }

  private static void writeOut(OutputStream out, short value) {
    try {
      for (int i = 0;i <= 2 ; i++ ) {
        out.write(value >> 16 - 8 * i);
      }
    } catch(IOException e) {}
  }
}



/*
#
*/
