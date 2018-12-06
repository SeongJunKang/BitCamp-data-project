package step20$InnerClass.exam04;

public class Test2 {

  public static void main(String[] args) {
    Outer2 p = new Outer2() ;
    Outer2.Inner p2 = p.new Inner();
    p2.test2();
  }
}
