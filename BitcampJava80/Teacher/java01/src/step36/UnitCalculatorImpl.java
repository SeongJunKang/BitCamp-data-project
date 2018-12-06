package step36;

public class UnitCalculatorImpl implements UnitCalculator {

  @Override
  public double kilogramToPound(double kilogram) {
    System.out.println("UnitCalculatorImpl.kilogramToPound()");
    return kilogram * 2.2;
  }

  @Override
  public double KilometerToMile(double kilometer) {
    System.out.println("UnitCalculatorImpl.KilometerToMile()");
    return kilometer * 0.621;
  }

}
