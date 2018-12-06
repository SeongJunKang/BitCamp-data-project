package designPattern.abstractFactory.exam02;

import java.util.Scanner;

public class Game {
  Scanner 스캔 = new Scanner(System.in);
  int 선택된종족;
  Home 집;
  HomeFactory 집공장;
  public void 서비스() throws Exception {
    종족선택();
    String 명령어 = null;
    do {
      System.out.print("명령? ");
      명령어 = 스캔.nextLine();
      if (명령어.equals("home")) {
        집건설();
      } else if (명령어.equals("quit")) { 
        System.out.println("게임을 종료합니다.");
      } else {
        System.out.println("유효하지 않는 명령어입니다.");
      }
    } while (!명령어.equals("quit"));
  }
  private void 종족선택() {
    System.out.println("1) 인간족\t2) 외계족\t3) 괴물족 ");
    System.out.print("종족을 선택하시오? ");
    선택된종족 = Integer.parseInt(스캔.nextLine());
    if (선택된종족 == 1) {
      집공장 = new HumanHomeFactory();
    } else if (선택된종족 == 2) {
      집공장 = new AlienHomeFactory();
    } else {
      집공장 = new MonsterHomeFactory();
    }
  }
  
  private void 집건설() {
    집 = 집공장.createHome();
    System.out.println("집짓기 완료 !");
    System.out.print("집 정보 --> "+ 집 +"\n");
  }
  
  public static void main(String[] args) throws Exception {
    Game 게임 = new Game();
    게임.서비스();
    
  }
}
