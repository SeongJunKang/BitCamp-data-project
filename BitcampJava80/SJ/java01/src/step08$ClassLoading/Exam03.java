package step08$ClassLoading;

public class Exam03 {
  public static void main(String[] args) {

    int a = 20;
    Myclass.setSValue(a);
    System.out.println(Myclass.sv);

  }
}
/*
*클래스를 로딩하는 경우

1) 클래스 변수(스태틱 변수)를 사용할 때
2) 클래스 메서드(스태틱 메서드)를 사용할 때
3) 인스턴스를 생성할 때

-> 한번 클래스를 로딩하면 다시 로딩하지 않는다.
-> JVM 이 종료할 때 로딩된 클래스가 제거된다.
cf) ClassLoader 물건을 통해 로딩된 클래스를 재로딩 할 수 있다.


*클래스 실행과 메모리 사용
1) Exam03.class 를 [Method Area] 에 로딩
2) main()를 [Method Area]에 호출
3) [Stack]에 main() 이 사용할 메모리 준비
4) [Stack]에 main의 (int a = 20) 명령어 실행
   [Stack] a 변수에 20 값을 저장
5) Myclass.class 를 [Method Area] 에 로딩
6) [Method Area] Myclass 의 스태틱 메서드를 실행한다.
7) 스택) setSValue() 의 로컬 변수 a 를 준비한다.
8) 스택) main()의 a값을 setSValue()의  a 파라미터에 저장한다.
9) [Method Area]에 main()에 있는 명령어 (Myclass.setSValue)
10) [Stack] main() 실행 완료 --> main()이 사용한 모든 로컬 메모리 제거 .
11) JVM 이 종료한다 . -> 종료하면 메모리를 OS가 강제 회수.
-> 모든 명령어는 [Method Area] 에 있음.

*/
