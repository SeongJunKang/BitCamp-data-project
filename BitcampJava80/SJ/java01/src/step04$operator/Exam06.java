/* 주제: 비트 연산자 사용 */
package step04$operator;

public class Exam06 {
  public static void main(String[] args) {
    // 비트연산자 사용 전
    boolean c =true;
    boolean cpp =false;
    boolean python =true;
    boolean php =false;
    boolean javascript =false;
    boolean java =true;
    boolean cs =false;
    boolean go =false;
    boolean scala =false;

    //값
    if(java== true)
      System.out.println("자바사용가능");

    //배열
    boolean[] lang = { true,false, true, false, false,true,false,false,false};
    if(lang[5] == true)
      System.out.println("자바사용가능");

    //비트연산자 사용후
    int mylang =0b1_0100_1000;

    //각 언어의 값이 무엇인지 알아낼 때 사용할 마스크 선언.
    int c_L=0b1_0000_0000;      //8번 비트의 값만 추출하는 마스크로 사용
    int cpp_L=0b0_1000_0000;    //7번 비트의 값만 추출하는 마스크로 사용
    int py_L=0b0_0100_0000;     //6번 비트의 값만 추출하는 마스크로 사용
    int j_L=0b0_0000_1000;      //3번 비트의 값만 추출하는 마스크로 사용

    //비교를 수행. -> 비교할 값에 마스크를 씌운다.
    // 그래서 통과된 값이 마스크 값과 일치하는지 검사.
    if( (mylang & j_L) == j_L) System.out.println("자바사용가능");
    if( (mylang & c_L) == c_L) System.out.println("C 사용가능");
    if( (mylang & cpp_L) == cpp_L) System.out.println("cpp 사용가능");

  }
}
