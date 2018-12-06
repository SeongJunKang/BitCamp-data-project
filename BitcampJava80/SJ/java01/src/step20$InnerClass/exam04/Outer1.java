// how to use top level inner class.
package step20$InnerClass.exam04;

public class Outer1 {

  static int no ;
  int no2;
  static void m() { // static member 에서 접근하기
    Outer1.no = 10;
    no = 20;
    // no2 = 30;     // << 얘만 컴파일 오류
  }

  void m2() {     // instance member에서 접근하기

  }

  /*
  중첩 클래스에서 바깥 클래스의 멤버에 접근하기
  스태틱 중첩 클래스는 바깥 클래스의 스태틱 멤버에 접근할 수 있다.
  스태틱 중첩 클래스는
  */


  static class Inner {
    public static void test1() {
     no = 100;  // 메서드의 스태틱 여부는 상관 없다.
     m();       // 중첩 클래스가 스태틱이냐 아니냐이다.
     //no2 =20; // static 환경에서 instance 에 접근 불가.
     System.out.println(no);
    }

    public void test2() {
      no =100;
      m();
      System.out.println(no);
      // no2 = 100; // 현재 메서드의 스태틱 여부는 상관없다.
                    // 중첩 클래스의 스태틱여부가 중요.

    }
  }
}
