/*
각 클래스마다 값을 개별적으로 관리하ㄱㅣ
*/
package step07$StaticClass;
public class Exam05 {
  public static void main(String[] args) {


    calculator4 calc1 = new calculator4();
    calculator4 calc2 = new calculator4();

    calc1.plus(2);
    calc2.plus(3);
    calc1.multiple(3);
    calc2.minus(7);
    calc1.plus(6);
    calc2.multiple(2);
    calc1.minus(7);
    calc2.plus(27);
    System.out.println(calc1.result); //5
    System.out.println(calc2.result); //19
  }
}
