//문제 2 두수 사이에 있는 수 중에서 짝수 값을 출력
// 4 12

package step13$WrapperAutoBoxingDate;

public class Quiz04 {
  public static void main(String[] args){

    int[] sort = new int[args.length];
    for(int i = 0 ; i < args.length ; i++) {
      sort[i] = Integer.parseInt(args[i]);
    }
    for(int i = 0 ,tmp; i < args.length ; i++) {
      for(int j = 0 ; j < args.length ; j++) {

        if(sort[i]<sort[j]) {
          tmp=sort[i];
          sort[i]=sort[j];
          sort[j]=tmp;
        }
      }
    }
    for(int i = 0 ; i<args.length ; i++) {
      System.out.print(sort[i]+"  ");
    }
      System.out.print("\n");
  }
}
