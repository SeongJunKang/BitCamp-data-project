// 원시 타입 값을 출력하기 - java 에서 제공하는 데코레이터 사용하기
package step22$File.exam05;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
  
public class Test01 {

  public static void main(String[] args)  {
    try {
      FileOutputStream out = new FileOutputStream("exam05.Test01.data");
      // FileOutputStream 에 데코레이터를 붙인다.
      // 원시타입을 byte 단위로 쪼개서 출력하는 기능을 갖고 있다.
      // 이런 데코레이터 클래스를 "Data Processting Stream Class"라 부른다.
      DataOutputStream out2 = new DataOutputStream(out);

      short no = 17;
      int kor = 100;
      int eng = 89;
      int math = 75;

      out2.writeShort(no);
      out2.writeInt(kor);
      out2.writeInt(eng);
      out2.writeInt(math);

      // 자원을 해제할 떄 맨 마지막에 연결된 객체부터 해제하라.
      out2.close();
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
