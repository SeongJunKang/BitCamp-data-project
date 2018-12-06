package step15$polymorphic;

public class CalculatorPlus extends Calculator {

  

  public void multiple(int value) {
    this.result *= value;
  }

  public void divide(int value) {
    this.result /= value;
  }

  public void remainder(int value) {
    this.result %= value;
  }

}
