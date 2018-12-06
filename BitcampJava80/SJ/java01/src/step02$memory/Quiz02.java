/* 문제: 다음 값을 저장할 수 있는 변수를 선언하시오.
  -국,영,수,사,과,음,미,체,철학 점수를 저장할 변수
  -총점과 평균
*/
package step02$memory;
import java.util.Random;
public class Quiz02 {

  public static void main(String[] args) {
    Random rd = new Random();
    int sum=0;
    int[] scores =new int[9];
    for(int i=0;i<9;i++){
      scores[i]=rd.nextInt(50)+50;
      sum+=scores[i];
    }
    float avr=sum/scores.length;
    for(int i=0;i<9;i++)
      System.out.println(scores[i]);
    System.out.println("총점 :"+sum+", 평균 :"+avr);


  }
}
