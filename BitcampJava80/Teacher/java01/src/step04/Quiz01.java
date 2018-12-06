/* 문제: 개인이 좋아하는 영화 장르를 저장하고 출력하는 프로그램을 작성하라.
=> 장르의 선호 여부를 표현할 때 비트로 표현할 것.
=> 비트 연산자를 이용하여 검사할 것.
=> 참고 예제: Exam06.java
=> 장르
범죄, 드라마, 코미디, 로맨스, 스릴러,
가족, 판타지, 액션, SF, 애니메이션,
다큐멘터리, 공포
=> 테스트 데이터
홍길동이 좋아하는 장르 : 드라마, 액션, SF, 다큐멘터리
010000011010
*/
package step04;

public class Quiz01 {
  public static void main(String[] args) {
    // 장르 마스크
    int g01 = 0x800;  // 범죄     1000_0000_0000
    int g02 = 0x400;  // 드라마   0100_0000_0000
    int g03 = 0x200;  // 코미디   0010_0000_0000
    int g04 = 0x100;  // 로맨스   0001_0000_0000
    int g05 = 0x80;  // 스릴러    0000_1000_0000
    int g06 = 0x40;  // 가족      0000_0100_0000
    int g07 = 0x20;  // 판타지    0000_0010_0000
    int g08 = 0x10;  // 액션      0000_0001_0000
    int g09 = 0x8;  // SF         0000_0000_1000
    int g10 = 0x4;  // 애니메이션 0000_0000_0100
    int g11 = 0x2;  // 다큐멘터리 0000_0000_0010
    int g12 = 0x1;  // 공포       0000_0000_0001

    // 개인 장르 데이터
    int myGenre = g02 | g08 | g09 | g11;

    // 개인이 좋아하는 장르 출력
    if ((myGenre & g01) == g01) System.out.println("범죄");
    if ((myGenre & g02) == g02) System.out.println("드라마");
    if ((myGenre & g03) == g03) System.out.println("코미디");
    if ((myGenre & g04) == g04) System.out.println("로맨스");
    if ((myGenre & g05) == g05) System.out.println("스릴러");
    if ((myGenre & g06) == g06) System.out.println("가족");
    if ((myGenre & g07) == g07) System.out.println("판타지");
    if ((myGenre & g08) == g08) System.out.println("액션");
    if ((myGenre & g09) == g09) System.out.println("SF");
    if ((myGenre & g10) == g10) System.out.println("애니메이션");
    if ((myGenre & g11) == g11) System.out.println("다큐멘터리");
    if ((myGenre & g12) == g12) System.out.println("공포");
  }
}
