// 주제 : 왜 Exception을 상속 받는가 ?
package step19$Exception;

public class Test16 {
/// Exception 만 사용하여 예외 정보 전달
  static void m1(int i) throws Exception {
    if (i < 17) {
      throw new Exception("17세 미만입니다.");
    } else if (i > 70) {
      throw new Exception("70세 초과입니다.");
    } else {
      System.out.println("케케케케케켘");
    }
  }
// Exception 의 하위 클래스를 사용하여 예외 정보 전달
  static void m2(int i) throws ChildException, OldmanException {
    if (i < 17) {
      throw new ChildException("17세 미만입니다.");
    } else if (i > 70) {
      throw new OldmanException("70세 초과입니다.");
    } else {
      System.out.println("케케케케케켘");
    }
  }

  public static void main(String[] args) {

    try{
      m1(10);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try{
      m2(10);
      // 예외를 던지는 쪽에서 Exception 으로 한번에 던지지 않고
      // 하위 클래스를 사용하여 좀 더 명확하게 예외를 던진다면,
      // 다음과 같이 예외를 처리할 때도 구분하여 처리할 수 있다.
    } catch (ChildException e) {
      System.out.println(e.getMessage());
    } catch (OldmanException e) {
      System.out.println(e.getMessage());
    }

  }
}

/*
Exception 을 상속 받아서 하위 예외를 만드는 이유 ?

1) 예외를 좀 더 상세하게 던질 수 있고,
  구분하여 처리할 수 있다.
2) 클래스 이름 만으로 예외를 빠르게 식별할 수 있다.
-> 보통 Exception 하위 클래스를 만들 떄 특별히 메서드를 추가하지 않는다.
-> 그럼에도 불구하고 이렇게 하는 이유는 ?
    => 예외가 발생했을 때 클래스 이름만으로 예외 내용을 빠르게 캐치하기 위함.



*/
