
package step14$SpecialGeneral.exam04;
public class Test {
  public static void main(String[] args) {
    // 승용차 정보를 저장하기 위해 인스턴스 생성
    Sedan s1 = new Sedan();


    // 트럭 정보를 저장하기 위해 인스턴스 생성
    Truck t1 = new Truck();


    // 다음은 무슨 정보를 저장하기 위해 생성하는가 ?
    // 원래 Car 의 존재 이유가 무엇인가.
    // Car c1 = new Car();
    // ---> 공통 코드를 정리하기 위해서.
    //-->  추상클래스이기 때문에 인스턴스를 생성할 수 없다.

  }
}


/*
Generalization 의 목적
- 여러 클래스들에 존재하는 공통 코드를 뽑아서 수퍼클래스로 정의함으로써
  코드의 관리를 쉽게하기 위함 -> 코드 정리

- 예) Car 클래스는 Sedan 과 Truck 의 코드정리를 위해 만든 클래스이다.
      Car 클래스를 직접 사용하려고 만든 클래스가 아니다.
        -> 사용할 수는 있지만 Generalization의 목적은 이것이 아니다.
      그래서 Car 클래스는 사용되어서는 안된다.
      단지 원래의 목적인 하위 클래스들에게 공통 속성/기능을 상속해주는
      역할만 하도록 만들어야 한다.
      => 추상 클래스

abstraction class
- 직접 인스턴스를 생성할 수 없다.
- 추상 메서드를 가질 수 있다.
- 서브클래스들에게  속성이나 메서드를 상속해 주는 역할을 한다.
  문법 ) abstract class Myclass{}

Car 클래스를 추상클래스로 만든다.
- Car의 인스턴스를 만들 수 없다.
- 그러나 Sedan과 Truck에게 상속해주는 역할은 그대로 유효하다.

*/
