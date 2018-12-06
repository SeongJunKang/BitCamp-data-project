/* 주제: 주석*/
/*
여러줄 주석
-이 사이에 있는 모든 내용은 주석으로 간주. 컴파일러가 무시.
*/

// 한줄 주석 : 그 줄이 끝나는 곳까지 주석으로 간주한다.

  /**
   javadoc 문서 생성 주석
   -  소스 파일에서 이 주석을 추출하여 HTML API 문서를 만든다.
   -  $JAVA_HOME/bin/javadoc.exe 가 이 주석을 사용하는 문서생성기다.
   -  클래스 앞에 선언하여 해당 클래스에 대한 정보를 제공한다.
  */
package step01$JavaClassMemory;
public class Exam00 {
  /**
    인스턴스 변수 앞에 앞에 선언하여 변수에 대한 정보 제공
  */  

  int i;

  /** 메서드 앞에 선언하여
  메서드에 대한 정보를 제공한다.
  */
  public static void main(String[] args) {
    System.out.println("Hello, World!");  // 모니터 출력 명령어 <- 한줄 주석
  }

  /* annotation : 애노테이션
  - 컴파일러나 JVM에게 명령이나 값을 전달하는 아주 특별한 주석
  - @애노테이션 이름(속성=값, 속성=값, ....)
  */
  @Override
  public String toString() {
    return "okok";
  }

}
