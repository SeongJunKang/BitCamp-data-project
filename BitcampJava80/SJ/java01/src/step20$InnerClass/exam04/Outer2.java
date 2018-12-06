// how to use member inner class.
package step20$InnerClass.exam04;

public class Outer2 {

  static int no ;
  int no2;
  static void m() { // static member 에서 접근하기
  }


  void m2() {     // instance member에서 접근하기
    Outer1.no = 10;
    no = 20;
    no2 = 30;
    m2();
  }

  /*
  중첩 클래스에서 바깥 클래스의 멤버에 접근
  -> 인스턴스(멤버) 중첩 클래스는 바깥 클래스의 스태틱 멤버에 접근가능
  -> 인스턴스 중첩 클래스는 바깥 클래스의 인스턴스 멤버에 접근 가능.
  -> 인스턴스 메서드와 동일
  */

  class Inner {
    public void test2() {
      no =100;
      m();
      no2 = 100;
      System.out.println("Inner.test2() method");
    }
  }
}
