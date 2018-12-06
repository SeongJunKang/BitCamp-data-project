package step05$ifswitchforwhile;

public class Exam06{

  public static void main(String[] args){
    int job = 3;    //: 일반관리직 , 2: 운영팀 , 3: 개발
    switch(job){
      case 1 :
        System.out.println("오피스 자격증");
        break;
      case 2 :
        System.out.println("리눅스 자격증");
        break;
      case 3 :
        System.out.println("자바 자격증");
        break;
      default :
        System.out.println("없는 직종입니다.");
        break;
    }

  }
}
