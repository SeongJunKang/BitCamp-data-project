package step24$Interface.exam04;

public interface C extends A,B {
  void m4();
}
/*
# 다중 상속

- 클래스는 다중 상속이 불가능하다.
같은 이름으로 구현된 메서드가 있다면 어떤 메서드를 호출해야 될지 모르기 떄문에.
그러나 인터페이스는 다중 상속이 가능하다.
어차피 구현되지 않아있기 때문에.
같은 메서드가 있더라도 구현된게 아니기 때문에, 어떤 메서드를 상속 받더라도
문제되지 않는다.

*/