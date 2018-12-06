// 주제 : 원시 타입 값을 출력하기.- Refactoring(코드개선3) : 인스턴스화
package step22$File.exam04;
import java.io.FileOutputStream;
import java.io.IOException;
public class Test05 {

  public static void main(String[] args)  {
    try {
      FileOutputStream out = new FileOutputStream("exam04.Test05.data");
      MyDataOutputStream3 data = new MyDataOutputStream3(out);
      short no = 17;
      int kor = 100;
      int eng = 89;
      int math = 75;
      data.writeOut(no);
      data.writeOut(kor);
      data.writeOut(eng);
      data.writeOut(math);

      out.close();
    } catch(IOException e) {}
      catch(NullPointerException e){}

  }
}



/*
#
*/
