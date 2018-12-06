package step36;

public class UnitCalculatorimpl implements UnitCalculator{

  @Override
  public double KilogramToPound(double kilogram) {
    System.out.println("UnitCalculatorimpl.kTop");
    return kilogram * 2.204623;
  }

  @Override
  public double KilometerToMile(double kilometer) {
    System.out.println("UnitCalculatorimpl.kTom");
    return  kilometer * 0.621371;
  }
  
}
