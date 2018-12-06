package test01;

public class Exam04 {

  public static void main(String[] args) {

    Calculator4 cal = new Calculator4();
    Calculator4 cal2 = new Calculator4();
    cal.result = 0;
    cal2.result = 0;
    cal.plus(2);
    cal2.plus(3);
    cal.mul(5);
    cal2.minus(7);
    cal.minus(3);
    cal2.plus(5);
    System.out.println(cal.result);
    System.out.println(cal2.result);
  }
}
