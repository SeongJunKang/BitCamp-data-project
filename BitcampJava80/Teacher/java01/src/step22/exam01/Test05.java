// 주제: 디렉토리에 있는 파일 목록(디렉토리 제외)을 알아내기
package step22.exam01;

import java.io.File;
import java.io.IOException;
import java.io.FileFilter;

public class Test05 {
  public static void main(String[] args) throws IOException {
    File f = new File(".");

    // 현재 폴더의 파일 이름을 모두 출력한다.
    File[] files = f.listFiles(new FileFilter() {
      @Override
      public boolean accept(File file) {
        if (file.isFile()) return true;
        else return false;
      }
    });

    for (File file : files){
      System.out.println(file.getName());
    }
  }








}
