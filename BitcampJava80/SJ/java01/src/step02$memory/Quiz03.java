/* 퀴즈 : 다음 값을 저장하고 지시에 따라 내용을 출력하시오 !
  -학생 30명의 국영수평총 점수
  -인덱스 5번 학생의 점수를 저장하라. 점수는 다음과 같다.
  -인덱스 5번의 // 출력하라.
*/

package step02$memory;

public class Quiz03{
  public static void main(String[] args){
    int[][] scores = new int[30][4];
    float[] avr = new float[30];
    scores[5][0]=100;
    scores[5][1]=90;
    scores[5][2]=50;
    scores[5][3]=scores[5][2]+scores[5][1]+scores[5][0];
    avr[5]= scores[5][3]/3;

    System.out.printf("%d %d %d %d %.2f \n",scores[5][0],scores[5][1],scores[5][2],scores[5][3],avr[5]);
  }
}





/*

package step02;
import java.util.Random;
public class Quiz03{

  public static void main(String[] args) {
    Random rd=new Random();
    int[][] student_scores=new int[30][4];
    float[] avers = new float[30];

    for(int i=0;i<30;i++)
    {
      for(int j=0;j<3;j++)
        student_scores[i][j]=rd.nextInt(50)+50;
    }
    for(int i=0;i<30;i++){
        student_scores[i][3]=student_scores[i][0]+student_scores[i][1]+student_scores[i][2];
        avers[i]= student_scores[i][3]/3;
    }
    for(int i=0;i<30;i++)
      System.out.printf("%d %d %d %d %.2f \n",student_scores[i][0],student_scores[i][1],student_scores[i][2],student_scores[i][3],avers[i]);

  }
}*/
