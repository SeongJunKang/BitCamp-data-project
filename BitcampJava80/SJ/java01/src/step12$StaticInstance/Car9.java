package step12$StaticInstance;

//클래스 앞에 final 붙이면 상속 불가.
public final class Car9 {
  //변수 앞에 final 붙이면 한번만 값 할당.
  // - > 상수값으로 사용하기 위해!
  // - > 조회용도로 사용하고 싶을 떄.
  // - > 상수로 사용할 것이기 때문에 인스턴스마다 개별적으로 만들 필요가없음.
  //     그래서 static 변수로 만든다.
  // - > 따라서 상수 변수는 보통 static 이면서 final이 된다.
  static final String model = "TICO";

  //  메서드앞에 fianl 붙이면 재정의 불가.
  public final void m(final int value) {
    //메서드명도 변수다.
  }
}
