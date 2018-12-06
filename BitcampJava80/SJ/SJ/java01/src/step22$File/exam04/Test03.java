// 주제 : 원시 타입 값을 출력하기.- Refactoring(코드개선2) : 클래스화
package step22$File.exam04;
import java.io.FileOutputStream;
import java.io.IOException;
public class Test03 {

  public static void main(String[] args)  {
    try {
      FileOutputStream out = new FileOutputStream("exam04.Test01.data");
      short no = 17;
      int kor = 100;
      int eng = 89;
      int math = 75;

      MyDataOutputStream.writeOut(out,no);
      MyDataOutputStream.writeOut(out,kor);
      MyDataOutputStream.writeOut(out,eng);
      MyDataOutputStream.writeOut(out,math);

      out.close();
    } catch(IOException e) {}
  }
}



/*
#
*/
