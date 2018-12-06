//   키보드로부터 데이터 읽기.
package step17$Scanner;
import java.util.Scanner;
//컴파일러에게 스캐너 클래스가 있는 패키지가 있는 주소가 어디있는지 기억하게 알려준다.

public class Exam01 {

  public static void main(String[] args) {
    // Scanner 생성자에 입력장치를 등록한다.
    Scanner keyScan = new Scanner(System.in);
    String str = keyScan.nextLine();
    System.out.println("===>"+str);

    str = keyScan.nextLine();
    System.out.println("===>"+str);

    str = keyScan.nextLine();
    System.out.println("===>"+str);

  }

}


/*
*  System.in     : 키보드를 가리키는 레퍼런스
*  System.out    : 콘솔을 가리키는 레퍼런스
*  System.err    : 콘솔을 가리키는 레퍼런스
*  Scanner       : 특정 입력장치로부터 데이터를 읽어 들이는 도구.

*/
