package step35.exam02;

public class ATM extends Thread{
  Account account;
  public ATM(String name,Account account) {
    super(name);
    this.account = account;
  }
  @Override
  public void run() {
    long sum = 0;
    long money = 0;
    while ((money = account.withdraw(100))> 0) {
      sum += money;
    }
    System.out.printf("%s : %7d\n",this.getName(),sum);
  }
}
