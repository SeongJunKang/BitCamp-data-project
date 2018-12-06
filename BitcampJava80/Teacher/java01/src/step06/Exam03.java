/* 주제: 메서드 정의하기3 */
package step06;

public class Exam03 {

  // 값을 리턴하는 메서드 정의하기
  static String hello() {
    return "안녕하세요";
  }

  public static void main(String[] args) {
    // 값을 반환하는 메서드 실행
    // => 주는 것 안받아도 된다.
    hello();

    // => 메서드가 주는 것 받고 싶다면 그 데이터을 담을 변수를 준비하라.
    String str;
    str = hello(); // 진짜는 문자열 물건의 주소를 리턴한다.
    System.out.println(str);

    String str2 = hello();
    System.out.println(str2);

    // => 리턴하는 데이터 타입과 다른 변수를 선언하면 할당 오류 발생!
    //int value = hello(); // 오류!
  }
}
