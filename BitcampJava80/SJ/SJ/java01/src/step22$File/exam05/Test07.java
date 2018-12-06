package step22$File.exam05;
//버퍼링 데코레이터 사용 전
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;

public class Test07 {

  public static void main(String[] args)  {
    try {
      FileOutputStream out0 = new FileOutputStream("exam05.Test07.data");
      BufferedOutputStream out = new BufferedOutputStream(out0);
      long start = System.currentTimeMillis();

      for (int i = 0;i < 5000000 ; i ++ ) {
        out.write(0x41);
      }

      long end = System.currentTimeMillis();
      System.out.println("걸린시간 : "+(end-start));
      // out.flush()
      out.close();
      out0.close();
    } catch(IOException e) {}
      catch(NullPointerException e){}

  }
}



/*
*/
