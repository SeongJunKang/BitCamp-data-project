

package step19$Exception;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Test7 {

  public static void main(String[] args) throws FileNotFoundException {
    String str = new String("test.txt");
    File f = new File(str);
    FileReader in = new FileReader(f);
    System.out.println(str+" 파일을 찾을 수 없습니다.");
  }

}


/*
Throws 명령
- 상위 호출자에게 오류 상황을 알리는 문법
- 만약 상위호출자가 JVM 이라면, 즉시 실행을 멈춘다.
- 주의 ! -> 사용을 자제하라.
         -> 상위 호출자가 JVM 이면 즉시 실행을 멈추기 때문.
         -> 예외 처리를 하지 않은 결과가 발생.
- 예외 처리 문법을 쓰는 이유 :
  -> 예외 상황이 발생했을때 시스템을 멈추지 않고
     적절한 조치를 취한 후 계속 실행하기 위해.
  -> 따라서 예외 상황을 상황을 상위 호출자에게 넘기는 경우,
      JVM 에게 전달되지 않도록 더욱 주의하라.

*/
