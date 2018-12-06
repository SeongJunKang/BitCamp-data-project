/* 주제: switch 문에 사용할 수 있는 값의 종류 */
package step05;

public class Exam09 {
  public static void main(String[] args) {
    String job = "개발"; // >= java7에서 String 가능해짐
    switch (job) {
    case "개발":
        System.out.println("자바 자격증");
    case "운영":
        System.out.println("리눅스 자격증");
    case "일반":
        System.out.println("오피스 자격증");
        break;
    default:
        System.out.println("자격증 필요없음.");
    }
    // switch 문에 사용할 수 있는 값의 종류:
    // => byte, short, int, char 4바이트 정수 값.
    // => String 가능
    // => enum 타입 가능(특별한 상수 타입)
    //long v1 = 10L; // 오류!
    //float v1 = 3.14f; // 오류!
    //double v1 = 3.14; // 오류!
    //char v1 = 'A'; // OK
    //byte v1 = 10; // OK
    //short v1 = 10; // OK
    String v1 = "okok"; // OK
    switch (v1) {}
  }





}
