/*주제 : for 문 중첩 */
package step05$ifswitchforwhile;

public class Exam17{

  public static void main(String[] args){

      for(int i = 2; i < 10; i++) {
        for (int j = 1 ; j <10 ; j++){
          System.out.printf("%d * %d = %d\n",i,j,i*j);
          if(i==5&j==6)
            break ;
        }
      }
      System.out.printf("===================================\n");
      ohmygod:{
      for(int i = 2; i < 10; i++) {
        for (int j = 1 ; j <10 ; j++){
          System.out.printf("%d * %d = %d\n",i,j,i*j);
          if(i==5&j==6)
            break ohmygod;
        }
      }
        System.out.printf("끝~~~\n");
    }
  }
}
