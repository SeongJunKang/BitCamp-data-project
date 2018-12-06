package step20$InnerClass.exam03;

public class Outer1 {
  // 1. top level inner class
  // static 멤버이다.
  static class TopLevelInner {

  }

  // 2. member inner class
  // 인스턴스 멤버이다.
  class MemberInner {

  }

  // 3. local inner class
  // 메서드 안에서만 사용 가능
  public void m() {
    class LocalInner {

    }
  }

  // 4. anonymous inner class
  // 클래스 이름이 없기 때문에 클래스 선언과 동시에 인스턴스 생성
  //  new [수퍼클래스 | 인터페이스] (파라미터값,파라미터값,...) {
  //     클래스 멤버 선언
  // }
  Object obj = new Object(){
    public void m() {
    }
  };

}
