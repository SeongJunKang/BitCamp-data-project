// 주제: 스레드의 생명주기(lifecycle)
package step35.exam01;

public class Test05 {
  
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

/*
# 스레드 생명주기

new Thread() -------------> Runnable 상태 -------------> Not Runnable 상태
               start()            |       sleep(), wait()
                                  |       <-------------
                                  |       timeout, notify()/notifyAll()
                                  |   
                                  V
                                Dead

1) Runnable 상태
   => CPU를 사용할 수 있는 상태.
   => 현재 실행하고 있거나, 프로세스 스케줄링에 따라 실행될 수 있는 상태.
2) Not Runnable 상태
   => CPU를 사용할 수 없는 상태.
   => OS는 이 상태에 있는 스레드는 실행하지 않는다.
3) Dead 상태
   => 스레드 실행을 종료한 상태.
   => Dead 상태에서는 다시 Runnable 상태로 돌아갈 수 없다.
   => start()를 호출하면 오류이다.
4) new Thread() 상태
   => Thread의 실행 준비를 완료한 상태.
   => start()를 통해 Runnable 상태가 되면 다시 이전 상태로 돌아 올 수 없다. 

 *
 */

















