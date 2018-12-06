//주제 다형적 변수에서 메서드 호출

package step15$polymorphic.exam02;

public class Test4 {

  public static void main(String[] args) {

    Member s1 = new Student();
    s1.id = "hong";
    s1.password = "1111";
    // 하위 클래스의 인스턴스를 가리키는 레퍼런스를 지고
    // 메서드를 호출한다면, 다음에 따라 실행
    // 하위 클래스의 오버라이딩 메서드를 먼저 호출
    s1.printInfo();
  }
}
