// 주제 : equals 오버라이딩
package step16$ObjectClass;

public class Exam03 {

  int age;
  int weight;


  @Override
  public String toString(){
    return "동해물과 백두산이";
  }

  public Exam03(int age,int weight) {
    this.age = age;
    this.weight = weight;
  }
  //
  // @Override
  // public boolean equals(Object other) {
  //
  // }

  public static void main(String[] args) {
    String s = new String("Hello");
    String s2 = new String("Hello");
    System.out.println( s == s2);
    System.out.println( s.equals(s2));

    System.out.println( "==============================================");

    Exam03 p = new Exam03(18,90);
    Exam03 p2 = new Exam03(18,90);
    System.out.println( p == p2);
    System.out.println( p.equals(p2));

  }
}

/*
String.equasl()
- 원래 Object로부터 상속 받은 equals는 인스턴스가 같은지를 비교한다. <- Object
- 그런데 String클래스에서 이 메서드를 재정의 하였다.
  인스턴스가 같은지 비교하는 대신, 인스턴스의 내요이 같은지 비교한다. <- String


Exam03.equals()
- Object로 부터 상속받은 메서드이기 때문에 인스턴스가 같은지를 비교.
- String 클래스처럼 내용이 같은지를 비교하려면 "오버라이딩"을 해야한다.

















*/
