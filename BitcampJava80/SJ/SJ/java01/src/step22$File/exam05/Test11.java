package step22$File.exam05;
//버퍼링 데코레이터 사용 전
import java.io.IOException;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
public class Test11 {

  public static void main(String[] args)  {
    try {
      FileInputStream in0 = new FileInputStream("exam05.Test10.data");
      BufferedInputStream in1 = new BufferedInputStream(in0);
      ObjectInputStream in =new ObjectInputStream(in1);

      Member2 m1 = (Member2)in.readObject();
      m1.calculateBMI();
      Member2 m2 = (Member2)in.readObject();
      m2.calculateBMI();

      in.close();
      in1.close();
      in0.close();
      System.out.println(m1);
      System.out.println(m2);
    } catch(IOException e) {}
      catch(NullPointerException e){}
      catch(ClassNotFoundException e){}

  }
}

/*
인스턴스를 바이트 배열로 변환 =>"Serialize"
JVM은 기본이 "보안"이기 때문에 Serialize를 막는다.
=> Serialize 를 허락하려면 해당 클래스에서 Serialize 할 수 있음을 명시해야한다.
class (name) implements Serializable {}

*/
