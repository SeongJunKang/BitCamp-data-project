/*
 * 주제 :기존 클래스에 기능 추가하기 
 * 방법 1 :
 * 기존 클래스에 소스 추가
 * 방법 2 :
 * 기존 클래스를 상속 받아 기능 추가.
 */
package designPattern.command.exam02;

public class Test {
  public static void main(String[] args) {
    Calculator c = new Calculator();
    c.plus(10, 20);
    c.minus(10, 20);
    // 추가한 기능 사용
    c.multiple(10, 20);
  }
}
 