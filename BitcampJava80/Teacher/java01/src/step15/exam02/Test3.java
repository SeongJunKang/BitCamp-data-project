// 주제: 다형적 변수의 형변환
package step15.exam02;

public class Test3 {
  public static void main(String[] args) {
    Member s1 = new Member();
    s1.id = "hong";
    s1.password = "1111";

    // s1은 Member 인스턴스를 가리킨다.
    // => 그런데 다음과 같이 s1이 가리키는 것이 Student라고 속이고
    //    형변환한다면 컴파일러는 속는다.
    // => 그러나 실행할 때 오류 발생한다.
    Student s2 = (Student)s1;
    s2.isWorking = true;

  }
}
