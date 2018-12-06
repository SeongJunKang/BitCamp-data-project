/* 주제: String 주요 도구 사용법1, immutable object 개념 */
package step03;

public class Exam07 {
  public static void main(String[] args) {
    String s1 = "Hello";
    String s2 = "안녕하세요";

    String s3 = s1.concat(s2); // s1과 s2를 합친 새 String 물건을 생성하여
                               // 그 주소를 리턴한다.

    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s3);
  }
}

/* immutable 객체
=> 내용물을 변경할 수 없는 객체
=> 예) String 객체

mutable 객체
=> 내용물을 변경할 수 있는 객체
=> 예) StringBuffer 객체

String 객체
=> 어떤 메서드를 실행하더라도 원본은 변경되지 않는다.
=> 다만 새 String 객체를 만들어 리턴할 뿐이다.

*/
