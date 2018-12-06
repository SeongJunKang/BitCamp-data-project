//주제 : 날짜 정보를 다루는 클래스
package step13$WrapperAutoBoxingDate;
import java.util.Calendar;

public class Exam05 {

  public static void main(String[] args) {

    Calendar cal = Calendar.getInstance();

    System.out.println(cal.get(Calendar.YEAR));
    System.out.println(cal.get(Calendar.MONTH));
    System.out.println(cal.get(Calendar.DATE));
    System.out.println(cal.get(Calendar.HOUR));
    System.out.println(cal.get(Calendar.MINUTE));
    System.out.println(cal.get(Calendar.SECOND));
    System.out.println(cal.get(Calendar.DAY_OF_WEEK));


    // System.out.println(cal.get(1));   //년
    // System.out.println(cal.get(2));   //월
    // System.out.println(cal.get(5));   //일
    // System.out.println(cal.get(10));  //시
    // System.out.println(cal.get(12));  //분
    // System.out.println(cal.get(13));  //초
    // System.out.println(cal.get(7));   //요일


  }
}


/*

*/
