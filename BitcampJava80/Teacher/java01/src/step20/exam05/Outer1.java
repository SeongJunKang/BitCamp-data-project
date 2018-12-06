package step20.exam05;

public class Outer1 {
  //1) top level inner Class
  static class Inner1 {}

  //2) member inner class
  class Inner2 {}

  public void m() {
    //3) local inner class
    class Inner3 {}

    //4) annonymous inner class
    Object obj =new Object() {};
  }
}
