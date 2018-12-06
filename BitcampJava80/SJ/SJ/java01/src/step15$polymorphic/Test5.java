//  주제 : 다형적 변수을 사용할 때 제약조건
package step15$polymorphic;

public class Test5 {

  public static void main(String[] args) {
    DeveloperCalculator c = new DeveloperCalculator();
    c.init(10);         // Calculator 의 메소드
    c.multiple(2);      // CalculatorPlus 의 메소드
    c.printResult(2);   // DeveloperCalculator 의 메소드

    // 왜 하위 클래스의 레퍼런스는 상위 클래스의 인스턴스를 가리킬 수 없는가 ?

//    DeveloperCalculator c2 = new CalculatorPlus();
//    c.init(10);         // Calculator 의 메소드 : 찾을 수 있다.
//    c.multiple(2);      // CalculatorPlus 의 메소드 : 찾을 수 있다.
//    c.printResult(2);   // DeveloperCalculator 의 메소드 : CalculatorPlus에 정의되있지 않은 메서드.

  }
}
