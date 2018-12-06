package step22$File.exam05;
import java.io.FileInputStream;
//데코레이터 사용후
import java.io.IOException;

public class Test04 {

  public static void main(String[] args)  {
    try {
      FileInputStream in0 = new FileInputStream("test.pdf");
      MyBufferedInputStream in = new MyBufferedInputStream(in0);
      long start = System.currentTimeMillis();

      int count = 0;
      while ((in.read()) >= 0) {
        if (count++ % 100000 == 0) {
          System.out.print(".");
        }
      }
      System.out.println();

      long end = System.currentTimeMillis();
      System.out.println("걸린시간 : "+(end-start));
      in.close();
    } catch(IOException e) {}
      catch(NullPointerException e){}

  }
}



/*
*/
