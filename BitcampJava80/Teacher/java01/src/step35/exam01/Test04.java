// 주제: 스레드를 정의하는 방법2 => Runnable 인터페이스 구현하기
package step35.exam01;

public class Test04 {
  
  static class MyRunnable implements Runnable {
    @Override
    public void run() {
      for (int i = 0; i < 10000; i++) {
        Math.random();
        System.out.println("==> " + i);
        Math.asin(0.5);
      }
    }
  }
  
  public static void main(String[] args) {
    MyRunnable r = new MyRunnable();
    
    // Runnable 구현체는 Thread 객체에 담아서 실행한다.
    // => 실무에서는 이 방법을 많이 쓴다.
    Thread t = new Thread(r);
    t.start();
    
    for (int i = 0; i < 10000; i++) {
      Math.random();
      System.out.println(i);
      Math.asin(0.5);
    }
  }
}






