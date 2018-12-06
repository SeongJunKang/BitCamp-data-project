package designPattern.chainofresponsibility;

public abstract class AbstractOperator {
  AbstractOperator nextOperator;

  public AbstractOperator setNext(AbstractOperator operator) {
    this.nextOperator = operator;
    return operator;
  }
  
  public int calculate(String op, int a, int b) {
    if (nextOperator == null) {
      throw new RuntimeException("지원하지 않는 연산자입니다.");
    }
    return nextOperator.calculate(op, a, b);
  }
}
