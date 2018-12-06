package step22$File.exam05;
import java.io.FileInputStream;
// 데코레이터 사용전..
import java.io.IOException;

public class Test03 {

  public static void main(String[] args)  {
    try {
      FileInputStream in = new FileInputStream("test.pdf");
      long start = System.currentTimeMillis();

      int count = 0;
      while ((in.read()) >= 0) {
        if (count++ % 100000 == 0) {
          System.out.print(".");
        }
      }
      System.out.println();

      long end = System.currentTimeMillis();
      System.out.println(start-end);
      in.close();
    } catch(IOException e) {}
      catch(NullPointerException e){}

  }
}



/*
*/
