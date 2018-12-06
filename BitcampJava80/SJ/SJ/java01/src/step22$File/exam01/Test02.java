// 파일 생성 삭제.

package step22$File.exam01;
import java.io.File;
import java.util.Scanner;

public class Test02 {
  Scanner scan = new Scanner(System.in);
  public static void main(String[] args) {
    try {
      File f = new File("./test01.txt");
      // 파일생성
      // f.createNewFile();

      //파일삭제
      // if (scan.nextLine().equals("y")) {
      //   if (f.delete()) {
      //     System.out.println("삭제성공");
      //   } else {
      //     System.out.println("삭제실패");
      //   }
      // }

      // 이름바꾸기
      // File f2 = new File("./testok.txt");
      // f.renameTo(f2);

      //디렉토리 생성
      f.mkdir();
    } catch (Exception e) {
      System.out.println("예외발생");
    }

  }
}


/*

*/
