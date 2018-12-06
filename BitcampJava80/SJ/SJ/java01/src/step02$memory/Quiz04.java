/* 퀴즈 : 다음 값을 저장하고 지시에 따라 내용을 출력하시오 !
  -데이터
  이름, 국여, 영어, 수학
  홍길동 100 90 80
  임꺽정 90 80 90
  유관순 70 100 100
  -출력
  이름 : 100, 90, 80, 합계, 평균
*/
package step02$memory;

public class Quiz04{
  public static void main(String[] args){
    int[][] scores = new int[][]{{100,90,80,0},{90,80,90,0},{70,100,100,0}};
    String[] name =new String[]{"홍길동","임꺽정","유관순"};
    float[] avr = new float[3];

    scores[0][3]=scores[0][0]+scores[0][1]+scores[0][2];
    scores[1][3]=scores[1][0]+scores[1][1]+scores[1][2];
    scores[2][3]=scores[2][0]+scores[2][1]+scores[2][2];
    avr[0]=scores[0][3]/3;
    avr[1]=scores[1][3]/3;
    avr[2]=scores[2][3]/3;


    System.out.printf("%s : %d, %d, %d, %d, %.2f \n",name[0],scores[0][0],scores[0][1],scores[0][2],scores[0][3],avr[0]);
    System.out.printf("%s : %d, %d, %d, %d, %.2f \n",name[1],scores[1][0],scores[1][1],scores[1][2],scores[1][3],avr[1]);
    System.out.printf("%s : %d, %d, %d, %d, %.2f \n",name[2],scores[2][0],scores[2][1],scores[2][2],scores[2][3],avr[2]);

  }
}
