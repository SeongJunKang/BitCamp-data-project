/* 주제 : 인스턴스 변수에 접근*/

package step12$StaticInstance;

public class Exam03 {

  int instancevalue;
  public void instanceMethod() {
    this.instancevalue = 2000;
  }
  static {
    // 인스턴스 주소가 있어야만 접근 가능.
    // 스태틱 블록은 인스턴스를 생성하기도 전에 실행되기 떄문에.
    // 인스턴스 주소가 있을 수가 없다.
    // Exam03.instancevalue = 3000; // error
    // instancevalue = 4000;        // error
    // this.instancevalue = 3000;   // error
    // this 란 변수가 존재하지도 않는다.
   }


   // 스태틱 메소드에서는 인스턴스 주소 this 를 사용할 수 없다.
   static void staticMethod(){
    //  this.instancevalue = 4000;
   }

  public static void main(String[] args) {
    Exam03.staticMethod();
    // Exam03.instancevalue = 5000; // error
    // instancevalue = 6000;        // error
    // 인스턴스 주소 없이는 인스턴스 변수에 접근할 수 없다.

    Exam03 E = new Exam03();
    E.instancevalue = 1000;
    System.out.println(E.instancevalue);

  }
}

/*
인스턴스 변수 및 메서드에 접근
- 인스턴스 주소가 있어야만 가능하다.

*/
