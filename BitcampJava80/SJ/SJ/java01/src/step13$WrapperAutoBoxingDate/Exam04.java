//주제 : 날짜 정보를 다루는 클래스
package step13$WrapperAutoBoxingDate;
import java.sql.Date;

public class Exam04 {

  public static void main(String[] args) {

    long currTime = System.currentTimeMillis();
    Date today  = new Date(currTime);

    System.out.println(today);

  }
}


/*

*/
