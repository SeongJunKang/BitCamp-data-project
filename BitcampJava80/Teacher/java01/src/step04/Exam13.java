/* 주제: 연산자 우선순위와 후위 연산자 */
package step04;

public class Exam13 {
  public static void main(String[] args) {
    int i = 3;
    int r = i++ + i++ * i++;
    System.out.println(r); // 23

    /* 실행 순서
    r = 3 + 4 * 5;
    r = 23
    결론 => *, /, % 보다 후위 연산자(++, --)가 우선한다.
    */

  }
}
