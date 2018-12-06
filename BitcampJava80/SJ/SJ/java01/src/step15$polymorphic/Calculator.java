package step15$polymorphic;

public class Calculator {
  protected int result;

  public void init(int value) {
    this.result = value;
  }

  public void plus(int value) {
    this.result += value;
  }

  public void minus(int value) {
    this.result -= value;
  }

  public void printResult() {
    System.out.println(this.result);
  }

}
