package designpattern.chainofresponsibility;

public class Test02 {

  public static void main(String[] args) throws Exception {
    AbstractOperator operator = new PlusOperator();
    operator.setNext(new MinusOperator())
            .setNext(new MultipleOperator())
            .setNext(new DivideOperator())
            .setNext(new RemainderOperator());
    
    System.out.println(operator.calculate("*", 2, 3));
    System.out.println(operator.calculate("/", 2, 3));
    System.out.println(operator.calculate("+", 2, 3));
    System.out.println(operator.calculate("-", 2, 3));
    System.out.println(operator.calculate("%", 2, 3));
    //System.out.println(operator.calculate("^", 2, 3));
  }

}





