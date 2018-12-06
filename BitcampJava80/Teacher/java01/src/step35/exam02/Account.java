package step35.exam02;

public class Account {
  long balance;
  
  public Account(long balance) {
    this.balance = balance;
  }
  
  /* withdraw()는 계좌 객체를 공유하기 때문에 
   * 여러 스레드가 동시에 진입하면 계좌의 잔액을 덮어쓰는 문제가 발생한다.
   * => 이렇게 여러 스레드가 진입할 때 문제가 발생하는 코드를 
   *    "크리티컬 섹션(critical section)" 이라 부른다.
   * => 해결 책? 한 번에 한 스레드만이 접근하도록 제한하면 된다.
   *             "뮤텍스(Mutual exclusion)"라 부른다.
   *    * 참고: "n 세마포어(semaphore)"는 n개의 스레드가 진입하는 것을 허용한다.
   *            "1 세마포어" = "뮤텍스"
   * => synchronized : 메서드나 블록 앞에 붙여 한 번에 한 스레드만이 
   *                   진입하도록 제어한다.            
   */
  /*synchronized*/ public long withdraw(long money) {
    long balance = this.balance;
    Math.random(); // 시간을 조금이라도 지연시킴으로써 OS가 다른 스레드를 실행하도록 유도한다.
    
    balance -= money;
    Math.abs(0.4);
    
    if (balance >= 0) {
      //Math.random();
      this.balance = balance;
      //Math.random();
      return money;
    } else {
      return 0;
    }
  }
}






