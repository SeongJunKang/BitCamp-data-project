/* 주제: 후위 증가/감소 연산자 */
package step04$operator;

public class Exam10 {
  public static void main(String[] args) {
    int i=10;

    i++;// 후위 증가 연산자(postfix)
    i++;
    i++;
    System.out.println(i);

    int j= 10;
    j--;
    j--;
    j--;//후위 감소 연산자
    System.out.println(i);

    i=10;
    j=10;
    System.out.println(i++);
    System.out.println(j--);

    // 전위 연산자는 먼저 값을 증가 시킨후 그 자리에 값을 놓는다.
    // 후위 연산자는 값을 먼저 놓은 다음에 변수의 값을 증가 시킨다.
  }
}
