package step36;

public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

  @Override
  public double plus(double a, double b) {
    System.out.println("ArithmeticCalculator.plus()");
    return a + b;
  }

  @Override
  public double minus(double a, double b) {
    System.out.println("ArithmeticCalculator.minus()");
    return a - b;
  }

  @Override
  public double multiple(double a, double b) {
    System.out.println("ArithmeticCalculator.multiple()");
    return a * b;
  }

  @Override
  public double divide(double a, double b) {
    System.out.println("ArithmeticCalculator.divide()");
    return a / b;
  }

}
