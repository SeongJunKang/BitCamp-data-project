/* 주제: 할당 연산자 */
package step04;

public class Exam08 {
  public static void main(String[] args) {
    int i = 10;
    i = i + 5;

    int j = 10;
    j += 5;
    System.out.printf("%d, %d\n", i, j);

    // +=, -=, *=, /=, %=, &=, |= ^=, <<=, >>=, >>>=
    i = i ^ 0x45;
    i ^= 0x45;
  }
}
