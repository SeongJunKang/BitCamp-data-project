// 주제: top level inner class 사용
package step20.exam03;

public class Test1 {
  public static void main(String[] args) {
    // "변수든 메서드든, 아니면 중첩 클래스든 간에
    // 바깥 클래스의 멤버일 뿐이다."
    Outer2.no = 20; // <--- 스태틱 변수 사용
    Outer2.m(); // <--- 스태틱 메서드 사용
    Outer2.Inner.m(); // <--- 스태틱 중첩 클래스 사용.


  }
}
