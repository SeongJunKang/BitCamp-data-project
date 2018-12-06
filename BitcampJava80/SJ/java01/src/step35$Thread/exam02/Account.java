package step35$Thread.exam02;

public class Account {
  long balance;

  public Account(long balance) {
    this.balance = balance;
  }
  /*
   * 여러 스레드가 동시에 진입했을 때
   * 공유 객체의 값을 서로 덮어 쓸 수 있다.
   * => 치명적인 코드 블럭 
   * => critical section(region) 
   * <=> Thread Safe 
   * <=> 여러 스레드가 동시에 진입하여 실행해도 안전한 코드 
   */
  /*withdraw() 계좌 객체를 공유하기 때문에 
   * 여러 스레드가 동시에 진입했을 때 계좌의 잔액을 덮어쓰는 문제가 발생한다.
   * => 이렇게 여러 스레드가 진입하면 문제가 발생하는 코드를 
   *        "critical section(region)"이라고 부른다. 
   * => 해결책 ? 한번에 한 스레드만이 접근하도록 제한하면 된다.
   *        "뮤텍스(Mutual exclusion)"이라고 부른다.
   *    *참고 : n 세마포어(semaphore)는 n개의 스레드가 진입하는 것을 허용한다.
   *            "1 세마포어" = "뮤텍스"
   * => synchronized : 메서드 블록 앞에 붙여 한번에 
   *                   한 스레드만이 진입하도록 제어.
   */
  synchronized
  public long withdraw(long money) {
    long balance = this.balance;
    Math.random();
    balance -= money;
    Math.abs(0.4);
    if (balance >= 0) {
      Math.random();
      this.balance = balance;
      return money;
    } else {
      return 0;
    }
  }
}
/* 동기화 문제 해결책
 * => critical section에 진입을 관리
 * semaphore  
 * - n개의 진입만 허용
 * mutext(mutual exclusion
 * - 1개 진입만 허용
 * - 상호 배제
 * - 예제) 선풍기 풍향세기 
 */