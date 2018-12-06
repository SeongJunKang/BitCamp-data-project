package step17$Scanner;
import java.util.Scanner;

public class ReceiveCount{

  public static int Receive() {
    int count ;
    Scanner scan = new Scanner(System.in);
    System.out.print("입력받을 회원 수 (0< x <= 100): ");
    while(true){
      count = scan.nextInt();
      if(0 < count && count <= 100)
        break;
      else
        System.out.println("숫자만!!!!");
    }
    return count;
  }
}
