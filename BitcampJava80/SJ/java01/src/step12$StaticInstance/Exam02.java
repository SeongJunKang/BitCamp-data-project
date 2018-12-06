/* 주제 : 스태틱 변수( 클래스 변수) 와 스태틱 블록*/

package step12$StaticInstance;

public class Exam02 {

  static int staticvalue;


  public void instanceMethod() {

    Exam02.staticvalue = 1000; // ok
    // 만약 메서드가 스태틱 변수와 같은 클래스에 있다면.
    // 클래스명 생략가능
    staticvalue = 2000;       // OK

  }
  static {
    Exam02.staticvalue = 4000; // ok
    staticvalue = 3000;        // ok
   }
  public static void main(String[] args) {

    Exam02.staticvalue = 5000; // ok
    staticvalue = 6000;        // ok
    System.out.println(Exam02.staticvalue);
    System.out.println(staticvalue);


  }
}

/*
*/
