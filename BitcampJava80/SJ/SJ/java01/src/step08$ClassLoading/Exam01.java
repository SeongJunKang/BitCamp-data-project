/*
클래스 구동원리 - 클래스 로딩과 메서드 실행
*/
package step08$ClassLoading;
public class Exam01 {
  public static void main(String[] args) {

    System.out.println("hello");

  }
}
/*
* 클래스 로딩
1)검증 - 로딩할 클래스의 바이트 코드 유효 여부 검사
2)준비 - 클래스에 스태틱 변수가 있으면 그 변수에 대해 메모리를 준비한다.
3)실행 - main() 메서드를 실행한다.

*  JVM 의 메모리 관리
- OS 로 부터 분양 받은 메모리를 크게 4개의 영역으로 나눠 관리한다.
1) Method Area
-클래스가 로딩되는 영역이다
2) Heap
- 인스턴스가 생성되는 영역이다
3) stack
- 메서드를 호출할 때마다
4)constant pool
-
*/
