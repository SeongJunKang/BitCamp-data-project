package step05$ifswitchforwhile;

public class Exam09{

  public static void main(String[] args){
    String job = "개발";    //문자열은 java 7 이상 버전에서만 사용가능!
    switch(job){
      case "개발" :
        System.out.println("자바 자격증");
        break;
      case "운영" :
        System.out.println("리눅스 자격증");
        break;
      case "일반관리직" :
        System.out.println("오피스 자격증");
        break;
      default :
        System.out.println("자격증 필요 없음");
        break;

    }
      //switch 문에 사용할 수 있는 값의 종류 :
      /*
      byte, short, int , char ,4 바이트 정숙밧
      String 가능
      enum 타입 가능(특별한 상수 타입)
      */
  }
}
