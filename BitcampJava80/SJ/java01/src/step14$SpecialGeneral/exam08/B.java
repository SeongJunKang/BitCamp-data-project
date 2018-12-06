package step14$SpecialGeneral.exam08;

public class B extends A {

  float v4 = 3.14f;
  char v5;


  public B() {
    super();
    System.out.println("B의 생성자------------------");
    v1 = "유관순";
    v2 = 40;
    System.out.println("----------------------------");
    // super() ; 오류!  수퍼클래스의 생성 호출은 무조건 맨 첫줄이여야한다.
  }
}
