package step14$SpecialGeneral.exam05;
public class Sedan2 extends Car{

  boolean isSunroof;
  boolean isAutomatic;

  //수퍼 클래스로부터 상속받은 메서드를 재정의.
  // 오버라이딩 ( overriding )
  // 수퍼클래스의 메서드와 똑같은 시그너처를 가져야한다.
  // -> Signature ? 메서드 이름 리턴타입 파라미터선언
  // Signature = function prototype

  @Override
  public void printInfo(){
    super.printInfo();
    System.out.printf("자동기어 : %b\n", this.isAutomatic);
    System.out.printf("썬루프 : %b\n", this.isSunroof);
  }
}


/*

* @Override
  - 컴파일러에게 지시를 하는 아주 특별한 주석
  - 즉 현재 메서드의 시그너처와 일치하는 수퍼 클래스의 메서드가 있는지 검사라하는 얘기
  - 만약 없다면 오버라이딩이 아니기 때문에 컴파일 오류가 발생
    => 개발자의 오타로 인한 버그를 줄일 수 있다.
  - 컴파일러나 JVM 에게 지시나 조언등을 제공하기 위해 작성하는 주석을
    Annotation"애노테이션" 이라고 부른다.
  - @애노테이션명(속성,속성,속성....)


// * 오버로딩 은 파라미터 갯수나 파라미터 선언이 다르더라도 같은 기능을 하는 메소드를
   같은 이름으로 정의하므로써 일관성을 유지시키는 기능

   * 오버라이딩 은 상속받은 메소드를 서브클래스의 역할에 맞게끔 재정의하는 것.
*/
