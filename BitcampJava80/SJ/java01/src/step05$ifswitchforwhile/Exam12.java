package step05$ifswitchforwhile;

public class Exam12{

  public static void main(String[] args){
      /*
      for( 초기 ; 조건 ;증감)
      */
      for(/*1*/int i = 0; /*2*/ i<3; /*3*/ i++)
      {
        /*4*/ System.out.println(i);
      }
      System.out.println("----------------------------------");
      //for 실행순서
      // 1> 2 >3 >4 >2  (반복)3 >4 >2

      //1) 초기값 없이
      int i=0;
      for(;i<3;i++)
      {
        System.out.println(i);
      }
      System.out.println("----------------------------------");

      //2) 증감값 없이
      i=0;
      for(;i<3;)
      {
        System.out.println(i++);
      }
      System.out.println("----------------------------------");
      //3) 조건문 빼고
      i=0;
      for(;;)
      {
        System.out.println(i++);
        if(i>=3)
          break;
      }
      System.out.println("----------------------------------");
      //그러나 이럴거면 While 문 쓸것.

  }
}
