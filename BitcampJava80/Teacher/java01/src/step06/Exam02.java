/* 주제: 메서드 정의하기2 */
package step06;

public class Exam02 {

  // 값을 받는 메서드 정의하기
  static void hello(String name) {
    System.out.printf("안녕하세요, %s님!\n", name);
  }

  public static void main(String[] args) {
    // 값을 받는 메서드 실행
    // => 메서드가 원하는 값을 반드시 넘겨줘야 한다.
    hello("홍길동");
    //hello(10); // 만약 메서드가 원하는 타입이 아닌 값을 준다면, 오류!
    hello("임꺽정");
    hello("유관순");
  }
}
