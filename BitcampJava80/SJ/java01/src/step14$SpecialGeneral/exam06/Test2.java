// 주제 : 상속과 인스턴스 변수
package step14$SpecialGeneral.exam06;

public class Test2 {
  public static void main(String[] args) {
    B p = new B();

    System.out.println(p.v1);
    System.out.println(p.v2);
    System.out.println(p.v3);
    System.out.println(p.v4);
    System.out.println(p.v5);

  }
}


/* 상속관계에서 생성자 호출
- 모든 생성자는 첫번째 줄에 수퍼클래스의 기본 생성자를 호출하는 문장을 포함하고 있다
예) super();

-  만약 개발자가 해당 코드를 넣지 않는다면 컴파일러가 자동으로 삽입.
  -> 그래서 하위 클래스의 생성자를 호출할 때 상위 클래스의 생성자가
     자동으로 호출된다.
*/