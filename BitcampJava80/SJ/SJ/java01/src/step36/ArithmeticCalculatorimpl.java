package step36;

public class ArithmeticCalculatorimpl  implements ArithmeticCalculator{

  @Override
  public double plus(double a, double b) {
    System.out.println("ArithmeticCalculatorimpl.+");
    return a + b;
  }

  @Override
  public double minus(double a, double b) {
    System.out.println("ArithmeticCalculatorimpl.-");
    return a - b;
  }

  @Override
  public double multiple(double a, double b) {
    System.out.println("ArithmeticCalculatorimpl.*");
    return a * b;
  }

  @Override
  public double divide(double a, double b) {
    System.out.println("ArithmeticCalculatorimpl./");
    return a / b;
  }

}
