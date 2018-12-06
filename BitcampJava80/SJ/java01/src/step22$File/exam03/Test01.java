
// 바이트값을 메모리로 출력하기 (바이트 배열)

package step22$File.exam03;
import java.io.ByteArrayOutputStream;
public class Test01 {

  public static void main(String[] args)  {
    try {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      // ByteArrayOutputStream 이 관리하는 내부 바이트 배열에 출력
      // 중요!
      // => 메모리에 데이터를 저장할 때도 꼭 파일로 출력하는 것처럼
      //    프로그래밍 짤 수 있다
      // => 데이터를 저장하는 대상이 파일이든, 메모리이든 간에
      //    일관된 방식(read / write)으로 프로그래밍 짤 수 있다.
      // => 이것이 스트리밍 API 이다.
      int value = 0x2a3b4c5d;
      for (int i = 24;i >= 0 ; i-=8 ) {
        out.write(value>>i);
      }
      byte[] bytes = out.toByteArray();
      for(byte b : bytes) {
        System.out.printf("%x ",b);
      }
      System.out.println();
      out.close();
    } catch (Exception e) {}

  }
}


/*
#
*/
