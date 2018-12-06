package step24$Interface.exam03;

public class Test implements B {
  public void m1() {}   // B 가 상속 받은 A 의 인터페이스도 구현
  public void m2() {}
  public void m3() {}

}


/*
# 인터페이스 구현
- B 의 인터페이스 메서드도 구현해야 하지만,
- B 의 수퍼 클래스인 A 의 클래스도 구현해야한다.

*/
