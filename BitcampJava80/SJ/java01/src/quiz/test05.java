package quiz;

// 출처: codefights.com
//
// 한번에 한 자리의 숫자만 바꿀 때 이전 값과 다르게 만들 수 있는 경우는 몇가지인가?
// 단 맨 앞의 숫자는 0이 될 수 없다.
// 예)
// 10 => 17
//
// 한 줄에 버그가 있다. 고쳐라!
//
public class test05 {

  public static void main(String[] args) {
  /*  int value=1230;
    int answer = 0;
    while (value > 0) {
      answer += 9 - value % 10;
      value /= 10;
    }
    System.out.println(answer);

*/
    int value = 1;
    String str = Integer.toString(value);
    int leng = str.length();
    int result = (leng==1)? 9 :leng * 9 - 1;
    System.out.println(result);


  }

}
