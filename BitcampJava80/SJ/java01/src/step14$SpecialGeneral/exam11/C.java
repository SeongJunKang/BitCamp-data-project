package step14$SpecialGeneral.exam11;

public class C extends B {

  @Override// 컴파일러에게 오버라이드 검사 요청
  public void m2() {
    System.out.println("C.m2()");
  }
  //새 메서드 추가
  public void m4() {
    System.out.println("C.m4()");
  }

  public void test() {
    //  의미. this 레퍼런스에 저장된 인스턴스를 가지고 m3() 메서드를 호출한다.
    //  m3()  메서드 호출 과정 .
    // 1) -> 현재 클래스 에서 찾아본다
    // 2) ->상속 받은 상위 클래스 에서 찾아본다.
    // 3) -> 없으면 상위 클래스의 상위 클래스를 찾아본다.
    // 4) 계속 찾다가 없으면 컴파일 오류.

    // cf) 메서드를 호출할 떄 마다 클래스 계층 구조(class hierarchy)를 훑기 때문에
    //     C 와 같은 functional 언어보다 실행 속도가 느리다.
    this.m3();
    this.m2();

    super.m1();
    // 재정의 하기 전의 메서드.
    super.m2();
    // super.super.m1(); < 오류 super 는 부모클래스를 가리키는 것이 아니다.

    this.m4();  // 현재 클래스 부터 상위 클래스로 따라 올라가면서 메서드를 찾아라.
    //super.m4(); // super 클래스(상위 클래스)부터 계층구조 위로 해당 메서드를 찾아라.
    // 객차지향 언어는 절차적 언어보다 무조건 느리다.
  }

}
