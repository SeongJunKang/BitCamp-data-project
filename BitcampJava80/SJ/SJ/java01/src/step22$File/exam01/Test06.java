// 디렉토리에 있는 모든 txt 파일 목록 알아내기

package step22$File.exam01;
import java.io.File;
import java.io.IOException;
import java.io.FilenameFilter;

public class Test06 {
  public static void main(String[] args) throws IOException {

    File f = new File(".");
    File[] filelist = f.listFiles(new FilenameFilter() {
      @Override

      public boolean accept(File dir,String name) {

        // 1)현재 폴더에서 파일 이름이 txt로 끝나는 경우를 모두 리턴
        return (dir.isDirectory() == true) && (name.endsWith(".txt") == true) ? true : false;
        //2 ) File temp = new File(dir,name)
        // 현재 폴더에서  파일 이름이 txt인 파일만 출력
        //return (temp.isFile() == true) && (name.endsWith(".txt") == true) ? true : false;
      }
    });
    for (File list : filelist ) {
        System.out.println("File     : "+list.getName());
    }
  }
}


/*

*/
