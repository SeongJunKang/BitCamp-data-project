/*
출처: codefights.com

등비수열(geometric progression 또는 geometric sequence)인지 검사하라.
등비수열이면 true, 아니면 flase를 출력하라.

등비수열이란?
=> 각 항이 그 앞 항과 일정한 비를 가지는 수열.
=> 이 일정한 비를 공비(common ratio)라고 한다.

Example
[1, 4, 16] = true <-- 공비는 4
[2, 4, 8, 17, 34] = false

입력: 정수 배열
출력: boolean 값

한 줄에 버그가 있다. 고쳐라!
 */
package quiz;

public class Test06 {
  static boolean isGeometricProgression(int[] sequence) {
    for (int i = 2; i < sequence.length; i++) {
      if (sequence[i] * sequence[0] != sequence[i - 1] * sequence[1]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isGeometricProgression(new int[]{1,4,16}));
    System.out.println(isGeometricProgression(new int[]{2,4,8,17,34}));
  }
}
