// 주제 : 원시 타입 값을 출력하기.- Refactoring(코드개선2) : 클래스화
package step22$File.exam04;
import java.io.FileOutputStream;
import java.io.IOException;
public class Test04 {

  public static void main(String[] args)  {
    try {
      FileOutputStream out = new FileOutputStream("exam04.Test04.data");
      short no = 17;
      int kor = 100;
      int eng = 89;
      int math = 75;
      MyDataOutputStream2.out = out;
      MyDataOutputStream2.writeOut(no);
      MyDataOutputStream2.writeOut(kor);
      MyDataOutputStream2.writeOut(eng);
      MyDataOutputStream2.writeOut(math);

      out.close();
    } catch(IOException e) {}
      catch(NullPointerException e){}

  }
}



/*
#
*/
