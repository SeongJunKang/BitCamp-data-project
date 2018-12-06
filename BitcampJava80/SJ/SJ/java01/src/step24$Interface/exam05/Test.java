package step24$Interface.exam05;

public class Test implements A,B {
  public void m1() {
//    WOMAN = 20 ;
    System.out.println(A.MAN);
    System.out.println(B.MAN);
    System.out.println(WOMAN);
    System.out.println(GIRL);
    System.out.println("this is m1()");
  }

  public static void main(String[] args) {
    Test p = new Test();
    p.m1();
  }

}

/*

*/
