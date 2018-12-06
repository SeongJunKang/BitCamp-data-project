// 주어진 폴더를 뒤져서 중첩 클래스파일만 이릅을 출력하라
package step22$File.exam01;
import java.io.File;
import java.io.IOException;
public class Test08 {
  public static void main(String[] args) {
    File f = null;
    for (String path : args) {
      f = new File(path);
      ClassList(f, "$");
    }
  }


  public static void ClassList(File files, String ext) {
    try {

      File[] fileList = files.listFiles();
      for (File file : fileList) {

        if (file.isFile() && file.getName().contains(ext)
        && file.getName().endsWith(".class")) {
          System.out.println(file.getName());
        } else if (file.isDirectory()) {
          ClassList(new File(file.getCanonicalPath()),ext);
        }
      }

    } catch(IOException e) {
    }

  }

}


/*

*/
