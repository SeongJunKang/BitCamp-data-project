//주제 : mutable 문자열 다루기
package step13$WrapperAutoBoxingDate;


public class Exam06 {

  public static void main(String[] args) {

    String str1 = new String("Hello");
    String r1 = str1.concat(", World!");      //새 문자열 인스턴스 리턴

    if(str1 == r1) {
      System.out.println("str1==r1");
    } else {
      System.out.println("str1!=r1");
    }
    System.out.println(str1);
    System.out.println(r1);

    StringBuffer str2= new StringBuffer("Hello");   // 기존 인스턴스 리턴
    StringBuffer r2 = str2.append(", World!");

    if(str2 == r2) {
      System.out.println("str2==r2");
    } else {
      System.out.println("str2!=r2");
    }

    System.out.println(str2);
  }
}


/*

*/
