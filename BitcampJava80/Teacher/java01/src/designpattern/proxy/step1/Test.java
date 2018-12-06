/* 주제: Calculator 객체를 직접 만들어 사용하기. */

package designpattern.proxy.step1;

public class Test {

  public static void main(String[] args) {
    // 계산기 객체 사용하기
    // 1) 객체 생성
    Calculator calc = new CalculatorImpl();
    
    // 2) 메서드 호출
    System.out.printf("10 + 20 = %f\n", calc.plus(10, 20));
    System.out.printf("10 - 20 = %f\n", calc.minus(10, 20));
    System.out.printf("10 * 20 = %f\n", calc.multiple(10, 20));
    System.out.printf("10 / 20 = %f\n", calc.divide(10, 20));
  }

}
