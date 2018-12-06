package step20$InnerClass.exam03;

public class Outer3 {
  //2) member class
  int no ;
  void m() {
  System.out.println("Outer.m()");
  }
  class Inner {
    /*
    public static void m() {
      System.out.println("Outer.Inner.m()");
    }*/
    public void m2() {
      System.out.println("Outer.Inner.m2()");
    }
  }

}
