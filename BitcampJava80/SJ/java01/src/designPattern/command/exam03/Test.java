/*
 * 주제 :기존 클래스에 기능 추가하기 
 * 
 */
package designPattern.command.exam03;

public class Test {
  public static void main(String[] args) {
    Calculator2 c = new Calculator2();
    // 수퍼클래스 기능 사용
    c.plus(10, 20);
    c.minus(10, 20);
    // 하위 클래스에서 추가한 기능사용
    c.multiple(10, 20);

  }
}
 