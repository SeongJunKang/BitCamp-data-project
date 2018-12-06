package step35.exam02;

public class Test01 {

  public static void main(String[] args) {
    Account account = new Account(1000000);
    ATM 강남 = new ATM("강남",account);
    ATM 부산 = new ATM("부산",account);
    ATM 광주 = new ATM("광주",account);
    ATM 제주 = new ATM("제주",account);
    
    강남.start();
    부산.start();
    광주.start();
    제주.start();
  }

}
