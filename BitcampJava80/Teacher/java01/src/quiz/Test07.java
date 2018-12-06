/*
출처: codefights.com

n!(n 팩토리얼) 값을 조사하여 몇 개의 0으로 끝나는 지(trailing zeros) 개수를 리턴하라.
예1) 10!의 값은 두 개의 0으로 끝난다.
예2) 23!은 4개의 값으로 끝난다. (23!의 값은 4바이트를 초과하기 때문에 테스트하지 말아라!)

한 줄에 버그가 있다. 고쳐라!
 */
package quiz;

public class Test07 {
  static int factorialTrailingZeros(int n) {
    int result = 0;
    for (int i = 5; i <= n; i += 5) {
      int number = i;
      while (number % 5 == 0) {
        number /= 5;
        result++;
      }
    }
    return result;
  }

  static long factorial(int n) {
    long result = 1;
    for (int i = 2; i <= n; i++) {
      result *= i;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(factorial(10));
    System.out.println(factorialTrailingZeros(10));

  }
}
