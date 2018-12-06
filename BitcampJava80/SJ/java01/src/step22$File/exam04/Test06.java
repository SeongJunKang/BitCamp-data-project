// 주제 : 원시 타입 값을 출력하기.- Refactoring(코드개선3) : 인스턴스화
package step22$File.exam04;

import java.io.IOException;
public class Test06 {

  public static void main(String[] args)  {
    try {
      MyDataOutputStream4 out = new MyDataOutputStream4("exam04.Test06.data");
      short no = 17;
      int kor = 100;
      int eng = 89;
      int math = 75;
      out.writeOut(no);
      out.writeOut(kor);
      out.writeOut(eng);
      out.writeOut(math);

      out.close();
    } catch(IOException e) {}
      catch(NullPointerException e){}

  }
}



/*
#
*/
