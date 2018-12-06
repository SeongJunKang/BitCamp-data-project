
package step22$File.exam01;
import java.io.File;

public class Test04 {
  public static void main(String[] args) {
    try {
      File f = new File(".");
      File[] filelist = f.listFiles();
      for (File list : filelist ) {
        if(list.isFile()){
          System.out.println("File     : "+list.getName());
        // } else if(list.isDirectory()) {
          // System.out.println("디렉토리 : "+list.getName());
        }
      }
      //현재 폴더의 파일만 모두 출력한다.
    } catch (Exception e) {
      System.out.println("예외발생");
    }

  }
}


/*

*/
