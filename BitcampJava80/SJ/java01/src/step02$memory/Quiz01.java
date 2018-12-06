/* 문제: 다음 값을 저장할 수 있는 변수를 선언하시오.
  -국,영,수 점수와 총점 ,평균, 재직여부, 성별을 저장.
*/
package step02$memory;
import java.util.Random;
public class Quiz01 {

  public static void main(String[] args) {
    Random rd = new Random();
    int kor=rd.nextInt(100)+1;
    int eng=rd.nextInt(100)+1;
    int math=rd.nextInt(100)+1;
    int sum=kor+eng+math;
    float average=sum/3;
    boolean working=false;
    char gender='남';

    System.out.println("국어 :"+kor+", 영어 :"+eng+", 수학 :"+math);
    System.out.println("총점 :"+sum+", 평균 :"+average);
    System.out.println("재직여부 :"+working+", 성별 :"+gender);

  }
}
