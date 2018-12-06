// 주제: catch의 다형성 - try 블록에 여러 예외가 있을 때,
package step19;

public class Test15 {

  static void m1(int i) throws AgeException {
    throw new AgeException();
  }

  static void m2(int i) throws ChildException {
    throw new ChildException();
  }

  static void m3(int i) throws OldManException {
    throw new OldManException();
  }

  public static void main(String[] args) {
    try {
      m3(10); // throw OldManException
      m2(10); // throw ChildException
      m1(10); // throw AgeException

    /*
    } catch (AgeException e) { // 이렇게 하면 안된다. 왜? 여기서 모두 잡는다.
      e.printStackTrace();
    */
    } catch (OldManException e) {
      e.printStackTrace();
    } catch (ChildException e) {
      e.printStackTrace();
    } catch (AgeException e) { // 상위 클래스가 아래에 위치해야 한다.
      e.printStackTrace();
    }
  }
}

/*
# catch 작성 순서
- try 블록에서 여러 개의 예외가 발생하고,
  각각의 예외를 개별로 처리해야할 경우,
  => 예외 간의 상속관계를 따져서 최하위 예외부터 잡도록(catch)한다.






*/
