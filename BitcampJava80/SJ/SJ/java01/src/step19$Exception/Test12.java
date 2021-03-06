// 주제 : RuntimeException 의 이해 2 ~ 활용
package step19$Exception;

public class Test12 {

  static void m1(int i) throws Exception {
    m2(i);
  }

  static void m2(int i) throws Exception {
    m3(i);
  }

  static void m3(int i) throws Exception {
    throw new Exception("예외입니다.");
  }

  public static void main(String[] args) {
    try{
      m1(75);
    } catch (Exception e) {
      // System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }

}


/*
Exception 의 의미
1) 예외가 발생할 수 있는 메서드에 대해서
   명확하게 메서드 선언부에 명시함으로써
   개발자가 주의깊게 사용하도록 유도한다.
2) 최종 메서드 호출 중간에 위치한 메서드들이 많은 경우
   매번 예외처리를 해야하기 때문에 코딩이 불편하다.
3) 그러나 예외처리를 강제함으로써 실행 안정성을 어느 정도 확보.
   "계륵과 같은 존재"
*/
