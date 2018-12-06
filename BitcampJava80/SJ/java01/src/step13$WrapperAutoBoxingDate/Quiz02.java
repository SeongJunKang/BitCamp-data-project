//문제 2 두수 사이에 있는 수 중에서 짝수 값을 출력
// 4 12

package step13$WrapperAutoBoxingDate;

public class Quiz02 {
  public static void main(String[] args){

    int[] even = new int[args.length];
    for(int i = 0 ; i < args.length ; i++){
      even[i] = Integer.parseInt(args[i]);
    }

    for(int i = even[0] ; i <= even[1] ; i++) {
      if(i == even[1])
        System.out.println(i);
      else if(i % 2 == 0)
        System.out.printf("%d ,",i);
    }

  }
}
