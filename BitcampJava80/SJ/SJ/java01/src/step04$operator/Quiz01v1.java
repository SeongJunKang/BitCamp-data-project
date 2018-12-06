/* 문제 :
개인이 좋아하는 영화 장르를 저장하고 출력하는 프로그램을 작성하라.
=> 각 장르의 좋아하는 여부를 표현할 때 비트로 표현할 것.
=> 비트 연산자를 이용하여 검사할 것.

장르 :
범죄 드라마 코미디 로맨스
스릴러 가족 판타지 액션
 SF 애니메이녀 다큐 공포

테스트 데이터
이름 : 홍길동
좋아하는 장르 : 드라마, 액션, SF, 다큐멘터리

*/
package step04$operator;
public class Quiz01v1{

  public static void main(String[] args) {

    String name ="홍길동";
    int cr=0x800;
    int dr=0x400;
    int co=0x200;
    int ro=0x100;
    int th=0x80;
    int fm=0x40;
    int fa=0x20;
    int ac=0x10;
    int sf=0x8;
    int an=0x4;
    int dc=0x2;
    int fe=0x1;

    int hong_pref= dr | ac | sf | dc;

    System.out.printf("%s 씨가 좋아하는 영화 장르는 \n",name);

    if((hong_pref & cr) == cr )      System.out.print("범죄 ");
    if((hong_pref & dr) == dr )      System.out.print("드라마 ");
    if((hong_pref & co) == co )      System.out.print("코미디 ");
    if((hong_pref & ro) == ro )      System.out.print("로맨스 ");
    if((hong_pref & th) == th )      System.out.print("스릴러 ");
    if((hong_pref & fm) == fm )      System.out.print("가족 ");
    if((hong_pref & fa) == fa )      System.out.print("판타지 ");
    if((hong_pref & ac) == ac )      System.out.print("액션 ");
    if((hong_pref & sf) == sf )      System.out.print("SF ");
    if((hong_pref & an) == an )      System.out.print("애니메이션 ");
    if((hong_pref & dc) == dc )      System.out.print("다큐 ");
    if((hong_pref & fe) == fe )      System.out.print("공포 ");

    System.out.println("입니다.");
  }
}
