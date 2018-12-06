package step14$SpecialGeneral.exam09;

public class A {
  String v1= "홍길돌";
  int v2 = 10;
  boolean v3;

  public A(){}
  // 기본생성자가 없다.
  public A(String name) {

    // super();
    System.out.println("A(String)의 생성자------------------");
    v1 = name;

  }
}
