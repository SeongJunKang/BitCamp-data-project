package designPattern.chainofresponsibility;

public class Test02 {

  public static void main(String[] args) throws Exception{
    // TODO Auto-generated method stub
    PlusOperator op =new PlusOperator(); 
        op.setNext(new MinusOperator())
        .setNext(new MultipleOperator())
        .setNext(new DivideOperator())
        .setNext(new RemainderOperator());
    int result = op.calculate("*", 2, 3);
    result = op.calculate("/", result, 2);
    result = op.calculate("+", result, 5);
    result = op.calculate("-", result, 7);
    result = op.calculate("%", result, 4);
    System.out.println(result);
  }

}
