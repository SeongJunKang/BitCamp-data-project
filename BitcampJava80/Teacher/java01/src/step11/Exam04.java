/* 주제: 오버로딩을 잘못한 예 */
package step11;

public class Exam04 {

  static int plus(int a, int b) {
    System.out.println("int, int");
    return a + b;
  }

  // 잘못 오버로딩 한 예
  // 1) 변수명만 다른 경우 => 오류!
  /*
  static int plus(int b, int a) {
    return a + b;
  }
  */

  // 2) 리턴 타입만 다른 경우 => 오류!
  /*
  static float plus(int a, int b) {
    return a + b;
  }
  */

  // OK
  static float plus(byte a, byte b) {
    System.out.println("byte, byte");
    return a + b;
  }

  public static void main(String[] args) {
    // 숫자 10은 int 형 literal이다.
    System.out.println(plus(10, 20));

    byte b1 = 10, b2 = 20;
    System.out.println(plus(b1, b2));
  }
}

/*
메서드 오버로딩
- 파라미터의 개수가 다르거나, 파리미터의 타입이 다르다면
  같은 이름을 갖는 메서드를 추가로 선언할 수 있다.
- 의미?
  파라미터의 개수나 타입이 다르더라도 같은 기능을 수행하는 메서드에 대해
  같은 이름을 부여함으로써 프로그래밍의 일관성을 확보하는 문법

같은 이름을 갖는 메서드의 호출 규칙
- 메서드를 호출할 때 넘겨주는 값(아규먼트)으로 호출할 메서드를 결정한다.
1) 파라미터의 타입과 개수가 완전히 일치하는 메서드를 찾는다.
2) 없다면, 암시적 형변환을 해서라도 값을 넘겨줄 수 있는 메서드를 찾는다.
3) 없다면, 컴파일 오류 발생!







*/
