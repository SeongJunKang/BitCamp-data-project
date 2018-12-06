package step14.exam08;

public class A {
  String v1 = "홍길동"; // 변수 선언 + 초기화 문장
  int v2 = 10;  // 변수 선언 + 초기화 문장
  boolean v3; // 변수 선언

  public A() {
    super();

    System.out.println("A의 생성자 -------");
    v1 = "유관순";
    v2 = 20;

    //super();
  }
}
