package step20$InnerClass.exam03;

public class Outer2 {
  // 1. top level inner class
  // static 멤버이다.
  static int no ;
  static void m() {
    System.out.println("Outer.m()");
  }
  static class Inner {
    public static void m() {
      System.out.println("Outer.Inner.m()");
    }
    public void m2() {
      System.out.println("Outer.Inner.m2()");
    }
  }


}
