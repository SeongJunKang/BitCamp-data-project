// 주제: top level inner class 사용 3
package step20.exam03;

// 스태틱 멤버를 컴파일러에게 미리 알려주기.
// 중첩 클래스가 어떤 클래스의 스태틱 멤버인지 컴파일러에게 알려준다.
// => 단 static 키워드를 붙여라!
import static step20.exam03.Outer2.Inner;

public class Test3 {
  public static void main(String[] args) {
    // static 멤버르
    Inner p = new Inner();
    p.m2();
  }
}
