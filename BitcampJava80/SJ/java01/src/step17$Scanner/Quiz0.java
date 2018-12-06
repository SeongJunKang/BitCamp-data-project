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

public class Quiz0 {

  public static void main(String[] args) {

    int count = ReceiveCount.Receive();
    Member[] member = new Member[count];
    member = Play.Playinsert(count);

    for(int i = 0 ; i < member.length; i++) 
      member[i].Printmember();


  }
}
