/*
클래스 구동원리 - 클래스 로딩과 메서드 실행
*/
package step08$ClassLoading;
public class Exam02 {
  public static void main(String[] args) {
    int a = 20;
    Myclass.sv = a ;
    System.out.println(Myclass.sv);

  }
}
/*
* 로컬변수
- 메서드 안에 선언된 변수
- 스택 메모리 영역에 준비
- 파라미터도 로컬 변수

*클래스 실행과 메모리 사용
1) Exam02.class 를 [Method Area] 에 로딩
2) main()를 [Method Area]에 호출
3) [Stack]에 main() 이 사용할 메모리 준비
4) [Stack]에 main의 (int a = 20) 명령어 실행
   [Stack] a 변수에 20 값을 저장
5) Myclass.class 를 [Method Area] 에 로딩
6) [Method Area] 클래스 변수 Svalue 를 준비한다.
7) [Method Area]에 main()에 있는 명령어 (Myclass.Svalue = a) 실행
    => [Stack] 메모리에 있는 a 값을
        [Method Area]에 있는 Myclass.Svalue에 저장한다.
8) [Method Area]에 main()에 있는 (System.out.println(Myclass.sv)) 를 실행.
9) [Stack] main() 실행 완료 --> main()이 사용한 모든 로컬 메모리 제거 .
10) JVM 이 종료한다 . -> 종료하면 메모리를 OS가 강제 회수.
-> 모든 명령어는 [Method Area] 에 있음.

*/
