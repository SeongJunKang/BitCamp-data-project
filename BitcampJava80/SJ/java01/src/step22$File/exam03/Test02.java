
// 메모리(바이트배열) 에 있는 바이트 값을 스트림 API 를 사용해서 읽기

package step22$File.exam03;
import java.io.ByteArrayInputStream;
public class Test02 {

  public static void main(String[] args)  {
    try {
      byte[] bytes = new byte[20];
      for (byte i = 20 ; i > 0 ; i-- ) {
        bytes[20 - i] = i;
      }
      ByteArrayInputStream in = new ByteArrayInputStream(bytes);

      for (int i = 0;i < 10 ; i ++ ) {
        System.out.print(in.read()+" ");  // 쓸 때는 write 읽을 땐 read
      }                                   // ByteStream API에는
      System.out.println();               //일관적인 장점을 가지고 있다.
      in.close();
    } catch (Exception e) {}

  }
}


/*
#
*/
