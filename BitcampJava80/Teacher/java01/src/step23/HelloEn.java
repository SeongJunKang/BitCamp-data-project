package step23;

// HelloEn 클래스는 Hello 규칙을 이행한다/따른다/실행한다.
// => 즉 Hello 규칙에 선언된 메서드를 만들 것이다라는 의미.
public class HelloEn implements Hello {
  @Override
  public String greet() {
    return "Hello~~";
  }
}
