// 주제: final 3
package step13;

public class Exam11 {
  static final int a;
  static {
    a = 20;
  }
  static final int b = 20;

  // 보통 상수 값은 변수 이름을 대문자로 짓는다.
  static final int YEAR = 1;
  

  public static void main(String[] args) {
      //a = 20; // 오류!
  }
}

/* 스태틱 변수에 final 붙일 때 값을 할당하는 방법
- 변수 선언 시 초기화 문장으로 값을 할당
 예) static final int a = 20;
- static 블록에서 값을 할당
 static final int b;
 static {
   b = 20;
}



*/
