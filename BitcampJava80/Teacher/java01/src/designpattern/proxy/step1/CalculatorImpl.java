package designpattern.proxy.step1;

public class CalculatorImpl implements Calculator {

  @Override
  public double plus(double a, double b) {
    return a + b;
  }

  @Override
  public double minus(double a, double b) {
    return a - b;
  }

  @Override
  public double multiple(double a, double b) {
    return a * b;
  }

  @Override
  public double divide(double a, double b) {
    return a / b;
  }

}
