package step20$InnerClass.exam03;
public class Outer4 {
  int no ;
  void m() {
    //로컬 이너 클래스.
    // => m() 메서드 안에서만 사용가능
    class Inner {/*
      public static void m() {
        System.out.println("Outer.Inner.m()");
      }*/
      public void m2() {
        System.out.println("Outer.Inner.m2()");
      }
    }
    Inner p = new Inner();
    p.m2();
  }
}
