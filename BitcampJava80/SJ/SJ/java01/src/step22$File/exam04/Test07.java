// 주제 : 원시 타입 값을 출력하기.- Refactoring(코드개선3) : Decorator 패턴
package step22$File.exam04;

import java.io.IOException;
import java.io.FileOutputStream;

public class Test07 {

  public static void main(String[] args)  {
    try {
      // 실제로 작업을 수행할 객체 원본은 있어야한다.
      FileOutputStream out = new FileOutputStream("exam04.Test07.data");

      // 작업할 객체에 보조기능을 장착한다.
      // 보조 기능을 가진 객체를 Decorator 라 부른다.
      // 보조 기능은 필요할 때 언제나 붙일 수 있다.
      // 필요 없으면 떼면 된다.
      OutputStreamDecorator1 d1 = new OutputStreamDecorator1(out);
      OutputStreamDecorator2 d2 = new OutputStreamDecorator2(d1);

      short no = 17;
      int kor = 100;
      int eng = 89;
      int math = 75;
      d2.writeShort(no);
      d1.writeInt(kor);
      d1.writeInt(eng);
      d1.writeInt(math);

      d2.close();
      d1.close();
      out.close();
      
    } catch(IOException e) {}
      catch(NullPointerException e){}

  }
}



/*
# Decorator patton
 - 기능을 선택적으로 추가 /삭제 할 수 있다.
 - 상속은 불가!

# Java I/O API
  - Decorator patton 이 적용되어 있다.

*/
