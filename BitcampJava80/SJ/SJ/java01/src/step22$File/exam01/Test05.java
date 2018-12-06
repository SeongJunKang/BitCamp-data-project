// 디렉토리에 있는 모든 파일(디렉토리 제외 ) 목록 알아내기

package step22$File.exam01;

import java.io.File;
import java.io.FileFilter;

public class Test05 {
  public static void main(String[] args) {
    try {
      File f = new File(".");

      File[] filelist = f.listFiles(new FileFilter() {
        @Override
        public boolean accept(File file) {
          return file.isFile() == true ? true : false;
        }
      });

      for (File list : filelist ) {
          System.out.println("File     : "+list.getName());
      }

    } catch (Exception e) {
      System.out.println("예외발생");
    }

  }
}


/*

*/
