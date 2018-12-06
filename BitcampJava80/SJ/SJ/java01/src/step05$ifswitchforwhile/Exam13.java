package step05$ifswitchforwhile;

public class Exam13{

  public static void main(String[] args){
    int[] scores =new int[]{100,60,70,0};
    for(int i=0;i<3;i++){
      scores[3]+=scores[i];
    }
    for(int i=0;i<4;i++)
      System.out.println(scores[i]);

  }
}
