/* 주제:다차원 배열*/
package step02$memory;
public class Exam09{

  public static void main(String[] args) {
      int[] lengths= new int[3];
      int[][][] scores ={
      {
        {100,90,90,0},
        {90,90,90,0},
        {80,100,100,0},
      },
      {
        {50,60,70,0},
        {80,86,94,0},
      },
      {
        {88,78,76,0},
        {84,86,92,0},
        {87,87,98,0},
        {97,97,98,0}
      }
    };
    for(int i=0;i<scores.length;i++)
      lengths[i]=scores[i].length;
    for(int i=0;i<scores.length;i++)
    {
      for(int j=0;j<lengths[i];j++)
        scores[i][j][3]=scores[i][j][0]+scores[i][j][1]+scores[i][j][2];
    }
    float[][] avr =new float[][]{
      {scores[0][0][3]/3,scores[0][1][3]/3,scores[0][2][3]/3},
      {scores[1][0][3]/3,scores[1][1][3]/3},
      {scores[2][0][3]/3,scores[2][1][3]/3,scores[2][2][3]/3,scores[2][3][3]/3}
    };
    char[] clas=new char[]{'A','B','C'};

    for(int i=0 ;i<scores.length; i++)
    {
          for(int j=0;j<lengths[i];j++){
            System.out.printf("%c Class : %d , %d , %d , 총점 : %d , 평균 : %.1f\n",
                clas[i],scores[i][j][0],scores[i][j][1],scores[i][j][2],scores[i][j][3],avr[i][j]);
        }
    }
  }

}
