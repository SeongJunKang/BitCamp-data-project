/* 주제 : 변수와 메소드 정리*/

package step12$StaticInstance;

public class Exam07 {


  public static void main(String[] args) {

    Car4 car = new Car4("티코", "비트자동차", 2000, 5);    // 인스턴스 묶음 하나 준비
    Car4 car2 = new Car4("그랜저", "비트자동차", 3000, 5);    // 인스턴스 묶음 하나 더 준비 ( 총 2개)
    Car4 car3 = new Car4();    // 인스턴스 묶음 하나 더 준비 ( 총 3개)
  
    car3.model = "코란도";
    car3.maker = "비트자동차";
    car3.cc = 3500;
    car3.capacity = 2;


  }
}

/*

*/
