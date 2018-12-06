// 주제 : 원시 타입 값을 읽기.-> Java 에서 제공하는 데코레이터 사용하기
package step22$File.exam04;

import java.io.IOException;
import java.io.FileInputStream;

public class Test08 {

  public static void main(String[] args)  {
    try {
      FileInputStream in = new FileInputStream("exam04.Test06.data");
      MyDataInputStream in2 = new MyDataInputStream(in);    // <--  데코레이터

      short no = in2.readShort();
      int kor = in2.readInt();
      int eng = in2.readInt();
      int math = in2.readInt();


      System.out.println(no + " "+kor+ " "+eng+ " "+math);
      in2.close();
      in.close();
    } catch(IOException e) {}
      catch(NullPointerException e){}

  }
}



/*
*/
