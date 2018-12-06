/* 주제: char[] 배열을 이용하여 String 물건 만들기 */
package step03;

public class Exam05 {
  public static void main(String[] args) {
    char[] c = {'H', 'e', 'l', 'l', 'o'};
    String s = new String(c);
    // 1) new String(c) : c 배열의 값을 가지고 String 물건을 만든다.
    // 2) 물건의 주소를 그 자리에 둔다.
    // 3) 물건의 주소를 s 메모리에 저장한다.

    System.out.println(s);
    // println(String 물건의 주소) : 물건이 있는 주소로 찾아가서
    //                               String 물건의 내용을 출력한다.

    int i = 10;
    System.out.println(i); // println(값) : 값을 출력한다.
  }
}
