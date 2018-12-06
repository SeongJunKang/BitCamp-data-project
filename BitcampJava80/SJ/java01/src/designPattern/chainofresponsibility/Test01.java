package designPattern.chainofresponsibility;

public class Test01 {

  public static void main(String[] args) throws Exception{
    // TODO Auto-generated method stub
    PlusOperator op1 = new PlusOperator();
    MinusOperator op2 = new MinusOperator();
    MultipleOperator op3 = new MultipleOperator();
    DivideOperator op4 = new DivideOperator();
    RemainderOperator op5 = new RemainderOperator();
    op1.setNext(op2);
    op2.setNext(op3);
    op3.setNext(op4);
    op4.setNext(op5);
    int result = op1.calculate("*", 2, 3);
    result = op1.calculate("/", result, 2);
    result = op1.calculate("+", result, 5);
    result = op1.calculate("-", result, 7);
    result = op1.calculate("%", result, 4);
    System.out.println(result);
  }

}
