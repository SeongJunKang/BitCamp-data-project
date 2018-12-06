package step19$Exception;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class Test5 {

  public static void main(String[] args) throws FileNotFoundException {
    File f = new File("test.txt");
    FileReader in = new FileReader(f);
  }

}


/*
File 생성자
- NullPointerException 이 발생할 수 있다.
- 그러나 NullPointerException 은 RuntimeException 의 하위 클래스이기 때문에
  반드시 예외처리 코드를 작성할 필요는 없다.
- 그래서 new FIle();명령에 대해 컴파일 오류가 발생하지 않는다.

FileReader 생성자
- FileNotFoundException은 RuntimeException의 하위 클래스가 아니다.
- 따라서 반드시 예외 코드처리를 해야한다.
- 예외 처리를 하고 싶지 않다면, 하위 호출자에게 예외 정보를 전달하는 코드를
  작성해야 한다.
*/
