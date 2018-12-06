


package step17$Scanner;
import java.util.Scanner;
public class Play {

  Play(){}


    public static Member[] Playinsert(int count) {

      String check;
      String[] info = new String[4];
      Scanner scan = new Scanner(System.in);
      Member[] member = new Member[count];

      for(int i = 0 ; i < member.length; i++) {
        for(int j = 0 ; j < info.length ; j++) {
          Whatinfo(j);
          info[j] = scan.nextLine();
        }
        while(true) {
          System.out.print("저장하시겠습니까 ? (y/n) : ");
          check = scan.nextLine();
          if(check.equalsIgnoreCase("n")) {
            i--;
            System.out.println("저장취소했습니다.\n");
            break;
          } else if(check.equalsIgnoreCase("y")) {
              member[i] = new Member(info[0],info[1],info[2],info[3]);
              System.out.println("저장했습니다\n");
              break;
          }
        }
      }
      return member;
    }

    public static void Whatinfo(int a) {
      switch(a) {
          case 0 :System.out.print("이름 ? :");
            break;
          case 1 :System.out.print("이메일 ? :");
            break;
          case 2 :System.out.print("암호 ? :");
            break;
          case 3 :System.out.print("전화 ? :");
            break;
      }
    }
}
