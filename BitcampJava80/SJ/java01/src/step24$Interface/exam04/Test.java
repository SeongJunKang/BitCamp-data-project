package step24$Interface.exam04;

public class Test implements C {
  public void m1() {}   // A , B 만족
  public void m2() {}   // A 만족
  public void m3() {}   // B 만족
  public void m4() {}   // C 만족

}


/*
# 인터페이스 구현
- B 의 인터페이스 메서드도 구현해야 하지만,
- B 의 수퍼 클래스인 A 의 클래스도 구현해야한다.

*/
