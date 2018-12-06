package step35.exam02;

public class Test01 {
  public static void main(String[] args) {
    Account account = new Account(1000000);
    ATM a1 = new ATM("강남", account);
    ATM a2 = new ATM("부산", account);
    ATM a3 = new ATM("광주", account);
    ATM a4 = new ATM("제주", account);
    
    a1.start();
    a2.start();
    a3.start();
    a4.start();
    
    // main() 메서드 실행을 마쳤다하더라도 스레드가 실행 중이면 
    // 프로그램을 종료하지 않는다.
  }
}








