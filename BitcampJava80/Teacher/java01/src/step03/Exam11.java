/* 주제: String 주요 도구 사용법5 */
package step03;

public class Exam11 {
  public static void main(String[] args) {
    String str = "비트캠프는 최고의 교육센터 입니다.";

    boolean b = str.startsWith("비트"); // 특정 문자열로 시작하는 지 여부 판별
    System.out.println(b);

    b = str.endsWith("입니다");
    System.out.println(b);

    b = str.contains("교육");
    System.out.println(b);

    String[] arr = str.split(" ");
    // 공백으로 쪼갠 문자열을 배열로 만들어 그 배열의 주소를 리턴.
    // => new String[]{"비트캠프는", "최고의", "교육센터", "입니다."}
    // 물건(object)을 주고 받을 수는 없다. => 주소를 주고 받을 뿐이다.
    // 오직 primitive type(byte,short,int,long,float,double,boolean,char)만
    // 값을 주고 받을 수 있다.

    System.out.println(arr.length);
    System.out.println(arr[0]);
    System.out.println(arr[1]);
    System.out.println(arr[2]);
    System.out.println(arr[3]);
  }
}
