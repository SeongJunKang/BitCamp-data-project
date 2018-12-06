package step19$Exception;

public class Test2 {

  public static void main(String[] args) {
    Calculator2 calc = new Calculator2();
    calc.plus(10);
    try {
      System.out.println("----------------------------------------");
      calc.divide(0);
      System.out.println(calc.result);
      System.out.println("----------------------------------------");
    } catch (ArithmeticException e) {
      System.out.println("나누기 오류 발생 ! ");
      System.out.println(e.getMessage());
      System.out.println("----------------------------------------");
      e.printStackTrace();
    }
  }
}
