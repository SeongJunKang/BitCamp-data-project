package step22$File.exam05;
//버퍼링 데코레이터 사용 전
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
public class Test08 {
  
  public static void main(String[] args)  {

    Member m1 = new Member("홍길동",20,180,70);
    Member m2 = new Member("임꺽정",45,178,98);

    try {
      FileOutputStream out0 = new FileOutputStream("exam05.Test08.data");
      BufferedOutputStream out1 = new BufferedOutputStream(out0);
      DataOutputStream out =new DataOutputStream(out1);

      out.writeUTF(m1.name);
      out.writeInt(m1.age);
      out.writeInt(m1.height);
      out.writeInt(m1.weight);

      out.writeUTF(m2.name);
      out.writeInt(m2.age);
      out.writeInt(m2.height);
      out.writeInt(m2.weight);

      out.close();
      out1.close();
      out0.close();
    } catch(IOException e) {}
      catch(NullPointerException e){}

  }
}



/*
*/
