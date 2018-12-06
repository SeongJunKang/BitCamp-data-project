package step19$Exception;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Test6 {

  public static void main(String[] args) {
    String str = new String("test.txt");
    File f = new File(str);
    try {
      FileReader in = new FileReader(f);
    } catch (FileNotFoundException e) {
      System.out.println(str+" 파일을 찾을 수 없습니다.");
    }
  }

}


/*
RuntimeException 과 Exception 의 용도
1) RuntimeException
- 자질구레한 예외 상황을 알릴 떄 사용한다.
- 프로그램을 실행하면서 흔하게 발생되는 오류인 경우.
  RuntimeException으로 예외상황을 알린다.
- 개발자 입장
  => RuntimeException 을 던지는 메소드를 사용할 떄
      반드시 try ~catch  를 작성해야 하는 것은 아니다.
  => 에외처리에 대한 부담이 적음 , 선택권이 개발자에게 있음.

2) Exception
- 프로그램 실행에 치명적인 영향을 끼치는 오류를 알릴 떄 사용한다.
- 즉 이런 오류를 발생하는 메서드를 사용할 떄는 더욱 주의.
  반드시 예외 처리를 고려.
- 개발자 입장!
  => Exception을 던지는 메서드를 사용할 떄
    => 예외 상황을 처리하는 코드를 반드시 작성한다.
    - try catch를 사용하거나
    - throw 사용하여 자신을 호출한 상위 호출자에게 전달.
*/
