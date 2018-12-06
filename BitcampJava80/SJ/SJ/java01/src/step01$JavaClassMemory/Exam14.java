/* 주제: 특수 문자의 표현 -Escape 문자 사용 */
package step01$JavaClassMemory;

public class Exam14 {
  public static void main(String[] args) {

    System.out.print("Hello");
    System.out.print('\b');     // return backspace unicode :0x 0008
    System.out.print("World\n");// \n return linefeed unicode :0x 000a
    System.out.print('"'+"\n");;// 큰따옴표 :0x 0022
    System.out.print("THis is \"홍길동\".\n");
    System.out.print('\''+"\n");// 작은따옴표 :0x 0027
    System.out.print('\\'+"\n");// 작은따옴표 :0x 005c

    /*
    System.out.print('\t');
    System.out.print('\f');
    System.out.print('\r');
    System.out.print('\"');
    System.out.print('\'');
    System.out.print('\\');
*/

  }
}

/* Escape 문자
- \b : backspace
- \t : tab
- \n : linefeed (LF)
- \f : formfeed
- \r : carrage return(CR)
- \" : double quote
- \' : single quote
- \\ : backslash
*/
