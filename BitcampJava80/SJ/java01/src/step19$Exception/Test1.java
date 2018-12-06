package step19$Exception;

public class Test1 {

  public static void main(String[] args) {
    Calculator1 calc = new Calculator1();
    calc.plus(10);
    calc.divide(2);

    System.out.println(calc.result);
  }

}
