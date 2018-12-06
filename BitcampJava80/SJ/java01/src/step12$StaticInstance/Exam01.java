/* 주제 : 스태틱 변수( 클래스 변수) 와 스태틱 블록*/

package step12$StaticInstance;

public class Exam01 {

  static int staticvalue;
  int instancevalue;

  public void instanceMethod() {
    System.out.println(instancevalue);
  }
  public Exam01() {
    instancevalue = 100;
  }

  // static 변수를 사용하기 전에 적절한 값으로 초기화 시키는 방법.
  // static 블록
  static {
    staticvalue = 500;
  }

  public static void main(String[] args) {

      System.out.println(Exam01.staticvalue);
      Exam01 x = new Exam01();
      x.instanceMethod();

  }
}

/* 스태틱 블록
1) 클래스 로딩
2) 스태틱 변수 준비
3) 스태틱 변수의 초기화 문장 실행

*/
