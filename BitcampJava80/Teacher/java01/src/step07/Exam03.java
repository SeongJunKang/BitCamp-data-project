/* 주제: 클래스 변수의 한계 */
package step07;

public class Exam03 {
  public static void main(String[] args) {
    // 문제: 2 * 3 + 6 - 7 = ?
    // 문제: 3 - 7 * 2 + 27 = ?  (단, 연산자 우선순위 무시한다. 순서대로 계산할 것);
    Calculator2.result = 0;
    Calculator2.plus(2); // 0 + 2
    Calculator2.plus(3); // 0 + 3

    Calculator2.multiple(3); // 0 + 2 * 3
    Calculator2.minus(7); // 0 + 3 - 7

    Calculator2.plus(6); // 0 + 2 * 3 + 6
    Calculator2.multiple(2); // 0 + 3 - 7 * 2

    Calculator2.minus(7); // 0 + 2 * 3 + 6 - 7
    Calculator2.plus(27); // 0 + 3 - 7 * 2 + 27

    System.out.println(Calculator2.result);
    System.out.println(Calculator2.result);

    // 해결책?
    // => 중간 계산 결과를 개별적으로 관리하면 된다.
    // => Exam04.java
  }
}
