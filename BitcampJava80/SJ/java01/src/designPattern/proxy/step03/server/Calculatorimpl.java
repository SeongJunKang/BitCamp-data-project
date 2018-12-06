package designPattern.proxy.step03.server;

public class Calculatorimpl implements Calculator{

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
