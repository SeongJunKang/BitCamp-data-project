// 파일정보 다루기.

package step22$File.exam01;
import java.io.File;
import java.io.IOException;


public class Test01 {

  public static void main(String[] args) {
    File f = new File("../project01/src/bitcamp/pms/ProjectApp.java");
    try {
      System.out.printf("getName : %s\n",f.getName());
      System.out.printf("getPath : %s\n",f.getPath());
      System.out.printf("getAbsolutePath : %s\n",f.getAbsolutePath());

      // . 또는 ..에 대해 계산을 완료한 경로
      // . -> 현재 위치 폴더
      // .. -> 상위폴더
      System.out.printf("getCanonicalPath : %s\n",f.getCanonicalPath());
      // 파일인 경우 폴더를 가리킨다.
      System.out.printf("getParent : %s\n",f.getParent());
      //파일의 크기 (바이트)
      System.out.printf("length : %s\n",f.length());
      //URI 정보 추출
      System.out.printf("toURI : %s\n",f.toURI());
      // 파일 및 디렉토리 여부 검사
      System.out.printf("isFile : %s\n",f.isFile());
      System.out.printf("isDirectory : %s\n",f.isDirectory());

      //파일 또는 디렉토리의 존재 여부
      System.out.printf("exists : %s\n",f.exists());

      //파티션의 크기
      System.out.printf("getTotalSpace  : %s\n",f.getTotalSpace());
      System.out.printf("getUsableSpace : %s\n",f.getUsableSpace());
      System.out.printf("getFreeSpace   : %s\n",f.getFreeSpace());

      //파일 작성일 또는 마지막으로 변경한 날짜
      long millis =f.lastModified();
      java.sql.Date date = new java.sql.Date(millis);
      System.out.printf("lastModified   : %s\n", date.toString());

    } catch (IOException e) {
    }
  }

}


/*
# 파일의 위치 정보 표현
1) path
  - OS 의 파일 시스템의 경로 정보이다.
  - ex) 윈도 => c:\Program Files\Java\jdk1.8.0_74
  - ex) 리눅스 => /usr/local/jdk1.8.0_74
2) URL
  - 웹 주소 형태로 표현하는 경로 정보이다.
  - 예) 윈도 => file://c:/Program+Files/Java/jdk1.8.0_74
  - 예) 리눅스 => file://usr/local/jdk1.8.0_74


# URI, URL ,URN

- URI (Uniform Resource Indicator)
  => 네트워크 상에 있는 자원의 주소를 표현하는 방법
  => 표현 방법
    1) URL (Uniform Resource Locator)
      프로토콜 ://서버주소:포트번호/.../자원경로
    2) URN (Uniform Resource Name)


*/
