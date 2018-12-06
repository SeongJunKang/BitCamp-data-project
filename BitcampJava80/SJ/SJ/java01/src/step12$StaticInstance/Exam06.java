/* 주제 : 변수와 메소드 정리*/

package step12$StaticInstance;

public class Exam06 {


  public static void main(String[] args) {

    Car3 car = new Car3("티코","비트자동차",2000,5);    // 인스턴스 묶음 하나 준비
    Car3 car2 = new Car3("그랜저","비트자동차",3000 ,5);    // 인스턴스 묶음 하나 더 준비 ( 총 2개)
    Car3 car3 = new Car3("코란도","비트자동차",3500,2);    // 인스턴스 묶음 하나 더 준비 ( 총 3개)

  }
}

/*

*/
