/* 주제: 후위 증가/감소 연산자2 */
package step04$operator;

public class Exam11 {
  public static void main(String[] args) {
    int i=10;
    int r1 = ++i + ++i + ++i;
    System.out.println(r1);

    int j=10;
    int r2 = j++ + j++ + j++;
    System.out.println(r2);

    i=10;
    i=i++;
    System.out.println(i);

  }
}
