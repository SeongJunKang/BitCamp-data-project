// 주제 : catch의 다형성  - try 블록에 여러 예외가 있을 때
package step19$Exception;

public class Test15 {

  static void m1(int i) throws AgeException {
    throw new AgeException();
  }

  static void m2(int i) throws ChildException {
    throw new ChildException();
  }

  static void m3(int i) throws OldmanException {
    throw new OldmanException("예외입니다.");
  }

  public static void main(String[] args) {

    try{
      m3(10);
      m2(10);
      m1(10);
    // } catch (AgeException e) {         // 상위 클래스이기 때문에 여기서 모두 잡음.
      // e.printStackTrace();
    } catch (OldmanException e) {
      e.printStackTrace();
    } catch (ChildException e) {
      e.printStackTrace();
    } catch (AgeException e) {          //  상위 클래스는 아래에 있어야 한다.
      e.printStackTrace();
    }
  }
}

/*
catch 작성 순서
- try  블록에서 여러 개의 예외가 발생하고,
  각각의 예외를 개별로 처리해야할 경우,
  -> 예외 간의 상속관계를 따져서 최하위 예외부터 잡도록 해야한다.ㅊ
*/
