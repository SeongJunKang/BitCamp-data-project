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
public class Quiz01v2{

  public static void main(String[] args) {

    String name ="홍길동";
    int[] genre = new int[]{0x800,0x400,0x200,0x100,0x80,0x40,0x20,0x10,0x8,0x4,0x2,0x1};
    String[] genre_title= new String[]{"범죄","드라마","코미디","로맨스","스릴러",
  "가족","판타지","액션","SF","애니메이션","다큐","공포"};

    int hong_pref= genre[1] | genre[6] | genre[7] | genre[10];

    System.out.printf("%s 씨가 좋아하는 영화 장르는 \n",name);
    for(int i=0;i<genre.length;i++)
      if((hong_pref & genre[i] ) == genre[i] )      System.out.print("'"+genre_title[i]+"' ");

    System.out.println("입니다.");
  }
}
