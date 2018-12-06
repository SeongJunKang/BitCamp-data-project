// 주제: 왜 상위 클래스의 레퍼런스는 하위 클래스의 인스턴스를 가리킬 수 있는가?
package step15.exam02;

public class Test2 {
  public static void main(String[] args) {
    Member s1 = new Student();
    s1.id = "hong";
    s1.password = "1111";

    // 컴파일러는 항상 레퍼런스의 클래스 범위 내에서만
    // 변수나 메서드를 사용하도록 제약한다.
    // 설사, 더 많은 기능을 가진 하위 클래스의 인스턴스를 가리킬 지라도
    // 무조건 레퍼런스의 클래스 범위 내에서만 사용할 수 있다.
    //s1.isWorking = true; // 컴파일 오류!

    // 해결책? 실제 가리키는 타입으로 형변환시킨 후 사용하라!
    Student s2 = (Student)s1;
    s2.isWorking = true;
    //((Student)s1).isWorking = true; // 위 코드의 단축 코드이다.
  }
}
