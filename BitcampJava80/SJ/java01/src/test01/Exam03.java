package test01;

public class Exam03 {

  public static void main(String[] args) {

    Calculator3 cal = new Calculator3();
    Calculator3 cal2 = new Calculator3();
    cal.result = 0;
    cal2.result = 0;
    cal.plus(cal,2);
    cal2.plus(cal2,3);
    cal.mul(cal,5);
    cal2.minus(cal2,7);
    cal.minus(cal,3);
    cal2.plus(cal2,5);
    System.out.println(cal.result);
    System.out.println(cal2.result);
  }
}
