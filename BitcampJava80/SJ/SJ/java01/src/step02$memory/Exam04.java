/* 주제: 문자 변수 사용 */
package step02$memory;
public class Exam04 {

  public static void main(String[] args) {


      char c0= 0x41;
      char c1= 0x0041;
      char c2= '\u0041';        // 유니코드 값 0041을 저장
      char c3= 'A';             // A 문자의 유니코드 값을 저장
      char c4= '가';            // 가 문자의 유니코드 값을 저장
      char c5= 44032;
//      short s1= '가';        // 2byte unsigned 값을 2byte signed 메모리에 저장 불가

      System.out.println((int)c0);
      System.out.println((int)c1);
      System.out.println((int)c2);
      System.out.println((int)c3);
      System.out.println((int)c4);
      System.out.println(c5);
  }
}

/*
*println(변수)
-

*/
