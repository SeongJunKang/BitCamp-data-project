//클래스파일 출력
package step22$File.exam01;
import java.io.File;
import java.io.IOException;

public class Test07 {
  public static void main(String[] args) {
    ClassList(".", ".class");
  }

  public static void ClassList(String path, String ext) {
    File dir = new File(path);
    File[] fileList = dir.listFiles();
    try {
      for (File file : fileList) {
        if (file.isFile() && file.getName().endsWith(ext)){
          System.out.println(file.getName());
        } else if (file.isDirectory()) {
          ClassList(file.getCanonicalPath().toString(),ext);
        }
      }
    } catch(IOException e) {
    }
  }

}


/*

*/
