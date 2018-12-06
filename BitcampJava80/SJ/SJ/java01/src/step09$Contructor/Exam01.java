// 주제 : 기본 데이터 타입만 사용하여 복잡한 데이터를 다루기
package step09$Contructor;

public class Exam01 {
  public static void main(String[] args) {

    String[] name = new String[3];
    int[] kor = new int[3];
    int[] eng = new int[3];
    int[] math = new int[3];
    int[] sum = new int[3];
    float[] avr = new float[3];

    name[0] = "홍길동";
    kor[0] = 100;
    eng[0] = 90;
    math[0] = 100;

    name[1] = "임꺽정";
    kor[1] = 90;
    eng[1] = 90;
    math[1] = 80;

    name[2] = "유관순";
    kor[2] = 100;
    eng[2] = 100;
    math[2] = 100;

    for (int i = 0 ; i < name.length ; i++ ) {
      sum[i] = kor[i] + eng[i] + math[i];
      avr[i] = sum[i] / 3f;
    }

    for ( int i = 0  ; i < name.length ; i ++ ) {
      System.out.printf("%s : %d, %d, %d  - sum :%d , avr : %.2f \n",name[i],kor[i],eng[i],math[i],sum[i],avr[i]);
    }

  }
}


/*


*/
