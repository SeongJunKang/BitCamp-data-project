/* 주제: 반복문 for와 배열 */
package step05;

public class Exam13 {
  public static void main(String[] args) {
    int[] scores = {100, 60, 70, 0};
    for (int i = 0; i < 3; i++) {
      scores[3] += scores[i];
    }
    System.out.println(scores[3]);
  }





}
