package step20$InnerClass.exam03;
import java.lang.reflect.Method;

public class Outer6 {
  int no ;
  //anonymous inner class에 메서드 추가하기
  Object obj1 = new Object() {
    public void test() {
      System.out.println("어떻게 호출하지 ?");
    }
    @Override
    public String toString() {
      return "으헿헿헤헿ㅎㅎㅎㅎ";
    }
  };    // Object의 하위 클래스


  void m() {
    System.out.println(obj1);
    //obj1.test(); // 오류
    // 컴파일러는 레퍼런스 변수의 탑일 조사하여
    // 메서드를 호출할 수 있는지 검사한다.
    // 실제 레퍼런스가 어떤 인스턴스를 가리키는 지는 고려하지 않는다.


    // 직접 코드로 호출할 수는 없지만, 특수 도구를 사용하면 가능.
    try {
      Class classinfo = obj1.getClass();
      Method methodinfo = classinfo.getMethod("test");
      methodinfo.invoke(obj1);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
