// 디렉토리에 있는 모든 파일(디렉토리) 목록 알아내기

package step22$File.exam01;
import java.io.File;

public class Test03 {
  public static void main(String[] args) {
    try {
      File f = new File(".");
      File[] filelist = f.listFiles();
      for (File list : filelist ) {
        if(list.isFile()){
          System.out.println("File     : "+list.getName());
        } else if(list.isDirectory()) {
          System.out.println("디렉토리 : "+list.getName());
        }
      }
      //현재 폴더의 파일과 디렉토리 이름을 모두 출력한다.
    } catch (Exception e) {
      System.out.println("예외발생");
    }

  }
}


/*

*/
