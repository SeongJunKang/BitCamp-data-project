/*
출처: codefights.com


한 줄에 버그가 있다. 고쳐라!
 */
package quiz;

public class Test08 {
  static int maxFraction(int[] numerators, int[] denominators) {
    int maxFractionIndex = 0;
    for (int i = 1; i < numerators.length; i++) {=
      if (numerators[i] * denominators[maxFractionIndex] >
        denominators[i] * numerators[maxFractionIndex]) {
        maxFractionIndex = i;
      }
    }
    return maxFractionIndex;
  }

  public static void main(String[] args) {
    System.out.println(maxFraction(
        new int[]{5, 2, 5}, new int[]{6, 3, 4}));

  }
}
