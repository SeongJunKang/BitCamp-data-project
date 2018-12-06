
package quiz;

// 출처: codefights.com
//
// 주어진 숫자에 짝수가 몇 개인지 세어라.
// 예)
// 1010 => 2
// 123 => 1
//
//한 줄에 버그가 있다. 고쳐라!
public class test01 {

  public static void main(String[] args) {

    int value =123123124;
    int cnt=0;
    while(value != 0) {
      cnt= (value % 2) == 0? cnt+1:cnt;
      value/=10;
    }
    System.out.println(cnt);

    /*
    int result = 0;
    int n = 1238694636;
    while(n != 0) {
      if ((n % 2) == 0) {
        result++;
      }
      n /= 10;
    }
    System.out.println(result);
*/
  }

}
