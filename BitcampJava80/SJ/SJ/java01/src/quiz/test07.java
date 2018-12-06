package quiz;//->>>>>>>>>>>문제를모름

// 출처: codefights.com
// 한 줄에 버그가 있다. 고쳐라!
/*
정수 n값이 주어진다.
십진수 에서 n!로 묘사되는 trailing zeros 숫자들을 찾아라.

Given an integer n, find the number of trailing zeros
in the decimal representation of n!
(the exclamation mark means factorial).

Example

for n = 10 output should be 2

[input] integer n

a positive integer
[output] integer
*/
import java.util.Scanner;
public class test07 {

  static long factorial(long a) {
    long x = 1;
    if(a != 1)
      x=a * factorial( --a);
    return  x;
  };

  public static void main(String[] args) {
    int n=0;
    int result = 0;
    Scanner S = new Scanner(System.in);
    while(true){
      n=S.nextInt();
    for (int i = 5; i <= n; i += 5) {
      int number = i;
      while (number % 5 == 0) {
      //while (number % 2 == 0) {
        //System.out.println(number);

        number /= 5;
        result++;
      }
    }
    System.out.println(result);
    System.out.println(factorial((long)n));
    result=0;
  }
  }

}
