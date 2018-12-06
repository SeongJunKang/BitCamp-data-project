package step20$InnerClass.exam03;
import java.lang.reflect.Method;

public class Outer7 {
  int no ;
  //anonymous inner class에 메서드 추가하기
  void m() {

    Object obj1 = new Object() {
      @Override
      public String toString() {
        return "으헿헿헤헿ㅎㅎㅎㅎ";
      }

    };    // Object의 하위 클래스
    System.out.println(obj1);
  }
}
