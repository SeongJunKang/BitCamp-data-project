package step22$File.exam05;
//버퍼링 데코레이터 사용 전
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectOutputStream;
public class Test10 {

  public static void main(String[] args)  {

    Member2 m1 = new Member2("홍길동",20,180,70);
    Member2 m2 = new Member2("임꺽정",45,178,98);

    try {
      FileOutputStream out0 = new FileOutputStream("exam05.Test10.data");
      BufferedOutputStream out1 = new BufferedOutputStream(out0);
      ObjectOutputStream out =new ObjectOutputStream(out1);

      out.writeObject(m1);
      out.writeObject(m2);
      out.close();
      out1.close();
      out0.close();
    } catch(IOException e) {}
      catch(NullPointerException e){}

  }
}

/*
인스턴스를 바이트 배열로 변환 =>"Serialize"
JVM은 기본이 "보안"이기 때문에 Serialize를 막는다.
=> Serialize 를 허락하려면 해당 클래스에서 Serialize 할 수 있음을 명시해야한다.
class (name) implements Serialize {}

*/
