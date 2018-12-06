/*
클래스 공용변수 사용
*/
package step07$StaticClass;
//import step07.calculater;
public class Exam02 {
  public static void main(String[] args) {

    //공용변수 사용전
    int a = calculator.multiple(2, 3);
    a = calculator.plus(a, 6);
    a = calculator.minus(a, 7);
    System.out.println(a);

    //공용변수 사용후
    calculator2.result = 0;
    calculator2.plus(2);
    calculator2.multiple(3);
    calculator2.plus(6);
    calculator2.minus(7);
    System.out.println(calculator2.result);
  }
}

/*

*/
