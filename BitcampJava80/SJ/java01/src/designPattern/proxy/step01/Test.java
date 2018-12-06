package designPattern.proxy.step01;

public class Test {

  public static void main(String[] args) {
    //계산기 객체사용하기
    // 1) 객체생성
    Calculator calc = new Calculatorimpl();
    
//    2) 메서드 호출
    System.out.println("10 + 20 = " +calc.plus(10, 20));
    System.out.println("10 - 20 = " +calc.minus(10, 20));
    System.out.println("10 * 20 = " +calc.multiple(10, 20));
    System.out.println("10 / 20 = " +calc.divide(10, 20));
    
    

  }

}
