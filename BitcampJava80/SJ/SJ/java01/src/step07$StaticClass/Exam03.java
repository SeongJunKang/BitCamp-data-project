/*
클래스 변수의 한계
*/
package step07$StaticClass;
//import step07.calculater;
public class Exam03 {
  public static void main(String[] args) {
    //문제 2 * 3 + 6 - 7
    //문제 3 - 7 * 2 + 27

    //공용변수 사용후
    calculator2.result = 0;
    calculator2.result = 0;
    calculator2.plus(2);
    calculator2.plus(3);
    calculator2.multiple(3);
    calculator2.minus(7);
    calculator2.plus(6);
    calculator2.multiple(2);
    calculator2.minus(7);
    calculator2.plus(27);
    System.out.println(calculator2 .result); //48
    System.out.println(calculator2 .result); //48

    //해결책
    // 중간 계산 결과를 개별적으로 관리하면 된다.
    // to be continue.
  }
}

/*

*/
