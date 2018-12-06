package step22$File.exam05;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.BufferedInputStream;

public class Test05 {

  public static void main(String[] args)  {
    try {
      FileInputStream in0 = new FileInputStream("test.pdf");
      BufferedInputStream in = new BufferedInputStream(in0);
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
      in0.close();
    } catch(IOException e) {}
      catch(NullPointerException e){}

  }
}



/*
*/
