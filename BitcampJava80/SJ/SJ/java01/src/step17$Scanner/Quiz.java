/*
5명 회원 정보를 입력 받아 보관하라.
> java -cp bin step17.Quiz
 이름 ? 홍길동
 이메일 ? hong@test.com
 암호 ? 1111
 전화 ? 111-1111
 정말 저장하시겠습니까 ?( y / n )
 저장했습니다. / 저장취소했습니다.
-------------------------------------------------
.... 다섯번 반복
 지금까지 입력한 회원 정보는 다음과 같습니다.
-------------------------------------------------
홍길동, hong@test.com, 1111, 111-1111
임꺽정, leem2@test.com, 1111, 111-1112
임꺽정2, leem3@test.com, 1111, 111-1112
임꺽정3, leem4@test.com, 1111, 111-1112
임꺽정4, leem5@test.com, 1111, 111-1112
--------------------------------------------------
>
*/
package step17$Scanner;
import java.util.Scanner;

public class Quiz {

  public static void Printinfo(int a) {
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

  public static void main(String[] args) {

    String[][] member = new String[5][4];
    Scanner scan = new Scanner(System.in);
    String check;
    for(int i = 0 ; i < member.length ; i++) {
      for(int j = 0 ; j < member[0].length ; j++) {
          member[i][j] ="0";
        }
      }


    for(int i = 0 ; i < member.length ; i++) {
      for(int j = 0 ; j < member[0].length ; j++) {
        if(member[i][j].equals("0")) {
          Printinfo(j);
          member[i][j]=scan.nextLine();
        }
      }
      while(true) {
        System.out.print("저장하시겠습니까 ? (y/n) : ");
        check = scan.nextLine();
        if(check.equals("n") || check.equals("N") )
        {
          System.out.println("저장취소되었습니다. ");
          System.out.println("-------------------------------------------");
          member[i][0] = "0";
          member[i][1] = "0";
          member[i][2] = "0";
          member[i--][3] = "0";
          break;
        }
        else if( check.equals("y") || check.equals("Y") ) {
          System.out.println("저장했습니다.");
          System.out.println("-------------------------------------------");
          break;
        }
      }
    }

    for(int i = 0 ; i < member.length ; i++) {
          System.out.println(member[i][0] + " \t "+member[i][1] + " \t "+member[i][2]
          + " \t "+member[i][3]);
    }
    System.out.print("-------------------------------------------\n");










  }
}
