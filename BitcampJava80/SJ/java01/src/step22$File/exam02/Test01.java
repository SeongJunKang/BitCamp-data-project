// 바이트 출력하기

package step22$File.exam02;
import java.io.FileOutputStream;
import java.io.IOException;
public class Test01 {

  public static void main(String[] args) throws IOException {
      FileOutputStream out = new FileOutputStream("exam02.Test01.data");
      int value = 0x2a3b4c5d; //708529245
      out.write(value); //비록 파라미터 타입이 int 이지만 맨 끝 1 바이트만 출력.
      out.close();
  }
}


/*
# 자바 입출력
- data streaming 개념을 지원한다
  즉 대상이 누구냐에 상관없이 데이터 입출력 도구를 정의한 것.
- 특징)
  1) 입력과 출력 역할을 분리하였다.
  2) 바이트 스트림과 문자 스트림으로 구분하였다.
  3) 데이터를 목적지에 직접 읽고 쓰는 클래스와 중간에서 데이터를 처리하는 클래스로
  구분하였다.
- 주요 클래스
  1) InputStream/OutputStream : 바이트 스트림을 다루는 추상 클래스
    => Data Sink Stream Class (직접 읽고 쓰기)
        FileInputStream / FileOutputStream           --> I/O 대상이 파일이다.
        ByteArrayInputStream / ByteArrayOutputStream --> I/O 대상이 바이트 배열
        PipedInputStream / PipedOutputStream         --> I/O 대상이 프로세스(다른 프로그램)

    => Data Processing Stream Class (중간에서 데이터 가공)
        BufferedInputStream /BufferedOutputStream --> 버퍼를 이용한 입출력 속도 개선
        DataInputStream / DataOutputStream        --> 원시타입 등의 데이터를 입출력하기 쉽다.
        ObjectInputStream /ObjectOutputStream     --> 인스턴스 입출력
        PrintStream                               --> 바이트 및 문자도 출력가능
  2) Reader/ Writer : 문자 스트림을 다루는 추상 클래스.
    => Data Sink Stream Class (직접 읽고 쓰기)
        FileReader / FileWriter           --> I/O 대상이 파일
        CharArrayReader / CharArrayWriter --> I/O 대상이 캐릭터 배열
        StringReader / StringWriter       --> I/O 대상이 문자열
        PipedReader / PipedWriter         --> I/O 대상이 프로세스
    => Data Processing Stream Class (중간에서 데이터 가공)
        BufferedReader / BufferedWriter   --> 버퍼를 이용한 입출력 속도 개선
        PrintWriter                       --> 출력


*/
