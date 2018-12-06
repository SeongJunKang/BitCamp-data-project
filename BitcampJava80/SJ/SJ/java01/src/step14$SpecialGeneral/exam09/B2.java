package step14$SpecialGeneral.exam09;

public class B2 extends A {

  float v4 = 3.14f;
  char v5;
  public B2() {
    // 수퍼클래스에 기본생성자가 없을때
    // 다른생성자를 명시해줘야 한다.
    super("우헤헤헿");
    System.out.println("B의 생성자------------------");
    v1 = "유관순";
    v3 = false;
    v5 = '가';


  }
}
