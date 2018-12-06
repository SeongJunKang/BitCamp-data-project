// 스레드를 정의하는 방법1 => Thread 상속하기
package step35$Thread.exam01;

public class Test03 {
  
  static class MyThread extends Thread {
    @Override
    public void run() {
      for (int i = 0; i < 10000; i++) {
        Math.random();
        Math.atan(0.5);
        Math.asin(0.5);
        System.out.println("==>" + i);
      }
    }
  }
  
  public static void main(String[] args) {
    MyThread t = new MyThread();
    t.start();
    
    for (int i = 0; i < 10000; i++) {
      Math.random();
      Math.atan(0.5);
      Math.asin(0.5);
      System.out.println(i);
    }
  }
}
