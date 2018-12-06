/* 주제 : 변수와 메소드 정리*/

package step12$StaticInstance;

public class Exam05 {


  public static void main(String[] args) {

    // Car.model = "티코";
    // Car.maker = "비트자동차";
    // Car.cc = 2000;
    // Car.capacity = 5;


    // 인스턴스 변수에 접근하려면 먼저
    // 그 클래스의 인스턴스( 클래서 설계도에 따라 준비한 메모리)를 생성

    Car2 car = new Car2();    // 인스턴스 묶음 하나 준비
    Car2 car2 = new Car2();    // 인스턴스 묶음 하나 더 준비 ( 총 2개)
    Car2 car3 = new Car2();    // 인스턴스 묶음 하나 더 준비 ( 총 3개)
    car.model = "티코";
    car.maker = "비트자동차";
    car.cc = 2000;
    car.capacity = 5;

    car2.model = "그랜저";
    car2.maker = "비트자동차";
    car2.cc = 3000;
    car2.capacity = 5;

    car3.model = "코란도";
    car3.maker = "비트자동차";
    car3.cc = 3500;
    car3.capacity = 2;


  }
}

/*

*/
