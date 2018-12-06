import java.util.Calendar;
import java.util.Scanner;

public class Shutdown {

  // TODO Auto-generated method stub

  public static void main(String[] args) throws InterruptedException {
    Runtime runtime = Runtime.getRuntime();
    Scanner keyScan= new Scanner(System.in);
    System.out.print("몇시에 종료 하시겠습니까 ?\n ex)오전 7시 => 0700 , 7시 30분 => 1930\n 시간 :");
    String time = null;
    time = keyScan.nextLine();
    Calendar getTime;
    String[] splitGetTime;
    String[] splitTime; 
    if ( time.length()==4) {
      while (true) {
        getTime = Calendar.getInstance();
        splitGetTime= getTime.getTime().toString().split(" ");
        splitTime = splitGetTime[3].split(":");
        if(time.equals(splitTime[0]+splitTime[1])) {
          break;
        }
        Thread.sleep(60000);
        System.out.println(".");
      }
    } else {
      System.out.println("4자리로 입력해야 합니다.");
      keyScan.close();
      return;
    }
    
    try {
      Process process = runtime.exec("shutdown -s -f -t 00 \n");
      process.waitFor();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      keyScan.close();
    }
  }
}
